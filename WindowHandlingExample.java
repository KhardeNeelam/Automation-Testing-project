package mytestng.test;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import utilities.Browserutil;
//Demonstrate handling multiple tabs/windows
public class WindowHandlingExample {
	
	@Test(enabled = false)
	public void test1() throws InterruptedException {
		RemoteWebDriver driver = Browserutil.getDriver("chrome");
		
		driver.get("https://www.selenium.dev/");
		String parentwindowHandler = driver.getWindowHandle();
		System.out.println("Parent window--->"+parentwindowHandler);
		//Here below you see it says new window Tab so the highlighted window is new window
		//else when only .window is used it will highlight the parent or previous window. 
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.navigate().to("https://www.google.com");
		String googlewindowHandler = driver.getWindowHandle();
		System.out.println("Google window--->"+googlewindowHandler);
		
		//Here we can delete any specific window any window you want 
		driver.switchTo().window(parentwindowHandler);
		driver.close();
		driver.switchTo().window(googlewindowHandler);
		driver.navigate().to("https://www.facebook.com");
		driver.findElement(By.xpath("//a[text()='Forgotten password?']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Forgotten account?')]")).click();
		Thread.sleep(1000);
		driver.close();//So here it is deleting the child window which is highlighted.
		
		
		Thread.sleep(5000);
		driver.quit();
	}
	@Test()
	public void test2() throws InterruptedException {
		RemoteWebDriver driver = Browserutil.getDriver("chrome");
		
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		Thread.sleep(1000);
		//Total number of windows open on browser
		Set<String> handles = driver.getWindowHandles();
		System.out.println("Total windows open are---->"+handles.size());
		//Here if you have 10 windoes open you can go to specific window by matching the title.
		
		for(String handle: handles) {
			driver.switchTo().window(handle);
			String title = driver.getCurrentUrl();
			if(title.contains("")) {
				break;
			}
		}
		driver.close();
		driver.quit();
	}
	
}

