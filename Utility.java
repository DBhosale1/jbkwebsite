package com.jbk;

import java.io.File;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Utility {

	public static void getScreenshot(WebDriver driver, String screenshotname)
	{
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			
			File src = ts.getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(src, new File("./Screenshots/"+screenshotname+".png"));
			System.out.println("Screenshot Taken");
		} catch (Exception e) {
			System.out.println("Exception while taking a screenshot"+e.getMessage());

		}
	
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
