package day9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {

    public static void main(String[] args) throws InterruptedException {

        //Set up your Chromedriver with Webdrivermanager
        WebDriverManager.chromedriver().setup();
        //Set Chrome Options
        ChromeOptions options = new ChromeOptions();
        //Set the condition to Incognito Mode
        options.addArguments("incognito");
        //Set the condition to maximize/fullscreen your driver
        options.addArguments("start-maximized");
        //Setting your driver as headless (running on background)
        //options.addArguments("headless");
        //For mac use full screen
        //options.addArguments("start-fullscreen");
        //Define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);
     //navigate to usps website
        driver.navigate().to("https://www.usps.com");
        Thread.sleep( 3000);

        //declare and define mouse action
        Actions mouseActions = new Actions(driver);

        //hover to send tab
        WebElement sendTab = driver.findElement(By.xpath( "//*[@id='mail-ship-width']"));
        mouseActions.moveToElement(sendTab).perform();

        //click on tracking using mouse actions
        WebElement tracking = driver.findElement(By.xpath( "//*[@text()='Tracking']"));
        mouseActions.moveToElement(tracking).click().perform();
        Thread.sleep(3000);

        //type invalid tracking using sendkeys with mouse actions
        WebElement trackingField = driver.findElement(By.xpath( "//*[@id='tracking-input']"));
        mouseActions.moveToElement(trackingField).click().perform();
        mouseActions.moveToElement(trackingField).sendKeys("111234243242").perform();



















    }//end of main
}//end of java class

