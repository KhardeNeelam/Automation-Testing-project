package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTestWithCSSSelectors {

	public static void main(String[] args) {
		// Print starting message to the console
		System.out.println("My First Selenium Test");

		// Initialize Chrome WebDriver
		ChromeDriver driver = new ChromeDriver();
		//FirefoxDriver	driver = new FirefoxDriver();
		//EdgeDriver driver = new EdgeDriver();

		// Navigate to Google's homepage
		driver.get("https://www.google.com");
		// Locate Google's search textbox using XPath and enter the text "Selenium Dev"
		WebElement textArea = driver.findElement(By.xpath("//textarea[@name=\"q\"]"));
		textArea.sendKeys("Selenium Dev");
		
	/*	WebElement button = driver.findElement(By.className("gNO89b"));
		button.click();*/
		// Navigate to Facebook's homepage
		driver.navigate().to("https://www.facebook.com");
		// Locate Facebook's email input box using XPath and enter an email address
		driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("neelam@gmail.com");
		//driver.findElement(By.tagName("button")).click();
		//driver.findElement(By.linkText("Forgotten password?")).click();
		
		
		
		
	}

}

