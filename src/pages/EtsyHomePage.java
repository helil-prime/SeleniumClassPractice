package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class EtsyHomePage {
	
	// why we create constructor?  
	//we create constructor of a class to implement something when the object of the class is created.
	
	public EtsyHomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//span[contains(text(), 'Jewelry & Accessories')]")
	public WebElement jewelary;
	
	@FindBy(xpath = "(//span[contains(text(), 'Bags & Purses')])[1]")
	public WebElement bagPurse;
	
	@FindBy(xpath = "//a[contains(text(), 'Shoulder Bags')]")
	public WebElement shoulderBag;
	
	@FindBy(xpath = "//span[contains(text(), 'Shoulder Bags')]")
	public WebElement shoulderBagTextElement;
	
	
	
	
	
}
