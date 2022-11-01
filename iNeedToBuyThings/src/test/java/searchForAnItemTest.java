package test.java;

import pageObjects.functions;
import pageObjects.*;
import pageObjects.resources;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class searchForAnItemTest extends functions {

	WebDriver webDriver = null;

	public searchForAnItemTest() {

	}

	@Test
	public void TC1Test() throws InterruptedException {			
		webDriver = browserSetup();
		assertTrue(landingPage.validateLandingPage(),"Cannot validate the landingPage");			
		landingPage.searchForAnItem("Blouse");	  
		assertTrue(searchResults.validateSearchResults(),"Cannot validate the search results");		
		assertEquals(searchResults.searchItemsFoundText(),"1 result has been found.");	 
	} 

	@Test
	public void TC2Test() throws InterruptedException {	
		String searchItems = "Blouse,top,short";
		String[] searchItemsArray = searchItems.split(",");
		int[] numberOfItemsExpectedToBeFound = {1,1,4}; 
		String [] expectedItemsToBeFound = {"1 result has been found.","1 result has been found.","4 results have been found."};	
		
		webDriver = browserSetup();
		assertTrue(landingPage.validateLandingPage(),"Cannot validate the landingPage");
		
		for(int index = 0;index < searchItemsArray.length;index++)
		{
			landingPage.searchForAnItem(searchItemsArray[index]);		  
			assertEquals(searchResults.numberOfSearchItemsFound(),numberOfItemsExpectedToBeFound[index]);
			assertEquals(searchResults.searchItemsFoundText(),expectedItemsToBeFound[index]);
			landingPage.searchBoxInputCleared();						
		}
	}		

	

	@Test
	public void TC3Test() throws InterruptedException, IOException {
		String searchItems = "";
		int[] numberOfItemsExpectedToBeFound = { 1, 1, 4 };
		String[] expectedItemsToBeFound = { "1 result has been found.", "1 result has been found.",
				"4 results have been found." };
		List<String> searchItemsList = resources.getSearchedItemsFileList();
		String[] searchItemsArray = null;
		for (int count = 0; count < searchItemsList.size(); count++) {
			searchItems += searchItemsList.get(count);
		}
		searchItemsArray = searchItems.split(",");

		webDriver = browserSetup();
		assertTrue(landingPage.validateLandingPage(), "Cannot validate the landingPage");

		for (int index = 0; index < searchItemsArray.length; index++) {
			landingPage.searchForAnItem(searchItemsArray[index]);
			assertEquals(searchResults.numberOfSearchItemsFound(), numberOfItemsExpectedToBeFound[index]);
			assertEquals(searchResults.searchItemsFoundText(), expectedItemsToBeFound[index]);
			landingPage.searchBoxInputCleared();
		}
	}

	@Test
	public void TC4Test() throws InterruptedException {			
		
		webDriver = browserSetup();
		landingPage.validateLandingPage();
		landingPage.signInButtonClick();
		
		assertEquals(loginPage.loginPageValidated(),true,"Cannot validate the login page");			
		loginPage.loginProcess(getUsername(), getPassword());		
		assertEquals(homePage.homePageValidated(),true,"Unable to login!");
	}
	
	@Test
	public void TC5Test() throws InterruptedException  {			
		webDriver = browserSetup();
		assertTrue(landingPage.validateLandingPage(),"Cannot validate the landingPage");			
		landingPage.searchForAnItem("short");	
		String[] expectedItemsToBeFound = { "1 result has been found.", "1 result has been found.",
				"4 results have been found." };
		assertTrue(searchResults.validateSearchResults(),"Cannot validate the search results");		
		assertEquals(searchResults.searchItemsFoundText(),expectedItemsToBeFound[2]);		
		int itemsFoundWhichCanBeAddedtoCart = searchResults.numberOfSearchItemsFound();
		Random randomNumber = new Random();
		int selectedItemToBeClicked = randomNumber.nextInt(itemsFoundWhichCanBeAddedtoCart) + 1;
		int addItem = 0;
		double totalToPayWithoutShipping = 0,resultExpectedToPay = 0;
		String expectedToPay = "";
		
		do
		{
		addItem = addItem + 1;
		totalToPayWithoutShipping += searchResults.currentTotalToPay(searchResults.getTheCurrentVaueOfTheItemSelected(selectedItemToBeClicked), 1);
		searchResults.addToCartButtonClicked(selectedItemToBeClicked);		
		assertTrue(searchResults.itemsSuccesfullyAddedToTheCartCheckMark());	
		
		
		selectedItemToBeClicked = randomNumber.nextInt(itemsFoundWhichCanBeAddedtoCart) + 1;
		if(addItem != itemsFoundWhichCanBeAddedtoCart)
			searchResults.continueToShopLinkClicked();
		}while(addItem < itemsFoundWhichCanBeAddedtoCart);
		
		searchResults.proceedToCheckoutLinkClicked();
		resultExpectedToPay = (totalToPayWithoutShipping + 2);
		expectedToPay =  String.format("%.02f",resultExpectedToPay);
		assertEquals("$".concat(expectedToPay.replace(',','.')),searchResults.totalPriceToPay());		
	} 
	
	@Test
	public void TC6Test() {
		webDriver = browserSetup();
		assertTrue(landingPage.validateLandingPage(),"Cannot validate the landingPage");
		assertTrue(menuLinks.validateMenuLinks(),"Cannot validate the menuLinks");
		menuLinks.hoverOverMenuAndClickSubMenuLinks(functions.findWebElement("cssSelector",menuLinks.womenLink()),functions.findWebElement("xpath",menuLinks.blousesSubLink()));
		assertEquals(searchResults.validateBlouseTextFound(),true);
		menuLinks.hoverOverMenuAndClickSubMenuLinks(functions.findWebElement("cssSelector",menuLinks.dressesLink()),functions.findWebElement("cssSelector",menuLinks.casualDressesSubLink()));
		assertEquals(searchResults.validateCasualDressTextFound(),true);
		menuLinks.hoverOverMenuAndClickSubMenuLinks(functions.findWebElement("cssSelector",menuLinks.tShirtsLink()),functions.findWebElement("cssSelector",menuLinks.tShirtsLink()));	
		assertEquals(searchResults.validateTShirtTextFound(),true);
	}	
}
