package day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chromeoptions_GoogleSearch {

    public static void main(String[] args) throws InterruptedException {

        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //set chrome options for arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the conditions to maximize your driver
        options.addArguments("start-maximized");

        //setting your driver as headless(running on background)
        options.addArguments("headless");

        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);
        //maximize the driver
       // driver.manage().window().maximize();F


        //go to google home page
        driver.navigate().to( " http://www.google.com");
        Thread.sleep( 3000);
        driver.manage().window().maximize();
        //locate element for search field and type key word 'cars'
        driver.findElement(By.xpath( "//*[@name='q']")).sendKeys("cars");
        //submit on google search button
        driver.findElement(By.xpath( "//*[@name='btnK']")).submit();
        //capture the google result and print it
        String searchResult = driver.findElement(By.xpath( "//*[@id='result-stats']")).getText();
        // System.out.println(" Result is " + searchResult);
        //extract out the number and print the number only
        String[] arrayResult = searchResult.split( " ");
        System.out.println("My search number is " + arrayResult[1]);

        //quit the driver
        //driver.quit(); //in order to quit,remove those // on this line
    }//end of main

}//end of java class
