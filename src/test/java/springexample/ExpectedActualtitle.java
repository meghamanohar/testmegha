package springexample;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ExpectedActualtitle {
	
  public static WebDriver driver;
//  public String baseUrl = "http://demo.guru99.com/test/newtours/";
  
     
  @Test
  public void ExpectedActual() {
	  String expectedTitle = "Welcome: Mercury Tours";
	  String actualTitle = driver.getTitle();
	  System.out.println(expectedTitle);
	  System.out.println(actualTitle);
	  Assert.assertEquals(actualTitle, expectedTitle);
  }
  @BeforeTest
  public void launchBrowser() {
	  System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
	  driver = new ChromeDriver();
	  System.out.println("launching chrome browser"); 
	  driver.get("http://demo.guru99.com/test/newtours/");
//	  driver.get(baseUrl);
	  
  }

  @AfterTest
  public void afterTest() {
	 driver.close();
  }

}
