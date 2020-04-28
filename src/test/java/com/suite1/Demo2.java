package com.suite1;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo2 {
	@Test
	public void run() {
		System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
		WebDriver driver = new ChromeDriver();
		Reporter.log("In Demo 2. The browser is opened now");
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Hi");
		Reporter.log("Data \"Hi\" entered");
		driver.close();

	}

}