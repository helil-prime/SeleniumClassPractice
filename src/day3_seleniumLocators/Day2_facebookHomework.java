package day3_seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2_facebookHomework {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/primetech/Documents/Tools/chromedriver");
		
		
		/*
		 * Test case 1
         * go to facebook.com
         * find the Email or phone number field and type Automation
         * find the Password field and type Automation
         * find the Login button and click on it.
		 */
		
		// go to facebook.com
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com");
		
		// find the email field and type automation
		driver.findElement(By.id("email")).sendKeys("automation");
		// find the password field and type automation
		driver.findElement(By.id("pass")).sendKeys("automation");
		// find the log in button and click on it
		driver.findElement(By.name("login")).click();
		
		
		
		/*
		 * Test case 2 
         * go to facebook.com
         * find the Create New Account button and click on it
         * find the FirstName,  LastName, Email and Password fields and type Automation
         * find the Sign Up button and click on it.
		 */
		
		// go to facebook.com
		driver.get("https://facebook.com");
		// find the Create New Account button and click on it
		driver.findElement(By.linkText("Create new account")).click();
		Thread.sleep(1000);
		// find the firstName field and type automation
		driver.findElement(By.name("firstname")).sendKeys("automation");
		// find the lastName field and type automation
		driver.findElement(By.name("lastname")).sendKeys("automation");
		// find the email field and type automation
		driver.findElement(By.name("reg_email__")).sendKeys("automation");
		// find the password field and type automation
		driver.findElement(By.id("password_step_input")).sendKeys("automation");
		// find the sign up button and click on it
		driver.findElement(By.name("websubmit")).click();
		
	}

}
