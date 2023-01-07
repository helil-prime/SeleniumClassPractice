package day10_windowHanldles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/primetech/Documents/Tools/chromedriver");
		IframeTest test = new IframeTest();
		test.iframeTest();
		
		

	}
	
	public void iframeTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// go to the website
		driver.get("http://practice.primetech-apps.com:4567/styled/iframes-test.html");
		// switch into iframe
		driver.switchTo().frame("thedynamichtml");
		// get the text iFrame text and print
		String iFrameText = driver.findElement(By.xpath("//h1[text()='iFrame']")).getText();
		System.out.println("Iframe text is : " +iFrameText);
		
		// switch back to main frame and get the main frame header 
		driver.switchTo().parentFrame();
		
		String mainFrameText = 
				driver.findElement(By.xpath("//h1[text()='iFrames Example']")).getText();
		System.out.println("Main frame text is: " + mainFrameText);
		
	}

}
