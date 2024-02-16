package com.mystore.pageobject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndexPage  {
	
	WebDriver driver;
	WebDriverWait wait;
	public IndexPage(WebDriver rdriver)
	{
		driver = rdriver;
		PageFactory.initElements(driver, this);;
	}
	

	@FindBy(linkText = "Sign in")
	WebElement signInLink;
	
	
	public void clickOnSignIn()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try{
			wait.until(ExpectedConditions.titleContains("My Shop"));
		}
		catch (Exception e) {
			driver.navigate().refresh();
		}
		wait.until(ExpectedConditions.elementToBeClickable(signInLink)).click();
		
	}
}
