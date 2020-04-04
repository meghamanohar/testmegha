import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {
  @Test
  public void searchTestngIngoogle() {
	  final String searchKey = "TestNG";
	  System.out.println("Search " + searchKey + " in google");
	  driver.navigate().to("http://www.google.com");
	  WebElement element = driver.findElement(By.name("q"));
	  element.sendKeys(searchKey);
	  element.submit();
	   (new WebDriverWait(driver, 10)).until(new ExpectedCondition() {
           public Boolean apply(WebDriver d) {
               return d.getTitle().toLowerCase()
                       .startsWith(searchKey.toLowerCase());
           }
       });
	   
  }
  @BeforeSuite
  public void initDriver() throws Exception {
      System.out.println("You are testing in firefox");
      driver = new FirefoxDriver();
  }
  @AfterSuite
  public void quitDriver() throws Exception {
      driver.quit();
  }

}
