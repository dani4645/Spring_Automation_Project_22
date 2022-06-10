package day7;
import  io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
public class AI04_Assingnment_2 {
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

        //Navigate to Weight Watchers Website
        driver.navigate().to("https://www.weightwatchers.com");
        //Slow down script
        Thread.sleep(3000);

        //Create an ArrayList for zipCode
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("19082");
        zipCode.add("19092");
        zipCode.add("19064");

        //State For Loop
        for(int i = 0; i < zipCode.size(); i++) {
            //Handle the exception for Attend button
            try {
                //Click on Attend button for dropdown on top right of the page, cannot use select method as tag is not under select
                driver.findElement(By.xpath("//*[@data-e2e-name='attend']")).click();
            } catch (Exception e) {
                System.out.println("Unable to locate Attend Button " + e);
            }//End of exception for Attend

            //Handle the exception for Unlimited Workshops
            try {
                //Select Unlimited Workshops from Attend drop-down
                //We are clicking on index 1 because there are 2 elements for this xpath
                driver.findElements(By.xpath("//*[text()='Unlimited Workshops']")).get(1).click();
            } catch (Exception e) {
                System.out.println("Unable to select Unlimited Workshops button " + e);
            }//End of exception for Unlimited Workshops

            //Handle the exception for Studio link
            try {
                //Click on Studio link
                //We are clicking on index 1 because there are 2 elements in this xpath
                WebElement Studio = driver.findElements(By.xpath("//span[@class='buttonText-3DCCO']")).get(1);
                Studio.click();
            } catch (Exception e) {
                System.out.println("Unable to select Studio Link button " + e);
            }//End of exception for Studio link
            //Handle exception for Location field
            try{
                //Locate element for Location field
                WebElement Location = driver.findElement(By.xpath("//*[@class='input input-3TfT5']"));
                //Clear Location field
                Location.clear();
                //Enter zipCode in Location field
                Location.sendKeys(zipCode.get(i));
            }catch(Exception e){
                System.out.println("Unable to locate Location field " + e);
            }//End of exception for Location field

            //Handle exception for Search button
            try{
                //Locate element for Search button
                WebElement Search = driver.findElement(By.xpath("//*[@class='rightArrow-daPRP']"));
                //Click Search button
                Search.click();
                //Slow down script
                Thread.sleep(2500);
            }catch(Exception e){
                System.out.println("Unable to location Search button " + e);
            }//End of exception for Search button

            //Handle exception for Studio Links for zipCode
            try{
                //Declare Web Element for Search Results/Studio Links that appear
                WebElement studioLink = driver.findElements(By.xpath("//*[@class='wrapperLink-2NobU']")).get(i);

                //Create if statements based on zipCode ArrayList that correspond to their respective Studio Link
                //Click the Studio Links
                //Print the Studio Address
                if(i == 0) {
                    studioLink.click();
                    Thread.sleep(2000);//slow down script
                    String studioAddress = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
                    System.out.println("Address for zipcode is 19082 is " + studioAddress );


                }if(i == 1) {
                    studioLink.click();
                    Thread.sleep(2000);//slow down script
                    String studioAddress = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
                    System.out.println("Address for zipcode 19092 is " + studioAddress);

                }if(i == 2) {
                    studioLink.click();
                    Thread.sleep(2000);//slow down script
                    String studioAddress = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
                    System.out.println("Address for zipcode 19064 is: " + studioAddress);
                }//End of condition

            }catch(Exception e){
                System.out.println("Unable to locate Studio Links for zipcodes ");
            }//End of exception for Studio Links for zipCode

            //Declare javascriptexecutor variable
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            //Scroll down to view Studio Workshop Schedule for each Studio Link
            jse.executeScript("scroll(0,800)");
            //Slow down script
            Thread.sleep(3000);

            //Handle exception for Studio Workshop Schedule
            try {
                //Create string for xpath that shows the Studio Workshop Schedule
                String studioWorkshopSchedule = driver.findElement(By.xpath("//*[@id='studioWorkshopSchedule']")).getText();
                //Print Studio Schedule
                System.out.println("The schedule for the studio is " + studioWorkshopSchedule);
            }catch(Exception e){
                System.out.println("Unable to print Studio Workshop Schedules for locations ");
            }//End of exception for Studio Workshop Schedule

        }//End of for loop

        //Quit the driver
        driver.quit();

















        }//end of main

}//end of java class
