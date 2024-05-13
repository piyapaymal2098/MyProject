package com.comcast.crm.objectRepositoryuti;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.genric.webdriverutility.JavaUtility;

public class CreatNewContactPage extends JavaUtility{	WebDriver driver;

public CreatNewContactPage (WebDriver driver) {
	this.driver= driver;
	PageFactory.initElements( driver,this);	
}
	
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement CreatNEDt;
	
@FindBy(className = "dvHeaderText")
private WebElement headerConmsg;

@FindBy(id = "dtlview_Support Start Date")
private WebElement actulstartdate;
@FindBy(id = "dtlview_Support End Date")
private WebElement actulEnddate;
	
	public WebElement getActulstartdate() {
	return actulstartdate;
}
public WebElement getActulEnddate() {
	return actulEnddate;
}
	public WebElement getHeaderConmsg() {
	return headerConmsg;
}

	@FindBy(id = "dtlview_Last Name")
	private WebElement actlastName;
			
	public WebElement getActlastName() {
		return actlastName;
	}

	@FindBy(name = "lastname")
	private WebElement lastnameEdt;

	public WebElement getCreatNEDt() {
		return CreatNEDt;
	}
	public WebElement getSupportEndDate() {
		return supportEndDate;
	}
	public WebElement getSupportStartDate() {
		return supportStartDate;
	}
	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}
	
	@FindBy(name = "support_end_date")
	private WebElement supportEndDate;
	
	@FindBy(name = "support_start_date")
	private WebElement supportStartDate;
	

	public WebElement getPlusSing() {
		return plusSing;
	}

	@FindBy(name = "button")
	private WebElement saveedt;
	
	
	@FindBy(xpath = "//input[@name='account_name']//following-sibling::img")
	private WebElement plusSing;
	
	public WebElement getSearchbtnorg() {
		return searchbtnorg;
	}

	@FindBy(name = "search_text")
	private WebElement searchbtnorg;
	
   
	public WebElement getSaveedt() {
		return saveedt;
	}
	public  void suppoortendstartdate() {
    	String systemdate = getSystemDateYYYYDDMM();
    	String requridedate = getRequrieDateYYYYDDMM(30);
    	supportEndDate.sendKeys(requridedate);
    	supportStartDate.sendKeys(systemdate);
    	saveedt.click();
		
	}
	
	public void searchbtnorg(String orgname) {
		searchbtnorg.sendKeys(orgname);
		searchbtnorg.sendKeys(Keys.ENTER);
	}
	
	
	
	
}


