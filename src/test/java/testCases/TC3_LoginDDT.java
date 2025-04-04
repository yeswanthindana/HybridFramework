package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.loginPage;
import pageObjects.myAccountPage;
import testBase.baseClass;
import utilities.dataProviders;




/*
 Data - Valid - Login success - test pass - logout
 Data - Valid - Login Failed - test failed
 
 Data - Invalid - Login success - test fail - logout'
 Data - Invalid - Login Failed - test pass
 */

public class TC3_LoginDDT extends baseClass{
	
	@Test(dataProvider = "LoginData", dataProviderClass = dataProviders.class, groups = "datadriven") //since data provider utility is prrsengt in other calss and h3nce using dataprovoiderclass with import the class
	public void verifyloginDDT(String email, String password, String expres) {
		
	logger.info("**********************TC03 DDT STARTED*********************");
		
	try {	
	Homepage hp = new Homepage(driver);
	hp.clickMyAccount();
	hp.clickLogin();
	
	
	loginPage lp = new loginPage(driver);
	lp.enterEmail(email);
	lp.enterPassword(password);
	lp.clickLogin();
	
	myAccountPage mp = new myAccountPage(driver);
	boolean target = mp.isMyAccountexist();
	
	if(expres.equalsIgnoreCase("Valid")) 
	{ // dATA IS VALID
		if(target==true) 
		{    // LOGIN SUCCESS
			logger.info("**********************Data is Valid, Login success and test case PASS*********************");
			Assert.assertTrue(true);
			mp.clklogout();
		} 
		else 
		{             // LOGIN FAIL
			logger.info("**********************Data is Valid, Login failed and test case FAIL*********************");
			Assert.assertTrue(false);
		}
	}
		
	
	if(expres.equalsIgnoreCase("Invalid")) 
	{            //Data is invalid
		if(target==true) 
		{    // LOGIN SUCCESS
			logger.info("**********************Data is Invalid, Login success and test case FAIL*********************");
			mp.clklogout();
			Assert.assertTrue(false);
		} 
		else 
		{             // LOGIN FAIL
			logger.info("**********************Data is Invalid, Login failed and test case PASS*********************");
			Assert.assertTrue(true);
		}
	
	}
	
	} catch (Exception e) {
		logger.info("**********************TC03 DDT FAILED*********************");
		Assert.fail();
	}
	
	logger.info("**********************TC03 DDT FINISHED*********************");
	
	

}
}
