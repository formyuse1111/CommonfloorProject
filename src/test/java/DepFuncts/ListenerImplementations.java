package DepFuncts;

import org.apache.log4j.Logger;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementations implements ITestListener {

    private final Logger logger = Logger.getLogger(this.getClass());

    public void onTestStart(ITestResult iTestResult) {

        logger.info("[Listener] Starting the test: " + iTestResult.getMethod().getMethodName());

    }

    public void onTestSuccess(ITestResult iTestResult) {

    }

    public void onTestFailure(ITestResult iTestResult) {

        logger.debug("[Listener] Test failed: " + iTestResult.getMethod().getMethodName());

    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }

}