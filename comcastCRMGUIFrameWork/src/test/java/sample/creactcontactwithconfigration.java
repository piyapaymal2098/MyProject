package sample;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class creactcontactwithconfigration {
	@BeforeSuite
	public void confiBs() {
		System.out.println("execute Bs");
	}
	@BeforeClass
	public void confiBC() {
		System.out.println("execute Bc");
	}
	@Test
	public void creatcontact() {
		System.out.println("execute creatcontact");
	}
	@Test
	public void creatcontactWithSupportDate() {
		System.out.println("execute creatcontactWithSupportDate");
	}
	
	@BeforeMethod
	public void configBM() {
		System.out.println("execute BM");
	}
	@AfterMethod
	public void configAM() {
		
		System.out.println("execute AM");
	}
	@AfterClass
	public void confiAC() {
		System.out.println("execute Ac");
	}
	@AfterSuite
	public void confiAs() {
		System.out.println("execute Bs");
	}

}
