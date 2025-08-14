package mytestng.test;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Simpletestng {

	ChromeDriver driver;
	
	@BeforeSuite               //Environment configuration
	public void beforesuite() {
	System.out.println("@BeforeSuite");
	}
	@AfterSuite
	public void aftersuite() {
		System.out.println("@AfterSuite");
	}
	
	@BeforeTest//
	public void beforetest() {
	System.out.println("@BeforeTest");
	}
	@AfterTest
	public void aftertest() {
		System.out.println("@AfterTest");
	}
	
	@BeforeClass
	public void beforeC() {
	System.out.println("@BeforeClass");
	}
	@AfterClass
	public void afterC() {
		System.out.println("@AfterClass");
	}
	@AfterMethod
	public void after() {
	driver.quit();
	}
	
	@Test(priority = 0, description="Loging test for google")
	public void googletest() {
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://www.google.com");
	}
	@Test(priority = 1, description="Loging test for facebook")
	public void facebooktest() {
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://www.facebook.com");
	}
}
