package sample;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.baseclass;
@Listeners(com.comcast.crm.listenerUtility.ListenerImpclass.class)
public class INvoic extends baseclass {
	
	
	@Test
	public void creatInvoicTest() {
		System.out.println("excuet creatInvoicTest");
		 String actTitle = driver.getTitle();
		 assertEquals(actTitle, "login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
	@Test
	public void creatInvoicWithContactTest() {
		System.out.println("excuet creatInvoicWithContactTest");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
	
	
	


}
