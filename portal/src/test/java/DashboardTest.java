import org.testng.annotations.AfterTest;
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
        // String login = "default";
        // String password = "1q2w3e";
        // page.inputLogin(login);
        // page.inputPassword(password);
        LaunchPage launch = page.submitData();
        DashboardPage dashPage = launch.goToDashboard();
        projectPage = dashPage.addBoard("Test");
        // projectPage = dashPage.clickProject("DEMO DASHBOARD");
    }

    @Test
    public void createWidgetTest() {
        projectPage.addWidget();
        projectPage.chooseStatic();
        projectPage.nextStep1();
        projectPage.chooseFilter();
        projectPage.nextStep2();
        String name = "Helloo";
        projectPage.enterName(name);
        projectPage.saveWidget();
    }
    
    @AfterTest
    public void DeleleteDashboard() {
        projectPage.deleteDashboard();
    }
}
