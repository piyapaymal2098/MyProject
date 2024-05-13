package com.comcast.crm.contactTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.baseclass;
import com.comcast.crm.objectRepositoryuti.CreatNewContactPage;
import com.comcast.crm.objectRepositoryuti.CreatingNewOrganizationPage;
import com.comcast.crm.objectRepositoryuti.HomePage;
import com.comcast.crm.objectRepositoryuti.OrganizationInformationPagr;
import com.comcast.crm.objectRepositoryuti.OrganizationPage;
/**
 * @author supriya
 * 
 * 
 */
public class CreatContactTest extends baseclass {
	@Test(groups = {"smokeTest","regressionTest"})
	public void creatcontact() throws Throwable {
		/*read testscript data from Excel file */
		 String LastName = excel.getDataFromExcel("Contact", 1, 2) + jlib.getRandomNumber();
		 /*Step-2 Naviagte to contact module */ 
		 HomePage hp= new HomePage(driver);
			hp.getConlin().click();
		 
			CreatNewContactPage cncp= new CreatNewContactPage(driver);
			cncp.getCreatNEDt().click();
		 
			cncp.getLastnameEdt().sendKeys(LastName);
			cncp.getSaveedt().click();
			
	  String actHeader= cncp.getHeaderConmsg().getText();
	   boolean status = actHeader.contains(LastName);
	  assertEquals(status, true);
	
	    String actLastName = cncp.getActlastName().getText();
	SoftAssert soft= new SoftAssert();
	soft.assertEquals(actLastName, LastName);
	}

	@Test(groups = "regressionTest")
	public void CreateContactWithSupportDate() throws Throwable {
		
	 String LastName = excel.getDataFromExcel("Contact", 1, 2) + jlib.getRandomNumber();
		 
		 HomePage hp= new HomePage(driver);
			hp.getConlin().click();
		 
			CreatNewContactPage cncp= new CreatNewContactPage(driver);
			cncp.getCreatNEDt().click();
		 
			cncp.getLastnameEdt().sendKeys(LastName);
			cncp.suppoortendstartdate();
	
			String expectedsatrt = cncp.getSupportStartDate().getText();
			String actualstartdate = cncp.getActulstartdate().getText();
			 boolean status = actualstartdate.contains(expectedsatrt);
			 assertEquals(status, true);
			 
			 
			 String expectedend = cncp.getSupportEndDate().getText();
			String actulendadte = cncp.getActulEnddate().getText();
			boolean endstatus = actulendadte.contains(expectedend);
			assertEquals(endstatus, true);
			
			
			String actLastName = cncp.getActlastName().getText();
			SoftAssert soft= new SoftAssert();
			soft.assertEquals(actLastName, LastName);
	
	   
	
	}
	
	
	@Test(groups = "regressionTest")
	public void CreateContactWithOrgTest() throws Throwable {
		
		String orgName = excel.getDataFromExcel("Contact", 7, 2) + jlib.getRandomNumber();
		  String ContactLastName = excel.getDataFromExcel("Contact", 7, 3);
		  
		  HomePage op = new HomePage(driver);

			op.getOrglin().click();

			// step 4: click on create organization module

			OrganizationPage cnp = new OrganizationPage(driver);
			cnp.getCreatNeworgbtn().click();

			// step 5: enter all the details & create new organization
			CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
			cnop.creatOrg(orgName);
//		cnop.creatOrg(orgName, Industry);

			// verify Header msg expected result
			OrganizationInformationPagr oip = new OrganizationInformationPagr(driver);
			String actOrg = oip.getHeader().getText();
			SoftAssert soft= new SoftAssert();	
			soft.assertEquals(actOrg, orgName);
		  
			HomePage h =  new HomePage(driver);
			h.getConlin().click();
			
			CreatNewContactPage cncp= new CreatNewContactPage(driver);
			cncp.getCreatNEDt().click();
			cncp.getLastnameEdt().sendKeys(ContactLastName);
			cncp.getPlusSing().click();
			//switching  to child window
			wlib.switchToTabonURL(driver, "module=Accounts");
			
			cncp.searchbtnorg(orgName);
			
			driver.findElement(By.xpath("//a[text()=\""+orgName+"\"]")).click();
			wlib.switchToTabonURL(driver, "module=Contacts");
			
			
			cncp.getSaveedt().click();
			
			

			String actLastName = cncp.getActlastName().getText();
			SoftAssert soft1= new SoftAssert();
			soft.assertEquals(actLastName, ContactLastName);
			
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
