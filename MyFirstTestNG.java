package mytestng.test;
// Import necessary libraries
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import utilities.Browserutil;
/**
 * This class contains TestNG test methods for basic browser automation using Selenium WebDriver.
 */
public class MyFirstTestNG {
	 /**
     * Test to launch Google page and close the browser.
     * Priority: 0
     * Description: Logging test for google
     */
	@Test(priority = 0, description="Loging test for google")
	public void googletest() {
		// Initialize ChromeDriver instance (local browser automation)
		//Browserutil.getDriver(null); // Custom browser utility, currently commented out
		ChromeDriver driver = new ChromeDriver();
		// Set page load timeout to 30 seconds
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		// Open the Google homepage
		driver.get("https://www.google.com");
		// Close the browser
		driver.quit();
	}
	 /**
     * Test to launch Facebook page and close the browser.
     * Priority: 1
     * Description: Launching facebook pg
     */
	@Test(priority = 1, description = "launcing facebook pg")
	public void facebooktest() {
		ChromeDriver driver = new ChromeDriver();
		// Set page load timeout to 30 seconds
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		// Open the Facebook homepage
		driver.get("https://www.facebook.com");
		
		driver.quit();
	}
	/**
     * Test for dynamic loading example on "the-internet" site.
     * Priority: 2
     * This test is currently disabled.
     */
	@Test(priority = 2, enabled = false)
	public void Websitetest() {
		ChromeDriver driver = new ChromeDriver();
		// Set implicit wait timeout to 30 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Open the dynamic loading page
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
		// Click the "Start" button to load dynamic content
		driver.findElement(By.xpath("//button[text()=\"Start\"]")).click();
		// Check if the "Hello World" text is displayed
		boolean flag = driver.findElement(By.xpath("//h4[text()='Hello World']")).isDisplayed();
		// Print the result to the console
		System.out.println("Flag--->" +flag);
	}

}
