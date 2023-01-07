package day9_select_wait_alert;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Day8_homework {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/primetech/Documents/Tools/chromedriver");
		
		Day8_homework day8 = new Day8_homework();
		//day8.amazonSelectTest();
		day8.amazonTest2();
	}
	
	public void amazonSelectTest() {
		/*
		 * Test case 1
    	   go to amazon.com 
           get all the options in the departments select dropdown
    	   verify there are total 59 departments. And print them out.
		 */
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://amazon.com");
		
		//get all the options in the departments select dropdown
		WebElement selectDropdown = driver.findElement(By.id("searchDropdownBox"));
		
		Select letsSelect = new Select(selectDropdown);
		List<WebElement> allOptions = letsSelect.getOptions();
		System.out.println(allOptions.size());
		
		//verify there are total 59 departments. And print them out.
		if (allOptions.size() == 59) {
			System.out.println("Number of departments match.");
		}else {
			System.out.println("Number of departments DOES NOT match.");
		}
		
		for (int i = 0; i < allOptions.size(); i++) {
			System.out.println(allOptions.get(i).getText()); 
		}
		
		driver.close();
	
	}
	
	
	public void amazonTest2() {
		
		/*
		 * Test case 2
		 * go to amazon.com
           verify that you are on the amazon home page. (verify with title). 
           verify dropdown value is by default “All Departments”
           select department Home & Kitchen, and search coffee mug.
           verify you are on coffee mug search results page (use title).
           verify you are in Home & Kitchen department.
		 */
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://amazon.com");
		
		//verify that you are on the amazon home page. (verify with title).
		String expectedTitle = "Amazon.com. Spend less. Smile more.";
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Title match.");
		}else {
			System.out.println("Title does not match.");
		}

		//verify dropdown value is by default “All Departments”
		Select letsSelect = new Select(driver.findElement(By.id("searchDropdownBox")));
		WebElement firstOption = letsSelect.getFirstSelectedOption();
		if (firstOption.getText().equals("All Departments")) {
			System.out.println("Default option matches.");
		}else {
			System.out.println("Default option does not match.");
		}
		
		//select department Home & Kitchen, and search coffee mug.
		letsSelect.selectByVisibleText("Home & Kitchen");
		
		driver.findElement(
				By.id("twotabsearchtextbox")).sendKeys("coffee mug", Keys.ENTER);
		
		//verify you are on coffee mug search results page (use title).
		if(driver.getTitle().contains("coffee mug")) {
			System.out.println("Title contains search query.");
		}else {
			System.out.println("Title does NOT contain search query.");
		}
		
		//verify you are in Home & Kitchen department.
		
		WebElement selectBox = driver.findElement(By.id("searchDropdownBox"));
		Select select2 = new Select(selectBox);
		String finalDepartment = select2.getFirstSelectedOption().getText();
		
		System.out.println(finalDepartment);
		if (finalDepartment.equals("Home & Kitchen")) {
			System.out.println("Department is Home & Kitcken");
		}else {
			System.out.println("Department is NOT Home & Kitcken");
		}
		
		driver.close();
	}

}
