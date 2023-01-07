package day7_workingWithWebElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IndeedElementStatus {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/primetech/Documents/Tools/chromedriver");
		IndeedElementStatus check = new IndeedElementStatus();
		//check.elementStatusTest();
		check.radioButtonCheck();

	}
	
	public void radioButtonCheck() throws InterruptedException {
		/*
		 * go to https://designsystem.digital.gov/components/radio-buttons/
         * find those available radio buttons.
         * check if it’s displayed and enabled,  
         * if true, check if it’s selected, 
         * if false select and check if it’s selected.
		 */
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//go to https://designsystem.digital.gov/components/radio-buttons/
		driver.get("https://designsystem.digital.gov/components/radio-buttons/");
		//find those available radio buttons.
		List<WebElement> radioButtons = 
				driver.findElements(By.cssSelector(".usa-radio__label"));
		
		//check if it’s displayed and enabled,
		for (WebElement elems : radioButtons) {
			if (elems.isDisplayed() && elems.isEnabled()) {
				System.out.println("Element is displayed and enabled");
				//if true, check if it’s selected,
				//if false select and check if it’s selected.
				if (!elems.isSelected()) {
					elems.click();
					System.out.println("Element is just clicked.");
				} 
				Thread.sleep(1000);
				if (elems.isSelected()) {
					System.out.println("The radio button is selected!");
				}
				Thread.sleep(1000);
			} else {
				System.out.println("Element is not displayed or enabled.");
			}
			 
		}
		
		
	}
	
	public void elementStatusTest() {
		/*
		 * go to https://indeed.com
         * check if the search fields are enabled and displayed.
		 */
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//go to https://indeed.com
		driver.get("https://indeed.com");
		// check if the search fields are enabled and displayed.
		
		WebElement whatField = driver.findElement(By.cssSelector("#text-input-what"));
		WebElement whereField = driver.findElement(By.cssSelector("#text-input-where"));
		
		if (whatField.isDisplayed() && whatField.isEnabled()) {
			System.out.println("What feild is displayed and enabled");
		} else {
			System.out.println("Nothing matchs!");
		}
			
		if (whereField.isDisplayed() && whereField.isEnabled()) {
			System.out.println("Where feild is displayed and enabled");
		} else {
			System.out.println("Nothing matchs!");
		}
		
		driver.close();
	}

}
