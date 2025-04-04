package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

public class basePage {
	
	WebDriver driver;
	
	

	public basePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	

}
