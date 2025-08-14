package uitestingplayground;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utilities.Browserutil;

public class dynamicid {
	
	@Test(enabled =false)
	public void test1() {
	
		RemoteWebDriver driver = Browserutil.getDriver("chrome");
		driver.get("http://www.uitestingplayground.com/dynamicid");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		}
	@Test(enabled =false)
	public void test2() throws InterruptedException {
	
		RemoteWebDriver driver = Browserutil.getDriver("chrome");
		driver.get("http://www.uitestingplayground.com/classattr");
		Thread.sleep(5000);
		//Here we are using concatenation to get the exact value.
		driver.findElement(By.xpath("//button[contains(concat(' ', normalize-space(@class), ' '), ' btn-primary ')]")).click();
		Thread.sleep(5000);	
		
				driver.switchTo().alert().dismiss();
				System.out.println("Blue");
			
	
	}
	@Test(enabled =false)
	public void test3() throws InterruptedException {
	
		RemoteWebDriver driver = Browserutil.getDriver("chrome");
		driver.get("http://www.uitestingplayground.com/hiddenlayers");
		driver.findElement(By.xpath("//button[text()='Button']")).click();
		Thread.sleep(5000);
		//Here we see that button can be click only once 
		driver.findElement(By.xpath("//button[text()='Button']")).click();
		Thread.sleep(5000);
		
	}
	
	@Test(enabled =false)
	public void test4() throws InterruptedException {
	//Record the following steps. Press the button below and wait for data to appear (15 seconds),
	//click on text of the loaded label.
	//Then execute your test to make sure it waits for label text to appear.
		
		RemoteWebDriver driver = Browserutil.getDriver("chrome");
		driver.get("http://www.uitestingplayground.com/ajax");
				
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='content']/p")));
		String text = driver.findElement(By.xpath("//p[@class='bg-success']")).getText();
		System.out.println("End"+text);
		
		driver.quit();
			
	}	
	
	@Test(enabled =false)
	public void test5() throws InterruptedException {
		
		RemoteWebDriver driver = Browserutil.getDriver("chrome");
		driver.get("http://www.uitestingplayground.com/clientdelay");
		driver.findElement(By.xpath("//button[@id='ajaxButton']")).click();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='content']/p")));
		String text = driver.findElement(By.xpath("//div[@id='content']/p")).getText();
		System.out.println("End--->"+text);
		driver.quit();
		
	}
	@Test(enabled =false)
	public void test6() throws InterruptedException {
		
		RemoteWebDriver driver = Browserutil.getDriver("chrome");
		driver.get("http://www.uitestingplayground.com/textinput?");
		
		driver.findElement(By.xpath("//input[@id='newButtonName']")).sendKeys("Neelam");
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='updatingButton']")));
		driver.findElement(By.xpath("//button[@id='updatingButton']")).click();
		String text = driver.findElement(By.xpath("//button[@id='updatingButton']")).getText();
		System.out.println("End--->"+text);
		driver.quit();
		
	}
	@Test(enabled =true)
	public void test7() throws InterruptedException {
		
		//Create a test that clicks Start button and then waits for the progress bar to reach 75%. 
		//Then the test should click Stop. 
		//The less the differnce between value of the stopped progress bar and 75% the better your result.
		
		RemoteWebDriver driver = Browserutil.getDriver("chrome");
		driver.get("http://www.uitestingplayground.com/progressbar");
		
		driver.findElement(By.xpath("//button[@id='startButton']")).click();
		
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(90));
		
		ExpectedCondition<Boolean> progressBarAt75Percent = new ExpectedCondition<Boolean>() {
		    @Override
		    public Boolean apply(WebDriver driver) {
		    	String value =driver.findElement(By.xpath("//div[@id='progressBar']")).getAttribute("aria-valuenow");
		        try {
		            int currentValue = Integer.parseInt(value);
		            return currentValue >= 75; // Returns true when 75% or more is reached
		        } catch (NumberFormatException e) {
		            System.err.println("Warning: Could not parse 'aria-valuenow' attribute: " + value);
		            return false;
		        }
		    }

		    
		    @Override
		    public String toString() {
		        return "progress bar to reach at least 75%";
		    }
		};
			
		
			
		driver.findElement(By.xpath("//button[@id='stopButton']")).click();
	
		
	}
	
}
	

