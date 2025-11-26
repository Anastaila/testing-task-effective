
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
    public void incorrectTest() {
        String login = "invalidUser";
        String password = "wrongPAssword";
        page.inputLogin(login);
        page.inputPassword(password);
        page.submitData();
        Assert.assertEquals(page.getError(), "Bad Credentials");
    }   
}
