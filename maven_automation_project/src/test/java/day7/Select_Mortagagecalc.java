package day7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Select_Mortagagecalc {

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
        //navigate to mortgage calculator
        driver.navigate().to( "http://www.mortgagecalculator.org");
        Thread.sleep( 3000);
        //select start month from the dropdown
        WebElement startMonth = driver.findElement(By.xpath("//*[@name='param[start_month]"));
        //define select command
        Select dropDown = new Select(startMonth);
        //select by visible text
        dropDown.deselectByVisibleText("June");
        //clicking on dropdown and its valueif the dropdown tag is not under select tag
        startMonth.click();
        //click on the value of start month
        driver.findElement(By.xpath( "//*[text()='jun']")).click();




        //select loan type from the dropdown
        WebElement loanType = driver.findElement(By.xpath( "//*[@name='param[milserve]"));
        //define selct command
        Select loanTypeDropdown = new Select(loanType);
        //select by visible text
        loanTypeDropdown.selectByVisibleText("FHA");




    }//end of main

}//end of java class
