package day12_PageObjectModel;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.Actions;
import pages.EtsyHomePage;
import utils.DataReader;
import utils.Driver;

public class EtsyHoverOverWithPOM {
	
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
		
		EtsyHomePage etsyPage = new EtsyHomePage();
		
		//go to Etsy.com
		Driver.getDriver().get(DataReader.getData("etsyUrl"));
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Hover Over on Jewelry & Accessories
		Actions action = new Actions(Driver.getDriver());
		
		action.moveToElement(etsyPage.jewelary).perform();
		Thread.sleep(1000);
		//Mouseover on Bags & Purses
		
		action.moveToElement(etsyPage.bagPurse).build().perform();
		Thread.sleep(1000);
		//Mouseover to Shoulder Bags
		//Click on the shoulder bags
		
		action.moveToElement(etsyPage.shoulderBag).click().build().perform();
		Thread.sleep(1000);
		//Verify you are on the Shoulder bags page
		
	    if (etsyPage.shoulderBagTextElement.getText().equalsIgnoreCase("shoulder bags")) {
			System.out.println("We are on the shoulder bags page.");
		}else {
			System.out.println("We are Not on the shoulder bags page.");
		}
	    
	    Driver.quitDriver();
	}

}
