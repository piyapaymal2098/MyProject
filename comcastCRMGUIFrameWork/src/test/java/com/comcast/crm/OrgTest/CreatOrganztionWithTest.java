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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.baseclass;
import com.comcast.crm.genric.fileutility.ExcelUtility;
import com.comcast.crm.genric.fileutility.FileUtility;
import com.comcast.crm.genric.webdriverutility.JavaUtility;
import com.comcast.crm.genric.webdriverutility.UtilityClassObject;
import com.comcast.crm.genric.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositoryuti.CreatingNewOrganizationPage;
import com.comcast.crm.objectRepositoryuti.HomePage;
import com.comcast.crm.objectRepositoryuti.LoginPage;
import com.comcast.crm.objectRepositoryuti.OrganizationInformationPagr;
import com.comcast.crm.objectRepositoryuti.OrganizationPage;
@Listeners(com.comcast.crm.listenerUtility.ListenerImpclass.class)
public class CreatOrganztionWithTest extends baseclass {
	@Test(groups = "smokeTest")
	public void creatOrganztionWithest() throws Throwable {
UtilityClassObject.getTest().log(Status.PASS , "read data from Excle");
		String orgName = excel.getDataFromExcel("Orgname", 1, 2) + jlib.getRandomNumber();

		// step 3: navigate to organization module
		UtilityClassObject.getTest().log(Status.PASS , "Navigate to org page");
		HomePage op = new HomePage(driver);

		op.getOrglin().click();

		// step 4: click on create organization module
		UtilityClassObject.getTest().log(Status.PASS , "Navigate to org page");
		OrganizationPage cnp = new OrganizationPage(driver);
		cnp.getCreatNeworgbtn().click();

		// step 5: enter all the details & create new organization
		UtilityClassObject.getTest().log(Status.PASS , "creat a new org");
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.creatOrg(orgName);
//	cnop.creatOrg(orgName, Industry);

		// verify Header msg expected result
		UtilityClassObject.getTest().log(Status.PASS , "creat a new org");
		OrganizationInformationPagr oip = new OrganizationInformationPagr(driver);
		String actOrg = oip.getHeader().getText();
		if (actOrg.contains(orgName)) {
			System.out.println(actOrg + "Name is Varified===pass");
		} else {
			System.out.println(actOrg + "Name is not Varified===Fail");
		}

	}
	

	
	@Test(groups = "regressionTest")
	public void CreatOrganztionWithIndustryWithTest() throws Throwable {

		String orgName = excel.getDataFromExcel("Orgname", 4, 2) + jlib.getRandomNumber();
		// drop down is static data no need to attache the random integer
		String Industry = excel.getDataFromExcel("Orgname", 4, 3);
		String Type = excel.getDataFromExcel("Orgname", 4, 4);

		// step 3: navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrglin().click();

		OrganizationPage orn = new OrganizationPage(driver);
		orn.getCreatNeworgbtn().click();

		CreatingNewOrganizationPage cno = new CreatingNewOrganizationPage(driver);
		cno.creatOrg(orgName, Industry);

		cno.type(Type);

		// verify the drop down industry
		OrganizationInformationPagr oip = new OrganizationInformationPagr(driver);
		String actIndusrty = oip.getIndustryveriEle().getText();

		if (actIndusrty.equals(Industry)) {
			System.out.println(Industry + "   information is  verified==pass");
		} else {
			System.out.println(Industry + "    information is not verified ==Fail");
		}

		// verify the drop down type info
		String actType = oip.getTypedtlview().getText();

		if (actType.equals(Type)) {
			System.out.println(Type + "     information is  verified==pass");
		} else {
			System.out.println(Type + "    information is not verified ==Fail");
		}

	}

	@Test(groups = "regressionTest")
	
	public void CreatOrganztionWithPhoneNumberTest() throws Throwable {

		String orgName = excel.getDataFromExcel("Orgname", 7, 2) + jlib.getRandomNumber();

		String PhoneNumber = excel.getDataFromExcel("Orgname", 7, 3);
		HomePage hp = new HomePage(driver);
		hp.getOrglin().click();

		OrganizationPage cnp = new OrganizationPage(driver);
		cnp.getCreatNeworgbtn().click();

		CreatingNewOrganizationPage cno = new CreatingNewOrganizationPage(driver);
		cno.phone(orgName, PhoneNumber);

		OrganizationInformationPagr oip = new OrganizationInformationPagr(driver);

		String actPhoneNumber = oip.getPhoneNou().getText();
		if (actPhoneNumber.equals(PhoneNumber)) {
			System.out.println(PhoneNumber + "     information is  verified==pass");
		} else {
			System.out.println(PhoneNumber + "    information is not verified ==Fail");
		}

	}

}
