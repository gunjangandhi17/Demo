package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage {

    public WebDriver driver;

    By username=By.id("user_email");
    By password= By.xpath("//input[@type='password']");
    By signin=By.name("commit");
    By forgotpassword=By.linkText("Forgot Password?");

    public Loginpage(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver=driver;
    }

    public Forgotpassword forgotPassword()
    {
        //as on clicking forgot password, control moves to new page so we will click here

        driver.findElement(forgotpassword).click();
        return new Forgotpassword(driver);

    }



    public WebElement password()
    {
        return driver.findElement(password);
    }

    public WebElement email()
    {
        return driver.findElement(username);
    }

    public WebElement signin()
    {
        return driver.findElement(signin);
    }

}
