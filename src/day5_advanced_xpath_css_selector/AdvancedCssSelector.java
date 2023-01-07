package day5_advanced_xpath_css_selector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdvancedCssSelector {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/primetech/Documents/Tools/chromedriver");
		
		/*
		 * Test case: 
		 * Go to etsy.com 
		 * Click on Sign in. 
		 * Click on Register. 
		 * Enter an email address, (jon.dow@gmail.com) 
		 * Enter first name. 
		 * Enter password. 
		 * Click on Register. 
		 * Verify you get the error message: 
		 * “Sorry, the email you have entered is already in use.”
		 */
		
		// Go to etsy.com
		WebDriver driver = new ChromeDriver();
		driver.get("https://etsy.com");
		
		//Click on Sign in.
		driver.findElement(By.cssSelector(".select-signin")).click();
		Thread.sleep(1000);
		//Click on Register.
		driver.findElement(
				By.cssSelector(".wt-btn.wt-btn--secondary.wt-btn--small"))
		.click();
		Thread.sleep(500);
		//Enter an email address, (jon.dow@gmail.com)
		driver.findElement(By.cssSelector("#join_neu_email_field"))
		.sendKeys("jon.dow@gmail.com");
		//Enter first name. 
		driver.findElement(By.cssSelector("input[name=first_name]"))
		.sendKeys("automation");
		//Enter password. 
		driver.findElement(By.cssSelector("input[name=password]"))
		.sendKeys("automation");
		//Click on Register.
		driver.findElement(By.cssSelector(".wt-btn.wt-btn--primary.wt-width-full"))
		.click();
		Thread.sleep(500);
		
		String expectedErrorMessage = "Sorry, the email you have entered is already in use.";
		//Verify you get the error message: 
		//“Sorry, the email you have entered is already in use.”
		String actualMessage = driver.findElement(
				By.cssSelector("#aria-join_neu_email_field-error"))
		.getText();
		
		if (actualMessage.equals(expectedErrorMessage)) {
			System.out.println("Test Pass!");
		} else {
			System.out.println("Test Fail!");
		}
		

	}

}
