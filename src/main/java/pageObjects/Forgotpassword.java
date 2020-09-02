package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Forgotpassword {
    public WebDriver driver;

    By username=By.id("user_email");
    By sendme= By.name("commit");

    public Forgotpassword(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver=driver;
    }

    public WebElement email()
    {
        return driver.findElement(username);
    }

    public WebElement sendinstructions()
    {
        return driver.findElement(sendme);
    }

}

