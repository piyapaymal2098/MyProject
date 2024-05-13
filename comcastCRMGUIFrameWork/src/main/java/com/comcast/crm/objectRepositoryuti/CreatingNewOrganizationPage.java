package com.comcast.crm.objectRepositoryuti;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.genric.webdriverutility.WebDriverUtility;

public class CreatingNewOrganizationPage extends WebDriverUtility{
	WebDriver driver;
	public CreatingNewOrganizationPage (WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements( driver,this);	

}
	@FindBy(name = "accountname")
	private WebElement orgNameEdt;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveBtn;
	
	@FindBy(name = "industry")
	private WebElement indstryEdt;
	
	@FindBy(name = "accounttype")
	private WebElement typeedt;
	
	@FindBy(id = "phone")
	private WebElement phoneNumedt;
	
	public WebElement getPhoneNumedt() {
		return phoneNumedt;
	}

	public WebElement getTypeedt() {
		return typeedt;
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getIndstryEdt() {
		return indstryEdt;
	}

	public WebElement getOrgNameedt() {
		return orgNameEdt;
	}

	public WebElement getSavebtn() {
		return saveBtn;
	}
	
	public void creatOrg(String orgName) {
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();                                     //method name is same only orgument is differnt overloading concept
		
	}
	
	public void creatOrg(String orgName ,String industry) {
		orgNameEdt.sendKeys(orgName);
		Select s= new Select(indstryEdt);
		s.selectByVisibleText(industry);
		
		
	}
	public void type(String type) {
		typeedt.click();
		typeedt.sendKeys(type);
		saveBtn.click();
		
	}
	public void phone(String orgName, String PhoneNumber ) {
		orgNameEdt.sendKeys(orgName);
		phoneNumedt.sendKeys(PhoneNumber);
		saveBtn.click();
	}
	
	public void  CreatingNewOrganization(String orgName, String PhoneNumber,String type,String industry) {
		orgNameEdt.sendKeys(orgName);
		Select s= new Select(indstryEdt);
		s.selectByVisibleText(industry);
		typeedt.click();
		typeedt.sendKeys(type);
		phoneNumedt.sendKeys(PhoneNumber);
		saveBtn.click();
		
		
	}	
	
	
}