package day8_MoreOnSelenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EtsyHomework {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/primetech/Documents/Tools/chromedriver");
		
		EtsyHomework etsyTest = new EtsyHomework();
		etsyTest.EtsyTest();

	}
	
	public void EtsyTest() {
		/*
		 * maximize window.
          explicitly wait for 10 seconds.
          go to etsy.com.   
          search coffee mug.
          find all the results and store them in a list of webelements.
          loop through all those and get the prices of each item and print it out. 
          then quit.
		 * 
		 */
		
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://etsy.com");
		driver.findElement(By.name("search_query")).sendKeys("Coffee Mug", Keys.ENTER);
		
		List<WebElement> itemPrices = driver.findElements(
				By.xpath("//div[contains(@class, 'lc-price')]"));
		System.out.println("Size of the List." + itemPrices.size());
		for (WebElement element : itemPrices) {
			System.out.println(element.getText());
		}
	}

}
