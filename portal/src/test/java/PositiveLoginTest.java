import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import test.work.Configurator;
import test.work.LaunchPage;
import test.work.PortalLoginPage;

public class PositiveLoginTest {
    PortalLoginPage page;

    @BeforeTest
    public void setChrome() {
        Configurator.setupChrome();
        page = new PortalLoginPage(Configurator.getChromeDriver());
        page.getPage();
    }

    @Test
    public void correctTest() {
        String login = "default";
        String password = "1q2w3e";
        page.inputLogin(login);
        page.inputPassword(password);
        LaunchPage launch = page.submitData();
        WebDriverWait wait = new WebDriverWait(Configurator.getChromeDriver(), Duration.ofSeconds(10));
        Assert.assertTrue(wait.until(ExpectedConditions.urlContains("https://demo.reportportal.io/ui/#default_personal/launches/all")));
    }
}
