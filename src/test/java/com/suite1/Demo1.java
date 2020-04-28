package com.suite1;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo1 {
	@Test
	public void run() {
		System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
		WebDriver driver = new ChromeDriver();
		Reporter.log("In Demo 1. The browser is opened now");
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Hi");
		Reporter.log("Data \"Hi\" entered");
		driver.close();

	}

}
