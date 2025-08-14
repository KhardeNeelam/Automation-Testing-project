package utilities;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Browserutil {
	
	public static RemoteWebDriver getDriver(String browserName) {
		RemoteWebDriver driver;
		
		if (browserName == null) {
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
		}
		
		else if (browserName.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("edge")){
			driver = new EdgeDriver();
		}
		
		else {
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		return driver;
	}
}
