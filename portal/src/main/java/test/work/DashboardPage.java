package test.work;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
   private WebDriver driver;
   
   public DashboardPage(final WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver,this);
   }

   @FindBy(xpath = "//a[text()='DEMO DASHBOARD']")
   private WebElement demo;

   public DashboardPrivatePage clickProject() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    wait.until(ExpectedConditions.visibilityOf(demo));
    wait.until(ExpectedConditions.elementToBeClickable(demo));
    demo.click();
    return new DashboardPrivatePage(driver);
   }
}
