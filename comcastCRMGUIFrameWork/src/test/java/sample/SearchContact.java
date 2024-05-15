package sample;
/**
 * test class for conatct module
 * @author Supriya
 * 
 *
 */

import org.testng.annotations.Test;

import com.comcast.crm.basetest.baseclass;
import com.comcast.crm.objectRepositoryuti.LoginPage;

public class SearchContact  extends baseclass{
	/**
	 * Scenario login ()==> Navigate to contact===> Createcontact===>Verify
	 */
	
@Test
public void seacrchcontactTest() {
	/*Step-1 login to application */
	LoginPage lp= new LoginPage(driver);
	lp.LoginToapp("ur", "pass", "user");
	
}
}
