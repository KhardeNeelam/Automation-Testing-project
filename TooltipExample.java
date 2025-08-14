package mytestng.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import utilities.Browserutil;

public class TooltipExample {

	@Test(description = "Simple way to print Iframe attribute" , enabled =true)
	public  void test1() {
		
		RemoteWebDriver driver = Browserutil.getDriver("chrome");
		//Because it is in iframe so directly give address of that iframe
		//As iframe is another window only inside html page also called nested html page.
		driver.get("https://jqueryui.com/resources/demos/tooltip/default.html");
		driver.switchTo().frame(0);
		String Tooltip =driver.findElement(By.id("age")).getAttribute("title");
		System.out.println("Tooltip1--->"+Tooltip);
		
		
	}
	
	@Test(enabled =false)
	public  void test2() {
		
		RemoteWebDriver driver = Browserutil.getDriver("chrome");
		
		driver.get("https://jqueryui.com/tooltip/");
		//There are 3 ways to print iframe attribute
		//Swicth  driver crontrol to the frame
		driver.switchTo().frame(0);
		String Tooltip =driver.findElement(By.id("age")).getAttribute("title");
		System.out.println("Tooltip2--->"+Tooltip);
			
	}
	@Test(enabled =false)
	public  void test3() {
		
		RemoteWebDriver driver = Browserutil.getDriver("chrome");
		
		driver.get("https://jqueryui.com/tooltip/");
		//Swicth to WebElement frame  driver crontrol to the frame
		
		WebElement element =driver.findElement(By.xpath("//iframe"));
		driver.switchTo().frame(element);
		
		String Tooltip =driver.findElement(By.id("age")).getAttribute("title");
		System.out.println("Tooltip3--->"+Tooltip);
		
		
		// Now if you are inside frame and try to click draggable elemnt it wont
		//so you want to perform any operation outside the iframe you 
		//have to come out of iframe
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text()='Draggable']")).click();
				
	}
	
	@Test
	public  void test4() throws InterruptedException {
		
		RemoteWebDriver driver = Browserutil.getDriver("chrome");
		
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
		//Multiple the frames how to do that
		
		driver.switchTo().frame("iframeResult");
		System.out.println("Inside the iframe parent window");
		WebElement frame = driver.findElement(By.xpath("//iframe[@title='Iframe Example']"));
		driver.switchTo().frame(frame);
		
		System.out.println("Message-->"+driver.getPageSource());
		
		//If you want to come out of inside frame that is child frame to parent frame
		driver.switchTo().parentFrame();
		//driver.switchTo().defaultContent();
		System.out.println("Message for parent frame--->"+driver.getPageSource());
		
		driver.switchTo().defaultContent();
		System.out.println("Switch to Default Window");
		
		driver.get("https://www.w3schools.com/howto/tryit.asp?filename=tryhow_css_modal2");
		System.out.println("Launch the Window");
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.id("myBtn")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='close']")).click();
		//so here we leanred about modal dialog box
		//its not like alert(), you can simply go on modal dialog and dismiss it.
		System.out.println("End of the example multiple windows");
		
		driver.quit();
	}
	
}
