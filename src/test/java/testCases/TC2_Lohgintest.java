package testCases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.loginPage;
import pageObjects.myAccountPage;
import testBase.baseClass;

public class TC2_Lohgintest extends baseClass{
	
	@Test(groups = {"sanity","master"})
	public void verify_login() throws IOException {

		try {
		logger.info("*******************TC02 STARTED*********************");
		
		Homepage hp = new Homepage(driver);
		
		hp.clickMyAccount();
		logger.info("Clicked on My Account");
		
		hp.clickLogin();
		logger.info("Clicked on Login");
		
		loginPage lp = new loginPage(driver);
		
		lp.enterEmail(properties.getProperty("username"));
		logger.info("entered username");
		
		lp.enterPassword(properties.getProperty("password"));
		logger.info("entered password");
		
		lp.clickLogin();
		logger.info("Clicked on Login");
		
		myAccountPage ap = new myAccountPage(driver);
	
		boolean targetPage = ap.isMyAccountexist();
		if(targetPage) {
			logger.info("required page exists");
			logger.info("*******************TC02 PASSED*********************");
		 } else {
			 logger.error("no required page exists");
			 logger.debug("debug resukts");
			 logger.info("*******************TC02 FAILED*********************");
			 Assert.fail();
			 
		 }
		
		logger.info("*******************TC02 FINISHED*********************");
		
		
	} catch (Exception e ) {

		logger.error("Test failed");
		logger.debug("Debug logs");
		logger.info("*****************************TC01 is FAILED******************************");
		Assert.fail();
		
	}
	} 
	
	

}
