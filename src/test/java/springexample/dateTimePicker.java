package springexample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class dateTimePicker {
  @Test
  public void dateTimePicker() {

      System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

      WebDriver driver = new ChromeDriver();

      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      driver.get("http://demo.guru99.com/test/");
      WebElement dateBox = driver.findElement(By.xpath("//form//input[@name='bdaytime']"));
      dateBox.sendKeys("09252013");
      dateBox.sendKeys(Keys.TAB);
      dateBox.sendKeys("0245PM");
      driver.close();
  }
}
