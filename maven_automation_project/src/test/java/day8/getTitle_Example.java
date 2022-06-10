package day8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class getTitle_Example {
    public static void main(String[] args) {



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
//navigate to ggogle
        driver.navigate().to( "https://www.google.com");
        //capture the title of the page and compare with the expected title GOOGLE
        String actualTitle = driver.getTitle();
        if(actualTitle.equals("Google")) {
            System.out.println(" My title matches");

        }else {
            System.out.println("Title does not match. Actual Title is " + actualTitle);

        }





    }//end of main
}//end of class
