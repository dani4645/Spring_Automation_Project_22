package day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class ForLoop_ArrayList_GoogleSearch {
    public static void main(String[] args) throws InterruptedException {


        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //set chrome options for arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the conditions to maximize your driver
        options.addArguments("start-fullscreen");

        //setting your driver as headless(running on background)    add// to see web opening
       options.addArguments("headless");

        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);
        //maximize the driver
        // driver.manage().window().maximize();
        //capture search number and print for the following cities using Arraylist  and for loop
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Brooklyn");
        cities.add("Queens");
        cities.add("Bronx");

       for(int i = 0; i < cities.size(); i++) {
           //go to google home page
           driver.navigate().to(" http://www.google.com");
           Thread.sleep(3000);

           //locate element for search field and type key word 'cars'
           driver.findElement(By.xpath("//*[@name='q']")).sendKeys(cities.get(i));
           //submit on google search button
           driver.findElement(By.xpath("//*[@name='btnK']")).submit();
           Thread.sleep(2500);
           //capture the google result and print it
           String searchResult = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
           // System.out.println(" Result is " + searchResult);
           //extract out the number and print the number only
           String[] arrayResult = searchResult.split(" ");
           //to replace ( and ) from the seconds that's coming from ArrayList[3] use.replace command to replace it with **(no space)
          // String replaceParanth = arrayResult[3].replace("(", "").replace(")", "");
           System.out.println("My search number for city " + cities.get(i) + " is " + arrayResult[1]);
       }//end of for loop

           //quit the driver
       // driver.quit(); //in order to quit,remove those // on this line




    }//end pf main

}//end of java class
