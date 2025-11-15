package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * Example demonstrating how to use implicit waits in Selenium WebDriver with ChromeDriver.
 * Implicit waits instruct WebDriver to wait for a certain amount of time when
 * trying to find elements if they are not immediately available.
 */
public class ImplicitWaitExample  {

	public static void main(String[] args) throws InterruptedException{
		// Instantiate ChromeDriver (launches a new browser session)
		ChromeDriver driver = new ChromeDriver();
		
		//Implicit wait-- locate element appliy wait
		//Smart wait. Element is found before 30 sec it will go on next element.
		//max is 200sec no more than that may be 30 to 60 sec
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Navigate to the dynamic loading page
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
		// Click the Start button to begin loading hidden content
		driver.findElement(By.xpath("//button[text()=\"Start\"]")).click();
		 // Check if the "Hello World!" message is displayed after loading
		boolean flag = driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed();
		// Output the result in the console
		System.out.println("Flag--->" +flag);
		
		// Navigate to another page with dynamic controls
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		// Click the checkbox to select it
		driver.findElement(By.xpath("//form[@id='checkbox-example']//input")).click();
		// Click the button to remove/add the checkbox
		driver.findElement(By.xpath("//button[@type='button']")).click();
		// Note: The browser window will remain open after execution;
        // consider adding driver.quit() at the end to close it.
	}

}

