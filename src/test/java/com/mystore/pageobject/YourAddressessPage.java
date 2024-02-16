package com.mystore.pageobject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YourAddressessPage {

	WebDriver driver;
	WebDriverWait wait;
	public YourAddressessPage(WebDriver rdriver)
	{
		driver = rdriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id ="address1")
	WebElement address;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="id_state")
	WebElement state;
	
	
	@FindBy(id="postcode")
	WebElement postalCode;
	
	@FindBy(id="phone")
	WebElement phoneNo;
	
	@FindBy(id="phone_mobile")
	WebElement mobileNo;
	
	@FindBy(id="alias")
	WebElement addressTitle;
	
	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement btnSave;
	
	public void addAddressDetails()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(address)).sendKeys("Arera Colony");
		wait.until(ExpectedConditions.elementToBeClickable(city)).sendKeys("Bhopal");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", state);
		Select dropdown = new Select(state);
		dropdown.selectByVisibleText("Alaska");
		
		wait.until(ExpectedConditions.elementToBeClickable(postalCode)).sendKeys("12122");
		wait.until(ExpectedConditions.elementToBeClickable(phoneNo)).sendKeys("0755246228");
		wait.until(ExpectedConditions.elementToBeClickable(mobileNo)).sendKeys("1234567890");
		wait.until(ExpectedConditions.elementToBeClickable(city)).sendKeys("DummyAddress1");
		wait.until(ExpectedConditions.elementToBeClickable(btnSave)).click();
		
	}
}
