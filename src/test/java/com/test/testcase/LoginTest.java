package com.test.testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.test.helper.CustomException;
import com.test.pages.LoginPage;
import com.test.readdata.Base;

public class LoginTest extends Base  {
	LoginPage loginpage;
    

	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		loginpage = new LoginPage();
	}
	  
	  @Test(priority = 1, description = "Verify Login functionality with valid username and password") 
	  public void TC_001_verifyLoginFunctionalitywithDifferentUsers() throws IOException, CustomException
	  { 
		loginpage.loginToAppWithCredentials(readconfig.getUsername(),readconfig.getPassword());
		Assert.assertTrue(loginpage.getValidationMessage());
      }  
	  
	  @Test(priority = 2, description = "Verify Login functionality with valid username and invalid password") 
	  public void TC_002_verifyLoginFunctionalitywithValidUsernameandInvalidPassword() throws IOException, CustomException
	  { 
		loginpage.loginToAppWithCredentials(readconfig.getUsername(),readconfig.getInvalidPassword());
		Assert.assertFalse(loginpage.getValidationMessage());
      }
      
	  
	  @Test(priority = 3, description = "Verify Login functionality with invalid username and valid password") 
	  public void TC_003_verifyLoginFunctionalitywithInvalidUsernameandValidPassword() throws IOException, CustomException
	  { 
		loginpage.loginToAppWithCredentials(readconfig.getInvalidUsername(),readconfig.getPassword());
		Assert.assertFalse(loginpage.getValidationMessage());
      }
	  
	  @Test(priority = 4, description = "Verify Login functionality with invalid username and invalid password") 
	  public void TC_004_verifyLoginFunctionalitywithInvalidUsernameandInvalidPassword() throws IOException, CustomException
	  { 
        loginpage.loginToAppWithCredentials(readconfig.getInvalidUsername(),readconfig.getInvalidPassword());
        Assert.assertFalse(loginpage.getValidationMessage());
      }
	
	  
	@AfterMethod
	public void teardown() {
	driver.quit();
	}

}
