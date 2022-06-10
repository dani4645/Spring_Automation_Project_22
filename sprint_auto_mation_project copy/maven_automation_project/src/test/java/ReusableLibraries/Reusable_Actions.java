package ReusableLibraries;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reusable_Actions {

    //reusable function for webdriver as a return method
    public static WebDriver setDriver(){
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
        return driver;
    }//end of set driver method

    //create a mouse hover method
    public static void mouseHover(WebDriver driver,String xpath,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();

        } catch (Exception e) {
            System.out.println("unable to hover on element" + elementName + " " + e);
        }

    }//end of mouseHover
    //create a click method
    public static void clickAction(WebDriver driver,String xpath,String elementNmae) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();

        } catch (Exception e) {
            System.out.println("unable to click on element " +elementNmae + " " + e);
        }


    }//end of click action
    //create a send keys methos
    public static void sendKeysAction(WebDriver driver,String xpath,String userValue,String elementNmae) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();
            element.clear();
            element.sendKeys("userValue");

        } catch (Exception e) {
            System.out.println("unable to click on element" + elementNmae + " " + e);
        }
    }//end of sendkeys method
    //create a getText method

    public static  String getTextAction(WebDriver driver, String xpath, String elementNmae) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = null;
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            result = element.getText();

        } catch (Exception e) {
            System.out.println("unable to capture text on element" + elementNmae + " " + e);

        }
        return result;
    }//end of getTextAction method

//create a click by index method

    public static void clickByIndexAction(WebDriver driver,String xpath, int indexNumber, String elementNmae) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            element.click();

        } catch (Exception e) {
            System.out.println("unable to click on element " + elementNmae + " " + e);
        }

    }//end od clickByIndexAction

    //create selectByText method
    public static void selectByText(WebDriver driver,String xpath, String elementNmae) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();

        } catch (Exception e) {
            System.out.println("unable to click on element " + elementNmae + " " + e);
        }

    }//end of selectByText

    //create switchToTabByIndex method
    public static void switchToTabByIndex(WebDriver driver,String xpath, int indexNumber, String elementNmae) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            element.click();

        } catch (Exception e) {
            System.out.println("unable to click on element " + elementNmae + " " + e);
        }
    }//end of switchToTabByIndex

    //CREATE verifyTitle method
    public static void verifyTitle(WebDriver driver,String xpath, String elementNmae) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();

        } catch (Exception e) {
            System.out.println("unable to click on element " + elementNmae + " " + e);
        }
    }//end of verifyTitle

    //create a submit method
    public static void submitAction(WebDriver driver,String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.submit();
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + " " + e);
        }
    }//end of submit


}//end of class
