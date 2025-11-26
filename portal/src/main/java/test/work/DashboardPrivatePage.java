package test.work;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPrivatePage {
    private WebDriver driver;
   
   public DashboardPrivatePage(final WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver,this);
   }
   
   @FindBy(xpath = "//a[text()='Add new widget']")
   private WebElement buttonAdd;

   @FindBy(xpath = "//input[value = 'statisticTrend']")
   private WebElement choiceStatic;

   @FindBy(xpath = "//span[text()='Next step']")
   private WebElement buttonNext;
   
   @FindBy(xpath = "//input[value = '1']")
   private WebElement choiceFirstProject;

    @FindBy(css = "input[placeholder = 'Enter widget name']")
    private WebElement widgetName;

   @FindBy(xpath = "//button[text()='Add']")
   private WebElement buttonSave;

   public void addWidget() {
    buttonAdd.click();
   }

   public void chooseStatic() {
    choiceStatic.click();
   }

   public void nextStep() {
    buttonNext.click();
   }

   public void chooseFirstProject() {
    choiceFirstProject.click();
   }

   public void enterName(String name) {
    widgetName.click();
    widgetName.clear();
    widgetName.sendKeys(name);
   }

   public void saveWidget() {
    buttonSave.click();
   }
}
