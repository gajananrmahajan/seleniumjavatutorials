package org.test.seleniumtestng;

import java.io.File;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {
	
	private static Logger logger = Logger.getLogger(CrossBrowserTest.class.getName());
	
	private WebDriver driver;
	
  @Test
  @Parameters({"browser"})
  public void crossBrowserTest(String browser) {
	  String chrome = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
	  String ie = System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe";
	  
	  if(browser.equalsIgnoreCase("Firefox")){
		  driver = new FirefoxDriver();
	  }else if(browser.equalsIgnoreCase("Chrome")){
		  System.setProperty("webdriver.chrome.driver", (new File(chrome)).getAbsolutePath());
		  driver = new ChromeDriver();
	  }else if(browser.equalsIgnoreCase("IE")){
		  System.setProperty("webdriver.ie.driver", (new File(ie)).getAbsolutePath());
		  driver = new InternetExplorerDriver();
	  }else{
		  logger.info("Incorrect browser was provided");
	  }
	  driver.manage().window().maximize();
  }
  
  @AfterClass
  public void teardown(){
	   driver.quit();
  }
}
