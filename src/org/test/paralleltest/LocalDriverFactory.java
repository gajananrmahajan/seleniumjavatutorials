package org.test.paralleltest;

import java.io.File;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LocalDriverFactory {
	
	public static WebDriver createBrowserInstance(String browserName){
		Logger logger = Logger.getLogger(LocalDriverFactory.class.getName());

		String chrome = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
		String ie = System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe";
		
		WebDriver driver = null;
		
		if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					(new File(chrome)).getAbsolutePath());
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",
					(new File(ie)).getAbsolutePath());
			driver = new InternetExplorerDriver();
		} else {
			logger.info("Incorrect browserName was provided");
		}
		
		driver.manage().window().maximize();

		return driver;
	}
}
