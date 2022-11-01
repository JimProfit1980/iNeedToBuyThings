package pageObjects;

import org.openqa.selenium.By;

public class loginPage extends functions {

	public static String alreadyRegisteredHeadingText() {
		return "//h3[@class='page-subheading' and contains(text(),'Already registered?')]";
	}

	public static String emailAddressInput() {
		return "//input[@id='email']";
	}

	public static String passwordInput() {
		return "//div[@class='form-group']//span//input";
	}

	public static String forgotPasswordLink() {
		return "//a[text()='Forgot your password?']";
	}

	public static String signInButton() {
		return "SubmitLogin";
	}

	public static boolean loginPageValidated() {
		boolean isFound = false;
		try {
			functions.driver.findElement(By.xpath(alreadyRegisteredHeadingText())).isDisplayed();
			functions.driver.findElement(By.xpath(emailAddressInput())).isDisplayed();
			functions.driver.findElement(By.xpath(passwordInput())).isDisplayed();
			functions.driver.findElement(By.xpath(forgotPasswordLink())).isDisplayed();
			functions.driver.findElement(By.id(signInButton())).isDisplayed();
			isFound = true;
		} catch (Exception ex) {
			System.out.println("Cannot validate the Login Page!");
			isFound = false;
		}
		return isFound;
	}

	/*****
	 * Username entered. 
	 * @param userName
	 **/
	public static void emailEntered(String userName) {
		functions.driver.findElement(By.xpath(emailAddressInput())).sendKeys(userName);
		
	}

	/*****
	 * Password entered.
	 * 
	 * @param password
	 **/
	public static void passwordEntered(String password) {
		functions.driver.findElement(By.xpath(passwordInput())).sendKeys(password);
	}

	/*****
	 * Sign button clicked
	 */
	public static void signInButtonClicked() {
		functions.driver.findElement(By.id(signInButton())).click();
	}

	/**
	 * Login process completed, username and password entered. And Sign In clicks in
	 * @param userName
	 * @param password 
	 **/
	public static void loginProcess(String userName,String password) {
		try {
		emailEntered(userName);
		passwordEntered(password);
		signInButtonClicked();		
		}
		catch(Exception ex) {
			System.out.println("Failed login process");
		}
		
	}
}
