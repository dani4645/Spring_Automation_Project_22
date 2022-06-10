package day11;
import ReusableLibraries.Reusable_Actions;
import ReusableClasses.Reusable_Actions_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;
public class US_BANK {


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

    @Test(priority = 1)
    public void clickOnPersonalTab(){

        logger = reports.startTest("Click on Personal Tab ");
        driver.navigate().to("https://www.usbank.com");
        //click on the tab that says Personal
        Reusable_Actions_Loggers.clickAction(driver,"//*[@id='navigation-menuitem-personal']",logger,"Personal Tab");

        //click on the investment and retirement plans
        Reusable_Actions_Loggers.clickAction(driver,"//*[@id='navigation-menuitem-investing-and-retirement']",logger,"Investment and Retirement");

        //click on the investment management options
        Reusable_Actions_Loggers.clickAction(driver,"//*[@href='/content/usbank/investing/investment-management.html']",logger,"Investment Management");

        //using jse to scroll so you can see all the plans
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("scroll(0,5300)");

        //end the logger per test

        reports.endTest(logger);

    }//end of Test 1


    @Test(priority = 2)
    public void VerifyTitle() {

        logger = reports.startTest("Verify title");
        driver.navigate().to("https://www.usbank.com");

        //verify Title for US Bank
        Reusable_Actions_Loggers.verifyTitle(driver, logger, "Consumer banking");

        reports.endTest(logger);
    }//end of Test 2

    @Test(priority = 3)
    public void CheckingAccount(){

        logger = reports.startTest("Click on Checking Account");
        driver.navigate().to("https://www.usbank.com");

        //click on the tab that says Personal
        Reusable_Actions_Loggers.clickAction(driver,"//*[@id='navigation-menuitem-personal']",logger,"Personal Tab");

        //Click on Bank Account, so you can get all Account Plans List
        Reusable_Actions_Loggers.clickAction(driver,"//*[@id='navigation-menuitem-bank-accounts']",logger,"Bank Account");

        //click on Checking Account
        Reusable_Actions_Loggers.clickAction(driver,"//*[@href='/bank-accounts/checking-accounts.html']",logger,"Checking Account");

        //use jse to scroll down and see the options
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("scroll(0,400)");


        reports.endTest(logger);
    }//end of Test 3

    @Test(priority = 4)
    public void ApplyForCreditCard(){

        logger = reports.startTest("Click on Credit Card");
        driver.navigate().to("https://www.usbank.com");
        //click on the tab that says Personal
        Reusable_Actions_Loggers.clickAction(driver,"//*[@id='navigation-menuitem-personal']",logger,"Personal Tab");

        //click on the option that say Credit Card
        Reusable_Actions_Loggers.clickAction(driver,"//*[@id='navigation-menuitem-credit-cards']",logger,"Credit Card");

        //click on View all Credit Card, so you can see all credit card and apply for one
        Reusable_Actions_Loggers.clickAction(driver,"//*[@href='/credit-cards.html']",logger,"View Credit Cards");

        //using jse to scroll down
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("scroll(0,3500)");

        //click on apply for credit card
        Reusable_Actions_Loggers.clickAction(driver,"//*[@href='https://applications.usbank.com/oad/begin?locationCode=8069&sourceCode=37913&offerId=7961492XPV']",logger,"Apply Now");

        //click on Get Started
        Reusable_Actions_Loggers.clickAction(driver,"//*[@id='securedCardOnline']",logger,"Get Started");

        reports.endTest(logger);

    }//end of Test 4

   @Test(priority = 5)
    public void clickOnVehicleLoan(){

        logger = reports.startTest("Click on Credit Card");
        driver.navigate().to("https://www.usbank.com");

        //click on the tab that says Personal
        Reusable_Actions_Loggers.clickAction(driver,"//*[@id='navigation-menuitem-personal']",logger,"Personal Tab");

        //click on Vehicle Loan option
        Reusable_Actions_Loggers.clickAction(driver,"//*[@id='navigation-menuitem-vehicle-loans']",logger,"Vehicle Loan");

        //click on Auto Loan options Now
        Reusable_Actions_Loggers.clickAction(driver,"//*[@href='/content/usbank/vehicle-loans/auto-loans.html']",logger,"Auto Loan");

        //using jse to scroll down to see all the options
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("scroll(0,600)");

        //click on apply now
        Reusable_Actions_Loggers.clickAction(driver,"//*[@aria-label='Apply now for a U.S. Bank new car loan']",logger,"Apply Now");

        reports.endTest(logger);
    }//end of Test 5

    @Test(priority = 6)
    public void HomeLoanandEquityPlans() {

        //Create an array list for zipcode
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11218");
        logger = reports.startTest("HomeLoanandEquity");
        for (int i = 0; i < zipCode.size(); i++) {


            driver.navigate().to("https://www.usbank.com");

            //click on the tab that says Personal
            Reusable_Actions_Loggers.clickAction(driver, "//*[@id='navigation-menuitem-personal']", logger, "Personal Tab");

            //click on the tab that says Home Loan
            Reusable_Actions_Loggers.clickAction(driver, "//*[@id='navigation-menuitem-home-loans']", logger, "HomeLoan");

            //click on Home Equity
            Reusable_Actions_Loggers.clickAction(driver, "//*[@href='/home-loans/home-equity.html']", logger, "HomeLoan");


            //using jse to scroll down
            JavascriptExecutor jse = (JavascriptExecutor) driver;

            jse.executeScript("scroll(0,600)");

            Reusable_Actions_Loggers.clickAction(driver, "//*[@aria-label='Apply for a U.S. Bank Home equity loan']", logger, "Apply Now");

            //type Zipcode in zipcode field
            Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@class='form-control zipInputField']",zipCode.get(i),logger,"Zipcode");

            //click the go button
            Reusable_Actions_Loggers.submitAction(driver,"//*[@id='executeZipEligibilityButton']",logger,"Click on GO button");

            reports.endTest(logger);
        }//end of forLoop
    }//end of test 6



    @AfterSuite
    public void quitSession(){

        driver.quit();
        reports.flush();

    }//end of after suite
}//end of java class














