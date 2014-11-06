package org.test.seleniumtestng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class DataDrivenTestWithParameters {
  private WebDriver driver = null;
  
  @Test
  @Parameters({"url", "title"})
  public void test(String url, String title) {
    driver.get(url);
    Assert.assertTrue(driver.getTitle().contains(title));
  }
  
  @BeforeClass
  public void beforeClass() {
    driver = new FirefoxDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() {
    driver.quit();
  }
}
