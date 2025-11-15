package tests;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
/**
 * Demonstrates the use of Selenium WebDriver's page load timeout feature.
 * Sets the maximum amount of time to wait for a page to load in ChromeDriver.
 */
public class PageLoadWait {

	public static void main(String[] args) {
		 // Initialize ChromeDriver instance
		ChromeDriver driver = new ChromeDriver();
		// Set the page load timeout to 60 seconds.
		//Always keep the limits 60 to 90 sec otherwise tell developer it is too long wait
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		 // Attempt to load the specified web page
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");
		// Print the page title after successful load
		System.out.println(driver.getTitle());

	}

}

