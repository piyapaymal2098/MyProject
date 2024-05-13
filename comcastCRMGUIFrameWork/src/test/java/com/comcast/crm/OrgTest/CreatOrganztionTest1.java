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

public class CreatOrganztionTest1 {

	public static void main(String[] args) throws Throwable {
		//read comman data from properties
		FileInputStream fis1 = new FileInputStream("./configAppData/creatorg.properties.txt");
		 Properties pro = new Properties();
		 pro.load(fis1);
		 String BROWSER = pro.getProperty("browser");
		 String URL = pro.getProperty("url");
		 String USERNAME = pro.getProperty("username");
		  String PASSWORD = pro.getProperty("password");
		//generate the random number 
		 Random r = new Random();
		 
		 int RandomInt = r.nextInt(100);
		
		 FileInputStream fis = new FileInputStream("./testData/TestScriptdata.xlsx");
		 Workbook wb = WorkbookFactory.create(fis);
		 Sheet sh = wb.getSheet("Orgname");
		  Row row = sh.getRow(1);
		  String orgName = row.getCell(2).toString() + RandomInt;
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
//		  //step 1: login to app
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get(URL);
	  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
   driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
   
	  //step 3: navigate to organization module
	driver.findElement(By.xpath("//a[@href=\"index.php?module=Accounts&action=index\"]")).click();
	
	 //step 4: click on create organization module
	driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
	
	
	 //step 5: enter all the details & create new organization
	driver.findElement(By.name("accountname")).sendKeys(orgName);
	driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
	//verify Header msg expected result
	 String headInfo = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
	 //to verify partical data we ues contains
	if(headInfo.contains(orgName)) {
		System.out.println(orgName+"is created==pass");
	}
	else {
		System.out.println(orgName+"is not created==Fail");
	}
	
	//verify Header orgName info expected result
	
	String actOrgName = driver.findElement(By.xpath("//span[@id=\"dtlview_Organization Name\"]")).getText();
	if(actOrgName.equals(orgName)) {
		System.out.println(orgName+"is created==pass");
	}
	else {
		System.out.println(orgName+"is not created==Fail");
	}
	 
////step:6 logout
	Thread.sleep(1000);
     Actions act = new Actions(driver);
    act.moveToElement(driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"))).perform();
	driver.findElement(By.linkText("Sign Out")).click();
	driver.quit();
	}

}
