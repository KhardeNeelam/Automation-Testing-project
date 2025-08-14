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
		ChromeDriver driver = new ChromeDriver();
		
		//Explicit image
		//element to be clickable, alert present, element to be visible or not visible, number of windows becomes 5
		// so what ever is ExpectedConditions.options(click)
		
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		driver.findElement(By.xpath("//button[text()='Enable']")).click();
		//Thread.sleep(10000);
		//Explicit wait
		//WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		
	    Wait<ChromeDriver> wait =
	            new FluentWait<>(driver)				//Fluent Wait
	                .withTimeout(Duration.ofSeconds(2))
	                .pollingEvery(Duration.ofSeconds(30))
	                .ignoring(ElementNotInteractableException.class);

	        
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='input-example']/input")));
				
		driver.findElement(By.xpath("//form[@id='input-example']/input")).sendKeys("Testing");
		

		
		
		driver.findElement(By.xpath("//button[text()='Remove']")).click();
		
		
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//form[@id='checkbox']")));
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//button[text()='Add']")).click();

	}

}
