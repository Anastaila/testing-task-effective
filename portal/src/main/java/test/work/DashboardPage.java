package test.work;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class DashboardPage {
   private final WebDriver driver;
   
   public DashboardPage(final WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver,this);
   }

   private final By buttonAddBoard = By.xpath("//button[.//span[text()='Add New Dashboard']]");

   @Step("Adding dashboard")
   public DashboardPrivatePage addBoard(final String name) {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      WebElement buttonAdd = wait.until(ExpectedConditions.elementToBeClickable(buttonAddBoard));
      buttonAdd.click();
      WebElement fieldName = driver.findElement(By.cssSelector("input[placeholder = 'Enter dashboard name']"));
      fieldName.click();
      fieldName.sendKeys(name);
      WebElement buttonSave = driver.findElement(By.xpath("//button[text()='Add']"));
      buttonSave.click();
      return new DashboardPrivatePage(driver);
   }

   @Step("Click on existing project")
   public DashboardPrivatePage clickProject(final String name) {
      WebElement project = driver.findElement(By.xpath("//a[text()='"+ name + "']"));
      ((JavascriptExecutor) driver).executeScript("arguments[0].click();", project);
      return new DashboardPrivatePage(driver);
   }
}
