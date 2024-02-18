package com.mystore.datadriven.tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;
import com.mystore.pageobject.MyAccountPage;
import com.mystore.tests.Base;
import com.mystore.utilities.ReadExcelFile;

public class DataDrivenLoginTest extends Base {

	@DataProvider(name = "LoginDataProvider")
	public String[][] loginDataProvider()
	{
		String fileName = System.getProperty("user.dir") + "\\TestData\\LoginTestData.xlsx";

/*No need to create the object as all the methods in the "ReadExcelFile" are static*/
		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");
	

		String data[][]=new String[ttlRows-1][ttlColumns];

		for(int i=1;i<ttlRows;i++)//rows =1,2
		{
			for(int j=0;j<ttlColumns;j++)//col=0, 1,2
			{

				data[i-1][j]=ReadExcelFile.getCellValue(fileName,"LoginTestData", i,j);
			}

		}
		return data;
	}
	
	
	
	@Test(dataProvider = "LoginDataProvider")
	public void verifyLoginTest(String username, String password, String expectedUsername) throws IOException
	{
		SoftAssert sa = new SoftAssert();
		logger.info("*******Verify Login Test Starts*******");
		
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
		if(userName.equals(expectedUsername))
		{
			logger.info("VerifyLogin - Passed");
			sa.assertTrue(true);
		}
		else
		{
			logger.info("VerifyLogin - Failed");
			captureScreenShot(driver, "VerifyLogin");
			sa.assertTrue(false);
		}
		lp.clickOnSignOut();
		logger.info("Successfully logged Out");
		sa.assertAll();
		logger.info("*******Verify Login Test Ends*******");
	}
	
}
