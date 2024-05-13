package com.comcast.crm.objectRepositoryuti;

import java.util.jar.Attributes.Name;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	WebDriver driver;
	public OrganizationPage (WebDriver driver) { // pagefactory class static method init element
		this.driver= driver;
		PageFactory.initElements( driver,this);	
	
	}
	
	@FindBy(xpath = "//img[@alt=\"Create Organization...\"]")
 private WebElement creatNeworgbtn;
	
	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "search_field")
	private WebElement searchDD;
	
	@FindBy(name = "submit")
	private WebElement serachBtn;
	
	
	
	
	public WebElement getSerachBtn() {
		return serachBtn;
	}


	public WebElement getSearchEdt() {
		return searchEdt;
	}


	public WebElement getSearchDD() {
		return searchDD;
	}


	public WebElement getCreatNeworgbtn() {
		return creatNeworgbtn;
	} 
	


}
