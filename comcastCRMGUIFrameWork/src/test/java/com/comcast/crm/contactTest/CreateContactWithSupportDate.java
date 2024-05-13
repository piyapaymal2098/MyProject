package com.comcast.crm.contactTest;

import java.io.FileInputStream;
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

import com.comcast.crm.genric.webdriverutility.JavaUtility;

public class CreateContactWithSupportDate {

	public static void main(String[] args) throws Throwable {
		JavaUtility javau= new JavaUtility();
		
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
		 Sheet sh = wb.getSheet("Contact");
		  Row row = sh.getRow(1);
		  String LastName = row.getCell(2).toString() + RandomInt;
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
   
	  //step 3: navigate to contact module
	driver.findElement(By.xpath("//a[@href=\"index.php?module=Contacts&action=index\"]")).click();
	
	 //step 4: click on create contact module
	driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
	
	 String startdate = javau.getSystemDateYYYYDDMM();
	 String enddate = javau.getRequrieDateYYYYDDMM(30);
	 //step 5: enter all the details & create new organization
	driver.findElement(By.name("lastname")).sendKeys(LastName);
	
driver.findElement(By.name("support_start_date")).clear();
driver.findElement(By.name("support_start_date")).sendKeys(startdate);
driver.findElement(By.name("support_end_date")).clear();
driver.findElement(By.name("support_end_date")).sendKeys(enddate);
	
	driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
	

	//verify Header msg expected result
	 String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
	 
	 //to verify partical data we ues contains
	if(actLastName.equals(LastName)) {
		System.out.println(LastName+"is created==pass");
	}
	else {
		System.out.println(LastName+"is not created==Fail");
	}
	
////step:6 logout
//	Thread.sleep(1000);
//     Actions act = new Actions(driver);
//    act.moveToElement(driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"))).perform();
//	driver.findElement(By.linkText("Sign Out")).click();
//	driver.quit();

	}

}
