 package com.comcast.crm.listenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.baseclass;
import com.comcast.crm.genric.webdriverutility.UtilityClassObject;

public class ListenerImpclass implements ITestListener , ISuiteListener{
	
	public static ExtentReports report;
	public static ExtentTest test;
	@Override 
	public void onStart(ISuite suite) {
	System.out.println("Report Configration");
	 String cTime = new Date().toString().replace(" ", "_").replace(":", "_");
	 ExtentSparkReporter  spark= new ExtentSparkReporter("./AdvanceReport/report_"+cTime+".html");
		spark.config().setDocumentTitle("CRM Test Suite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		//add enviroment info and creat test
		 report= new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "window-11");
		report.setSystemInfo("Browser", "chrome");
		 test = report.createTest("CreatContactTest");
		
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("========"+result.getMethod().getMethodName()+"====Start===");
		 test = report.createTest(result.getMethod().getMethodName());//testcase name/ creatcontct
		 UtilityClassObject.setTest(test);//<== pass real test variable 
		 test.log(Status.INFO, result.getMethod().getMethodName()+"====>STARTED====");//befor excution of excution of every testtcase thos meg will be insterted
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("========"+result.getMethod().getMethodName()+"====ENd===");
		test.log(Status.INFO, result.getMethod().getMethodName()+"====>Pass====");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		 String testNmae = result.getMethod().getMethodName();//failure testcase
		TakesScreenshot edriver=(TakesScreenshot)baseclass.sdriver;
		String filepath = edriver.getScreenshotAs(OutputType.BASE64);
		 String cTime = new Date().toString().replace(" ", "_").replace(":", "_");
		 test.addScreenCaptureFromBase64String(filepath, testNmae +"_"+cTime);
		 test.log(Status.INFO, result.getMethod().getMethodName()+"====>Failed====");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
	
	

}
