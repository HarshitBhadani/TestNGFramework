package com.learnautomation.Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass {
	
	
	public WebDriver driver;
	public ConfigReader config;
	public ExcelDataProvider exceldp;
	public Helper helper;
	public ExtentReports extent;
	public ExtentSparkReporter spark;
	public ExtentTest test;
	
	@BeforeSuite
	public void SetUp() {
		exceldp = new ExcelDataProvider();
		config = new ConfigReader();
		helper = new Helper();
		
		extent = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/spark.html");
		spark.config().setTheme(Theme.DARK);
		extent.attachReporter(spark);
	}
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) {
		//driver = DriverFactory.startApplicatiion(driver, config.getBrowser(), config.getAppUrl());
		driver = DriverFactory.startApplicatiion(driver, browser, config.getAppUrl());
		System.out.println(driver.getTitle());
	}
	
	@AfterSuite
	public void tearDown() {
		DriverFactory.quitBrowser(driver);
		extent.flush();
	}
	
	@AfterMethod
	public void takeScreenshot(ITestResult result) {
		System.out.println("Result is :" +result.getStatus());
		String path = helper.captureScreenshot(driver);
		test.pass("Test Case Passed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		
		
//		String screenshotName = "screenshot";
//		byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//		scenario.attach(sourcePath, "image/png", screenshotName);
//		test.addScreenCaptureFromBase64String("");
	}

}
