package com.comcast.crm.genric.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	
	
	 Connection con;//connection object declare globaly because we are going to close db in another method
	 
	 
public void getDbConnection(String url, String username, String password) throws Throwable {
		try{

			Driver driver= new  Driver();//connection
			DriverManager.registerDriver(driver);//load the driver manger//register the diver
			  con = DriverManager.getConnection(url, username, password);// coonection object make sure coming from java.sql connection
			                                      //crendantial 
		}catch(Exception e){
		
		}	
}
	public void closeDbconnection() throws SQLException  {
		con.close(); 
	}
	//two method for select query execution And non select query execution
	
	
	public ResultSet executSelectQuery(String query) throws Throwable {//<===pass your query
		ResultSet result= null;
		 try {
			 
			 Statement stat = con.createStatement();//using concention obj we creat a statement fst it is return the object statment interface
			  stat.executeQuery(query);// using satm obj we execute a query "executquery" it return result set obj
			 //in this result we have complet table "result"
		 }
		 catch(Exception e) {
			 
		 }
		return result;
	}
		
	public int executNonSelectQuery(String query) throws Throwable {//<===pass your query
		int reult= 0;
		 try {
			 
			 Statement stat = con.createStatement();//using concention obj we creat a statement fst it is return the object statment interface
		stat.executeUpdate(query);// using satm obj we execute a query "executquery" it return result set obj
			 //in this result we have complet table "result"
		 }
		 catch(Exception e) {
			 
		 }
		 return reult;
		
			
	
		 
	}
	
	
	public void getDbConnection() throws Throwable {
	try{

			Driver driver= new  Driver();//connection
			DriverManager.registerDriver(driver);//load the driver manger//register the diver
			  con = DriverManager.getConnection("jdbc:mysql://localhost:3036/project", "root", "root");// coonection object make sure coming from java.sql connection
			                                      //crendantial 
		}catch(Exception e){
		
	
}	
}
	
	
	
	
		
	  
	
	
	


}
