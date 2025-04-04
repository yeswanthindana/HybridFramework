package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AccountRegistrationPage extends basePage {

	

	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//constructor
	
	
	//locator
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtmobile;
	
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtpassword;
		
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtcnfpwd;
	
	
	
	@FindBy(xpath="//label[normalize-space()='No']//input[@name='newsletter']")
	WebElement subscribeNo;
	
	@FindBy(xpath="//label[normalize-space()='Yes']//input[@name='newsletter']")
	WebElement subscribeYes;

	@FindBy(xpath="//input[@name='agree']")
	WebElement checkprivacy;

	@FindBy(xpath="//input[@value='Continue']")
	WebElement buttoncontinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msghconfirmation;
	
	//--------------------------------------------------------------------------------------

	
	 
	  public void setFirstName(String fname) {
	 
		txtFirstName.sendKeys(fname);
		
	}
	
	public void setLastname(String lname) {
		txtLastName.sendKeys(lname);	
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
		
	}
	
	public void setMobile(String Mobile) {
		txtmobile.sendKeys(Mobile);
		
		
	}
	
	public void setPassword(String pwd) {
		txtpassword.sendKeys(pwd);
		
	}
	
	public void setcnfpassword(String pwd) {
		txtcnfpwd.sendKeys(pwd);
	}
	
	public void subscribeYes() {
		subscribeYes.click();
	}
	
	public void subscribeNo() {
		subscribeNo.click();
	}
	
	
	public void checkprivacy() {
		checkprivacy.click();
	}
	
	public void clickcontinue() {
		buttoncontinue.click();
	}
	
	public String msgcompare() {
		try {
			return (msghconfirmation.getText());
		} catch(Exception e) {
			return (e.getMessage());
		}
		
		
	}

}




