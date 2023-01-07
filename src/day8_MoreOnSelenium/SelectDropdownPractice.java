package day8_MoreOnSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdownPractice {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/primetech/Documents/Tools/chromedriver");
		SelectDropdownPractice test = new SelectDropdownPractice();
		test.selectTest();
	}

	public void selectTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://amazon.com");
		// find the dropdown element
		WebElement AllDropdown = driver.findElement(By.id("searchDropdownBox"));
		
		// use Select class to choose an option from it
		Select letsSelect = new Select(AllDropdown);
		
		System.out.println(letsSelect.getFirstSelectedOption().getText());
		// select by index
		// letsSelect.selectByIndex(4);
		
		// select by value
		//letsSelect.selectByValue("search-alias=mobile-apps");
		
		//select by visible text
		letsSelect.selectByVisibleText("Luxury Stores");
	    System.out.println(letsSelect.getFirstSelectedOption().getText());
	
	}
}
