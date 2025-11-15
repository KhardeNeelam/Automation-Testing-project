package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		// Initialize the Chrome WebDriver
		ChromeDriver driver = new ChromeDriver();
		// Comment: Example of using explicit waits for web interactions
        // Explicit waits can be used for conditions like elements being clickable,
        // visibility, alert presence, or waiting for certain number of windows.
		
		//Explicit image
		//element to be clickable, alert present, element to be visible or not visible, number of windows becomes 5
		// so what ever is ExpectedConditions.options(click)
		
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		// Click the 'Enable' button
		driver.findElement(By.xpath("//button[text()='Enable']")).click();
		//Thread.sleep(10000);
		//Explicit wait
		//WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		// Example of FluentWait (a more flexible type of explicit wait)
        // FluentWait allows us to specify timeout, polling interval, and exception ignoring
	    Wait<ChromeDriver> wait =
	            new FluentWait<>(driver)				// Create a FluentWait for the driver
	                .withTimeout(Duration.ofSeconds(2)) // Maximum wait time
	                .pollingEvery(Duration.ofSeconds(30)) // Frequency for checking the condition
	                .ignoring(ElementNotInteractableException.class); 

	    // Wait until the input box is clickable    
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='input-example']/input")));
		// Send text to the input box		
		driver.findElement(By.xpath("//form[@id='input-example']/input")).sendKeys("Testing");
		

		
		// Click the 'Remove' button to remove checkbox element
		driver.findElement(By.xpath("//button[text()='Remove']")).click();
		
		
		// Wait until checkbox form is invisible
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//form[@id='checkbox']")));
		Thread.sleep(10000);
		// Click the 'Add' button to re-add the checkbox element
		driver.findElement(By.xpath("//button[text()='Add']")).click();

	}

}

