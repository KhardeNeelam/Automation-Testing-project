package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitExample  {

	public static void main(String[] args) throws InterruptedException{
		ChromeDriver driver = new ChromeDriver();
		
		//Implicit wait-- locate element appliy wait
		//Smart wait. Element is found before 30 sec it will go on next element.
		//max is 200sec no more than that may be 30 to 60 sec
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
		driver.findElement(By.xpath("//button[text()=\"Start\"]")).click();
		boolean flag = driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed();
		System.out.println("Flag--->" +flag);
		
		
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		driver.findElement(By.xpath("//form[@id='checkbox-example']//input")).click();
		driver.findElement(By.xpath("//button[@type='button']")).click();

	}

}
