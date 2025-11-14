package mytestng.test;

import java.time.Duration;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utilities.Browserutil;
/**
 * This class demonstrates TestNG test dependencies and cross-browser/parallel testing setup.
 * Each test launches a browser (as specified by parameter), navigates to a different website,
 * and has dependencies to control the execution order.
 */
public class DependsonTests {

	    // Test 1: Opens the provided browser and navigates to Facebook.
		@Parameters({"browser"})
		@Test
		public void Test1(String browserName) {
			System.out.println("browserName--->"+browserName);
			RemoteWebDriver driver = Browserutil.getDriver(browserName);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.get("https://www.facebook.com");
			driver.quit();
		}  /**
     * Test 2: Depends on Test1.
     * Opens the provided browser and navigates to Google.
     * Demonstrates cross-browser and parallel test capabilities in TestNG.
     */
		
		@Parameters({"browser"})
		@Test (dependsOnMethods = {"Test1"})
		public void Test2(String browserName) {
			System.out.println("browserName--->"+browserName);
			RemoteWebDriver driver = Browserutil.getDriver(browserName);
			//RemoteWebDriver driver = new FirefoxDriver();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.get("https://www.google.com");
			//driver.get(url);
			driver.quit();
		}
		 // Test 3: Opens the provided browser and navigates to Amazon.
		@Parameters({"browser"})
		@Test 
		public void Test3(String browserName) {
			System.out.println("browserName--->"+browserName);
			RemoteWebDriver driver = Browserutil.getDriver(browserName);
			//RemoteWebDriver driver = new FirefoxDriver();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.get("https://www.amazon.com");
			//driver.get(url);
			driver.quit();
		} /**
     * Test 4: Depends on Test3.
     * Opens the provided browser and navigates to nib.com.
     */
		@Parameters({"browser"})
		@Test (dependsOnMethods = {"Test3"})
		public void Test4(String browserName) {
			System.out.println("browserName--->"+browserName);
			RemoteWebDriver driver = Browserutil.getDriver(browserName);
			//RemoteWebDriver driver = new FirefoxDriver();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.get("https://www.nib.com");
			//driver.get(url);
			driver.quit();
		}
		
}

