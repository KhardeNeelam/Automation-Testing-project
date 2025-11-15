package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
// This is the main class for running a Selenium WebDriver test
public class FirstSeleniumTest {

	public static void main(String[] args) {
		// Print an informational message to the console
		System.out.println("My First Selenium Test");
		// Create a new instance of Chrome WebDriver
		ChromeDriver driver = new ChromeDriver();
		//FirefoxDriver	driver = new FirefoxDriver();
		//EdgeDriver driver = new EdgeDriver();

		// Open Google's homepage
		driver.get("https://www.google.com");
		
		/*WebElement textArea = driver.findElement(By.name("q"));
		textArea.sendKeys("Selenium Dev");
		WebElement button = driver.findElement(By.className("gNO89b"));
		button.click();*/
		 // Navigate to Facebook's homepage
		driver.navigate().to("https://www.facebook.com");
		// Find the email input field by its id and enter an email address
		driver.findElement(By.id("email")).sendKeys("neelam@gmail.com");
		// Find a button on the page using its tag name and click it
		driver.findElement(By.tagName("button")).click();
		// Click on the "Forgotten password?" link using link text
		driver.findElement(By.linkText("Forgotten password?")).click();
		 // End of the test; browser will close when the program exits
	}

}

