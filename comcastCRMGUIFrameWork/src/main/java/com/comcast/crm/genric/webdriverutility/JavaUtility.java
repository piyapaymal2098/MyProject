package com.comcast.crm.genric.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int  getRandomNumber() {
		Random random= new Random();//object creation of randma
	int ranDomNumber	= random.nextInt(5000);//method nextInt using this method we are specify the boundry//it will one of pick  number within this boundayr
	return ranDomNumber;
		
	}
	public String getSystemDateYYYYDDMM() {
		Date dateobj= new Date();
		SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd");// MM shoude be uper case
		 String Date = sim.format(dateobj);
		return Date; 
		
	}
	
	
	public String getRequrieDateYYYYDDMM(int days) {// u have to pass interger data if you pass intergdata it wll gives after date /-if you pass "-_" it will give privous date

		SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd");
		 Calendar cal = sim.getCalendar();
	 cal.add(Calendar.DAY_OF_MONTH,days);
	 String reqDate = sim.format(cal.getTime());
	  return reqDate;
	}
	
}
