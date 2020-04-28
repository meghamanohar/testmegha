package springexample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class javascriptCalendar {

	public static void main(String[] args) {
		  System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");

	      WebDriver driver = new ChromeDriver();

	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      driver.get("http://spicejet.com");
	      WebElement date = driver.findElement(By.id("ctl00_mainContent_view_date1"));
	      String dateVal = "29/04";
	      main2(driver,date,dateVal);

	  	}
	public static void main2(WebDriver driver,WebElement element, String dateVal ) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);
	}
	
	
	
}
