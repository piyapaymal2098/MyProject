package sample;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.genric.fileutility.ExcelUtility;

public class GetProductInfo1 {
@Test(dataProvider ="getData" )
	public void GetProductInfoTest(String brandname,String productname ) throws Throwable {
	

		WebDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.in");
		//search product 
		driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys(brandname,Keys.ENTER);
		//capture the producr info
		String x = "//span[text()='"+productname+"']/../../../../div[3]/div[1]/div/div[1]/div[1]/div/a/span[1]/span[2]/span[2]";
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);

		driver.quit();
		
		
	}
	@DataProvider
	public Object[][] getData() throws Throwable{
		ExcelUtility elib= new ExcelUtility();
		int Rowcount = elib.getRowCount("product");

		Object[][]objeArr= new Object[Rowcount][2];
		
	for(int i=0;i<Rowcount;i++) {
		
		objeArr[i][0]=elib.getDataFromExcel("product", i+1, 0);
		objeArr[i][1]=elib.getDataFromExcel("product", i+1, 1);

	}
		return objeArr;
	
	
		
	}
	}

