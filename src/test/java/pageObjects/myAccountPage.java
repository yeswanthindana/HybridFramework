package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myAccountPage extends basePage{

	public myAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement msgheading;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") //added in step 6
	WebElement clklogout;
	
	public void clklogout() {
		clklogout.click();
	}
	
	
	
	public boolean isMyAccountexist() {
	try {
		return (msgheading.isDisplayed());
	}
		catch(Exception e) {
			return false;
		}
	}
	
}

