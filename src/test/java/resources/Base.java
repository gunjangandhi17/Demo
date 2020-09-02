package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;
    public Properties prop;

    public WebDriver Initializedriver() throws IOException
    {
        prop=new Properties();
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
        prop.load(fis);

        String browsername=prop.getProperty("browser");
        System.out.println(browsername);


        if(browsername.contains("chrome"))
        {
            //to make Chrome run in headless mode, we use ChromeOptions object and pass in Chromedriver object
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\drivers\\chromedriver.exe");
            ChromeOptions options=new ChromeOptions();
            if(browsername.contains("headless"))
            {
                options.addArguments("headless");
            }
            //pass the argument to options object and then pass to chromedriver

            driver=new ChromeDriver(options);
        }
        else if(browsername.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\main\\java\\drivers\\geckodriver.exe");
            driver=new FirefoxDriver();
        }
        else if(browsername.equals("edge"))
        {
            System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\src\\main\\java\\drivers\\msedgedriver.exe");
            driver=new EdgeDriver();
        }

//give implicit time
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

        //we need to send driver object back so that we can use it in test case
    }

    //method for screenshot
    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException
    {
        TakesScreenshot ts=(TakesScreenshot)driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        //create destination location


        String destinationFile=System.getProperty(System.getProperty("user.dir")+"\\src\\test\\java\\test-output\\screenshots\\"+driver.getTitle()+testCaseName+".png");
        //to copy file from virtual source location to local
        FileUtils.copyFile(source, new File(destinationFile));

        return destinationFile;
    }

    public static void takeScreenshot() throws Exception {
        String timeStamp;
        File screenShotName;
        File reports;
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);


        //The below method will save the screen shot in d drive with name "screenshot.png"
        timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        screenShotName = new File(System.getProperty("user.dir")+"\\src\\test\\java\\test-output\\screenshots\\"+driver.getTitle()+timeStamp+".png");
        FileUtils.copyFile(scrFile, screenShotName);
        Reporter.log("<br><img src='"+screenShotName+"'height='400' width='400'/><br>");


    }



}





