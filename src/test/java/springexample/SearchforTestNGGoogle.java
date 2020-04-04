package springexample;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;


public class SearchforTestNGGoogle {
	 	  private WebDriver driver;

		  @Test
		  public void searchTestngIngoogle() {
			  final String searchKey = "TestNG";
			  System.out.println("Search " + searchKey + " in google");
			  driver.navigate().to("http://www.google.com");
			  WebElement element = driver.findElement(By.name("q"));
			  element.sendKeys(searchKey);
			  element.submit();
/*			   (new WebDriverWait(driver, 10)).until(new ExpectedCondition() x	{
		           public Boolean apply(WebDriver d) {
		               return d.getTitle().toLowerCase()
		                       .startsWith(searchKey.toLowerCase());
		           }
		       });*/
			  
			   
		  }
		  @BeforeSuite
		  public void initDriver() throws Exception {
		      System.out.println("You are testing in chrome");
		      System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
		      driver = new ChromeDriver();
		  }
		  @AfterSuite
		  public void quitDriver() throws Exception {
		      driver.quit();
		  }

		}

