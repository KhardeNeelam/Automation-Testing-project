package mytestng.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import utilities.Browserutil;

public class ScrollingPageExample {

	@Test
	public void test1() throws InterruptedException {
		RemoteWebDriver driver = Browserutil.getDriver("chrome");
		driver.get("https://jqueryui.com/tooltip/");
		for(int i=0;i<5;i++) {
			//Scrolling by  position in javascript
		driver.executeScript("window.scrollBy(0, 600);");
		System.out.println("Scroll By --->"+i);
		}
		Thread.sleep(5000);
		//Scrolling to that position(Here it is going to top) in JAVASCRIPT
		driver.executeScript("window.scrollTo(0, 400);");
		Thread.sleep(5000);
		System.out.println("Scroll To 400");
		driver.get("https://jqueryui.com/tooltip/");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='Cookie']"));
		Thread.sleep(5000);
		//Here it is scrolling to that element on the web (in this scenario it is in down position in footer
		driver.executeScript("arguments[0].scrollIntoView();", link);
		Thread.sleep(5000);
	}
	
}
