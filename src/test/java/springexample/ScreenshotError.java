package springexample;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ScreenshotError {
    public static WebDriver getDriver(){
    	WebDriver driver = new ChromeDriver();
    
    	
        if(driver==null){
    	System.setProperty("webdriver.chrome.driver","/Applications/chromedriver");
    	driver = new ChromeDriver();
        }

        return driver;

    }
    

    // This function will take screenshot

    // @param webdriver

    // @param fileWithPath

    // @throws Exception


   public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
	 //Convert web driver object to TakeScreenshot
	   TakesScreenshot scrShot =((TakesScreenshot)webdriver);
	 //Call getScreenshotAs method to create image file
	   File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	 //Move image file to new destination
	   File DestFile=new File(fileWithPath);
	 //Copy file at destination
	   FileUtils.copyFile(SrcFile, DestFile);

	   

   }
}
