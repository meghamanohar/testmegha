package springexample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(springexample.ListenerDemo2.class)

public class TestCasesListener {
	public static WebDriver driver;			
  @Test (priority = 0)
  public void login() {
	    System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
	    driver = new ChromeDriver();
	    driver.get("http://demo.guru99.com/V4/");					
	    driver.findElement(By.name("uid")).sendKeys("mngr34926");							
	    driver.findElement(By.name("password")).sendKeys("amUpenu");							
	    driver.findElement(By.name("btnLogin")).click();
  }
  @Test (priority = 1)
  public void TestToFail()				
  {		
      System.out.println("This method to test fail");					
      Assert.assertTrue(false);			
  }	
}
