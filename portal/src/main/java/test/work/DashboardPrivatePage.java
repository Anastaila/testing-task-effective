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

import io.qameta.allure.Step;

public class DashboardPrivatePage {
    private final WebDriver driver;
   
   public DashboardPrivatePage(final WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
   }
   
   @FindBy(xpath =  "//button[.//span[text()='Add new widget']]")
   private WebElement buttonAdd;

   @Step("Click on button add widget")
   public void addWidget() {
    new Actions(driver).moveToElement(buttonAdd).click().perform();
   }

   @Step("Choose parameter Static")
   public void chooseStatic() {
    WebElement choiceStatic = driver.findElement(By.xpath( "//input[@value = 'statisticTrend']/.."));
    choiceStatic.click();
   }

   @Step("First click on button next")
   public void nextStep1() {
    WebElement buttonNext = driver.findElement(By.xpath("//span[text()='Next step']/.."));
    buttonNext.click();
   }

   @Step("Choose filter")
   public void chooseFilter() {
    WebElement buttonFilter = driver.findElement(By.xpath("//input[@value = '1']/.."));
    buttonFilter.click();
   }

   @Step("Second click on button next")
   public void nextStep2() {
    WebElement buttonNext = driver.findElement(By.xpath("(//span[text()='Next step']/..)"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonNext);
   }

   @Step("Fill field name project with {name}")
   public void enterName(String name) {
    WebElement widgetName = driver.findElement(By.cssSelector("input[placeholder = 'Enter widget name']"));
    widgetName.click();
    widgetName.clear();
    widgetName.sendKeys(name);
   }

   @Step("Save widget")
   public boolean saveWidget() {
    WebElement buttonSave = driver.findElement(By.xpath("//button[text()='Add']"));
    buttonSave.click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    return wait.until(ExpectedConditions.invisibilityOf(buttonSave));
   }

    @Step("Search created widget")
   public boolean chooseWidget(final String name) {
    WebElement widget = driver.findElement(By.xpath("//div[text()='"+ name + "']"));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    try {
        wait.until(ExpectedConditions.visibilityOf(widget));
        return true;
    } catch (Exception e) {
         return false;
        } 
   }

   @Step("Click on button to delete Dashboard")
   public void deleteDashboard() {
    WebElement buttonDel = driver.findElement(By.xpath("//button[.//span[text()='Delete']]"));
    buttonDel.click();
    WebElement buttonFinalDel = driver.findElement(By.xpath("//button[text()='Delete']"));
    buttonFinalDel.click();
   }
}
