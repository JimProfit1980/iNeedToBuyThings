package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class landingPage extends functions {	
	
	static WebDriver driver;
	
	public landingPage() {		
		
	}
	
	public static String shopHeadingText() {
		return "#header_logo > a > img";
	}
	
	public static String searchBoxInput() {
		return "search_query_top";
	}
	
	public static String searchBoxButton() {
		return "//button[@name='submit_search']";
	}
	
	public static String signInButton() {
		return "login";
	}
	
	public static String womenNavigationLink() {
		return "//a[@class='sf-with-ul' and @title='Women']";
	}
	
	public static String dressesNavigationLink() {
		return "#block_top_menu > ul > li:nth-child(2) > a";   
	}
	
	public static String tShirtsNavigationLink() {
		return "//div[@id='block_top_menu']/ul/li[3]/a";
	}
	
	/**
	 * Validates the landing page
	 * @return a boolean result
	 */
	public static boolean validateLandingPage() {
		boolean isFound = false;
			try {		    
			 functions.driver.findElement(By.cssSelector(shopHeadingText())).isDisplayed();
			 functions.driver.findElement(By.id(searchBoxInput())).isDisplayed();
			 functions.driver.findElement(By.xpath(searchBoxButton())).isDisplayed();
			 functions.driver.findElement(By.className(signInButton())).isDisplayed();			
			 isFound = true;	 
			}
			catch(Exception ex)
			{
				isFound = false;
			}
			return isFound;
		}
	
	/**
	 * You are able to type an item and search in the search box and search for it:
	 * @param searchedItem
	 * @throws InterruptedException   
	 */
	public static void searchForAnItem(String searchedItem) {
		functions.driver.findElement(By.id(searchBoxInput())).sendKeys(searchedItem);
		functions.driver.findElement(By.xpath(searchBoxButton())).click();	
		
	}
	
	/**
	 * The process of searching for multiple items
	 * @param searchedItem
	 * @throws InterruptedException   
	 */
	public static void searchForMultipleItems(String searchedItem) {
		functions.driver.findElement(By.id(searchBoxInput())).sendKeys(searchedItem);
		functions.driver.findElement(By.xpath(searchBoxButton())).click();	
		
	}

	/*****
	 * Sign button clicked
	 */
	public static void signInButtonClick() {
		functions.driver.findElement(By.className(signInButton())).click();
	}	
	
	/*****
	 * Search Box button clicked
	 */
	public static void searchBoxButtonClicked() {
		functions.driver.findElement(By.className(searchBoxButton())).click();
	}
	
	/*****
	 * Search box has been cleared
	 */
	public static void searchBoxInputCleared() {
		functions.driver.findElement(By.id(searchBoxInput())).clear();
	}	
}
