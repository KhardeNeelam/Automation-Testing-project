package mytestng.test;

import java.time.Duration;


import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utilities.Browserutil;


public class DependsonTestsParalleltest {

	package mytestng.test;

	import java.time.Duration;

	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.remote.RemoteWebDriver;
	import org.testng.annotations.Optional;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;

	import utilities.Browserutil;
// This is sample for dependancy testing..........................................
// Do not try to run this

	public class DependsonTestsParalleltest {

		//dependencies on tests
		@Parameters({"browser"})
		@Test
		public void Test1(String browserName,/* @Optional("Firefox") String defaultvaluebrowser, String url*/) {
			System.out.println("browserName--->"+browserName);
			RemoteWebDriver driver = Browserutil.getDriver(browserName);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.get("https://www.facebook.com");
			driver.quit();
		}
		//this is cross browser testing
		@Parameters({"browser"/*, "url"*/})
		@Test (dependsOnMethods = {"Test1"})
		public void Test2(String browserName,/* @Optional("Firefox") String defaultvaluebrowser, String url*/) {
			System.out.println("browserName--->"+browserName);
			RemoteWebDriver driver = Browserutil.getDriver(browserName);
			//RemoteWebDriver driver = new FirefoxDriver();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.get("https://www.google.com");
			//driver.get(url);
			driver.quit();
		}
		
		@Parameters({"browser"})
		@Test 
		public void Test3(String browserName,/* @Optional("Firefox") */String defaultvaluebrowser) {
			System.out.println("browserName--->"+browserName);
			RemoteWebDriver driver = Browserutil.getDriver(browserName);
			//RemoteWebDriver driver = new FirefoxDriver();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.get("https://www.amazon.com");
			//driver.get(url);
			driver.quit();
		}
		@Parameters({"browser"})
		@Test (dependsOnMethods = {"Test1"})
		public void Test4(String browserName,/* @Optional("Firefox")*/ String defaultvaluebrowser) {
			System.out.println("browserName--->"+browserName);
			RemoteWebDriver driver = Browserutil.getDriver(browserName);
			//RemoteWebDriver driver = new FirefoxDriver();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.get("https://www.nib.com");
			//driver.get(url);
			driver.quit();
		}
		
	}


	
}

