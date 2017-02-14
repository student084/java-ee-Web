package com.amaker.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
******************************************************************************
*Copyright(c).
*Allrightsreserved.
*
*File 		$ProjectName: SkyOne$
*Author		$Author:jian Wang$
*Version	$Revision:0.0.1$
*Date$Date:	2016/2/14 18:33$
*Description
*	Create a DBUtil-Object, use openConnection and you will get a connection
*	to MYSQL 
******************************************************************************
*/
public class DBUtil {
	
	//url: mysql's url ->jdbc:mysql://xxx.xxx.xxx.xxx:port/dbName
	//driver: db driver url
	//username: mysql username
	//password: mysql pwd
	
	private Connection getConnection(String url, String driver, String username, String password){
		try {
			//load the db driver ,if successed then use DriverManager.getConnection() to get connection
			Class.forName(driver);
			try {
				return DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Connection openConnection(){
		
		Properties prop = new Properties();
		//init var
		String driver = null;
		String url = null;
		String username = null;
		String password = null;
		
		try {
			// load the proerties source stream for the file
			prop.load(this.getClass().getClassLoader().getResourceAsStream("DBConfig.properties"));
			
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			
			return this.getConnection(url, driver, username, password);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	// Close the Connection
	
	public void closeConnection(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
