package resources;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listeners extends Base implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
        Reporter.log("Test Started");



    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        //get the value from object ExtentTest and then pass the status
        System.out.println("Test pass");
        Reporter.log("Test Passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            takeScreenshot();
            System.out.println("Successfully captured a screenshot");
        }
        catch (Exception e)
        {
            System.out.println("Exception while taking screenshot "+e.getMessage());
        }
    }

      @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub


    }
}


