package sample;

import org.apache.commons.collections4.iterators.ObjectArrayListIterator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreatcontactTestusingDataprovider1 {
@Test(dataProvider = "getData")
public void creatContactTest(String firstname , String lastname,long phonenumber) {
	System.out.println( "FistrName:" +firstname +   ", lastname:"+ lastname +    "phonenumber:"+  phonenumber );
	
}

@DataProvider
public Object[][] getData(){
	Object[][]objeArr= new Object[3][3];
	objeArr[0][0]="supriya";
	objeArr[0][1]= "p";
	objeArr[0][2]= 7589456956l;
	

	objeArr[1][0]="priya";
	objeArr[1][1]= "j";
	objeArr[1][2]= 1234567812l;
	
	objeArr[2][0]="piya";
	objeArr[2][1]= "j";
	objeArr[2][2]= 9876543210l;
	
	return objeArr;
	
}
}
