package com.test.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.test.helper.CustomException;
import com.test.readdata.Base;

public class WebElementExtensions extends Base{

	
	public static long page_load_timeout = 120;
	public static long Implicit_wait = 20;
	
	/// <summary>
	/// This will Enter Text in text box
	/// </summary>
	/// <param name="element"></param>
	/// <param name="value"></param>
	public static void enterText(WebElement element, String value) throws CustomException {
		try {
			element.clear();
			element.sendKeys(value);
		} catch (Exception ex) {
			throw new CustomException(CustomException.exceptionMessage(ex));
		}
	}

	/// <summary>
	/// This will Enter Text in text box
	/// </summary>
	/// <param name="element"></param>
	/// <param name="value"></param>
	public static void enterText(WebDriver driver, By by, String value, int timeout) throws CustomException {
		try {
			new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(by));
			driver.findElement(by).clear();
			driver.findElement(by).sendKeys(value);
		} catch (Exception ex) {
			throw new CustomException(CustomException.exceptionMessage(ex));
		}
	}

	/// <summary>
	/// This will Enter Text in text box without clear the field
	/// </summary>
	/// <param name="element"></param>
	/// <param name="value"></param>
	public static void enterTextWithoutClear(WebElement element, String value) throws CustomException {
		try {
			element.sendKeys(value);
		} catch (Exception ex) {
			throw new CustomException(CustomException.exceptionMessage(ex));
		}
	}

	/// <summary>
	/// This will click a button, check box or radio button
	/// </summary>
	/// <param name="element"></param>
	public static void clickAtElement(WebElement element) throws CustomException {
		try {
			element.click();
		} catch (Exception ex) {
			throw new CustomException(CustomException.exceptionMessage(ex));
		}
	}

	/// <summary>
	/// This will click a button, check box or radio button
	/// </summary>
	/// <param name="element"></param>
	public static void clickAtElement(WebDriver driver, By by, int timeout) throws CustomException {
		try {
			new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(by));
			driver.findElement(by).click();
		} catch (Exception ex) {
			throw new CustomException(CustomException.exceptionMessage(ex));
		}
	}

	/// <summary>
	/// This will click a button, check box or radio button
	/// </summary>
	/// <param name="element"></param>
	public static void doubleClickAtElement(WebDriver driver, By by, int timeout) throws CustomException {
		Actions action = new Actions(driver);
		try {
			new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(by));
			action.doubleClick(driver.findElement(by)).perform();
		} catch (Exception ex) {
			throw new CustomException(CustomException.exceptionMessage(ex));
		}
	}

	// Verify element is present
	private static Boolean isElementPresent(WebElement element) {

		try {
			return element.isDisplayed();
		} catch (Exception ex) {
			return false;
		}
	}

	// This will return true if element is clickable
	private static Boolean isElementClickable(WebElement element) {
		try {
			return (element.isEnabled());
		} catch (Exception ex) {
			return false;
		}
	}

	/// <summary>
	/// This will select a value from dropdown list using index
	/// </summary>
	/// <param name="element"></param>
	/// <param name="value"></param>
	public static void selectDropDownByIndex(WebElement element, int index) throws CustomException {
		try {
			Select ddl = new Select(element);
			ddl.selectByIndex(index);
		} catch (Exception ex) {
			throw new CustomException(CustomException.exceptionMessage(ex));
		}
	}

	/// <summary>
	/// This will select a value from dropdown list using value
	/// </summary>
	/// <param name="element"></param>
	/// <param name="value"></param>
	public static void selectDropDownByValue(WebElement element, String value) throws CustomException {
		try {
			Select ddl = new Select(element);
			ddl.selectByValue(value);
		} catch (Exception ex) {
			throw new CustomException(CustomException.exceptionMessage(ex));
		}
	}

	/// <summary>
	/// This will select a value from dropdown list using text
	/// </summary>
	/// <param name="element"></param>
	/// <param name="value"></param>
	public static void selectDropDownByVisibleText(WebElement element, String str) throws CustomException {
		try {
			Select ddl = new Select(element);
			ddl.selectByVisibleText(str);
		} catch (Exception ex) {
			throw new CustomException(CustomException.exceptionMessage(ex));
		}
	}

	/// <summary>
	/// This will send key to the given element on the basis of value argument
	/// </summary>
	/// <param name="element"></param>
	/// <param name="value"></param>
	/// <param name="test"></param>
	public static void enterKeys(WebElement element, int value) {
		switch (value) {
		case 0:
			element.sendKeys(Keys.TAB);
			break;
		case 1:
			element.sendKeys(Keys.ENTER);
			break;
		case 2:
			element.sendKeys(Keys.SPACE);
			break;
		case 3:
			element.sendKeys(Keys.BACK_SPACE);
			break;
		}
	}

	/// <summary>
	/// This will hover mouse on element
	/// </summary>
	/// <param name="driver"></param>
	/// <param name="element"></param>
	public static void hover(WebDriver driver, WebElement element) throws CustomException {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
		} catch (Exception ex) {
			throw new CustomException(CustomException.exceptionMessage(ex));
		}
	}

	/// <summary>
	/// This will hover mouse and click on element
	/// </summary>
	/// <param name="driver"></param>
	/// <param name="elementToHover"></param>
	/// <param name="elementToClick"></param>
	public static void hoverAndClick(WebDriver driver, WebElement elementToHover, WebElement elementToClick)
			throws CustomException {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(elementToHover).build().perform();
			action.moveToElement(elementToClick).click();
		} catch (Exception ex) {
			throw new CustomException(CustomException.exceptionMessage(ex));
		}
	}

	/// <summary>
	/// This method is used to get text from any element
	/// </summary>
	/// <param name="element"></param>
	/// <returns></returns>
	public static String getElementText(WebElement element) {
		return element.getText();
	}

	/// <summary>
	/// This method is used to get text from any element
	/// </summary>
	/// <param name="element"></param>
	/// <returns></returns>
	public static int[] getXAndYCoordinate(WebElement element) {
		int[] cor = new int[2];
		Point point = element.getLocation();
		cor[0] = point.getX();
		cor[1] = point.getY();
		return cor;
	}

	/// <summary>
	/// This method is used to get text from any element
	/// </summary>
	/// <param name="element"></param>
	/// <returns></returns>
	public static int[] getWidthAndHeight(WebElement element) {
		int[] size = new int[2];
		Rectangle dem = element.getRect();
		size[0] = dem.getWidth();
		size[1] = dem.getHeight();
		return size;
	}

}
