package Testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Forgotpassword;
import pageObjects.LandingPage;
import pageObjects.Loginpage;
import resources.Base;

import java.io.IOException;

public class Homepage extends Base {

    public WebDriver driver;


    @BeforeTest

    public void Initialization() throws IOException {
        driver=Initializedriver();

        driver.get(prop.getProperty("url"));

        System.out.println(driver.getTitle());
        driver.close();
    }

    @Test(dataProvider="getData")
    public void Loginpage(String username,String password) throws Exception 	{
        driver=Initializedriver();
        driver.get(prop.getProperty("url"));
        System.out.println(driver.getTitle());
        LandingPage ld=new LandingPage(driver);
        ld.Login().click();
        Loginpage lp=new Loginpage(driver);
        lp.email().sendKeys(username);
        lp.password().sendKeys(password);
        lp.signin().click();
        Reporter.log("Login is Verified");
        takeScreenshot();
        Forgotpassword fp= lp.forgotPassword();
        fp.email().sendKeys("XYZ");
        fp.sendinstructions();
        Reporter.log("Forgot link is Sent");
        driver.close();
    }

    @AfterTest
    public void teardown()
    {
        driver.quit();
    }



    @DataProvider
    public Object[][] getData()
    {
        // TODO Auto-generated method stub
        //row that is first[] will identify how many different types of data test should run
        //second [] or columns will identify how many values we are sending per test case
        Object[][] data=new Object[2][2];
        data[0][0]="non-restricted user@gmail.com";
        data[0][1]="non-restricted";

        data[1][0]="restricted user@gmail.com";
        data[1][1]="restricted";

        return data;
    }


}




