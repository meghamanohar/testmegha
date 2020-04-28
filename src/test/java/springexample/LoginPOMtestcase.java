package springexample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPOMtestcase {
	String driverPath = "/Applications/chromedriver";
	WebDriver driver;
	LoginPOM objLogin;
	LoginPOMhomePage objHomePage;
	   @BeforeTest

	    public void setup(){

		System.setProperty("webdriver.chrome.driver", driverPath);
	        
	        driver = new ChromeDriver();

	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        driver.get("http://demo.guru99.com/V4/");

	    }
	   @Test(priority=0)
	   public void test_Home_Page_Appear_Correct(){
   		   objLogin = new LoginPOM(driver);
		    //Verify login page title
		    String loginPageTitle = objLogin.getLoginTitle();
		    Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
		    //login to application

		    objLogin.loginToGuru99("mgr123", "mgr!23");
		 // go the next page

		    objHomePage = new LoginPOMhomePage(driver);
		    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
            driver.close();
		    
		    
	   }


	   }

