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

public class ValidateTitle extends Base {
    public WebDriver driver;

    LandingPage ld;
    @Test

    //we need to tell the method that we are expecting 3 variables, username,password and text
    public void ValidateTitle() throws IOException
    {

        //get the methods from otherclass Landingpage
        ld=new LandingPage(driver);

        //to get the text through test
        ld.GetTitle().getText();
        //to compare the text value with actual value, we have to use assertions

        Assert.assertEquals(ld.GetTitle().getText(), "FEATURED COURSES");

        //to get the text of Acadamy title


        ld.GetContact().getText();
        Reporter.log("Title is Verified");


        //script will fail if the actual value received from ld.GetTitle().getText() is not same as Featured Courses
    }

    @Test
    public void ValidateHeader()
    {
        ld=new LandingPage(driver);
        ld.GetAcadamytitle().getText();
        Assert.assertEquals(ld.GetAcadamytitle().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
        Reporter.log("Header is Verified");

    }
    @AfterTest
    public void teardown()
    {
        driver.quit();
        System.out.println("close");
    }

    @BeforeTest
    public void initialization() throws IOException
    {
        driver=Initializedriver();

        driver.get(prop.getProperty("url"));

        System.out.println(driver.getTitle());
    }


}

