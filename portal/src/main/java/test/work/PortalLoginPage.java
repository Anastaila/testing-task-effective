package test.work;

import io.qameta.allure.Step;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PortalLoginPage {
    private WebDriver driver;

     public PortalLoginPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Go to the page login")
    public void getPage() {
        driver.get("https://demo.reportportal.io/ui/#login");
    }

    @FindBy(css = "input[placeholder = 'Login']")
    private WebElement fieldLogin;

     @FindBy(css = "input[placeholder = 'Password']")
    private WebElement fieldPassword;

     @FindBy(xpath = "//button[text()='Login']")
    private WebElement submitButtom;

    @FindBy(xpath="//span[text()='Bad Credentials']")
    private WebElement errorFlag;

    @Step("Input login {login}")
    public PortalLoginPage inputLogin(final String login) {
        fieldLogin.clear();
        fieldLogin.sendKeys(login);
        return this;
    }

    @Step("Input {password}")
    public PortalLoginPage inputPassword(final String password) {
        fieldPassword.clear();
        fieldPassword.sendKeys(password);
        return this;
    }

    @Step("Click on submit button")
    public LaunchPage submitData() {
        submitButtom.submit();
        return new LaunchPage(driver);
    }
    
    @Step("Getting error with Bad Credentials")
    public String getError() {
        return errorFlag.getText();
    }
}