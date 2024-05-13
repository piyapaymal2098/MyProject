package com.comcast.crm.objectRepositoryuti;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.genric.webdriverutility.WebDriverUtility;
/**
 * @author anil1
 * contains  login page element elements & business lib like login()
 * 
 */
public class LoginPage extends WebDriverUtility {
	WebDriver driver;
	public LoginPage(WebDriver driver) { //Rule 3: Object Initialization
	 this.driver=driver;	//local this.driver=driver<==global driver
		PageFactory.initElements(driver,this);//this means current object refernece /curent class object
	}
	
	//Rule 1: creat a seperate java class
	
	
	//Rule 2: Object Creation @findBy
	
    @FindBy(name="user_name")
    private WebElement UserTextField;
   
    @FindBy(name="user_password")
    private  WebElement PasswordTextField;
    
   @FindBy(id="submitButton")
   private WebElement LoginButton;
	
   
//Rule 4: Object Encapsulation
  public WebElement getUserTextField() {
	return UserTextField;
   }

  public WebElement getPasswordTextField() {
	return PasswordTextField;
  }

   public WebElement getLoginButton() {
	return LoginButton;
}
   
   //Rule 5: Utilizate the element getters method other wise we can provide action //business method
//public void LoginToapp(String username, String password) {// this method we can't use any other application this method can use only specific to application
//	   
//	   
//	   
//	   LoginBtn.click();;
//	   
//   }
   /**
    * login to application based on username , url, password argument
    * @param url
    * @param username
    * @param password
    */
   
   public void LoginToapp(String url, String username, String password) {
	   waitforPageLoad(driver);
	   driver.get(url);
		UserTextField.sendKeys(username);
		PasswordTextField.sendKeys(password);
		LoginButton.click();
   }
   

}
