package utilities;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
/**
 * Utility class for creating browser driver instances.
 */
public class Browserutil {
	/**
     * Returns a RemoteWebDriver instance for the specified browser name.
     * Supported browsers: "chrome", "firefox", "edge".
     * Defaults to ChromeDriver if browserName is null or unrecognized.
     *
     * @param browserName the name of the browser ("chrome", "firefox", "edge")
     * @return RemoteWebDriver instance
     */
	public static RemoteWebDriver getDriver(String browserName) {
		RemoteWebDriver driver;
		// Default to ChromeDriver if browserName i
		if (browserName == null) {
			driver = new ChromeDriver();
		} // Create ChromeDriver if browserName is "chrome"
		else if (browserName.equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
		}
		// Create FirefoxDriver if browserName is "firefox"
		else if (browserName.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}         // Create EdgeDriver if browserName is "edge"
		else if (browserName.equalsIgnoreCase("edge")){
			driver = new EdgeDriver();
		}
		// Default to ChromeDriver for any other values
		else {
			driver = new ChromeDriver();
		}
		// Maximize the browser window before returning the driver
		driver.manage().window().maximize();
		return driver;
	}
}

