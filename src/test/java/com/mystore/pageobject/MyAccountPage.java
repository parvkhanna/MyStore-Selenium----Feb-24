package com.mystore.pageobject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage {
	WebDriver driver;
	WebDriverWait wait;
	public MyAccountPage(WebDriver rdriver)
	{
		driver = rdriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@title='View my customer account']") 
	WebElement userName;
	
	@FindBy(className = "page-heading")
	private WebElement AccountPageHeading;
	
	@FindBy(xpath = "//a[contains(@title,'Add my first address')]")
	WebElement addMyFirstAddressLink;
	
	@FindBy(xpath = "//a[contains(@title,'Orders')]")
	WebElement orderHistoryLink;
	
	@FindBy(xpath = "//a[contains(@title,'Credit slips')]")
	WebElement myCreditSlips;
	
	@FindBy(xpath = "//a[contains(@title,'Addresses')]")
	WebElement myAddressesLink;
	
	@FindBy(xpath = "//a[contains(@title,'Information')]")
	WebElement myPersonalInfoLink;
	
	
	public String getUserName()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.visibilityOf(userName));
		String text = userName.getText();

		return text;
	}
	
	
	public void verifyAccountPage()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(AccountPageHeading));		
	}
	
	
	public void clickOnAddAddressLink()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(addMyFirstAddressLink)).click();
		}
		catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(myAddressesLink)).click();
			MyAddressesPage myAddressPage = new MyAddressesPage(driver);
			myAddressPage.clickOnAddNewAddress();
		}
	}

}
