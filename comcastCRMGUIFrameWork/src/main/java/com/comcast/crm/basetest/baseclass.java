package com.comcast.crm.basetest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.genric.databaseutility.DataBaseUtility;
import com.comcast.crm.genric.fileutility.ExcelUtility;
import com.comcast.crm.genric.fileutility.FileUtility;
import com.comcast.crm.genric.webdriverutility.JavaUtility;
import com.comcast.crm.genric.webdriverutility.UtilityClassObject;
import com.comcast.crm.genric.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositoryuti.HomePage;
import com.comcast.crm.objectRepositoryuti.LoginPage;

public class baseclass {
public 	DataBaseUtility dlib= new DataBaseUtility();
public 	FileUtility flib= new FileUtility();
public	ExcelUtility excel = new ExcelUtility();
public	JavaUtility jlib= new JavaUtility();
public	WebDriverUtility wlib=  new WebDriverUtility();
public WebDriver driver = null;//dont declaer in method beacues it act like a local
public static WebDriver sdriver = null;


	@BeforeSuite(groups = {"smokeTest","regressionTest"} )
	public void confiBs() throws Throwable {
		System.out.println("===connection to db===");
		dlib.getDbConnection();
	}


	@BeforeClass(groups = {"smokeTest","regressionTest"} )
	public void confiBC() throws Throwable {
		
	
		System.out.println("====launch the browser====");	
	String BROWSER = flib.getDataFromPropertiesFile("browser");;
	 
	  
	  if(BROWSER.equals("chrome")) {
		 
		  driver= new ChromeDriver();
	  }
	  
	  else  if(BROWSER.equals("firefox")) {
		  
		  driver= new FirefoxDriver();
	  }
	  else if(BROWSER.equals("edge")) {
		  driver= new EdgeDriver();
	  }
	  sdriver=driver;
	  UtilityClassObject.setDriver(driver);
		
	}
	@BeforeMethod(groups = {"smokeTest","regressionTest"} )
	public void configBM() throws Throwable {
		System.out.println("====login to application====");
		 String URL = flib.getDataFromPropertiesFile("url");
		 String USERNAME = flib.getDataFromPropertiesFile("username");
		 String  PASSWORD= flib.getDataFromPropertiesFile("password");
		LoginPage lp= new LoginPage(driver);
		lp.LoginToapp(URL, USERNAME, PASSWORD);
	}
	
	@AfterMethod(groups = {"smokeTest","regressionTest"} )
	public void configAM() {
		System.out.println("====logout to application====");
	HomePage hp= new HomePage(driver);
	hp.logout();
	}
	@AfterClass(groups = {"smokeTest","regressionTest"} )
	public void confiAC() {
		System.out.println("====close the browser====");
		driver.quit();
		
	}
		@AfterSuite(groups = {"smokeTest","regressionTest"} )
		public void confiAs() throws SQLException {
			
			System.out.println("====close db connection====");
			dlib.closeDbconnection();
			
		
	}
}
