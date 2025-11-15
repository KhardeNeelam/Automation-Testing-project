package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * This class demonstrates basic Selenium WebDriver operations using ChromeDriver.
 * It performs actions on Google and Facebook websites using different element locators.
 */
public class SeleniumTestWithXpath {

	public static void main(String[] args) {
		System.out.println("My First Selenium Test");
		ChromeDriver driver = new ChromeDriver();
		//FirefoxDriver	driver = new FirefoxDriver();
		//EdgeDriver driver = new EdgeDriver();
		// Open Google homepage
		driver.get("https://www.google.com");
		// Find the search text area using an incorrect selector: By.cssSelector with an XPath string
		// (Should be: By.xpath or use valid CSS selector)
		WebElement textArea = driver.findElement(By.cssSelector("//textarea[name='q']"));
		// Type "Selenium Dev" into the search text area
		textArea.sendKeys("Selenium Dev");
	/*	WebElement button = driver.findElement(By.className("gNO89b"));
		button.click();*/
		// Navigate to Facebook homepage
		driver.navigate().to("https://www.facebook.com");
		driver.findElement(By.cssSelector("input#email")).sendKeys("neelam@gmail.com");
		//driver.findElement(By.tagName("button")).click();
		//driver.findElement(By.linkText("Forgotten password?")).click();
		// End of test actions
		
		
		
		
	}

}

