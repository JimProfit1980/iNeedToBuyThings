package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.interactions.Actions;

public class searchResults extends functions {	

	public searchResults() {

		// TODO Auto-generated constructor stub
	}

	public static String resultsShowingText() {
		return "//div[contains(text(),'Showing ')]";
	}
	
	public static String searchedAllOptionsOfSearchedItemFoundElement(int number) {
		return "//ul[@class='product_list grid row']/li[" + number  + "]";
	}	

	public static String searchedAddToCartButton(int number) {
		return "//ul[@class='product_list grid row']/li[" + number  + "]//a[@data-id-product]/span";
	}	
	
	public static String searchedItemsList() {
		return "//ul[@class='product_list grid row']/li";
	}

	public static String searchedItemsFound() {
		return "span.heading-counter";
	}
	
	public static String addedToCardSuccessfullyCheckMark() {   
		return "icon-ok";
	}
	
	public static String addToCartContinueShoppingChevron() {
		return "//span[@title='Continue shopping']";
	}
	
	public static String addToCartProceedToCheckoutChevron() {
		return "//span[contains(text(),'Proceed to checkout')]";  
	}	
	
	public static String getPriceOfItemSelected(int number) {
		return "//ul[@class='product_list grid row']/li["+ number  +"]//div[@class='quick-view-wrapper-mobile']/../a[2]/../div[2]/span";
	}
	
	public static String currentTotal() {
		return "layer_cart_product_price";
	}
	
	public static String totalPriceToPayText() {
		return "//span[@id='total_price']";
	}
	
	public static String blouseSearchedText() {
		return "//span[contains(text(),'Blouses ')]";
	}
	
	public static String casualDressesSearchedText() {
		return "//div[@class='cat_desc']//span[contains(text(),'Casual Dresses')]";
	}
	
	public static String tshirtsSearchedText() {
		return "//div[@class='cat_desc']//span[contains(text(),'T-shirts')]";
	}

	/***
	 * * Validates if the searched item is found
	 * 
	 * @return true or false
	 */
	public static boolean validateSearchResults() {
		boolean isItemFound;
		try {
			functions.driver.findElements(By.xpath(resultsShowingText())).isEmpty();
			functions.driver.findElements(By.xpath(searchedItemsList())).isEmpty();
			functions.driver.findElement(By.cssSelector(searchedItemsFound())).isDisplayed();
			isItemFound = true;

		} catch (Exception ex) {
			System.out.println(
					"No items where found, please retry  contact us via email shoppingus@gmail.com or cell number on local XXXXXXXXXXX");
			isItemFound = false;
		}
		return isItemFound;
	}

	/** 
	 * Returns the the text of the item found
	 * @throws InterruptedException 
	 **/
	public static String searchItemsFoundText() throws InterruptedException {
		Thread.sleep(2000);
		String textFound = functions.driver.findElement(By.cssSelector(searchedItemsFound())).getText();
		return textFound.trim();
	}
	
	/** 
	 * Returns the number of items found displayed in text through the search
	 **/
	public static int numberOfSearchItemsFound() {
		return functions.driver.findElements(By.xpath(searchedItemsList())).size();		
	}	
	
	/** 
	 * Move to add to cart button and click it. Required parameter which is the number of search items. 1 represents the first found item and the 4 would be the last if only 4 items found
	 * @param number 
	 * @throws InterruptedException 
	 * **/
	public static void addToCartButtonClicked(int number) throws InterruptedException {		
		Thread.sleep(2000);
		Actions actionClick = new Actions(functions.driver);
		actionClick.moveToElement(functions.driver.findElement(By.xpath(searchedAllOptionsOfSearchedItemFoundElement(number))));
		actionClick.moveToElement(functions.driver.findElement(By.xpath(searchedAddToCartButton(number))));
		actionClick.click().build().perform();
	}
	
	
	/** 
	 * Validates that the check mark shows for a successful product being added to the cart
	 * @throws InterruptedException 
	 * **/
	public static boolean itemsSuccesfullyAddedToTheCartCheckMark() throws InterruptedException {	    
               Thread.sleep(8000);
		return functions.driver.findElement(By.className(addedToCardSuccessfullyCheckMark())).isDisplayed();		
	}
	
	/**
	 * Returns the current value of the item selected
	 * @param 
	 * */
	
	public static double getTheCurrentVaueOfTheItemSelected(int numberOfItemSelected) {
		Actions actionClick = new Actions(functions.driver);
		actionClick.moveToElement(functions.driver.findElement(By.xpath(searchedAllOptionsOfSearchedItemFoundElement(numberOfItemSelected)))).build().perform();
		String getCurrentValueDisplayed =  functions.driver.findElement(By.xpath(getPriceOfItemSelected(numberOfItemSelected))).getText();
		 getCurrentValueDisplayed = getCurrentValueDisplayed.replace("$","");
		 return Double.parseDouble(getCurrentValueDisplayed);
	}
	
	/**
	 * Clicks the continue to shop link
	 * @throws InterruptedException 
	 ***/
	public static void continueToShopLinkClicked() throws InterruptedException {
		Thread.sleep(3000);
		functions.driver.findElement(By.xpath(addToCartContinueShoppingChevron())).click();	
		Actions action = new Actions(functions.driver);
		action.sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP)			
		.sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).build().perform();
		Thread.sleep(5000);
	}
	
	/**
	 * Proceed to checkout link is clicked
	 * @throws InterruptedException 
	 ***/
	public static void proceedToCheckoutLinkClicked() throws InterruptedException {
		functions.driver.findElement(By.xpath(addToCartProceedToCheckoutChevron())).click();	
		Thread.sleep(5000);		
	}
	
	/**
	 * Returns the money expected to pay order. Excluding shipping. Shipping is added at the end of the order
	 **/
	public static double currentTotalToPay(double price,int quantity) {
		return price * quantity;
	}
	
	/**
	 * Returns the total amount the customer is expected to pay
	 * @throws InterruptedException 
	 *****/
	
	public static String totalPriceToPay() throws InterruptedException {
		Actions action = new Actions(functions.driver);
		action.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).
		sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(3000);
		return functions.driver.findElement(By.xpath(totalPriceToPayText())).getText();
	}
	
	/**
	 * validates blouse search text found
	 **/
	
	public static boolean validateBlouseTextFound() {
		return functions.driver.findElement(By.xpath(blouseSearchedText())).isDisplayed();		
	}
	
	/**
	 * validates casual dresses search text found
	 **/
	
	public static boolean validateCasualDressTextFound() {
		return functions.driver.findElement(By.xpath(casualDressesSearchedText())).isDisplayed();		
	}
	
	
	/**
	 * validates tshirts search text found
	 **/
	
	public static boolean validateTShirtTextFound() {
		return functions.driver.findElement(By.xpath(tshirtsSearchedText())).isDisplayed();		
	}
	
}
