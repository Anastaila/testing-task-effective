
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import test.work.Configurator;
import test.work.PortalLoginPage;



public class NegativeLoginTest {
    PortalLoginPage page;

    @BeforeTest
    public void setChrome() {
        Configurator.setupChrome();
        page = new PortalLoginPage(Configurator.getChromeDriver());
        page.getPage();
    }

    @Test
    @Story("As user i want log in page to use all actions in site")
    @Description("Testing login page with positive data")
    public void incorrectLoginoginTest() {
        String login = "invalidUser";
        String password = "wrongPAssword";
        page.inputLogin(login);
        page.inputPassword(password);
        page.submitData();
        Assert.assertEquals(page.getError(), "Bad Credentials");
    }   
}
