package mytestng.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import utilities.Browserutil;

public class MyFirstTestNG {
	
	@Test(priority = 0, description="Loging test for google")
	public void googletest() {
		//Browserutil.getDriver(null);
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://www.google.com");
		driver.quit();
	}
	
	@Test(priority = 1, description = "launcing facebook pg")
	public void facebooktest() {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://www.facebook.com");
		driver.quit();
	}
	@Test(priority = 2, enabled = false)
	public void Websitetest() {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
		driver.findElement(By.xpath("//button[text()=\"Start\"]")).click();
		boolean flag = driver.findElement(By.xpath("//h4[text()='Hello World']")).isDisplayed();
		System.out.println("Flag--->" +flag);
	}
}