package day4_xpath_css_selector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathPractice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/primetech/Documents/Tools/chromedriver");

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

		//Go to etsy.com 
		WebDriver driver = new ChromeDriver();
		driver.get("https://etsy.com");

		//Click on Sign in.
		WebElement signInBtn = driver.findElement(By.xpath(
				"//button[@class='wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin']"));
		signInBtn.click();
		
		Thread.sleep(1000);
		//Click on Register.
		WebElement registerBtn = driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--secondary wt-btn--small inline-overlay-trigger register-header-action select-register']"));
		registerBtn.click();
		Thread.sleep(500);
		//Enter an email address, (jon.dow@gmail.com)
		driver.findElement(
				By.xpath("//input[@id='join_neu_email_field']")).sendKeys("jon.dow@gmail.com");
		//Enter first name.
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("jon");
		//Enter password.
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("helloEtsy");
		//Click on Register.
		driver.findElement(By.xpath("//button[@value='register']")).click();
		//Verify you get the error message: “Sorry, the email you have entered is already in use.”
	    Thread.sleep(1000);
		String errorMessage = driver.findElement(
	    		By.xpath("//div[@id='aria-join_neu_email_field-error']")).getText();
	    String expectedErrorMessage = "Sorry, the email you have entered is already in use.";
	    if (errorMessage.equals(expectedErrorMessage)) {
			System.out.println("Test Pass!");
		}else {
			System.out.println("Test Fail!");
		}
	    
	    driver.quit();
	}

}
