package day6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebElement_morgagecalc {

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
        //navigate to mortgagecalculator site
        driver.navigate().to( "https://www.mortgagecalculator.org");
        WebElement homeValue = driver.findElement(By.xpath( "//*[@id='homeval']"));
        homeValue.click();
        homeValue.click();
        Thread.sleep( 1500);
        homeValue.sendKeys( "45000");
        //click on % radio button
        driver.findElement(By.xpath( "//*[@value='percent']")).click();

        //click,clear and enter new data on down payment field
        WebElement downPayment = driver.findElement(By.xpath( "//*[@id='downpayment']"));
        downPayment.click();
        downPayment.clear();
        downPayment.sendKeys( "5");






    }//end of main
}//end of java class
