package com.comcast.crm.genric.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
	public String getDataFromPropertiesFile(String key ) throws Throwable  {
		FileInputStream fis= new FileInputStream("./configAppData/creatorg.properties.txt");
		Properties p= new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		
		return data;
		
		
		
	}

}
