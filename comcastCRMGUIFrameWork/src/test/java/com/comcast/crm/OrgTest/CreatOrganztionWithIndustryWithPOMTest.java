package com.comcast.crm.OrgTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.genric.fileutility.ExcelUtility;
import com.comcast.crm.genric.fileutility.FileUtility;
import com.comcast.crm.genric.webdriverutility.JavaUtility;
import com.comcast.crm.genric.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositoryuti.CreatingNewOrganizationPage;
import com.comcast.crm.objectRepositoryuti.HomePage;
import com.comcast.crm.objectRepositoryuti.LoginPage;
import com.comcast.crm.objectRepositoryuti.OrganizationInformationPagr;
import com.comcast.crm.objectRepositoryuti.OrganizationPage;

public class CreatOrganztionWithIndustryWithPOMTest {

	public static void main(String[] args) throws Throwable {
		//read comman data from properties
		FileUtility flib= new FileUtility();
		JavaUtility jlib= new JavaUtility();
		ExcelUtility lib= new ExcelUtility();
		WebDriverUtility wlib= new WebDriverUtility();
		
		
		
		
		 String BROWSER = flib.getDataFromPropertiesFile("browser");
		 String URL = flib.getDataFromPropertiesFile("url");
		 String USERNAME = flib.getDataFromPropertiesFile("username");
		  String PASSWORD = flib.getDataFromPropertiesFile("password");
		//generate the random number 
		 
		
		  String orgName = 	  lib.getDataFromExcel("Orgname", 4, 2) + jlib.getRandomNumber();
		  //drop down is static data no need to attache the random integer
		  String Industry = lib.getDataFromExcel("Orgname", 4, 3);
		  String Type = lib.getDataFromExcel("Orgname", 4, 4);
	
	
		  WebDriver driver =null;
		  
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
		  LoginPage lp= new LoginPage(driver);
		  lp.LoginToapp(URL,USERNAME, PASSWORD);
		  

	  //step 3: navigate to organization module
		  HomePage hp= new HomePage(driver);
          hp.getOrglin().click();
				  
	
	 //step 4: click on create organization module
          OrganizationPage orn= new OrganizationPage(driver);
          orn.getCreatNeworgbtn().click();
          
         
	
	 //step 5: enter all the details & create new organization
    CreatingNewOrganizationPage cno= new CreatingNewOrganizationPage(driver);
    cno.creatOrg(orgName, Industry);
	
	
    cno.type(Type);

	//verify the drop down industry 
    OrganizationInformationPagr oip= new OrganizationInformationPagr(driver);
    String actIndusrty = oip.getIndustryveriEle().getText();

	if(actIndusrty.equals(Industry)) {
		System.out.println(Industry +"   information is  verified==pass");
	}
	else {
		System.out.println(Industry +"    information is not verified ==Fail");
	}
	
	//verify the drop down type info
	String actType = oip.getTypedtlview().getText();

	if(actType.equals(Type)) {
		System.out.println(Type +"     information is  verified==pass");
	}
	else {
		System.out.println(Type +"    information is not verified ==Fail");
	}
	 
	

//step:6 logout
	hp.logout();

	
	
	 }

}
