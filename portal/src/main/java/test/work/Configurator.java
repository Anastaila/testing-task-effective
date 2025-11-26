package test.work;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Configurator {
    private static WebDriver driver;
    
    public static ChromeOptions setChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled", "--blink-settings=imagesEnabled=false");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        return options;
    }

    public static void setupChrome() {
        System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
        driver = new ChromeDriver(setChromeOptions());
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
    }

    public static WebDriver getChromeDriver() {
        return driver;
    }
    
    public static void setTimeoutTime(final int time, final TimeUnit timeUnit) {
        getChromeDriver().manage().timeouts().implicitlyWait(time, timeUnit);
    }
    
}
