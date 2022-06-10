package day6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FindElementsExample {

    public static void main(String[] args) throws InterruptedException {
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //set chrome options for arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the conditions to maximize your driver
        options.addArguments("start-fullscreen");

        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);

        //nevigate to bing home
      driver.navigate().to(  "https://www.bing.com");
        Thread.sleep( 3000);
        //click on images using class property with index of 1
        //to ignore white space in the property value we can use contain command in xpath
        driver.findElements(By.xpath( "//li[contains(@class,'scope')]")).get(0).click();


    }//end of main

}//end of java class
