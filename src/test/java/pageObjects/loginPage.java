package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends basePage{

	public loginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub		
	}
	
	//-----------------------------------------------------------
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtpassword;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnlogin;
	
	//------------------------------------------------------------
	
	public void enterEmail(String email) {
		txtemail.sendKeys(email);
	}
	
	public void enterPassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}
	
	public void clickLogin() {
		btnlogin.click();
	}

}
