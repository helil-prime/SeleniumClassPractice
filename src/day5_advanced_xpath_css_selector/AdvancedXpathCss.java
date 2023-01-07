package day5_advanced_xpath_css_selector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdvancedXpathCss {

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
		
		//Click on Sign in
		// find the sign in button with attribute contains method
		//driver.findElement(By.xpath("//button[contains(@class, 'select-signin')]")).click();
		
		// find the sign in button with text() method
//		driver.findElement(By.xpath("//button[text()='\n"
//				+ "        Sign in\n"
//				+ "    ']")).click();
		
		// find the sign in button with contains text method. 
		driver.findElement(By.xpath("//button[contains(text(), 'Sign in')]")).click();
		Thread.sleep(1000);
		//Click on Register.
		driver.findElement(By.xpath("//button[contains(text(), 'Register')]")).click();
		Thread.sleep(500);
		//Enter an email address, (jon.dow@gmail.com)
		driver.findElement(By.xpath("//input[contains(@inputmode, 'email')]")).sendKeys("jon.dow@gmail.com");
		//Enter first name. 
		driver.findElement(By.xpath("//input[contains(@aria-describedby, 'first_name')]")).sendKeys("automation");
		
		//Enter password. 
		driver.findElement(By.xpath("//input[contains(@aria-describedby, 'password')]")).sendKeys("automation");
		//Click on Register.
		driver.findElement(By.xpath("//button[contains(@value, 'register')]")).click();
		// Verify you get the error message: 
		// “Sorry, the email you have entered is already in use.”
		String expectedErrorMessage = "Sorry, the email you have entered is already in use.";
		Thread.sleep(500);
		String actualErrorMessage = driver.findElement(
				By.xpath("//div[text()='Sorry, the email you have entered is already in use.']"))
		.getText();
		if (actualErrorMessage.equals(expectedErrorMessage)) {
			System.out.println("Test Pass!");
		} else {
			System.out.println("Test Fail!");
		}
	}

}
