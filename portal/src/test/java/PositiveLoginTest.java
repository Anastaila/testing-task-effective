import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import test.work.Configurator;
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
    @Story("As user i want log in page to use all actions in site")
    @Description("Testing login page with negative data")
    public void validLoginTest() {
        String login = "default";
        String password = "1q2w3e";
        page.inputLogin(login);
        page.inputPassword(password);
        page.submitData();
        WebDriverWait wait = new WebDriverWait(Configurator.getChromeDriver(), Duration.ofSeconds(10));
        Assert.assertTrue(wait.until(ExpectedConditions.urlContains("https://demo.reportportal.io/ui/#default_personal/launches/all")));
    }
}
