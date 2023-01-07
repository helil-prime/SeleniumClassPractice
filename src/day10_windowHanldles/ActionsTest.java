package day10_windowHanldles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/primetech/Documents/Tools/chromedriver");
		
		ActionsTest test = new ActionsTest();
		test.actionTest();

	}

	public void actionTest() throws InterruptedException {
		
		/*
		 * Test case: 
		go to Etsy.com
		Hover Over on Jewelry & Accessories
		Mouseover on Bags & Purses
		Mouseover to Shoulder Bags
		Click on the shoulder bags
		Verify you are on the Shoulder bags page

		 */
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://etsy.com");
		//Hover Over on Jewelry & Accessories
		
		Actions action = new Actions(driver);
		WebElement jewelary = driver.findElement(By.xpath("//span[contains(text(), 'Jewelry & Accessories')]"));
		action.moveToElement(jewelary).build().perform();
		Thread.sleep(1000);
		WebElement bagsAndPurse =  driver.findElement(By.xpath("(//span[contains(text(), 'Bags & Purses')])[1]"));
		action.moveToElement(bagsAndPurse).build().perform();
		Thread.sleep(1000);
		
		
		
	}
}
