package com.listeners;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.annotations.FrameworkAnnotations;
import com.reports.ExtentLogger;
import com.reports.ExtentReport;

public class ListenerClass implements ITestListener , ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		
			ExtentReport.initReports();
		
		
	}

	@Override
	public void onFinish(ISuite suite) {
		
			ExtentReport.flushReports();
		
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getDescription());
		ExtentReport.addAutors(result.getMethod().getConstructorOrMethod().getMethod().
				getAnnotation(FrameworkAnnotations.class).author()); 
		ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().
				getAnnotation(FrameworkAnnotations.class).category()); 
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName()+" is passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
			ExtentLogger.fail(result.getMethod().getMethodName()+" is failed", true);
			ExtentLogger.fail(result.getThrowable().toString());
			ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName()+" is skipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
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
