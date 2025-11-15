package mytestng.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import utilities.Browserutil;
/**
 * This class demonstrates different ways to scroll a web page using Selenium's Javascript execution.
 * The examples cover:
 * - Scrolling by a fixed pixel amount
 * - Scrolling to an exact position
 * - Scrolling a specific element into view
 */
public class ScrollingPageExample {
	/**
     * Test method to show various scrolling techniques using Javascript.
     * @throws InterruptedException if the thread sleep is interrupted.
     */
	@Test
	public void test1() throws InterruptedException {
		// Initialize Chrome WebDriver through a utility method
		RemoteWebDriver driver = Browserutil.getDriver("chrome");
		// Load the demo page for tooltips
		driver.get("https://jqueryui.com/tooltip/");
		// Scroll down by 600 pixels 5 times, printing the current iteration
		for(int i=0;i<5;i++) {
			//Scrolling by  position in javascript
			
		driver.executeScript("window.scrollBy(0, 600);");
		System.out.println("Scroll By --->"+i);
		}
		Thread.sleep(5000);
		// Scroll to a position 400px from the top of the page
		//Scrolling to that position(Here it is going to top) in JAVASCRIPT
		driver.executeScript("window.scrollTo(0, 400);");
		Thread.sleep(5000);
		System.out.println("Scroll To 400");
		 // Reload the demo page
		driver.get("https://jqueryui.com/tooltip/");
		// Locate the "Cookie" link (likely in the footer)
		WebElement link = driver.findElement(By.xpath("//a[text()='Cookie']"));
		Thread.sleep(5000);
		// Scroll that element into the viewport using Javascript
		//Here it is scrolling to that element on the web (in this scenario it is in down position in footer
		driver.executeScript("arguments[0].scrollIntoView();", link);
		Thread.sleep(5000);
	}
	
}

