package com.test.helper;

public class CustomException extends Exception {

	public String message;	
	public static String NoSuchElement = "WebDriver couldn’t locate the element";
	public static String NoSuchWindow = "WebDriver couldn’t find such window";
	public static String NoSuchFrame = "WebDriver couldn’t locate the frame";
	public static String NoAlertPresent = "WebDriver couldn’t locate the Alert";
	public static String ElementNotVisible = "WebDriver couldn’t find this element visible";
	public static String ElementNotSelectable = "WebDriver found that this element was not selectable";
	public static String Timeout = "WebDriver Timed out after waiting for presence of element located";
	public static String ElementNotInteractable = "Element is not interactable";
	public static String UnhandledAlert = "Unhandled alert is presented on web page";
	public static String StaleElementReference = "The web element is detached from the current DOM";
	public static String NoSuchAttribute = "No such attribute is presented in the current DOM";

	public CustomException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public static String exceptionMessage(Exception ex) {
		String mess = "Invalid Exception";
		if (ex.getMessage().contains("NoSuchElementException")) {
			return NoSuchElement;
		} else if (ex.getMessage().contains("NoSuchWindowException")) {
			return NoSuchWindow;
		} else if (ex.getMessage().contains("NoSuchFrameException")) {
			return NoSuchFrame;
		} else if (ex.getMessage().contains("NoAlertPresentException")) {
			return NoAlertPresent;
		} else if (ex.getMessage().contains("ElementNotVisibleException")) {
			return ElementNotVisible;
		} else if (ex.getMessage().contains("ElementNotSelectableException")) {
			return ElementNotSelectable;
		} else if (ex.getMessage().contains("TmeoutException")) {
			return Timeout;
		} else if (ex.getMessage().contains("ElementNotInteractableException")) {
			return ElementNotInteractable;
		} else if (ex.getMessage().contains("UnhandledAlertException")) {
			return UnhandledAlert;
		} else if (ex.getMessage().contains("StaleElementReferenceException")) {
			return StaleElementReference;
		}
		return mess;
	}

	

}
