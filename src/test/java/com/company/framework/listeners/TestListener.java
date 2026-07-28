package com.company.framework.listeners;

import com.company.framework.base.BaseTest;
import com.company.framework.utils.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    // 1. Initialize ExtentReports instance
    private static ExtentReports extent = ExtentManager.getInstance();

    // 2. ThreadLocal with explicit <ExtentTest> generic type to handle parallel execution & prevent compilation errors
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        // Create an entry in the report when a @Test method starts
        ExtentTest test = extent.createTest(result.getMethod().getMethodName(),
                result.getMethod().getDescription());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Log pass status
        extentTest.get().log(Status.PASS, "Test Passed Successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Log fail status along with the exception details
        extentTest.get().log(Status.FAIL, "Test Failed: " + result.getThrowable());

        // Get driver instance from the running test class to capture screenshot
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();

        if (driver != null) {
            String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            extentTest.get().addScreenCaptureFromBase64String(base64Screenshot, "Failure Screenshot");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Log skipped status
        extentTest.get().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        // Write all logs into the HTML ExtentReport file
        extent.flush();
    }
}