package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; //Log4j
import org.apache.logging.log4j.Logger; //Log4j
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {

	public static WebDriver driver;
	public Properties properties;
	public Logger logger; // Log4j


	@Parameters({"os","browser"})
	@BeforeClass(groups= {"sanity","Regression","master","datadriven"})
	public void setup(String os, String br) throws IOException {
		
		//Loading config.properties
		
		FileReader file = new FileReader("./src/test/resources/config.properties");
		properties = new Properties();
		properties.load(file);

		//Loading logger
		
		logger = LogManager.getLogger(this.getClass());
	
		
		
		if(properties.getProperty("execution_environment").equalsIgnoreCase("remote")) {
			
			DesiredCapabilities cap = new DesiredCapabilities();
			
			/*
			 * cap.setPlatform(Platform.WIN11); cap.setBrowserName("chrome");
			 */
			
			//OS
			if(os.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN11);
			} else if (os.equalsIgnoreCase("mac")){
				cap.setPlatform(Platform.MAC);
			} else if(os.equalsIgnoreCase("Linux")){
				cap.setPlatform(Platform.LINUX);
			} else {
				System.out.println("Invalid or No matching OS available");
				return;
			}
			
			
			  switch(br.toLowerCase()) { 
			  case "chrome" : cap.setBrowserName("chrome"); break; 
			  case "edge" : cap.setBrowserName("MicrosoftEdge"); break; 
			 case "firefox": cap.setBrowserName("firefox"); break; 
			  default: System.out.println("Invalid Browser or no matching browser"); return;
			  
			  
			  }
			 
			
			driver = new RemoteWebDriver(new URL("http://192.168.31.103:4444/wd/hub"), cap); 

		}
			
			if(properties.getProperty("execution_environment").equalsIgnoreCase("local")) {
		
				
				switch(br.toLowerCase())
				{
				case "chrome" :  driver = new ChromeDriver(); break;
				case "edge" : driver = new EdgeDriver(); break;
				case "firefox" : driver = new FirefoxDriver(); break;
				default : System.out.println("Invalid Input");  return;
				}
				
				
		
			}
		
		
		logger.info("launching " + br + " browser");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(properties.getProperty("appurl"));
		driver.manage().window().maximize();
	} 
	
	
	@AfterClass(groups= {"sanity","Regression","master","datadriven"})
	public void teardown() {
		driver.quit();
	}

	public String randomString() {
		String genString = RandomStringUtils.randomAlphabetic(5);
		System.out.println(genString);
		return genString;
	}

	public String randomNum() {
		String genString = RandomStringUtils.randomNumeric(9);
		System.out.println(genString);
		return genString;
	}

	public String randomAlphanumber() {
		String genString = RandomStringUtils.randomAlphabetic(5);
		String genInt = RandomStringUtils.randomNumeric(4);
		System.out.println(genString + "@" + genInt);
		return (genString + genInt);
	}

	public String captureScreen(String tname) throws IOException {

		String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesscreenshot = (TakesScreenshot) driver;
		File sourceFile = takesscreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilepath = System.getProperty("user.dir") + "\\Screenshots\\" + tname + "_" + timestamp + ".png";
		File targetFile = new File(targetFilepath);

		sourceFile.renameTo(targetFile);
		return targetFilepath;

	}

}
