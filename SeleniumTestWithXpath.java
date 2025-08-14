package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTestWithXpath {

	public static void main(String[] args) {
		System.out.println("My First Selenium Test");
		ChromeDriver driver = new ChromeDriver();
		//FirefoxDriver	driver = new FirefoxDriver();
		//EdgeDriver driver = new EdgeDriver();
		driver.get("https://www.google.com");
		
		WebElement textArea = driver.findElement(By.cssSelector("//textarea[name='q']"));
		textArea.sendKeys("Selenium Dev");
	/*	WebElement button = driver.findElement(By.className("gNO89b"));
		button.click();*/
		
		driver.navigate().to("https://www.facebook.com");
		driver.findElement(By.cssSelector("input#email")).sendKeys("neelam@gmail.com");
		//driver.findElement(By.tagName("button")).click();
		//driver.findElement(By.linkText("Forgotten password?")).click();
		
		
		
		
	}

}
