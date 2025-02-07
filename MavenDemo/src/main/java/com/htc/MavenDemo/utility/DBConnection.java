package com.htc.MavenDemo.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class DBConnection {
	
  String url,username,pwd;
  private Logger log = Logger.getLogger(DBConnection.class.getName());
		
		public Connection getConnection() {
			 
			Connection con = null;
			try {
				FileReader fr = new FileReader("/Users/pranay/eclipse-workspace/EmployeeLoad/db.txt");
				
				Properties prop = new Properties();
				prop.load(fr);
				
				this.url=prop.getProperty("jdbc_url");
				this.username=prop.getProperty("jdbc_username");
				this.pwd = prop.getProperty("jdbc_password");
				
				con = DriverManager.getConnection(url,username,pwd);	
			}
			catch(SQLException e)
			{
				log.severe(e.getMessage()+"Problem in obtaining DB connection");
			} catch (FileNotFoundException e) {
				log.severe(e.getMessage()+"file not found");
			} catch (IOException e) {
				log.severe(e.getMessage());
			} 
			log.info("DB connection Obtained");
			return con;
		}
}
