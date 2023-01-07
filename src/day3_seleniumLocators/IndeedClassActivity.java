package day3_seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IndeedClassActivity {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/primetech/Documents/Tools/chromedriver");

		/*
		 * Test case 2 
		 * go to indeed.com 
		 * get the current URL and store it in a variable called homeURL. 
		 * get the website title and store it in a variable homeTitle.
		 * find the input field for WHAT and type SDET 
		 * find the input field for where, clear the field first and type washington DC 
		 * find the Find Jobs button and click on it. 
		 * get the current URL and store it a variable searchURL. 
		 * get the website title and store it in a variable searchTitle. 
		 * verify that searchURL does not equal to homeURL and contains the search criteria. 
		 * verify that searchTitle does not equal to homeTitle and has the search criteria. 
		 * Get Text of the JobsInLocation field, store it in a variable, 
		 * then verify if it’s equals to your search criteria.
		 */

		String jobSearchTitle = "Software Test Engineer";
		String jobLocation = "Boston, MA";
		// go to indeed.com
		WebDriver driver = new ChromeDriver();
		driver.get("https://indeed.com");
		// get the current URL and store it in a variable called homeURL.
		String homeURL = driver.getCurrentUrl();
		// get the website title and store it in a variable homeTitle.
		String homeTitle = driver.getTitle();
		// find the input field for WHAT and type SDET
		driver.findElement(By.id("text-input-what")).sendKeys(jobSearchTitle);
		// find the input field for where, clear the field first and type washington DC
		WebElement whereField = driver.findElement(By.id("text-input-where"));
		//whereField.clear();  
		//clear() function doesn't clrear the text if the text is pre-populated by the website
//		whereField.sendKeys(Keys.COMMAND, "a");
//		whereField.sendKeys(Keys.DELETE);
		
		clearTheText(whereField);
		
		//type washington dc
		whereField.sendKeys(jobLocation);
		
		// find the Find Jobs button and click on it.
		driver.findElement(By.className("yosegi-InlineWhatWhere-primaryButton")).click();
		
		// get the current URL and store it a variable searchURL.
		String searchURL = driver.getCurrentUrl();
		String searchTitle = driver.getTitle();
		
		// verify that searchURL does not equal to homeURL 
		// and contains the search criteria.
		
		if ((!searchURL.equals(homeURL)) && (searchURL.contains(jobSearchTitle))) {
			System.out.println("URLs do not match, and it contains the message. Test Pass!");
		} else {
			System.out.println("URLs match, Test Fail!");
		}
		
		// verify that searchTitle does not equal to homeTitle and has the search criteria.
		if ((!searchTitle.equals(homeTitle)) && (searchTitle.contains(jobLocation))) {
			System.out.println("Titles do not match, and it contains the message. Test Pass!");
		} else {
			System.out.println("Titles match, Test Fail!");
		}
		
		// find it, Get Text of the JobsInLocation field, store it in a variable,
	    String jobFieldText = driver.findElement(By.className("jobsearch-SerpTitle")).getText();
		
	    //then verify if it’s equals to your search criteria.
	    
	    // this is one way of verifying the text
//	    if (jobFieldText.contains("SDET") && jobFieldText.contains("Washington, DC")) {
//			System.out.println("Test Pass!");
//		} else {
//			System.out.println("Test Fail!");
//		}
	    
	    // this is another way of verifying the text
	    
	    System.out.println(jobFieldText);
	    String jobTitle = jobFieldText.substring(0, jobSearchTitle.length());
	    String jobWhereLocation = jobFieldText.substring(jobFieldText.length() - jobLocation.length());
	    								//26 - 13
	    System.out.println(jobTitle + "   :  " + jobWhereLocation);
	    
	    if (jobTitle.equals(jobSearchTitle) && jobLocation.equals(jobWhereLocation)) {
			System.out.println("Test Pass!");
		}else {
			System.out.println("Test Fail, the search criteria doesn't match.");
		}
	}
	
	
	// create a method that accepts a webElement as parameter
	// get the value of the attribute 'value' of the webElement
	// based on the size of the text
	// loop and Keys.Back_Space
	

	public static void clearTheText(WebElement element) {
		String location = element.getAttribute("value");
		for (int i = 0; i < location.length(); i++) {
			element.sendKeys(Keys.BACK_SPACE);
		}
	}
	
	// create a method that accepts a webelement as a parameter
	// do command a and delete on that webElement
	
	public static void allClear(WebElement elem) {
		elem.sendKeys(Keys.COMMAND, "a");
		elem.sendKeys(Keys.BACK_SPACE);
	}
}
