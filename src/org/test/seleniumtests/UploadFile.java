package org.test.seleniumtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class UploadFile {
	//herokuapp.
	private WebDriver driver;
	private String baseUrl = "http://the-internet.com/upload";
	private String file = "happy.jpg";
	private String filePath = null;

	@Test
	public void uploadFile() {
		WebElement uploadFile = driver.findElement(By.id("file-upload"));
		uploadFile.sendKeys(filePath);

		WebElement submit = driver.findElement(By.id("file-submit"));
		submit.click();

		Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(), file);
	}

	@BeforeClass
	public void beforeClass() {
		filePath = System.getProperty("user.dir") + "\\testdata\\" + file;
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
