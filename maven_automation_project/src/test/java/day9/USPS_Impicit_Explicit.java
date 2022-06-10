package day9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class USPS_Impicit_Explicit {
    public static void main(String[] args) {

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

        //set your global implicit wait(use implicit or explicit)
       // driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        //navigate to usps
        driver.navigate().to("https://www.usps.com");

        //call mouse action
        Actions actions = new Actions(driver);

        //declare and define explicit wait
        WebDriverWait wait = new WebDriverWait(driver,8);

        //hover to quick tools
       WebElement quickTools = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Quick Tools']")));
       actions.moveToElement(quickTools).perform();

       //click on track a package
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='g-navigation']"))).click();

        //click and then type on track a packge
        WebElement packageFeild = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tracking-package--input']")));
        packageFeild.click();
        packageFeild.sendKeys("122223232232");











    }//end of main
}//end of class
