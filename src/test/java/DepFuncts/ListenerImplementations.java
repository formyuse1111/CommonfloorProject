package DepFuncts;

import Utilities.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class ListenerImplementations implements ITestListener, WebDriverEventListener{

    public void onTestStart(ITestResult iTestResult) {

        System.out.println("Starting the test: " + iTestResult.getMethod().getMethodName());

    }

    public void onTestSuccess(ITestResult iTestResult) {

    }

    public void onTestFailure(ITestResult iTestResult)
    {

        System.out.println("Test failed: " + iTestResult.getMethod().getMethodName());
/*        System.out.println("***** Error "+iTestResult.getName()+" test has failed *****");
        String methodName=iTestResult.getName().toString().trim();
        ITestContext context = iTestResult.getTestContext();
        WebDriver driver = (WebDriver)context.getAttribute("driver");
        try {
            new DriverUtils(driver).saveScreenshot(methodName);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }

    public void beforeAlertAccept(WebDriver webDriver) {

    }

    public void afterAlertAccept(WebDriver webDriver) {

    }

    public void afterAlertDismiss(WebDriver webDriver) {

    }

    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    public void beforeNavigateTo(String s, WebDriver webDriver) {

    }

    public void afterNavigateTo(String s, WebDriver webDriver) {

    }

    public void beforeNavigateBack(WebDriver webDriver) {

    }

    public void afterNavigateBack(WebDriver webDriver) {

    }

    public void beforeNavigateForward(WebDriver webDriver) {

    }

    public void afterNavigateForward(WebDriver webDriver) {

    }

    public void beforeNavigateRefresh(WebDriver webDriver) {

    }

    public void afterNavigateRefresh(WebDriver webDriver) {

    }

    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {

        try {
            System.out.println("Going to find the element: " + webElement.getText());
        }
        catch (Exception e)
        {
        }

    }

    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {

    }

    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        try {
            System.out.println("Going to click on the element: " + webElement.getText());
        }
        catch (Exception e)
        {
        }

    }

    public void afterClickOn(WebElement webElement, WebDriver webDriver) {

        try {
            System.out.println("Clicked on this element: " + webElement.getText());
        }
        catch (Exception e)
        {
        }

    }

    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    public void beforeScript(String s, WebDriver webDriver) {

    }

    public void afterScript(String s, WebDriver webDriver) {

    }

    public void beforeSwitchToWindow(String s, WebDriver webDriver) {

    }

    public void afterSwitchToWindow(String s, WebDriver webDriver) {

    }

    public void onException(Throwable throwable, WebDriver webDriver) {

    }
}
