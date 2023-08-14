package com.test.helper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverExtensions {

	/// <summary>
	/// SmallWait Variable contains a value 5
	/// </summary>
	static int SmallWait = 5;

	/// <summary>
	/// MediumWait Variable contains a value 10
	/// </summary>
	static int MediumWait = 10;

	/// <summary>
	/// LargeWait Variable contains a value 15
	/// </summary>
	static int LargeWait = 15;

	/// <summary>
	/// Use this wait statement for all the editboxes & tables
	/// </summary>
	/// <param name="driver"></param>
	/// <param name="element"></param>
	public static void WaitForObjectAvaialble(WebDriver driver, By element, int timeout) {
		try {
			new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(element));

		} catch (Exception ex) {

		}
	}

	/// <summary>
	/// Use this wait statement before clicking on any Buttons, links, Dropdowns,
	/// Checkboxes, column headers, images, icons
	/// or on any element where you need to perform click operation
	/// </summary>
	/// <param name="driver"></param>
	/// <param name="element"></param>
	public static void waitForElementToBeClickable(WebDriver driver, WebElement element, long implicit_wait) {
		try {
			new WebDriverWait(driver, implicit_wait).until(ExpectedConditions.elementToBeClickable(element));

		} catch (Exception ex) {

		}
	}

	
	/*
	 * public static void waitForElementlistToBeClickable(WebDriver driver,
	 * List<WebElement> element, long implicit_wait) { try { new
	 * WebDriverWait(driver,
	 * implicit_wait).until(ExpectedConditions.elementToBeClickable(element));
	 * 
	 * } catch (Exception ex) {
	 * 
	 * } }
	 */
	/// <summary>
	/// Use this wait statement if the objects are loaded with the iFrame
	/// </summary>
	/// <param name="driver"></param>
	public static void waitForiFrameLoad(WebDriver driver, By by, int timeout) {
		WebElement iFrameHost = new WebDriverWait(driver, timeout)
				.until(ExpectedConditions.visibilityOfElementLocated(by));
		driver.switchTo().defaultContent(); // you are now outside both frames
		driver.switchTo().frame(iFrameHost);
	}

	/// <summary>
	/// This method is used to wait for an element to be displayed and enabled
	/// </summary>
	/// <param name="driver"></param>
	/// <param name="locator"></param>
	/// <param name="timeOut"></param>
	public static void waitForElementPresentAndEnabled(WebDriver driver, By locator, int timeout) {
		try {
			Thread.sleep(1000);
			new WebDriverWait(driver, timeout)
					.until(ExpectedConditions.and(ExpectedConditions.visibilityOfElementLocated(locator),
							ExpectedConditions.elementToBeClickable(driver.findElement(locator))));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	// This method is used to get current URL
	public static String getCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	// This method is used to get Current Window Title
	public static String getTitle(WebDriver driver) {
		return (driver.getTitle());
	}

	// This will refresh web page
	public static void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	// This will navigate web page back
	public static void backwardPage(WebDriver driver) {
		driver.navigate().back();
	}

	// This will navigate web page forward
	public static void forwardPage(WebDriver driver) {
		driver.navigate().forward();
	}
	 /// <summary>
    /// This method Wait till the frame is loaded and switch to it.
    /// </summary>
    /// <param name="driver">The object of web driver.</param>
    /// <param name="locator">The locator to wait for.</param>
    /// <param name="timeOut">Maximum wait time in seconds.</param>
    public static void WaitAndSwitchToFrame( WebDriver driver, By locator, int timeOut)
    {
        try
        {
        	new WebDriverWait(driver, timeOut).
                     until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
        }
        catch (Exception ex)
        {
        	ex.printStackTrace(); 
        }
    }
    /// <summary>
    /// Wait till alert is not present.
    /// </summary>
    /// <param name="driver">The object of web driver.</param>
    /// <param name="timeOut">Maximum wait time in seconds.</param>
    public static void WaitForAlert(WebDriver driver, long implicit_wait)
    {
    	new WebDriverWait(driver, implicit_wait).
            until(ExpectedConditions.alertIsPresent());
    }
}

