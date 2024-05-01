package com.mystore.datadriven.tests;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;
import com.mystore.pageobject.MyAccountPage;
import com.mystore.tests.Base;

public class JsonDataLoginTest extends Base {

	@DataProvider(name = "jsonData")
	public Object[][] getTestData() {
		String[][] testData = null;
		try {
			// Path to your JSON file
			String filePath = System.getProperty("user.dir") + "\\TestData\\testdata.json";
			// Parsing - Read JSON file
			JSONParser jsonParser = new JSONParser();
			FileReader reader = new FileReader(filePath);
			// Convert JSON object to Java object
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			// Get data array from JSON
			JSONArray dataArray = (JSONArray) jsonObject.get("userlogins");
			// Initialize the 2D array to store the data
			testData = new String[dataArray.size()][3];
			// Iterate over JSON array to populate testData array
			for (int i = 0; i < dataArray.size(); i++) 
			{
				JSONObject dataObject = (JSONObject) dataArray.get(i);
				testData[i][0] = (String) dataObject.get("username");
				testData[i][1] = (String) dataObject.get("password");
				testData[i][2] = (String) dataObject.get("expectedUsername");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return testData;
	}


	@Test(dataProvider = "jsonData")
	public void verifyLoginTest(String username, String password, String expectedUsername) throws IOException
	{
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
		System.out.println("Expected Username: " + expectedUsername);
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
