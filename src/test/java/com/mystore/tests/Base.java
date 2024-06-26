package com.mystore.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.mystore.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;
	protected static final Logger logger = LogManager.getLogger(Base.class);

	//Creating the object of readConfig class from utilities package
	ReadConfig readConfig = new ReadConfig();
	String url = readConfig.getBaseUrl();
	String browserName = readConfig.getBrowser();



	@BeforeClass
	public void setup()
	{    
		switch(browserName.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("Chrome Browser is launched");
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logger.info("FireFox Browser is launched");
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			logger.info("edge Browser is launched");
			break;
		default : 
			throw new IllegalArgumentException("Invalid browser name: " + browserName);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		logger.info("Application Launched");
	}

	@AfterClass	
	public void teardown()
	{ 
		if (driver != null) {
			driver.quit();
			logger.info("Driver closed");
		}
	}

	public void captureScreenShot(WebDriver driver,String testName) 
	{
		try {
			//step1: convert webdriver object to TakesScreenshot interface
			TakesScreenshot screenshot = ((TakesScreenshot)driver);

			//step2: call getScreenshotAs method to create image file

			File src = screenshot.getScreenshotAs(OutputType.FILE);

			File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");

			//step3: copy image file to destination
			FileUtils.copyFile(src, dest);
		}
		catch (IOException e) {
			System.err.println("Error occurred while capturing screenshot: " + e.getMessage());
		}
	}
}
