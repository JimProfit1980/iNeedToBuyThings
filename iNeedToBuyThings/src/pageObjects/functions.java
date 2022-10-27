package pageObjects;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class functions {
	static ChromeDriver driver;

	public functions() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Setups up the chrome driver instance
	 **/
	@BeforeMethod
	public static ChromeDriver setup() {
	 File file = new File("C:\\Users\\ShaneS\\Documents\\Learning\shoppingAutomation\\iNeedToBuyThings");
		System.getProperty("webdriver.chrome.driver",
				file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	@AfterMethod
	public static void teardown()
	{
		driver.quit();
	}

	/**
	 * Navigates to a set URL
	 **/
	public static String URL() {
		return "http://automationpractice.com/";
	}
}
