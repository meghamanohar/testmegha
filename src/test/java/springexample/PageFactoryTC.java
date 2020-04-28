package springexample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PageFactoryTC {
	
	String driverPath = "/Applications/chromedriver";
	WebDriver driver;
	PageFactoryLogin objLogin;
	PageFactoryHomepage objHomePage;
	@BeforeTest
	public void setup(){

        System.setProperty("webdriver.chrome.driver", driverPath);
        
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://demo.guru99.com/V4/");
    }
	@Test
	public void test_Home_Page_Appear_Correct(){
		 //Create Login Page object
		objLogin = new PageFactoryLogin(driver);
		//Verify login page title
		String loginPageTitle = objLogin.getLoginTitle();
		Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
		//login to application

	    objLogin.loginToGuru99("mgr123", "mgr!23");
	 // go the next page

	    objHomePage = new PageFactoryHomepage(driver);
	  //Verify home page

	    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
	    driver.close();
		
		
	}
	
}
