package day2_seleniumBasicFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasicFunctionsAndLocators {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/primetech/Documents/Tools/chromedriver");

		//Element locator by name
		
		// navigate to https://www.saucedemo.com
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		// find the username by name locator and store it in a webElement.
		WebElement usernameField = driver.findElement(By.name("user-name"));
		// type standard_user into username field.
		usernameField.sendKeys("standard_user");
		// find the password by name locator and store it in a webElment.
		WebElement passwordField = driver.findElement(By.name("password"));
		// type secret_sauce into password field.
		passwordField.sendKeys("secret_sauce");
		// find the login button and click on it.
		driver.findElement(By.name("login-button")).click();
		
		// Element locator with linkText
		
		//navigate to amazon.com
		driver.get("https://www.amazon.com");
		// find the Amazon Basics link using linkText locator and click on it.
		driver.findElement(By.linkText("Amazon Basics")).click();
		
		Thread.sleep(2000);
		
		// find the Shop epic link by partial linkText and click on it.
		driver.findElement(By.partialLinkText("Amazon Rewards Visa")).click();
		
		// Find element by className
		
		driver.navigate().back();
		
		Thread.sleep(1000);
		driver.findElement(By.className("nav-input"))
		.sendKeys("Ugly coffee mug");
		
	}

}
