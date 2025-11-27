package test.work;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaunchPage {
    private WebDriver driver;

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
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // wait.until(ExpectedConditions.visibilityOf(board));
        // wait.until(ExpectedConditions.elementToBeClickable(board));
        board.click();
        return new DashboardPage(driver);
    }
}
