package sample;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.baseclass;
@Listeners(com.comcast.crm.listenerUtility.ListenerImpclass.class)
public class INvoic2 extends baseclass {
	@Test(retryAnalyzer = com.comcast.crm.listenerUtility.retryimplimentation.class)
	public void activatesim() {
		System.out.println("excuet creatInvoicTest");
		 String actTitle = driver.getTitle();
		 assertEquals(actTitle, "login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}

	
	
	


}
