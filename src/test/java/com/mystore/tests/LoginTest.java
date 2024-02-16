package com.mystore.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;
import com.mystore.pageobject.MyAccountPage;

public class LoginTest extends Base {

	
	@Test(groups = {"SmokeTest"})
	public void verifyLoginTest() throws IOException
	{
		logger.info("*******Verify Login Test Starts*******");
		String username = "parvkhanna11@gmail.com";
		String password = "parv123";
		IndexPage index = new IndexPage(driver);
		LoginPage lp = new LoginPage(driver);
		MyAccountPage ap = new MyAccountPage(driver);
		
		index.clickOnSignIn();
		logger.info("Click on SignIn Link");
		
		lp.enterCredentials(username,password);
		logger.info("Input Credentials");
		lp.clickOnLoginbtn();
		logger.info("Successfully logged in");
		
		String userName = ap.getUserName();  // Reused Method
		if(userName.equals("Parv Khanna"))
		{
			logger.info("VerifyLogin - Passed");
			captureScreenShot(driver, "VerifyLogin");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("VerifyLogin - Failed");
			captureScreenShot(driver, "VerifyLogin");
			Assert.assertTrue(false);
		}
		
		logger.info("*******Verify Login Test Ends*******");
	}
	
}
