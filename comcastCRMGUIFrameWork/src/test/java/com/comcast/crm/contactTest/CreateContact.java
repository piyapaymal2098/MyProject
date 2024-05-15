package com.comcast.crm.contactTest;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.comcast.crm.basetest.baseclass;
import com.comcast.crm.genric.fileutility.ExcelUtility;
import com.comcast.crm.genric.fileutility.FileUtility;
import com.comcast.crm.genric.webdriverutility.JavaUtility;
import com.comcast.crm.genric.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositoryuti.CreatNewContactPage;
import com.comcast.crm.objectRepositoryuti.HomePage;
import com.comcast.crm.objectRepositoryuti.LoginPage;

public class CreateContact extends baseclass {

	public static void main(String[] args) throws Throwable {
		
		//creat object fileutilty
		
		FileUtility fil= new FileUtility();
		ExcelUtility excel = new ExcelUtility();
		
		JavaUtility jlib= new JavaUtility();
		WebDriverUtility wlib= new WebDriverUtility();
		
		 String BROWSER = fil.getDataFromPropertiesFile("browser");
		 String URL = fil.getDataFromPropertiesFile("url");
		 String USERNAME = fil.getDataFromPropertiesFile("username");
		  String PASSWORD = fil.getDataFromPropertiesFile("password");
		  
		//generate the random number 
		  String LastName = excel.getDataFromExcel("Contact", 1, 2) + jlib.getRandomNumber();
		  
		  WebDriver driver = null;
		  
		  if(BROWSER.equals("chrome")) {
			 
			  driver= new ChromeDriver();
		  }
		  
		  else  if(BROWSER.equals("firefox")) {
			  
			  driver= new FirefoxDriver();
		  }
		  else if(BROWSER.equals("edge")) {
			  driver= new EdgeDriver();
		  }
//		  //step 1: login to app
		  wlib.waitforPageLoad(driver);
  
	
	  LoginPage Lp = new LoginPage(driver);
	  
	 Lp.LoginToapp(URL,USERNAME, PASSWORD);
	  
//   driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
   
	  //step 3: navigate to contact module
	HomePage hp= new HomePage(driver);
	hp.getConlin().click();
	
	 //step 4: click on create comodule
	CreatNewContactPage cncp= new CreatNewContactPage(driver);
	cncp.getCreatNEDt().click();

	cncp.getLastnameEdt().sendKeys(LastName);
	 //step 5: enter all the details & create new organization
//
//	  String startDate = jlib.getSystemDateYYYYDDMM();
//	  
//	  
//	 String EndDate = jlib.getRequrieDateYYYYDDMM(30);
//	
//	
//	//step:creat support date satrdate
//	
//	 cncp.getSupportStartDate().clear();
//	 cncp.getSupportStartDate().sendKeys(startDate);
//	//Enddate
//	 cncp.getSupportEndDate().clear();
//	 cncp.getSupportEndDate().sendKeys(EndDate);
//	
//	
//	
//	
//	driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
	  cncp.suppoortendstartdate();
	
	//verify Header msg expected result
	 String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
	 
	 //to verify partical data we ues contains
	if(actLastName.equals(LastName)) {
		System.out.println(LastName+"is created==pass");
	}
	else {
		System.out.println(LastName+"is not created==Fail");
	}
//	 String actStarDate = driver.findElement(By.xpath("//span[@id=\"dtlview_Support Start Date\"]")).getText();
//	
//	if(actStarDate.equals(startDate)) {
//		System.out.println(startDate+"is created==pass");
//	}
//	else {
//		System.out.println(startDate+"is not created==Fail");
//	 
//	}
//	
////step:6 logout
//	Thread.sleep(1000);
//     Actions act = new Actions(driver);
//    act.moveToElement(driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"))).perform();
//	driver.findElement(By.linkText("Sign Out")).click();
//	driver.quit();

	}

}
