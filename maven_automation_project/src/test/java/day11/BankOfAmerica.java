package day11;

import ReusableLibraries.Reusable_Actions;
import ReusableClasses.Reusable_Actions_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class BankOfAmerica {

    //declare the local driver outside so that it can be reusable with other annotation methods
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;
    //before suite will set the driver you are using


    @BeforeSuite
    public void SetChromeDriver(){
        driver = Reusable_Actions.setDriver();
        //define the path to the report
        reports = new ExtentReports("src/main/java/HTML_Report/Automation.html",true);
    }//end of before suite annotation

    //navigate to Bank Of America website and click on Home Loans
    @Test(priority = 1)
    public void clickHomeLoans() throws InterruptedException {
        logger = reports.startTest("Home Loans");

        driver.navigate().to("https://www.bankofamerica.com");

        //click on home loans
        Reusable_Actions_Loggers.clickAction(driver,"//*[text()= 'Home Loans']",logger,"Home Loans");
                //click on home equity section
        Reusable_Actions_Loggers.clickAction(driver,"//*[@id='homeEquity']",logger,"Home Equity");

        //using jse to scroll so you can see the rates
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,2000)");

        //click on apply now
        Reusable_Actions_Loggers.clickAction(driver,"//*[@id='prequalifyTabNav']",logger,"Apply Now");

        //click on property location
        Reusable_Actions_Loggers.clickAction(driver,"//*[@id='zz_propertyLocation_v_1']",logger,"property location");

        //select new york as my state
        WebElement SelectLocation = driver.findElement(By.xpath("//*[@id='zz_propertyLocation_v_1']"));
        Select LocationDropDown = new Select(SelectLocation);
        LocationDropDown.selectByVisibleText("New York");

        //select primary residence as for the property use
        WebElement PropertyUse = driver.findElement(By.xpath("//*[@aria-describedby='zz_propertyUse_v_1-hint zz_propertyUse_v_1-errtxt']"));
        LocationDropDown = new Select(PropertyUse);
        LocationDropDown.selectByVisibleText("Primary residence");

        //WebElement EstimatedPropertyValue = driver.findElement(By.xpath("//*[@aria-describedby='zz_propertyValue_v_1-hint zz_propertyValue_v_1-errtxt']"));
       // LocationDropDown.selectByIndex(200000);

        //end the logger per test
               reports.endTest(logger);
    }//end of test 1




    @Test(priority = 2)
   public void VerifyTitle() throws InterruptedException {

      logger = reports.startTest("Verify title");
       driver.navigate().to("https://www.bankofamerica.com");

      // verify Title for Bank of America
       Reusable_Actions_Loggers.verifyTitle(driver, logger, "consumer banking");

       reports.endTest(logger);

   }//end of Test 2

     @Test(priority = 3)
   public void CreditCards() {
         driver.navigate().to("https://www.bankofamerica.com");

         //click on credit cards
        Reusable_Actions_Loggers.clickAction(driver,"//*[text()= 'Credit Cards']",logger,"Credit Cards");

        //click on credit cards for cash back
         Reusable_Actions_Loggers.clickAction(driver,"//*[@id='cashRewardsCards']",logger," cash back credit cards");

         reports.endTest(logger);
    }//end of test 3

    @AfterSuite
        public void quitSession () {
          // driver.quit();
            reports.flush();
        }//end of after suite



}//end of java class

