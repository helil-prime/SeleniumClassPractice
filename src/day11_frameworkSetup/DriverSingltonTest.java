package day11_frameworkSetup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.DataReader;
import utils.Driver;

public class DriverSingltonTest {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		/*
		 * Test case: 
		go to Etsy.com
		Hover Over on Jewelry & Accessories
		Mouseover on Bags & Purses
		Mouseover to Shoulder Bags
		Click on the shoulder bags
		Verify you are on the Shoulder bags page

		 */
		
		//go to Etsy.com
		Driver.getDriver().get(DataReader.getData("etsyUrl"));
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Hover Over on Jewelry & Accessories
		Actions action = new Actions(Driver.getDriver());
		WebElement jewelary = Driver.getDriver().findElement(By.xpath("//span[contains(text(), 'Jewelry & Accessories')]"));
		action.moveToElement(jewelary).perform();
		Thread.sleep(1000);
		//Mouseover on Bags & Purses
		WebElement bagPurse = Driver.getDriver().findElement(By.xpath("(//span[contains(text(), 'Bags & Purses')])[1]"));
		action.moveToElement(bagPurse).build().perform();
		Thread.sleep(1000);
		//Mouseover to Shoulder Bags
		//Click on the shoulder bags
		WebElement shoulderBags = Driver.getDriver().findElement(By.xpath("(//a[contains(text(), 'Shoulder Bags')])"));
		action.moveToElement(shoulderBags).click().build().perform();
		Thread.sleep(1000);
		//Verify you are on the Shoulder bags page
		String shoulderbagText = 
				Driver.getDriver().findElement(By.xpath("//span[contains(text(), 'Shoulder Bags')]")).getText();
	    if (shoulderbagText.equalsIgnoreCase("shoulder bags")) {
			System.out.println("We are on the shoulder bags page.");
		}else {
			System.out.println("We are Not on the shoulder bags page.");
		}
	    
	    Driver.quitDriver();
	}

}
