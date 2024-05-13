package com.comcast.crm.genric.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.jdbc.Driver;

public class WebDriverUtility {
	public void waitforPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	public void waitforElementPresent(WebDriver driver,WebElement element) {// if anybody want to wait for element make sure u passing the webelement refeenc
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void switchToTabonURL(WebDriver driver, String partialURL) {
		 Set<String> set = driver.getWindowHandles();
		  Iterator<String> it = set.iterator();
		  while(it.hasNext()) {
			   String windId = it.next();
			   driver.switchTo().window(windId);
			   String actulr = driver.getCurrentUrl();
			   if(actulr.contains(partialURL)) {
				   break;
				   
			   }
		  }
	}
	public void switchToTabonTitle(WebDriver driver, String title) {
		 Set<String> set = driver.getWindowHandles();
		  Iterator<String> it = set.iterator();
		  while(it.hasNext()) {
			   String winId = it.next();
			   driver.switchTo().window(winId);
			    String actTitle = driver.getTitle();
			    if(actTitle.contains(title)) {
			    	break;
			    }
		  }
	}
	
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver, String nameId) {
		driver.switchTo().frame(nameId);
	}
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);	
	}
	
	
	
	public void switchToAlterAccpet(WebDriver driver) {
		driver.switchTo().alert().accept();	
	}
	public void switchToAlterDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void select( WebElement element, int index) {
		 Select sele = new Select(element);
		 sele.selectByIndex(index);
		 	 
	}
	public void select( WebElement element, String text) {
		 Select sele = new Select(element);
		 sele.selectByVisibleText(text);
		 	 
	}
	public void mousemoveOnElement(WebDriver driver,WebElement element ) {
		Actions Act = new Actions(driver);
		Act.moveToElement(element).perform();
		
	}
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions Act = new Actions(driver);
		Act.doubleClick(element).perform();
	}

	

}
