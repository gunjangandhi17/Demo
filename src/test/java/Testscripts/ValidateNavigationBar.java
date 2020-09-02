package Testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.Base;

import java.io.IOException;

public class ValidateNavigationBar extends Base {

    public WebDriver driver;
    //public static Logger log =LogManager.getLogger(Base.class.getName());


    @BeforeTest
    public void initialization() throws IOException
    {
        driver=Initializedriver();
        //driver.get("http://www.qaclickacademy.com/");
        //directly take url from data.properties file and then call from base class
        //log.info("Driver is Initiated");
        Reporter.log("Driver is Initiated");
        driver.get(prop.getProperty("url"));
        //log.info("Homepage");
        Reporter.log("Homepage");
        System.out.println(driver.getTitle());
    }

    @Test
    //we need to tell the method that we are expecting 3 variables, username,password and text
    public void Mainpage() throws IOException
    {


        //get the methods from otherclass Landingpage

        LandingPage ld=new LandingPage(driver);
        //to get the text through test
        //to compare the text value with actual value, we have to use assertions


        //is displayed will send a boolean value - true if contact is present and false if it is not present

        //ld.GetContact().isDisplayed();

        Assert.assertTrue(ld.GetContact().isDisplayed());
        //log.info("Contact is displayed");
        Reporter.log("Contact is displayed");



    }




    @AfterTest
    public void teardown()
    {
        driver.quit();
    }

}


