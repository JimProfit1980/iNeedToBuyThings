package pageObjects;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class functions {
	static WebDriver driver;
	static final String url = "http://automationpractice.com";
	static WebElement webElement = null;
	static final String userName = "uncleshanie300@gmail.com";
	static final String password = "Password1234@1";

	public functions() {
		
	}

	/**
	 * Setups up the chrome driver instance and navigates to a set URL
	 **/
	@BeforeMethod
	public static WebDriver setup() {
		File chromeDriverFile = new File(System.getProperty("user.dir"));
	 File file = new File(chromeDriverFile + "\\chromedriver.exe");
		System.getProperty("webdriver.chrome.driver",file.getAbsolutePath());		
		return driver;
	}
		
	/**
	 * Additional setup for the browser
	 **/
	
	public static WebDriver browserSetup() {	
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(functions.URL());
		return driver;
	}
	
	@AfterMethod
	public void teardown()
	{
		functions.driver.quit();
	}
	
	/**
	 * Get the user's username
	 **/
	public static String getUsername() {
		return userName;
	}
	
	/**
	 * Get the user's password
	 **/
	public static String getPassword() {
		return password;
	}

	/**
	 * Navigates to a set URL
	 **/
	public static String URL() {
		return url;
	}
	
	/**
	 * Find element and clicks on it. Requires 2 parameters: 
	 * @param searchType e.g. xpath, id, name
	 * @param pageObject (locator used)
	 **/
	public static WebElement findWebElement(String searchType,String pageObject)
	{			
		
		switch(searchType)
		{
		case "cssSelector":
			webElement = functions.driver.findElement(By.cssSelector(pageObject));
			break;
		case "id": 
			webElement = functions.driver.findElement(By.id(pageObject));
			break;
		case "classname":
			webElement = functions.driver.findElement(By.className(pageObject));
			break;
		case "name":
			webElement = functions.driver.findElement(By.name(pageObject));
			break;
		case "tagname":
			webElement = functions.driver.findElement(By.tagName(pageObject));
			break;
		case "linktext":
			webElement = functions.driver.findElement(By.linkText(pageObject));
			break;
		case "partiallinktext":
			webElement = functions.driver.findElement(By.partialLinkText(pageObject));
			break;
		default:
			webElement = functions.driver.findElement(By.xpath(pageObject));
			break;
		}
		return webElement;
	}		
}
