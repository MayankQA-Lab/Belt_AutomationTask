package com.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.test.helper.CustomException;
import com.test.helper.WebDriverExtensions;
import com.test.helper.WebElementExtensions;
import com.test.readdata.Base;

//---****Initializing and updating the locators with action methods****------//

public class LoginPage extends Base {

	@FindBy(id = "username")
	public WebElement username;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(id = "submit")
	public WebElement submitbutton;
	
	@FindBy(xpath= "//h1[text()='Logged In Successfully']")
	public WebElement LoggedInheaderText;
	
	@FindBy(xpath= "//div//a[contains(text(),'Log out')]")
	public WebElement LogOutText;
	
	@FindBy(xpath= "//div[@id='error']")
	public WebElement validationerror;
	
	    public LoginPage() {
	    	
		PageFactory.initElements(driver, this); // For Initializing the web Objects declared above
	}

	    public void loginToAppWithCredentials(String usernametext, String passwordtext) throws CustomException
	    {
		 
	     WebDriverExtensions.waitForElementToBeClickable(driver, username, WebElementExtensions.page_load_timeout);
	     WebElementExtensions.enterText(username, usernametext);
	     WebDriverExtensions.waitForElementToBeClickable(driver, password, WebElementExtensions.page_load_timeout);
	     WebElementExtensions.enterText(password, passwordtext);
	     WebDriverExtensions.waitForElementToBeClickable(driver, submitbutton, WebElementExtensions.page_load_timeout);
	     WebElementExtensions.clickAtElement(submitbutton);   
	    }
	    
	    public boolean getValidationMessage()
	    {
	    	try
	    	{
	    	if(LoggedInheaderText.getText().contains(readconfig.getPageHeading()) && LogOutText.getText().contains(readconfig.getLogOutText()))
	    	{
	    		System.out.println("User is able to login successfully "+LoggedInheaderText.getText()+" "+LogOutText.getText());
	    		return true;
	    	}
			
	    	}
	    	catch(Exception e) {
		    		System.out.println("User is not able to login successfully "+validationerror.getText());
		    		return false;
		    	}
			return false;	    		
	    	
	    }
	    
	    
	    
	    
	    
	    
	    
	}
