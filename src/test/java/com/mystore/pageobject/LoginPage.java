package com.mystore.pageobject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

WebDriver driver;
	WebDriverWait wait;
	public LoginPage(WebDriver rdriver)
	{
		driver = rdriver;
		PageFactory.initElements(driver, this);
	}
	
	    //create new account
		@FindBy(id = "email_create") 
		WebElement createEmailId;

		@FindBy(id="SubmitCreate")
		WebElement SubmitCreate;

		
		//Already registered users
		@FindBy(id = "email")
		WebElement tfEmail;
	
	
		@FindBy(id = "passwd")
		WebElement tfPassword;
	
		@FindBy(xpath = "//span[normalize-space()='Sign in']")
		WebElement btnSignIn;
	
		@FindBy(xpath = "//a[@title='Log me out']")
		WebElement btnSignOut;
		
		
		public void enterCreateEmailAddress(String emailAdd) 
		{
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(createEmailId)).sendKeys(emailAdd);
		}

		
		public void clickSubmitCreate()
		{
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SubmitCreate)).click();
		}
		
		public void enterCredentials(String email,String password)
		{
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(tfEmail)).sendKeys(email);
			wait.until(ExpectedConditions.visibilityOf(tfPassword)).sendKeys(password);
		}
		public void clickOnLoginbtn()
		{
			btnSignIn.click();
		}
		
		public void clickOnSignOut()
		{
			btnSignOut.click();
		}

}
