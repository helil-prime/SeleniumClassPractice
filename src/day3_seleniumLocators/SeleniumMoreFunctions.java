package day3_seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMoreFunctions {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/primetech/Documents/Tools/chromedriver");
		
		
		WebDriver driver = new ChromeDriver();
		
		// go to facebook.com
		driver.get("https://facebook.com");
		// get title and verify it matches 'Facebook - log in or sign up'
		Thread.sleep(1000);
		String title = driver.getTitle();
		if (title.equals("Facebook - log in or sign up")) {
			System.out.println("Title Matches!");
		} else {
			System.out.println("Title Does Not Match!");
		}
		// get currentUrl
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current Url is: " + currentUrl);
		Thread.sleep(1000);
		// find the forget password element and get text
		WebElement forgotPassword = driver.findElement(By.linkText("Forgot password?"));
		String textOfForgotPassword = forgotPassword.getText();
		System.out.println("Forgot Password Element text is: " + textOfForgotPassword);
		// verify the text matches to 'Forgot password?'
		if (textOfForgotPassword.equals("Forgot password?")) {
			System.out.println("Forgot password text matches!");
		} else {
			System.out.println("Forgot password text doesn't match.");
		}
		Thread.sleep(1000);
		// close the browser
		// close() closes the current browser only
		//driver.close();
		
		driver.quit();
		// quit() - quits the driver sessions, which closes all browsers if open.
	}

}
