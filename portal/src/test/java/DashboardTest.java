import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import test.work.Configurator;
import test.work.DashboardPage;
import test.work.DashboardPrivatePage;
import test.work.LaunchPage;
import test.work.PortalLoginPage;

public class DashboardTest {
     PortalLoginPage page;
     DashboardPrivatePage projectPage;

    @BeforeTest
    public void setChrome() {
        Configurator.setupChrome();
        page = new PortalLoginPage(Configurator.getChromeDriver());
        page.getPage();
        String login = "default";
        String password = "1q2w3e";
        page.inputLogin(login);
        page.inputPassword(password);
        LaunchPage launch = page.submitData();
        DashboardPage dashPage = launch.goToDashboard();
        projectPage = dashPage.clickProject();
    }

    @Test
    public void correctTest() {
        projectPage.addWidget();
        projectPage.chooseStatic();
        projectPage.nextStep();
        projectPage.chooseFirstProject();
        projectPage.nextStep();
        String name = "Hello";
        projectPage.enterName(name);
        projectPage.saveWidget();
    }   
}
