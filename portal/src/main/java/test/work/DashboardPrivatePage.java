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

public class DashboardPrivatePage {
    private WebDriver driver;
   
   public DashboardPrivatePage(final WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver,this);
   }
   
   @FindBy(xpath =  "//button[.//span[text()='Add new widget']]")
   private WebElement buttonAdd;

   public void addWidget() {
    new Actions(driver).moveToElement(buttonAdd).click().perform();
   }

   public void chooseStatic() {
    WebElement choiceStatic = driver.findElement(By.xpath( "//input[@value = 'statisticTrend']/.."));
    choiceStatic.click();
   }

   public void nextStep1() {
    WebElement buttonNext = driver.findElement(By.xpath("//span[text()='Next step']/.."));
    buttonNext.click();
   }

   public void chooseFilter() {
    WebElement buttonFilter = driver.findElement(By.xpath("//input[@value = '1']/.."));
    buttonFilter.click();
   }

   public void nextStep2() {
    WebElement buttonNext = driver.findElement(By.xpath("(//span[text()='Next step']/..)"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonNext);
   }

   public void enterName(String name) {
    WebElement widgetName = driver.findElement(By.cssSelector("input[placeholder = 'Enter widget name']"));
    widgetName.click();
    widgetName.clear();
    widgetName.sendKeys(name);
   }

   public void saveWidget() {
    WebElement buttonSave = driver.findElement(By.xpath("//button[text()='Add']"));
    buttonSave.click();
   }

   public void deleteDashboard() {
    WebElement buttonDel = driver.findElement(By.xpath("//button[.//span[text()='Delete']]"));
    buttonDel.click();
    WebElement buttonFinalDel = driver.findElement(By.xpath("//button[text()='Delete']"));
    buttonFinalDel.click();
    // new Actions(driver).moveToElement(buttonFinalDel).click().perform();
   }
}
