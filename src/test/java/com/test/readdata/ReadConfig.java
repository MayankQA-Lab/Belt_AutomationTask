package com.test.readdata;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

//**-----To Read the Data from the Config.properties File----*****

public class ReadConfig extends Base {

	public ReadConfig() {
		File src = new File("./Configuration/Config.properties");
		try {
			pro = new Properties();
			FileInputStream fis = new FileInputStream(src);
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getApplicationURL() {
		return	pro.getProperty("url");
		 
	}

	public String getUsername() {
	return pro.getProperty("username");
	}

	public String getPassword() {
		return pro.getProperty("password");
	}
	
	public String getInvalidUsername() {
		return pro.getProperty("invalidusername");
		}

		public String getInvalidPassword() {
			return pro.getProperty("invalidpassword");
		}
	
		
	public String getBrowser() {
		String browser = pro.getProperty("browser");
		return browser;
	}
   
	
	public String getPageHeading() 
	{
		String heading = pro.getProperty("pageHeading");
		return heading;
	}
    
	public String getLogOutText() 
	{
		String text = pro.getProperty("logOutText");
		return text;
	}
	
	
	
}