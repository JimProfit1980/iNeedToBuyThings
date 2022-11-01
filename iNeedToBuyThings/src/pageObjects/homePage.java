package pageObjects;

import org.openqa.selenium.By;

public class homePage extends functions {
	
	public static String myAccountHeadingText() {
		return "//h1[text()='My account']";
	}
	
	public static String orderHistoryAndDetailsButton() {
		return "//span[text()='Order history and details']";
	}
	
	public static String myCreditSlipsButton() {
		return "//span[text()='My credit slips']";
	}
	
	public static String myAddressesButton() {
		return "//span[text()='My addresses']";
	}
	
	public static String myPersonalInformationButton() {
		return "//span[text()='My personal information']";
	}
	
	public static String myWishlistsButton() {
		return "//span[text()='My wishlists']";
	}
	
	public static String signOutLink() {
		return "//a[@class='logout']";
	}
	
	/**
	 * Home page is validated
	 **/
	public static boolean homePageValidated() {
		boolean isFound = false;
	 try {
		functions.driver.findElement(By.xpath(myAccountHeadingText())).isDisplayed();
		functions.driver.findElement(By.xpath(orderHistoryAndDetailsButton())).isDisplayed();
		functions.driver.findElement(By.xpath(myCreditSlipsButton())).isDisplayed();
		functions.driver.findElement(By.xpath(myAddressesButton())).isDisplayed();
		functions.driver.findElement(By.xpath(myWishlistsButton())).isDisplayed();
		functions.driver.findElement(By.xpath(signOutLink())).isDisplayed();
		isFound = true;
	 }
	 catch(Exception ex)
	 	{
		 System.out.println("Unable to login!");
		 isFound = false;
	 }
		return isFound;
	}

}
