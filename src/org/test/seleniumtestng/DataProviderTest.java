package org.test.seleniumtestng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
  
  private WebDriver driver = null;
  
  @DataProvider(name="testdata")
  public Object[][] testData(){
    return new Object[][]{
        {"http://www.google.com", "Google"}, 
        {"http://twitter.com", "Twitter"}
    };
  }
  
  @Test(dataProvider = "testdata")
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
