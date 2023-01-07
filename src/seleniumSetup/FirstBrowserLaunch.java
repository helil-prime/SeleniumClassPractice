package seleniumSetup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstBrowserLaunch {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/primetech/Documents/Tools/chromedriver");
		
		String title = new String();
		
		WebDriver driver = new ChromeDriver();
		// go to amazon.com
		driver.get("https://amazon.com");
		//get the title of amazon home page and printing. 
		title = driver.getTitle();
		System.out.println(title);
		
		// find the search box and store it into a webElement object
		WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		// type coffee mug
		searchbox.sendKeys("coffee mug");
		Thread.sleep(2000);
		// find the search button and store it in a webElement.
		WebElement searchBtn = driver.findElement(By.id("nav-search-submit-button"));
		// click the search button.
		searchBtn.click();
		
		// clear the coffee mug text from the search box 
		WebElement searchbox2 = driver.findElement(By.id("twotabsearchtextbox"));
		searchbox2.clear();
		// type pretty coffee mug
		searchbox2.sendKeys("pretty coffee mug");
		// click on the search button
		WebElement searchBtn2 = driver.findElement(By.id("nav-search-submit-button"));
		searchBtn2.click();
		
	}
	
	
	}
