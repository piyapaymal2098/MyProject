package com.comcast.crm.contactTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

import com.comcast.crm.genric.fileutility.ExcelUtility;
import com.comcast.crm.genric.fileutility.FileUtility;
import com.comcast.crm.genric.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositoryuti.CreatNewContactPage;
import com.comcast.crm.objectRepositoryuti.CreatingNewOrganizationPage;
import com.comcast.crm.objectRepositoryuti.HomePage;
import com.comcast.crm.objectRepositoryuti.LoginPage;
import com.comcast.crm.objectRepositoryuti.OrganizationInformationPagr;
import com.comcast.crm.objectRepositoryuti.OrganizationPage;

public class CreateContactWithOrgTest {
	
	public static void main(String[] args) throws Throwable {
		FileUtility flib= new FileUtility();
		ExcelUtility elib= new ExcelUtility();
	
		WebDriverUtility wlib= new WebDriverUtility();
		
		//read comman data from properties
		FileInputStream fis1 = new FileInputStream("./configAppData/creatorg.properties.txt");
				 Properties pro = new Properties();
				 pro.load(fis1);
				 String BROWSER =flib.getDataFromPropertiesFile("browser");
				 String URL = flib.getDataFromPropertiesFile("url");
				 String USERNAME = flib.getDataFromPropertiesFile("username");
				  String PASSWORD =flib.getDataFromPropertiesFile("password");
				//generate the random number 
				 Random r = new Random();
				 int RandomInt = r.nextInt(100);
				
					FileInputStream fis = new FileInputStream("./testData/TestScriptdata.xlsx");
					
					
		
				 Workbook wb = WorkbookFactory.create(fis);
				 Sheet sh = wb.getSheet("Contact");
				 
				  Row row = sh.getRow(7);
				  String orgName = elib.getDataFromExcel("Contact", 7, 2) + RandomInt;
				  String ContactLastName = elib.getDataFromExcel("Contact", 7, 3);
				  wb.close();
				  
				  
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
//				  //step 1: login to app
				  wlib.waitforPageLoad(driver);
		
			  LoginPage lp= new LoginPage(driver);
			  lp.LoginToapp(URL,USERNAME, PASSWORD);
		   
			  
				HomePage op = new HomePage(driver);

				op.getOrglin().click();

				// step 4: click on create organization module

				OrganizationPage cnp = new OrganizationPage(driver);
				cnp.getCreatNeworgbtn().click();

				// step 5: enter all the details & create new organization
				CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
				cnop.creatOrg(orgName);
//			cnop.creatOrg(orgName, Industry);

				// verify Header msg expected result
				OrganizationInformationPagr oip = new OrganizationInformationPagr(driver);
				String actOrg = oip.getHeader().getText();
				if (actOrg.contains(orgName)) {
					System.out.println(actOrg + "Name is Varified===pass");
				} else {
					System.out.println(actOrg + "Name is not Varified===Fail");
				}		  
			  

			HomePage h =  new HomePage(driver);
			h.getConlin().click();
			
			CreatNewContactPage cncp= new CreatNewContactPage(driver);
			cncp.getCreatNEDt().click();
			cncp.getLastnameEdt().sendKeys(ContactLastName);
			
//			//step 5 :Navigate to contact 
//			driver.findElement(By.xpath("//a[@href=\"index.php?module=Contacts&action=index\"]")).click();
//			
//			 //step 4: click on create contact module
//			driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
//			
//			
//			 //step 5: enter all the details & create new organization
//			driver.findElement(By.name("lastname")).sendKeys(ContactLastName);
			
	
			cncp.getPlusSing().click();
			//switching  to child window
			wlib.switchToTabonURL(driver, "module=Accounts");
			
			cncp.searchbtnorg(orgName);
//			cncp.getSearchbtnorg().sendKeys(orgName);
//			driver.findElement(By.name("search")).click();
			//static xpath to dynamic xpath
	 	driver.findElement(By.xpath("//a[text()=\""+orgName+"\"]")).click();
			
		//switching  parent window 
	 	  wlib.switchToTabonURL(driver, "module=Contacts");
	 
			cncp.getSaveedt().click();
			
			
			//verify Header msg expected result
			 String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
			 
			 //to verify partical data we ues contains
			if(actLastName.equals(ContactLastName)) {
				System.out.println(ContactLastName+"is created==pass");
			}
			else {
				System.out.println(ContactLastName+"is not created==Fail");
			}
			
 String actOrgname = driver.findElement(By.id("mouseArea_Organization Name")).getText();
			 
			 //to verify partical data we ues contains
			if(actOrgname.trim().equals(orgName)) {//to remove space
				System.out.println(orgName+"is created==pass");
			}
			else {
				System.out.println(orgName+"is not created==Fail");
			}
			
			
			
			
			

	}

}
