package day10_windowHanldles;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlesTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/primetech/Documents/Tools/chromedriver");
		WindowHandlesTest window = new WindowHandlesTest();
		window.getWindowHandleTest2();

	}
	
	public void getWindowHandleTest2() {
		/*
		 * Test case 2 
		go to http://practice.primetech-apps.com:4567/styled/windows-test.html
		Get the main window ID and store it in a String, 
		Click on the Basic Ajax in new page
		Get window IDs and store it into a SET
		Get the first window ID and Verify it matches with the main window id in step 2
		Switch to the second window
		Get the page header Text and verify it is “Basic Ajax Example”
		Close the window,  Switch back to the main window, 
		Verify you are on the main window. 
		 */
		
		// go to a website
				WebDriver driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.get("http://practice.primetech-apps.com:4567/styled/windows-test.html");
				// Get the main window ID and store it in a String,
				String mainWindowId = driver.getWindowHandle();
				System.out.println("Main window id: " + mainWindowId);
				//Click on the Basic Ajax in new page
				driver.findElement(By.id("gobasicajax")).click();
				//Get window IDs and store them into a SET
				Set<String> windowIds =  driver.getWindowHandles();
				//Get the first window ID and Verify it matches with the main window id in step 2
				
				Iterator<String> iterate = windowIds.iterator();
				String firstWindowId = iterate.next();
				System.out.println("First window id: " + firstWindowId);
				if (firstWindowId.equals(mainWindowId)) {
					System.out.println("First Id matches with the main window id.");
				}else {
					System.out.println("First Id does NOT match with the main window id.");
				}
				
				//Switch to the second window
				String secondWindowID = iterate.next();
				System.out.println("Second window id: " + secondWindowID);
				driver.switchTo().window(secondWindowID);
				
				
				//Get the page header Text and verify it is “Basic Ajax Example”
				String Text = driver.findElement(By.xpath("//h1[text()='Basic Ajax Example']")).getText();
				System.out.println("Driver is on the child window: " + Text);
				
				//Close the window,  Switch back to the main window,  
				driver.close();
				driver.switchTo().window(mainWindowId);
				
				//Verify you are on the main window.
				
				if (driver.getWindowHandle().equals(mainWindowId)) {
					System.out.println("We are back to main window.");
				}else {
					System.out.println("Something is wrong.");
				}
				
				driver.quit();
	}
	
	
	
	
	public void getWindowHandleTest() {
		// go to a website
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://practice.primetech-apps.com:4567/styled/windows-test.html");
		
		// get the current window handle
		String mainWindowId = driver.getWindowHandle();
		System.out.println("Main window id: " + mainWindowId);
		// click on a new page link 
		driver.findElement(By.id("gobasicajax")).click();
		// get window handles
		Set<String> windowIds = driver.getWindowHandles();
		
		// switch to next window (childWindow)
		for (String windowId : windowIds) {
			System.out.println("Window id: " + windowId);
			if (!windowId.equals(mainWindowId)) {
				driver.switchTo().window(windowId);
			}
		}
		String Text = driver.findElement(By.xpath("//h1[text()='Basic Ajax Example']")).getText();
		System.out.println("Driver is on the child window: " + Text);
		
		driver.close();
		
		// we need to switch back to main window in order to work there.
		
		driver.switchTo().window(mainWindowId);
		
		String mainWindowTest = 
				driver.findElement(By.xpath("//h1[text()='Windows Links and Examples']")).getText();
		System.out.println("Main window text: " + mainWindowTest);
		
		
	}

}
