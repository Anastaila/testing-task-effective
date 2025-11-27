package test.work;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaunchPage {
    private final WebDriver driver;

    public LaunchPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@href='#default_personal/dashboard']")
    private WebElement board;

    public String CheckPage() {
        return driver.getCurrentUrl();
    }

    public DashboardPage goToDashboard() {
        board.click();
        return new DashboardPage(driver);
    }
}
