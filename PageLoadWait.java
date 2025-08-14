package tests;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;

public class PageLoadWait {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		//Always keep the limits 60 to 90 sec otherwise tell developer it is too long wait
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");
		System.out.println(driver.getTitle());

	}

}
