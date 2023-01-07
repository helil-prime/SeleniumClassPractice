package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class SauceDemoLoginPage {
	
	
	public SauceDemoLoginPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id = "user-name")
	public WebElement username;
	
	// if the element has an id which doesn't violate the java naming rules, 
	//we can directly use the id as the element name
	public WebElement password;
	
	@FindBy(name = "login-button")
	public WebElement loginButton;

}
