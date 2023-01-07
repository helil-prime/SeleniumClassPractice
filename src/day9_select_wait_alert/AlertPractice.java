package day9_select_wait_alert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertPractice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/primetech/Documents/Tools/chromedriver");
		AlertPractice practice = new AlertPractice();
		
		//practice.testcase1();
		//practice.testcase2();
		//practice.testcase3();
		practice.testcase4();
	}
	
	public void testcase4() {
		/*
		 * Test case 4
           go to http://practice.primetech-apps.com:4567/alerts.html
           Click on the Show Prompt Box button, enter a text and accept.
           Validate the text input displays on the screen.
		 */
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://practice.primetech-apps.com:4567/alerts.html");
		
		driver.findElement(By.id("promptexample")).click();
		
		WebDriverWait letsWait = new WebDriverWait(driver, 5);
		letsWait.until(ExpectedConditions.alertIsPresent());
		
		Alert handle = driver.switchTo().alert();
		
		handle.sendKeys("Coffee mug.");
		handle.accept();
		
		String text = driver.findElement(By.id("promptreturn")).getText();
		
		if (text.equals("Coffee mug.")) {
			System.out.println("Test Pass.");
		}else {
			System.out.println("Test Fail.");
		}
		driver.close();
	}
	
	public void testcase3() {
		/*
		 *  Test case 3
          go to http://practice.primetech-apps.com:4567/alerts.html
          Find the text cret and save in a variable.
          Click on the Show Confirm Box button and Dismiss the alert.
          Validate the text cret has changed to False.
		 */
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://practice.primetech-apps.com:4567/alerts.html");
		
		String initialText = driver.findElement(By.id("confirmreturn")).getText();
		driver.findElement(By.id("confirmexample")).click();
		
		WebDriverWait letsWait = new WebDriverWait(driver, 5);
		letsWait.until(ExpectedConditions.alertIsPresent());
		
		Alert handle = driver.switchTo().alert();
		handle.dismiss();
		
		String finalText = driver.findElement(By.id("confirmreturn")).getText();
		if (!finalText.equals(initialText) && finalText.equals("false")) {
			System.out.println("Test Pass:  " + finalText);
		}
	}
	
	public void testcase2() {
		/*
		 * Test case 2 
           go to http://practice.primetech-apps.com:4567/alerts.html 
           Find the text cret and save in a variable. 
           Click on the Show Confirm Box button and Accept the alert.  
           Then Validate the text cret has changed to True.
		 */
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://practice.primetech-apps.com:4567/alerts.html");
		
		String initialText = driver.findElement(By.id("confirmreturn")).getText();
		driver.findElement(By.id("confirmexample")).click();
		
		WebDriverWait letsWait = new WebDriverWait(driver, 5);
		letsWait.until(ExpectedConditions.alertIsPresent());
		
		Alert handle = driver.switchTo().alert();
		handle.accept();
		
		String finalText = driver.findElement(By.id("confirmreturn")).getText();
		if (!finalText.equals(initialText) && finalText.equals("true")) {
			System.out.println("Test Pass:  " + finalText);
		}
	}
	
	public void testcase1() throws InterruptedException {
		/*
		 * Test case 1
		go to http://practice.primetech-apps.com:4567/alerts.html
		Click on the Show Alert Box button and Accept the alert. 
		 */
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://practice.primetech-apps.com:4567/alerts.html");
		
		driver.findElement(By.id("alertexamples")).click();
		Thread.sleep(2000);
		
		Alert handle = driver.switchTo().alert();
		System.out.println(handle.getText()); 
		handle.accept();
		
	}

}
