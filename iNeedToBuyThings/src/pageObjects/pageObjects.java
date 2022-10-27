package pageObjects;

public class pageObjects {

	public pageObjects() {
		// TODO Auto-generated constructor stub
	}	
	
	// --------------------------------------------Start Landing Page Objects ----------------------------------------//
	
	public static String shopHeadingText() {
		return "#header_logo > a > img";
	}
	
	public static String searchBoxInput() {
		return "#search_query_top";
	}
	
	public static String searchBoxButton() {
		return "//button[@name='submit_search']";
	}	
	
	public static String searchedItemFound() {
		return "//span[text()='Add to cart']";
	}
	
	public static String addToCart() {
		return "//span[text()='More']";
	}
	
	public static String SearchedItemFound() {
		return "//img[@src='http://automationpractice.com/img/p/7/7-home_default.jpg']";
	}
	
	// --------------------------------------------End Landing Page Objects ------------------------------------------//

}
