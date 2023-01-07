package day7_workingWithWebElements;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsPractice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/primetech/Documents/Tools/chromedriver");
		
		FindElementsPractice elements = new FindElementsPractice();
		elements.listOfElementsTest();
	}
	
	public void listOfElementsTest() throws InterruptedException {
		/*
		 * go to amazon
		 * search for coffee mug
		 * verify the amount of listing is equals to 65
		 */
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://amazon.com");
		driver.findElement(By.id("twotabsearchtextbox"))
		.sendKeys("Coffee Mug", Keys.ENTER);
		Thread.sleep(1000);
		
		//verify the amount of listing is equals to 65
		// find all the items and store them in a list of webElements
		List<WebElement> items = 
				driver.findElements(By.cssSelector(".a-section.a-spacing-base"));
		
		System.out.println(items.size());
		
		if (items.size() == 65) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Numbers don't match");
		}
	}

}
