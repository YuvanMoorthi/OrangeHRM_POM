package com.orangehrm.qa.ExtentReporterListener;

import java.io.File;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportListener implements ITestListener, ISuiteListener {

	private ExtentReports extent;
	private ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@Override
	public void onStart(ISuite suite) {
		String reportPath = System.getProperty("user.dir") + File.separator + "ExtentReports" + File.separator
				+ "ExtentReport.html";

		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
		sparkReporter.config().setReportName("Automation Test Report");
		sparkReporter.config().setDocumentTitle("Execution Summary");

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("Host Name", "Windows 10");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester", "Yuvan_Moorthi");
	}

	@Override
	public void onFinish(ISuite suite) {
		extent.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
		test.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.get().pass("Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.get().fail(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.get().skip(result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		test.get().warning("Test failed but within success percentage");
	}

	@Override
	public void onStart(ITestContext context) {
		// Placeholder for additional setup, if needed.
	}

	@Override
	public void onFinish(ITestContext context) {
		// Placeholder for additional teardown, if needed.
	}
}
