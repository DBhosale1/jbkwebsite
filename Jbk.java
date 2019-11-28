package com.jbk;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument.Tests;
import org.bson.diagnostics.Loggers;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utility.XlsReader;

import mx4j.log.Log4JLogger;

import java.io.IOException;

public class Jbk {
WebDriver driver;



ExtentReports extent;
ExtentTest logger;
XlsReader reader = new XlsReader("C:/Users/home/Desktop/data.xlsx");


@BeforeSuite
public void openSite(){
	//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	//driver = new ChromeDriver();
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.get("file:///D:/D-pendrive/JBK%20Offline/index.html");
	
	
}

@BeforeTest
public void startReport(){	

	 extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/JBkExtentReport.html", true);
	 extent
	                .addSystemInfo("Host Name", "Dheeraj")
	                .addSystemInfo("Environment", "Automation Testing")
	                .addSystemInfo("User Name", "DheerajBhosale");
	                extent.loadConfig(new File(System.getProperty(" D:\\Dhir data\\jbkwebsite\\extent-config.xml")+"\\extent-config.xml"));
	               
	                
	                //  C:\\Mamta\\programs\\jbkwebsite\\extent-config.xml
}
/*public static void email() throws EmailException{

	
	Email email = new SimpleEmail();
	email.setHostName("smtp.email.com");
	email.setSmtpPort(465);
	email.setAuthenticator(new DefaultAuthenticator("mamtakathane@gmail.com", ""));
	email.setSSLOnConnect(true);
	email.setFrom("deogadelikhita@gmail.com");
	email.setSubject("Automate jbk offline website");
	email.setMsg("This is a test mail ... :-)");
	email.addTo("foo@bar.com");
	email.send();	
}*/




@Test(priority= 1)
public void Home(){
	WebElement ele = driver.findElement(By.xpath("//ul//li[1]//a[contains(text(),'Home')]"));

	
		String  actHome = ele.getText();
		System.out.println(actHome);
		ele.click();
		
		String expHome = reader.getCellData("Sheet2", "Content", 2);
		System.out.println(expHome);
		logger = extent.startTest("passTest");
		Assert.assertEquals(actHome, expHome);
		 logger.log(LogStatus.PASS, "Test Case Passed is passTest");
}

@Test(priority= 2)
public void AboutSir(){

	WebElement ele1 = driver.findElement(By.xpath("//ul//li[2]//a[contains(text(),'About Sir')]"));

	
		String  actAboutSir = ele1.getText();
		System.out.println(actAboutSir);
		
		
		
		String expAboutSir = reader.getCellData("Sheet2", "Content", 3);
		System.out.println(expAboutSir);
		logger = extent.startTest("passTest");
		Assert.assertEquals(actAboutSir, expAboutSir);
		 logger.log(LogStatus.PASS, "Test Case Passed is passTest");
}
@Test(priority=3)
public void JavaSyallabus(){
	WebElement ele2 = driver.findElement(By.xpath("//ul//li[3]//a[contains(text(),'Java Syllabus')]"));
    String actJavaSyllabus = ele2.getText();
	System.out.println(actJavaSyllabus);
	
	
	
	String expJavaSyllabus = reader.getCellData("sheet2", "Content", 4);
	System.out.println(expJavaSyllabus);
	logger = extent.startTest("passTest");
	Assert.assertEquals(actJavaSyllabus, expJavaSyllabus);
	 logger.log(LogStatus.PASS, "Test Case Passed is passTest");
}
@Test(priority=4)
public void SeleniumTesting(){
	WebElement ele3 = driver.findElement(By.xpath("//ul//li[4]//a[contains(text(),'Selenium Testing')]"));
    String actSeleniumTesting = ele3.getText();
	System.out.println(actSeleniumTesting);
	
	
	
	String expSeleniumTesting = reader.getCellData("sheet2", "Content", 5);
	System.out.println(expSeleniumTesting);
	logger = extent.startTest("passTest");
	Assert.assertEquals(actSeleniumTesting, expSeleniumTesting);
	 logger.log(LogStatus.PASS, "Test Case Passed is passTest");
	
}

	

@Test(priority=5)
public void Videos(){
	WebElement ele4 = driver.findElement(By.xpath("//ul//li[5]//a[contains(text(),'Videos')]"));
    String actVideos = ele4.getText();
	System.out.println(actVideos);
	
	
	String expVideos = reader.getCellData("sheet2", "Content", 6);
	System.out.println(expVideos);
	 logger = extent.startTest("failTest");
	Assert.assertEquals(actVideos, expVideos);
	logger.log(LogStatus.PASS, "Test Case (failTest) Status is passed");
	 }


@Test(priority=6)
public void Services(){
	WebElement ele5 = driver.findElement(By.xpath("//ul//li[6]//a[contains(text(),'Services')]"));
    String actServices = ele5.getText();
	System.out.println(actServices);
	
	
	String expServices = reader.getCellData("sheet2", "Content", 7);
	System.out.println(expServices);
	logger = extent.startTest("passTest");
	Assert.assertEquals(actServices, expServices);
	logger.log(LogStatus.PASS, "Test Case Passed is passTest");

}
	
@Test(priority=7)
public void Carrers(){
	WebElement ele6 = driver.findElement(By.xpath("//ul//li[7]//a[contains(text(),'Careers')]"));
    String actCarrers = ele6.getText();
	System.out.println(actCarrers);
	
	
	String expCarrers = reader.getCellData("sheet2", "Content", 8);
	System.out.println(expCarrers);
	logger = extent.startTest("passTest");
	Assert.assertEquals(actCarrers, expCarrers);
	logger.log(LogStatus.PASS, "Test Case Passed is passTest");

}
@Test(priority=8)
public void Gallery(){
	WebElement ele7 = driver.findElement(By.xpath("//ul//li[8]//a[contains(text(),'Gallery')]"));
    String actGallery = ele7.getText();
	System.out.println(actGallery);
	
	String expGallery = reader.getCellData("sheet2", "Content", 9);
	System.out.println(expGallery);
	logger = extent.startTest("passTest");
	Assert.assertEquals(actGallery, expGallery);
	logger.log(LogStatus.PASS, "Test Case Passed is passTest");

}
@Test(priority=9)
public void MyBook(){

	WebElement ele8 = driver.findElement(By.xpath("//ul//li[9]//a[contains(text(),'My Book')]"));
    String actMyBook = ele8.getText();
	System.out.println(actMyBook);
	
	
	String expMyBook = reader.getCellData("sheet2", "Content", 10);
	System.out.println(expMyBook);
	logger = extent.startTest("passTest");
	Assert.assertEquals(actMyBook, expMyBook);
	logger.log(LogStatus.PASS, "Test Case Passed is passTest");

}
@Test(priority=10)
public void OldStudentFeedback(){

	WebElement ele9 = driver.findElement(By.xpath("//ul//li[10]//a[contains(text(),'Old Student Feedback')]"));
    String actOldStudentFeedback = ele9.getText();
	System.out.println(actOldStudentFeedback);
	
	String expOldStudentFeedback = reader.getCellData("sheet2", "Content", 11);
	System.out.println(expOldStudentFeedback);
	logger = extent.startTest("passTest");
	Assert.assertEquals(actOldStudentFeedback, expOldStudentFeedback);
	logger.log(LogStatus.PASS, "Test Case Passed is passTest");


}
@Test(priority=11)
public void ClassRoomExamples(){

	WebElement ele10 = driver.findElement(By.xpath("//a[@follow='nofollow']"));
    String actClassRoomExamples = ele10.getText();
	System.out.println(actClassRoomExamples);
	
	
	String expClassRoomExamples = reader.getCellData("sheet2", "Content", 12);
	System.out.println(expClassRoomExamples);
	logger = extent.startTest("passTest");
	Assert.assertEquals(actClassRoomExamples, expClassRoomExamples);
	logger.log(LogStatus.PASS, "Test Case Passed is passTest");


}
@Test(priority=12)
public void Contact(){

	WebElement ele11 = driver.findElement(By.xpath("//ul//li[12]//a[contains(text(),'Contact')]"));
    String actContact = ele11.getText();
	System.out.println(actContact);
	
	
	String expContact = reader.getCellData("sheet2", "Content", 13);
	System.out.println(expContact);
	logger = extent.startTest("passTest");
	Assert.assertEquals(actContact, expContact);
	logger.log(LogStatus.PASS, "Test Case Passed is passTest");


}

@Test(priority=13)
public void InterviewQuestions(){

	WebElement ele12 = driver.findElement(By.xpath("//ul//li[13]//a[contains(text(),'Interview Questions')]"));
    String actInterviewQuestions = ele12.getText();
	System.out.println(actInterviewQuestions);
	
	
	String expInterviewQuestions = reader.getCellData("sheet2", "Content", 14);
	System.out.println(expInterviewQuestions);
	logger = extent.startTest("passTest");
	Assert.assertEquals(actInterviewQuestions, expInterviewQuestions);
	logger.log(LogStatus.PASS, "Test Case Passed is passTest");

}
 

@Test(priority=14)
public void Tutorials(){

	WebElement ele13 = driver.findElement(By.xpath("//ul//li[14]//a[contains(text(),'Tutorials')]"));
    String actTutorials = ele13.getText();
	System.out.println(actTutorials);
	
	
	String expTutorials = reader.getCellData("sheet2", "Content", 15);
	System.out.println(expTutorials);
	logger = extent.startTest("passTest");
	Assert.assertEquals(actTutorials,expTutorials);
	logger.log(LogStatus.PASS, "Test Case Passed is passTest");


}

@Test(priority=15)
public void CorporateTraining(){

	WebElement ele14 = driver.findElement(By.xpath("//ul//li[15]//a[contains(text(),'Corporate Training')]"));
    String actCorporateTraining = ele14.getText();
	System.out.println(actCorporateTraining);
	
	
	String expCorporateTraining = reader.getCellData("sheet2", "Content", 16);
	System.out.println(expCorporateTraining);
	logger = extent.startTest("passTest");
	Assert.assertEquals(actCorporateTraining,expCorporateTraining);
	logger.log(LogStatus.PASS, "Test Case Passed is passTest");


}


@Test(priority=16)
public void Contactus(){

	driver.findElement(By.xpath("//ul//li[12]//a[contains(text(),'Contact')]")).click();
	
	WebElement ele11 = driver.findElement(By.xpath("//input[@id='name']"));
	
    String actContact = ele11.getText();
	System.out.println(actContact);
	
	
	String expContact = reader.getCellData("sheet2", "Content", 13);
	System.out.println(expContact);
	logger = extent.startTest("failTest");
	Assert.assertEquals(actContact, expContact);
	logger.log(LogStatus.PASS, "Test Case (failTest) Status is passed");
	
}

@AfterMethod
public void FailedTest(ITestResult result)
{
	if(ITestResult.FAILURE==result.getStatus())
	{
		Utility.getScreenshot(driver, "Dheeraj_Failed");
	}
}


@AfterMethod
public void getResult(ITestResult result)
{
	if(result.getStatus() == ITestResult.FAILURE)
	{
		logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
		logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
	}
		else if(result.getStatus() == ITestResult.SKIP)
		{
		logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}

extent.endTest(logger);
}

@AfterTest
public void endReport() {
    extent.flush();
    extent.close();
               
               
}      


@AfterSuite
public void teardown(){
	
	driver.quit();
}
}
