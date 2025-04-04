package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.AccountRegistrationPage;
import pageObjects.Homepage;
import testBase.baseClass;

public class TC1_AccountRegistrationtest extends baseClass{
	

	@Test(groups = {"Regression","master"})
	public void verify_account_registration() {
		
		logger.info("*****************STARTING TC01************************");
		
		try {
			
		
		Homepage hp =  new Homepage(driver); 
		hp.clickMyAccount();
		hp.clickRegister();
		
		
		logger.info("Clicked on My account link");
		
		AccountRegistrationPage ap = new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details");
		/*ap.setFirstName("John");
		
		ap.setLastname("jaddu");
	
		ap.setEmail("jadu@john.com");
		ap.setPassword("Jadd@123");
		ap.checkprivacy();
		ap.checksubscribe();
		ap.clickcontinue();
		String confmsg = ap.msgcompare();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
		------------------------------------------------------------------------------
		*/
		ap.setFirstName(randomString().toUpperCase());
		ap.setLastname(randomString().toUpperCase());
		ap.setEmail(randomString()+"@gmail.com");
		ap.setMobile(randomNum());
		String pwd = randomAlphanumber();
		System.out.println(pwd);
		ap.setPassword(pwd);
		ap.setcnfpassword(pwd);
		ap.subscribeYes();
		ap.checkprivacy();
		ap.clickcontinue();
		
		String mess = ap.msgcompare();
		logger.info("validating message");
		System.out.println(mess);
		
		
		if(mess.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
			logger.info("*****************************TC01 is PASSED******************************");
		} else {
			
			logger.error("Test Failed");
			logger.debug("debug logs");
			logger.info("*****************************TC01 is FAILED******************************");
			Assert.assertFalse(false);
			Assert.fail();
		}
		
		
		} catch(Exception e) {
			
			logger.error("Test failed");
			logger.debug("Debug logs");
			logger.info("*****************************TC01 is FAILED******************************");
			Assert.fail();
			
		}
		
		
		
		logger.info("*****************************TC01 Finished******************************");
	}
	


}
