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
/**
 * Simple TestNG class demonstrating the lifecycle annotations and basic browser navigation tests 
 * using Selenium ChromeDriver.
 */
public class Simpletestng {

	ChromeDriver driver;
	/**
     * Runs once before all tests in the suite.
     * Used for environment configuration.
     */
	@BeforeSuite               //Environment configuration
	public void beforesuite() {
	System.out.println("@BeforeSuite");
	}
	/**
     * Runs once after all tests in the suite.
     * Any global cleanup can be done here.
     */
	@AfterSuite
	public void aftersuite() {
		System.out.println("@AfterSuite");
	}
	/**
     * Runs before any test method belonging to the classes inside the <test> tag is run.
     */
	@BeforeTest//
	public void beforetest() {
	System.out.println("@BeforeTest");
	}
	 /**
     * Runs after all the test methods belonging to the classes inside the <test> tag have run.
     */
	@AfterTest
	public void aftertest() {
		System.out.println("@AfterTest");
	}
	/**
     * Runs before the first method in the current class.
     */
	@BeforeClass
	public void beforeC() {
	System.out.println("@BeforeClass");
	}
	 /**
     * Runs after all the methods in the current class have been run.
     */
	@AfterClass
	public void afterC() {
		System.out.println("@AfterClass");
	}
	/**
     * Runs after each test method.
     * This will quit the browser after every test.
     */
	@AfterMethod
	public void after() {
	driver.quit();
	}
	/**
     * Test to open Google's home page.
     * Sets a page load timeout and navigates to google.com.
     */
	@Test(priority = 0, description="Loging test for google")
	public void googletest() {
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://www.google.com");
	}
	 /**
     * Test to open Facebook's home page.
     * Sets a page load timeout and navigates to facebook.com.
     */
	@Test(priority = 1, description="Loging test for facebook")
	public void facebooktest() {
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://www.facebook.com");
	}
}

