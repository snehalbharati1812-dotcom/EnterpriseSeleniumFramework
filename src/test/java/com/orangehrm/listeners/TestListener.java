package com.orangehrm.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static ExtentReports extent;
    private static ExtentSparkReporter spark;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        if (extent == null) {
            extent = new ExtentReports();
            spark = new ExtentSparkReporter("reports/ExtentReport.html");
            spark.config().setReportName("Automation Test Results");
            spark.config().setDocumentTitle("Test Execution Report");
            extent.attachReporter(spark);
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        if (test.get() != null) {
            test.get().log(Status.PASS, "Test Passed");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        if (test.get() != null) {
            test.get().log(Status.FAIL, result.getThrowable());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        if (test.get() != null) {
            test.get().log(Status.SKIP, "Test Skipped");
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush();
        }
    }
}