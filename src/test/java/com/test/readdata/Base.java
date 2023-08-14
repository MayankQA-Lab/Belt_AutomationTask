package com.test.readdata;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.test.helper.WebElementExtensions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static ReadConfig readconfig = new ReadConfig(); // Creating the object of ReadConfig class
	public static Properties pro;
	public static WebDriver driver;

//	@SuppressWarnings("deprecation")
	public void initialization() throws IOException {
		String browsername = readconfig.getBrowser();
		System.out.println(browsername);

		if (browsername.equals("Chrome")) {

			ChromeOptions options = new ChromeOptions();
			;
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver(options);

		} else if (browsername.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browsername.equals("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (browsername.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browsername.equals("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new EdgeDriver();
		} else if (browsername.equals("IE")) {
			System.setProperty("webdriver.Safari.driver", " Drivers//safaridriver.exe");
			driver = new SafariDriver();
		} else {
			System.out.println("No browser value is given");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(WebElementExtensions.page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(WebElementExtensions.Implicit_wait, TimeUnit.SECONDS);
		System.out.println("Before " + readconfig.getApplicationURL());
		System.out.println("The thread ID for chrome is " + Thread.currentThread().getId());
		driver.get(readconfig.getApplicationURL());
		System.out.println("Executed=" + readconfig.getApplicationURL());
		driver.manage().timeouts().pageLoadTimeout(WebElementExtensions.page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(WebElementExtensions.Implicit_wait, TimeUnit.SECONDS);
		System.out.println("Executed=" + driver.getTitle());

	}

}
