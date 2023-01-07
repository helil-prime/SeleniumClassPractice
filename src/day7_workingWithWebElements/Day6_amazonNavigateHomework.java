package day7_workingWithWebElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day6_amazonNavigateHomework {
	
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/primetech/Documents/Tools/chromedriver");
		Day6_amazonNavigateHomework day6 = new Day6_amazonNavigateHomework();
	
		day6.amazonNavigateTest();
		
	}
	
	public void amazonNavigateTest() throws InterruptedException {
		/* 
		 * maximize browser
     	 * declare implicitly wait for 10 seconds
         * go to amazon.com
         * Search coffee mug.
         * Navigate back then search pretty coffee mug. 
         * Navigate back then navigate forward
         * Refresh the page.
		 */
		
		WebDriver driver = new ChromeDriver();
		//maximize browser
		driver.manage().window().maximize();
		//declare implicitly wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//go to amazon.com
		driver.get("https://amazon.com");
		//Search coffee mug.
		driver.findElement(By.cssSelector("#twotabsearchtextbox"))
		.sendKeys("Coffee Mug", Keys.ENTER);
		Thread.sleep(1000);
		//Navigate back then search pretty coffee mug.
		driver.navigate().back();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#twotabsearchtextbox"))
		.sendKeys("Pretty Coffee Mug", Keys.ENTER);
		//Navigate back then navigate forward
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().forward();
		Thread.sleep(1000);
		//Refresh the page.
		driver.navigate().refresh();
		Thread.sleep(1000);
		driver.close();
		
	}

}
