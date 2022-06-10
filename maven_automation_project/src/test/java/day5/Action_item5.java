package day5;
import  io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
public class Action_item5 {

    public static void main(String[] args) throws InterruptedException {
        //set up chrome driver manager with webdriver manager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set argument as incognito
        //options.addArguments("incognito");
        //set argument as full screen
        options.addArguments("start-fullscreen");
        //define webdriver I am using
        WebDriver driver = new ChromeDriver(options);

        //capture and print search numbers for hobbies using arraylist and for loop
        ArrayList<String> hobbies = new ArrayList<>();
        hobbies.add("swiming");
        hobbies.add("cricket");
        hobbies.add("football");
        hobbies.add("dance classes");
        hobbies.add("it classes");

        for (int i = 0; i < hobbies.size(); i++) {
            //go to bing home page
            driver.navigate().to("https:www.bing.com");
            Thread.sleep(3000);
            //locate element for search field and enter "hobbies"
            driver.findElement(By.xpath("//*[@name= 'q'] ")).sendKeys(hobbies.get(i));
            //click enter
            driver.findElement(By.xpath("//*[@name= 'q'] ")).submit();
            Thread.sleep(2000);
            //capture the Google search and print it
            String searchResult = driver.findElement(By.xpath("//*[@id= 'b_tween']")).getText();
            //use split method to capture number only and print it
            String[] arrayResult = searchResult.split(" ");

            //extract number and print what hobby it is for
            System.out.println("My search number for hobby " + hobbies.get(i) + "  is " + arrayResult[0]);

        }//end of for loop

        //quit the driver
        driver.quit();
    }//end of main
}//end of java class




