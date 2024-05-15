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

public class CreatOrganztionWithPhoneNumberPOM {

	public static void main(String[] args) throws Throwable {
		//read comman data from properties
		FileUtility flib= new FileUtility();
		JavaUtility jlib= new JavaUtility();
		ExcelUtility Elib= new ExcelUtility();
		WebDriverUtility wlib= new WebDriverUtility();
		
		 String BROWSER = flib.getDataFromPropertiesFile("browser");
		 String URL = flib.getDataFromPropertiesFile("url");
		 String USERNAME = flib.getDataFromPropertiesFile("username");
		  String PASSWORD = flib.getDataFromPropertiesFile("password");
		  
		//generate the random number 
		 
		  String orgName=  Elib.getDataFromExcel("Orgname", 7, 2) + jlib.getRandomNumber();
		
		  String PhoneNumber = Elib.getDataFromExcel("Orgname", 7, 3);//Instead  of toString write getStringcellvalue//because it right like  9.923452345E9 
		  //and manul u can write in the exel ' qoute becaues its considering string
		
		  //while storing the numerice data in excel make sure we have convert that numeric data in as  string in excel itself dont try to converting programatical  using tostring 
		
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
	
	 //step 4: click on create organization m;
	OrganizationPage cnp= new OrganizationPage(driver); 
	cnp.getCreatNeworgbtn().click();
	
	 //step 5: enter all the details & create new organization
	CreatingNewOrganizationPage cno= new CreatingNewOrganizationPage(driver);
	cno.phone(orgName, PhoneNumber);

	
	
	
	//verify the Phone Number  info Expected r
	OrganizationInformationPagr oip= new OrganizationInformationPagr(driver);
	
	String actPhoneNumber = oip.getPhoneNou().getText();
	if(actPhoneNumber.equals(PhoneNumber)) {
		System.out.println(PhoneNumber +"     information is  verified==pass");
	}
	else {
		System.out.println(PhoneNumber +"    information is not verified ==Fail");
	}
	 


///step:6 logout
hp.logout();

	
	}

}
