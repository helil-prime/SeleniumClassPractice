package day11_frameworkSetup;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Day10_homework {
	
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/primetech/Documents/Tools/chromedriver");
		
		Day10_homework test = new Day10_homework();
		//test.switchWindowTest();
		test.iframeTest();
	}
	
	
	public void switchWindowTest() throws InterruptedException {
		/*
		 * Test case 1
         go to http://demo.guru99.com/popup.php
         Get the title and store it in a variable.
     	 Click on Click Here button and switch over to next window, provide an email click Submit. 
     	 Get text of the user ID and password and store them in variables, print them out. 
         Then verify the text “This access is valid only for 20 days.”
     	 Close the window.
     	 Go back to the main window, and get the title then verify it equals to your stored title.
      	 Quit driver. 

		 */
		
		//go to http://demo.guru99.com/popup.php
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	    driver.get("http://demo.guru99.com/popup.php");
		
	    //Get the title and store it in a variable.
	    
	    String mainPageTitle = driver.getTitle();
		System.out.println("Main title is:  " + mainPageTitle);
		Thread.sleep(1000);
		//Click on Click Here button
		driver.findElement(By.linkText("Click Here")).click();
		Thread.sleep(1000);
		// switch over to next window,
		// get the window ids and store them into a set
		Set<String> windowIds = driver.getWindowHandles();
		// declate iterator on the set of window ids
		Iterator<String> iterate = windowIds.iterator();
		// Set of window ids: 
		//  1. windowid 1
		//  2. windowid 2
		
		
		String FirstWindowId = iterate.next();  // iterate into first item and get it into a string
		String secondWindowId = iterate.next(); // iterate into second item and get it into a string
		
		// switch to second window
		driver.switchTo().window(secondWindowId);
		Thread.sleep(1000);
		//provide an email click Submit.
		driver.findElement(By.name("emailid")).sendKeys("jon.dow@gmail.com");
		driver.findElement(By.name("btnLogin")).click();
		
		Thread.sleep(1000);
		// Get text of the user ID and password and store them in variables, print them out.
		
		String userId = driver.findElement(
						By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		
		System.out.println("UserID is: " + userId);
		
		String password = driver.findElement(
				By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
		
		System.out.println("Password is: " + password);
		
		//Then verify the text “This access is valid only for 20 days.”
		String accessText = driver.findElement(
				By.xpath("//h3[contains(text(), 'This access is valid')]")).getText();
		if (accessText.equals("This access is valid only for 20 days.")) {
			System.out.println("Test pass.");
		}else {
			System.out.println("Test fail.");
		}
		
		// Close the window.
		driver.close();
		Thread.sleep(1000);
     	// Go back to the main window, 
		driver.switchTo().window(FirstWindowId);
		// get the title then verify it equals to your stored title.
		if (driver.getTitle().equals(mainPageTitle)) {
			System.out.println("We are on the main window.");
		}else {
			System.out.println("we are not on the main window.");
		}
		Thread.sleep(1000);
      	// Quit driver.
		driver.quit();
		
	}
	
	
	public void iframeTest() {
		/*
		 * Test case 2: 
			go to http://practice.primetech-apps.com:4567/styled/index.html
			Find iFrames Test Page and click on it.
			Find the iFrame Example List text and print it out.
			Find the iFrame List Item 0 and print it out.
			Find the iFrame List Item 1, print it out.
			Find the iFrame List Item 2, print it out.
			Go back to the main frame, find the main frame header and print. 
			Find ‘Nested Page Example’ text and  print it 
			Go back to the main frame, find the main frame header and print.

		 */
		
		//go to http://practice.primetech-apps.com:4567/styled/index.html
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://practice.primetech-apps.com:4567/styled/index.html");
		
		//Find iFrames Test Page and click on it.
		driver.findElement(By.id("iframestest")).click();
		//Find the iFrame Example List text and print it out.
		String exampleListText = driver.findElement(By.xpath("//h2[text()='iFrame Example List']")).getText();
	    System.out.println(exampleListText);
	    
	    
	    WebElement iframe1 = driver.findElement(By.id("thedynamichtml"));
	    driver.switchTo().frame(iframe1);
	    //Find the iFrame List Item 0 and print it out.
	    System.out.println(driver.findElement(By.id("iframe0")).getText());
	    
	    // Find the iFrame List Item 1, print it out.
	    System.out.println(driver.findElement(By.id("iframe1")).getText());
		// Find the iFrame List Item 2, print it out.
	    System.out.println(driver.findElement(By.id("iframe2")).getText());
	    
	    //Go back to the main frame, find the main frame header and print.
	    // driver.switchTo().parentFrame() // or
	    driver.switchTo().defaultContent();
	    
	    System.out.println(driver.findElement(By.xpath("//h1[text()='iFrames Example']")).getText());
	    
	    //Find ‘Nested Page Example’ text and  print it
	    
	    driver.switchTo().frame("theheaderhtml");
	    System.out.println(driver.findElement(By.xpath("//h1[text()='Nested Page Example']")).getText());
	    
	    //Go back to the main frame, find the main frame header and print.
	    driver.switchTo().parentFrame();
	    System.out.println(driver.findElement(By.xpath("//h1[text()='iFrames Example']")).getText());
	    
	    driver.quit();
	    
	}

}
