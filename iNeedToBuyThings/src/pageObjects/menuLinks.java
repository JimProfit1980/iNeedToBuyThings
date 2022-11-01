package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class menuLinks extends functions {
	
	public static String womenLink() {
		return "#block_top_menu > ul > li:nth-child(1) > a";
	}
	
	public static String dressesLink() {
		return "#block_top_menu > ul > li:nth-child(2) > a";
	}
	
	public static String tShirtsLink() {
		return "#block_top_menu > ul > li:nth-child(3) > a";
	}
	
	public static String blousesSubLink() {
		return "//a[text()='Blouses' and @href]";
	}
	
	public static String casualDressesSubLink() {
		return "#block_top_menu > ul > li:nth-child(2) > ul > li:nth-child(1) > a";
	}
	
	public static String eveningSubLink() {
		return "#block_top_menu > ul > li:nth-child(2) > ul > li:nth-child(2) > a";
	}
	
	public static String summerDressesSubLink() {
		return "#block_top_menu > ul > li:nth-child(2) > ul > li:nth-child(3) > a";
	}	
	
	public static String tShirtsSubLink() {
		return "//li//a[text()='T-shirts' and @href]";
	}
	
	/**
	 * Validates the menu tabs
	 **/
	
	public static boolean validateMenuLinks() {
		boolean found = false;
		try {
		functions.driver.findElement(By.cssSelector(womenLink())).isDisplayed();
		functions.driver.findElement(By.cssSelector(dressesLink())).isDisplayed();
		functions.driver.findElement(By.cssSelector(tShirtsLink())).isDisplayed();	
		found = true;
				}
		catch (Exception ex) {
			return found = false;
		}
		return found;
	}
	
	/**
	 * Hovers over the menu links and clicks the submenu, if exists 
	 * @param menuLink
	 * @param subMenuLink
	 **/
	
	public static void hoverOverMenuAndClickSubMenuLinks(WebElement menuLink,WebElement subMenuLink) {
		Actions action = new Actions(functions.driver);
		action.moveToElement(menuLink);
		action.moveToElement(subMenuLink).click().build().perform();
	}	
	
}
