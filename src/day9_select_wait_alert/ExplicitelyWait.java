package day9_select_wait_alert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitelyWait {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/primetech/Documents/Tools/chromedriver");
		ExplicitelyWait wait = new ExplicitelyWait();
		wait.waitTest();
	}

	
	public void waitTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://etsy.com");
		
		// click on sign in button 
		driver.findElement(By.cssSelector(".select-signin")).click();
		// wait until the email field is visible
		driver.findElement(By.id("join_neu_email_field")).sendKeys("jon.dow@gmail.com");
		driver.findElement(By.name("submit_attempt")).click();
		
		//at this stage, there is no visible text.
		
		
		WebDriverWait letswait = new WebDriverWait(driver, 5);
		letswait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("aria-join_neu_password_field-error")));
		
		WebElement errorText = 
				driver.findElement(By.id("aria-join_neu_password_field-error"));
		
		String errorTextString = errorText.getText();
		System.out.println(errorTextString);
		
	}
}
