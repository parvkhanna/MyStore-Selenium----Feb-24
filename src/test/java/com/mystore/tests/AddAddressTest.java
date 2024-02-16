package com.mystore.tests;

import org.testng.annotations.Test;

import com.mystore.pageobject.MyAccountPage;
import com.mystore.pageobject.YourAddressessPage;

public class AddAddressTest extends Base{

	
	@Test(dependsOnGroups  = {"SmokeTest"})
	public void verifyAddAddress() throws InterruptedException
	{
		MyAccountPage ap = new MyAccountPage(driver);
		ap.clickOnAddAddressLink();
		logger.info("Navigate to 'Add Address' Page");
		
		YourAddressessPage yp = new YourAddressessPage(driver);
		yp.addAddressDetails();
		logger.info("Address added successfully");
	}
}
