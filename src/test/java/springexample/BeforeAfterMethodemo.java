package springexample;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class BeforeAfterMethodemo {
  public static WebDriver driver;
  public String expected = null;
  public String actual = null;
  
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","/Applications/chromedriver");
	  driver = new ChromeDriver();
	  driver.get("http://demo.guru99.com/test/newtours/");
	  String actualTitle = "Welcome: Mercury Tours";
	  String expectedTitle = driver.getTitle();
	  Assert.assertEquals(actualTitle, expectedTitle);
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  String actualTitle = "Welcome: Mercury Tours";
	  String expectedTitle = driver.getTitle();
	  Assert.assertEquals(actualTitle, expectedTitle);
	  
  }
  
  @Test(priority = 0)
  public void register() {
	    driver.findElement(By.linkText("REGISTER")).click() ;
        expected = "Register: Mercury Tours";
        actual = driver.getTitle();
        Assert.assertEquals(actual, expected);
  }
  
  @Test(priority = 1)
  public void support() {
	    driver.findElement(By.linkText("SUPPORT")).click() ;
        expected = "Under Construction: Mercury Tours";
        actual = driver.getTitle();
        Assert.assertEquals(actual, expected);
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.findElement(By.linkText("Home")).click() ;
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
