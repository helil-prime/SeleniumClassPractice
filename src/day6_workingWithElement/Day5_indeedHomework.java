package day6_workingWithElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day5_indeedHomework {
	
	// class level or global variables can be accessed by the methods in the class
	//WebDriver driver = new ChromeDriver();

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/primetech/Documents/Tools/chromedriver");
		// we create an object of a class to access it's properties (methods, variables..)
		Day5_indeedHomework day5 = new Day5_indeedHomework();
		day5.testCase1();
		day5.testCase2();
		day5.testCase3();		
		
	}
	
	public void testCase3() {
		/*
		 * Go to indeed.com
 	     * Find the Where field and get tag name, 
         * Then verify the tag name is equal to “input”.
		 */
		WebDriver driver = new ChromeDriver();
		//Go to indeed.com
		driver.get("https://indeed.com");
		//Find the Where field and get tag name,
		String actualTagName = driver.findElement(
				By.cssSelector("input[name=l]")).getTagName();
		//Then verify the tag name is equal to “input”.
		String expectedTagName = "input";
		if (actualTagName.equals(expectedTagName)) {
			System.out.println("Test Pass!");
		} else {
			System.out.println("Test Fail!");
		}
		driver.close();
	}
	
	public void testCase2() {
		/*
		 * Go to indeed.com
         * Find the Where field and get css value of color, 
         * then verify the color property is  “rgba(45, 45, 45, 1)”.
		 */
		WebDriver driver = new ChromeDriver();
		//Go to indeed.com
		driver.get("https://indeed.com");
		//Find the Where field and get css value of color,
		String actualColorPropertyValue = 
				driver.findElement(
						By.cssSelector("input[name=l]")).getCssValue("color");
		System.out.println("Color property value is: " + actualColorPropertyValue);
		//then verify the color property is  “rgba(45, 45, 45, 1)”.
		String expectedColorValue = "rgba(45, 45, 45, 1)";
		if (actualColorPropertyValue.equals(expectedColorValue)) {
			System.out.println("Test Pass!");
		} else {
			System.out.println("Test Fail!");
		}
		driver.close();
	}
	
	public void testCase1() {
		/*
		 * Go to indeed.com
         * Find the Where field and get the value of attribute ‘value’, 
         * then verify it’s based on your current location.
		 */
		
		//Go to indeed.com
		WebDriver driver = new ChromeDriver();
		driver.get("https://indeed.com");
		//Find the Where field and get the value of attribute ‘value’,
		String actualLocationAttributeValue = 
				driver.findElement(By.cssSelector("input[name=l]")).getAttribute("value");
		System.out.println("actual location: " + actualLocationAttributeValue);
		// then verify it’s based on your current location.
		String expectedLocation = "Fairfax, VA";
		
		if (actualLocationAttributeValue.equals(expectedLocation)) {
			System.out.println("Test Pass!");
		} else {
			System.out.println("Test Fails!");
		}
		driver.close();
	}

}
