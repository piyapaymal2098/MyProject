package com.comcast.crm.objectRepositoryuti;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.genric.webdriverutility.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
	
	WebDriver driver;
	
	public HomePage (WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements( driver,this);	
	}
	@FindBy(linkText = "Organizations")
	
	private WebElement orglin;
	
	@FindBy(linkText = "Contacts")
	private WebElement conlin;
	
	@FindBy(linkText = "Products")
	private WebElement productLnk; 
	public WebElement getProductLnk() {
		return productLnk;
	}
	@FindBy(linkText = "Campaigns")
	private WebElement Campaglin;
	
	@FindBy(linkText = "More")
	private WebElement morelin;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement singOutlin;



	public WebElement getSingOutlin() {
		return singOutlin;
	}



	public WebElement getAdminImg() {
		return adminImg;
	}



	public WebElement getCampaglin() {
		return Campaglin;
	}

	

	public WebElement getOrglin() {
		return orglin;
	}

	public WebElement getConlin() {
		return conlin;
	}

	public WebElement getMorelin() {
		return morelin;
	}
	
	public void NavigatetoCampagin() {
		Actions act = new Actions(driver);
		act.moveToElement(morelin).perform();
		Campaglin.click();
	}
	
	public void logout() {
		adminImg.click();
		Actions ac = new Actions(driver);
		ac.click(singOutlin).click().perform();
		
	}
	
	

}
