package com.mystore.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.AccountCreationDetailsPage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;
import com.mystore.pageobject.MyAccountPage;

public class RegisterUserTest extends Base {
	
	@Test()
	public void verifyUserRegisterationTest() 
	{
		logger.info("*****TestCase Verify Registration and Login starts*****");
		
		IndexPage index = new IndexPage(driver);
		index.clickOnSignIn();
		logger.info("Click on SignIn Link");
		
		LoginPage lp = new LoginPage(driver);
		lp.enterCreateEmailAddress("prachi6@gmail.com");
		logger.info("Email address entered in create account section.");
		lp.clickSubmitCreate();
		logger.info("clicked on create an account button");
		
		AccountCreationDetailsPage acp = new AccountCreationDetailsPage(driver);

		acp.selectTitleMrs();
		acp.enterCustomerFirstName("Prachi");
		acp.enterCustomerLastName("Gupta");
		acp.enterPassword("cs923");
		logger.info("entered user details on account creation page.");

		acp.clickOnRegister();
		logger.info("clicked on Register button");

		MyAccountPage myAccountPage = new MyAccountPage(driver);
		String userName = myAccountPage.getUserName();
		Assert.assertEquals("Prachi Gupta", userName);

		logger.info("*****TestCase Verify Registration and Login ends*****"); 

	}

	
	
	
}
