
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import utilities.Browserutil;

public class AlertHandlingExample {

	//example of Alert
	@Test
	public static void testHandlingAlert() throws InterruptedException {
		RemoteWebDriver driver = Browserutil.getDriver("chrome");//Launch browser
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		driver.findElement(By.xpath("//button[text()=\"Click for JS Alert\"]")).click();
		
		
		String message = driver.switchTo().alert().getText();
		System.out.println(message);
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		
		driver.quit();
	}
	//example of Confirm
	@Test
	public static void testHandlingConfirm() throws InterruptedException {
		RemoteWebDriver driver = Browserutil.getDriver("chrome");//Launch browser
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");	
		
		driver.findElement(By.xpath("//button[text()=\"Click for JS Confirm\"]")).click();
		String message= driver.switchTo().alert().getText();
		System.out.println(message);
		Thread.sleep(5000);
		driver.switchTo().alert().dismiss();
		driver.quit();
	}
	
	//example of Prompt
		@Test
		public static void testHandlingPrompt() throws InterruptedException {
			RemoteWebDriver driver = Browserutil.getDriver("chrome");//Launch browser
			driver.get("https://the-internet.herokuapp.com/javascript_alerts");
			
			driver.findElement(By.xpath("//button[text()=\"Click for JS Prompt\"]")).click();
			String message= driver.switchTo().alert().getText();
			System.out.println(message);
			Thread.sleep(5000);
			driver.switchTo().alert().sendKeys("Testing ongoing");
			driver.switchTo().alert().accept();
			driver.quit();
		}
		
	
}
