package shopPackage.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class searchForAnItem extends pageObjects.functions {

	@Test
	public void searchJust1Item() throws InterruptedException {
		
		ChromeDriver driver = setup() ;
	   
		driver.get(URL());
		driver.wait(3000);
		boolean navigatedSuccessfully = driver.findElement(By.cssSelector(pageObjects.pageObjects.shopHeadingText())).isDisplayed();
		assertEquals(navigatedSuccessfully, true);
		driver.findElement(By.className(pageObjects.pageObjects.searchBoxInput())).sendKeys("Blouse");
    	driver.findElement(By.xpath(pageObjects.pageObjects.searchBoxButton())).click();	
		driver.wait(5000);
	    boolean isItemFound = driver.findElement(By.xpath(pageObjects.pageObjects.searchedItemFound())).isDisplayed();
		driver.wait(6000);
		assertEquals(isItemFound, true);
	}
}
