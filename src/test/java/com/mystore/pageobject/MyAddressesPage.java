package com.mystore.pageobject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAddressesPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public MyAddressesPage(WebDriver rdriver)
	{
		driver = rdriver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath = "//span[text()='Add a new address']")
	WebElement addNewAddress;
	
	public void clickOnAddNewAddress()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(addNewAddress)).click();;
	}
	
}
