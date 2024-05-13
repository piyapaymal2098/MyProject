package com.comcast.crm.objectRepositoryuti;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPagr {
	WebDriver driver;
	public OrganizationInformationPagr (WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements( driver,this);	
	}
	
	
	@FindBy(className = "dvHeaderText")
	private WebElement header;
	
	@FindBy(id = "mouseArea_Industry")
	private WebElement industryveriEle;
	
	@FindBy(id = "dtlview_Type")
	private WebElement typedtlview;
	
	@FindBy(id = "dtlview_Phone")
	private WebElement phoneNou;
	
	

	
	

	public WebElement getPhoneNou() {
		return phoneNou;
	}

	public WebElement getTypedtlview() {
		return typedtlview;
		
	}

	public WebElement getIndustryveriEle() {
		return industryveriEle;
	}

	public WebElement getHeader() {
		return header;
	}

	

	
}
