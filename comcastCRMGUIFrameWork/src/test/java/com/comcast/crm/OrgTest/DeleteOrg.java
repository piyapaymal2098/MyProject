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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.genric.fileutility.ExcelUtility;
import com.comcast.crm.genric.fileutility.FileUtility;
import com.comcast.crm.genric.webdriverutility.JavaUtility;
import com.comcast.crm.genric.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositoryuti.CreatingNewOrganizationPage;
import com.comcast.crm.objectRepositoryuti.HomePage;
import com.comcast.crm.objectRepositoryuti.LoginPage;
import com.comcast.crm.objectRepositoryuti.OrganizationInformationPagr;
import com.comcast.crm.objectRepositoryuti.OrganizationPage;

public class DeleteOrg {

	public static void main(String[] args) throws Throwable {
		//read comman data from properties
		FileUtility fil= new FileUtility();
		ExcelUtility excel = new ExcelUtility();
		JavaUtility jlib= new JavaUtility();
		WebDriverUtility wlib= new WebDriverUtility();
		
	
		 String BROWSER = fil.getDataFromPropertiesFile("browser");
		 String URL = fil.getDataFromPropertiesFile("url");
		 String USERNAME = fil.getDataFromPropertiesFile("username");
		  String PASSWORD = fil.getDataFromPropertiesFile("password");
		//generate the random number 
		 
		 
		  String orgName = excel.getDataFromExcel("Orgname", 10, 2) + jlib.getRandomNumber();
	
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
	  
	  
	LoginPage Lp = new LoginPage(driver); 
	//business method 
	  Lp.LoginToapp(URL,USERNAME, PASSWORD);
	
	
//	Lp.getUsername().sendKeys("admin");//insted of accessing the elemnet directly we are going to use public method //
//	Lp.getPassword().sendKeys("admin");
//	Lp.getLoginBtn().click();
	
	
	  //step 3: navigate to organization module
		
		HomePage op = new HomePage(driver);
	
		op.getOrglin().click();
//		op.NavigatetoCampagin();
	
	
	 //step 4: click on create organization module
		
		OrganizationPage cnp= new OrganizationPage(driver); 
		cnp.getCreatNeworgbtn().click();
	
	
	 //step 5: enter all the details & create new organization
		CreatingNewOrganizationPage cnop= new CreatingNewOrganizationPage(driver);
		cnop.creatOrg(orgName);
//	cnop.creatOrg(orgName, Industry);
	  
		
	//verify Header msg expected result
		OrganizationInformationPagr oip= new OrganizationInformationPagr(driver) ;
		 String actOrg = oip.getHeader().getText();
		 if(actOrg.contains(orgName)) {
			 System.out.println(actOrg +"Name is Varified===pass" );
		 }
		 else {
			 System.out.println(actOrg +"Name is not Varified===Fail" ); 
		 }
		 //go back to organzation page
		 op.getOrglin().click();
		 
		
		 //search for organazation
		 
		 cnp.getSearchEdt().sendKeys(orgName);
		 wlib.select(cnp.getSearchDD(), "Organization Name");	
		 cnp.getSerachBtn().click();
		 
		 //In Dynamic webtable select and delete org
		 driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']")).click();
		 wlib.switchToAlterAccpet(driver);
	  
//		 op.logout(); 10- 2
////step:6 logout
//	driver.quit();
		 
//	
		 
	}
	

}
