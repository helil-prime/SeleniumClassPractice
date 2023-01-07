package day8_MoreOnSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonElementStatusCheckHomework {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/primetech/Documents/Tools/chromedriver");
		AmazonElementStatusCheckHomework test = new AmazonElementStatusCheckHomework();
		test.AmazonTest();
	}
	
	public void AmazonTest() {
		
		/*
		 * go to amazon.com click on signin 
         * verify that you are on sign in page (either by sign-in text or email field).
         * navigate back, and navigate forward
         * verify that you are on sign in page (either by sign-in text or email field).
         * click on create new account, verify you are on new account create page.
         * navigate back, verify you are on the sign-in page.
         * navigate forward, verify you are on the create account page.
         * click on the Continue button without filling the form
         * verify error messages displayed and get text to verify:
         * Enter your name
         * Enter your email or mobile phone number
         * Minimum 6 characters required

		 */
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// go to amazon.com click on signin
		driver.get("https://amazon.com");
		driver.findElement(By.linkText("Sign in")).click();
		//verify that you are on sign in page (either by sign-in text or email field).
		WebElement signInElement = driver.findElement(
				By.xpath("//h1[contains(text(), 'Sign in')]"));
		
		boolean signInText = signInElement.isDisplayed();
		if (signInText) {
			System.out.println("We are on Sign in page.");
		}else {
			System.out.println("We are NOT on Sign in page.");
		}
		
		//navigate back, and navigate forward
		driver.navigate().back();
		driver.navigate().forward();
		//verify that you are on sign in page (either by sign-in text or email field).
		boolean signInText2 = driver.findElement(
				By.xpath("//h1[contains(text(), 'Sign in')]")).isDisplayed();
		if (signInText2) {
			System.out.println("We are on Sign in page second time.");
		}else {
			System.out.println("We are NOT on Sign in page second time.");
		}
		
		//click on create new account, verify you are on new account create page.
		driver.findElement(By.id("createAccountSubmit")).click();
		WebElement createAccount = 
				driver.findElement(By.xpath("//h1[contains(text(), 'Create account')]"));
		if (createAccount.isDisplayed()) {
			System.out.println("We are on Create Account Page.");
		}else {
			System.out.println("We are NOT on Create Account Page.");
		}
	    //navigate back, verify you are on the sign-in page.
		driver.navigate().back();
		boolean signInText3 = driver.findElement(
				By.xpath("//h1[contains(text(), 'Sign in')]")).isDisplayed();
		if (signInText3) {
			System.out.println("We are on Sign in page second time.");
		}else {
			System.out.println("We are NOT on Sign in page second time.");
		}
		//navigate forward, verify you are on the create account page.
		driver.navigate().forward();
		WebElement createAccount2 = 
				driver.findElement(By.xpath("//h1[contains(text(), 'Create account')]"));
		if (createAccount2.isDisplayed()) {
			System.out.println("We are on Create Account Page.");
		}else {
			System.out.println("We are NOT on Create Account Page.");
		}
		//click on the Continue button without filling the form
		driver.findElement(By.id("continue")).click();
		
		// verify error messages displayed and get text to verify:
	         // Enter your name
	         // Enter your email or mobile phone number
	        // Minimum 6 characters required
		
		WebElement nameErrorMessage = 
				driver.findElement(By.xpath("//div[contains(text(), 'Enter your name')]"));
		if (nameErrorMessage.isDisplayed() && nameErrorMessage.getText().equals("Enter your name")) {
			System.out.println("The Name Error Message Displayed and Correct.");
		} else {
			System.out.println("Something is wrong with name error message.");
		}
		
		WebElement emailErrorMessage = 
				driver.findElement(By.xpath("//div[contains(text(), 'Enter your email')]"));
		if (emailErrorMessage.isDisplayed()) {
			String emailErrorText = emailErrorMessage.getText();
			if (emailErrorText.equals("Enter your email or mobile phone number")) {
				System.out.println("Email Error Message Match.");
			}else {
				System.out.println("Email Error Message Does Not Match.");
			}
		} else {
			System.out.println("Email error message is not displayed.");
		}
		
		WebElement passwordErrorMessage = 
				driver.findElement(By.xpath("//div[@id='auth-password-missing-alert']/div/div"));
	
		if (passwordErrorMessage.isDisplayed()) {
			String passwordErrorText = passwordErrorMessage.getText();
			if (passwordErrorText.equals("Minimum 6 characters required")) {
				System.out.println("Password Error Message Match.");
			}else {
				System.out.println("Password Error Message Does Not Match.");
			}
		} else {
			System.out.println("Password error message is not displayed.");
		}
		
		driver.close();
	}

}
