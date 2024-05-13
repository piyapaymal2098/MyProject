package sample;

import org.apache.commons.collections4.iterators.ObjectArrayListIterator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreatcontactTestusingDataprovider {
@Test(dataProvider = "getData")
public void creatContactTest(String firstname , String lastname) {
	System.out.println( "FistrName:" +firstname +", lastname:"+ lastname  );
	
}

@DataProvider
public Object[][] getData(){
	Object[][]objeArr= new Object[3][2];
	objeArr[0][0]="supriya";
	objeArr[0][1]= "p";

	objeArr[1][0]="priya";
	objeArr[1][1]= "j";
	
	objeArr[2][0]="piya";
	objeArr[2][1]= "j";
	
	return objeArr;
	
}
}
