package day3_seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EtsyClassActivity {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/primetech/Documents/Tools/chromedriver");
		
		/*
		 * Test case 1
		 * Go to etsy.com
		 * Find Sign in button and click on it
		 * Find email address field and type "automation"
         * Find the password field and type "automation"
         * Find the sign in button and click on it
		 */

		
		WebDriver driver = new ChromeDriver();
		// Go to etsy.com
		driver.get("https://www.etsy.com/");
		// Find Sign in button and click on it
		driver.findElement(By.className("select-signin")).click();
		Thread.sleep(500);
		// Find email address field and type "automation"
		driver.findElement(By.id("join_neu_email_field")).sendKeys("automation");
		// Find the password field and type "automation"
		driver.findElement(By.id("join_neu_password_field")).sendKeys("automation");
		// Find the sign in button and click on it
		driver.findElement(By.name("submit_attempt")).click();
	}

}
