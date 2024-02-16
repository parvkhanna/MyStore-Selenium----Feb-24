package com.mystore.pageobject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountCreationDetailsPage {

	//1. create object of webdriver
	WebDriver driver;
	WebDriverWait wait;
	//constructor
	public AccountCreationDetailsPage(WebDriver rdriver)
	{
		driver = rdriver;
		PageFactory.initElements(driver, this);
	}


	//identify webelements
	@FindBy(id = "id_gender2") //Title-Mrs
	WebElement titleMrs;

	@FindBy(id = "id_gender1") //Title-Mrs
	WebElement titleMr;

	@FindBy(id="customer_firstname")
	WebElement custfirstName;

	@FindBy(id="customer_lastname")
	WebElement custlastName;

	@FindBy(id="passwd")
	WebElement password;

	@FindBy(id="firstname")
	WebElement addFirstname;

	@FindBy(id="lastname")
	WebElement addLastname;

	//address1
	@FindBy(id="address1")
	WebElement address1;

	@FindBy(id="city")
	WebElement city;

	//id_state
	@FindBy(id="id_state")
	WebElement state;

	@FindBy(id="postcode")
	WebElement postcode;


	@FindBy(id="id_country")
	WebElement country;

	//phone_mobile
	@FindBy(id="phone_mobile")
	WebElement phone_mobile;

	//alias
	@FindBy(id="alias")
	WebElement alias;


	@FindBy(id="submitAccount")
	WebElement register;
	//identify actions to be performed on web elements

	public void selectTitleMrs()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(titleMrs)).click();
	}

	public void selectTitleMr()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(titleMr)).click();
	}
	public void enterCustomerFirstName(String fname)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(custfirstName)).sendKeys(fname);
	}

	public void enterCustomerLastName(String lname)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(custlastName)).sendKeys(lname);
	}

	public void enterPassword(String pwd)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(password)).sendKeys(pwd);
	}

	public void enterAddressFirstName(String fname)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(addFirstname)).clear();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(addFirstname)).sendKeys(fname);
	}

	public void enterAddressLastName(String lname)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(addLastname)).clear();

		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(addLastname)).sendKeys(lname);
	}

	public void enterAddress(String address)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(address1)).sendKeys(address);
	}

	public void enterCity(String cityName)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(city)).sendKeys(cityName);
	}

	public void selectState(String text)
	{
		Select obj = new Select(state);
		obj.selectByVisibleText(text);
	}

	public void enterPostcode(String postcodeData)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(postcode)).sendKeys(postcodeData);
	}

	public void selectCountry(String text)
	{
		Select obj = new Select(country);
		obj.selectByVisibleText(text);
	}

	public void enterMobilePhone(String mobile)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(phone_mobile)).sendKeys(mobile);
	}

	public void enterAlias(String text)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(alias)).clear();
		alias.sendKeys(text);
	}

	public void clickOnRegister()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(register)).click();
	}
}