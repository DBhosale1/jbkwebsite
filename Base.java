package com.jbk;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
public static WebDriver driver;
public static void initialization()
{
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("file:///D:/JBK%20Offline/index.html");
}
	public static void failed(String testMethodName) throws IOException
	{
	

	    TakesScreenshot ts =(TakesScreenshot)driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(source,new File("./Screenshots/"+testMethodName+"_"+".png"));
		System.out.println("Screenshot taken");
		
	
	}
}
	
	
	

