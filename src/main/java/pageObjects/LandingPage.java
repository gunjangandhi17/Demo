package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    public WebDriver driver;


    private By login=By.xpath("//span[contains(text(),'Login')]");
    private By register=By.xpath("//span[contains(text(),'Register')]");
    private By title=By.xpath("//h2[contains(text(),'Featured Courses')]");
    private By contacts=By.xpath("//a[contains(text(),'Contact')]");
    //xpath for forgot password -//a[contains(text(),'Forgot')]
    private By learntitle=By.cssSelector("div[class*=video-banner] p");
    private By acadamytitle=By.cssSelector("div[class*=video-banner] h3");

    public LandingPage(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver=driver;
    }




    public WebElement Register()
    {
        return driver.findElement(register);
    }

    public WebElement GetTitle()
    {
        return driver.findElement(title);
    }

    public WebElement GetContact()
    {
        return driver.findElement(contacts);
    }

    public WebElement GetLearnTitle()
    {
        return driver.findElement(learntitle);
    }

    public WebElement GetAcadamytitle()
    {
        return driver.findElement(acadamytitle);
    }




    public WebElement Login() {
        // TODO Auto-generated method stub
       return driver.findElement(login);

    }





}

