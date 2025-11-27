package test.work;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

   @FindBy(xpath = "//button[.//span[text()='Add New Dashboard']]")
   private WebElement buttonAddBoard;

   public DashboardPrivatePage addBoard(final String name) {
      buttonAddBoard.click();
      WebElement fieldName = driver.findElement(By.cssSelector("input[placeholder = 'Enter dashboard name']"));
      fieldName.click();
      fieldName.sendKeys(name);
      WebElement buttonSave = driver.findElement(By.xpath("//button[text()='Add']"));
      buttonSave.click();
      return new DashboardPrivatePage(driver);
   }

   public DashboardPrivatePage clickProject(final String name) {
      WebElement project = driver.findElement(By.xpath("//a[text()='"+ name + "']"));
      // new Actions(driver).moveToElement(project).click().perform();
      // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
      ((JavascriptExecutor) driver).executeScript("arguments[0].click();", project);
      // wait.until(ExpectedConditions.visibilityOf(project));
      // wait.until(ExpectedConditions.elementToBeClickable(project));
      // project.click();
      return new DashboardPrivatePage(driver);
   }
}
