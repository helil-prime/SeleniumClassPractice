package day6_workingWithElement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeysPressPractice {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/primetech/Documents/Tools/chromedriver");
		KeysPressPractice press = new KeysPressPractice();
		press.keyPressEnter();
		press.navigateTest();
	}
	
	public void keyPressEnter() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// implicitely wait waits the page load 
		// until the time specified if not an element is found. 
		// if the element is found, driver doesn't wait for the full amount of time
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://google.com");
		driver.findElement(
				By.cssSelector("input[name=q]")).sendKeys("Coffee Mug", Keys.ENTER);
	    driver.close();
	}
	
	public void navigateTest() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		// implicitely wait waits the page load 
		// until the time specified if not an element is found. 
		// if the element is found, driver doesn't wait for the full amount of time
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.navigate().to("https://etsy.com");
		driver.findElement(
				By.cssSelector("input[data-id=search-query]"))
		.sendKeys("Coffee Mug", Keys.ENTER);
		
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().forward();
		Thread.sleep(1000);
		driver.navigate().refresh();
	}

}
