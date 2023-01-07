package day7_workingWithWebElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoItemsTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/primetech/Documents/Tools/chromedriver");
		SauceDemoItemsTest items = new SauceDemoItemsTest();
		items.printItemSize();
		

	}
	
	public void printItemSize() {
		/* 
		 * go to https://saucedemo.com
         * log in with username = standard_user   password = secret_sauce
         * find all the results and get them in a list, 
         * and print the size of the list.
         * print the price of each result. 
     Hint: loop through the list, get index and get text
		 */
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//log in with username = standard_user   password = secret_sauce
		driver.findElement(By.cssSelector("input[data-test=username]"))
		.sendKeys("standard_user");
		driver.findElement(By.cssSelector("input[data-test=password]"))
		.sendKeys("secret_sauce");
		driver.findElement(By.cssSelector("input[data-test=login-button]")).click();
		
		//find all the results and get them in a list, 
		List<WebElement> itemPrices = 
				driver.findElements(By.cssSelector(".inventory_item_price"));
		// and print the size of the list.
		
		System.out.println("Number of Items: " + itemPrices.size());
		
		//print the price of each result. 
		for (int i = 0; i < itemPrices.size(); i++) {
			System.out.println(itemPrices.get(i).getText());
		}
	}

}
