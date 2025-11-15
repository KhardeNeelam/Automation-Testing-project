package mytestng.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utilities.Browserutil;
/**
 * This class demonstrates various mouse operations using Selenium's Actions class and TestNG tests.
 * Each test method shows how to handle different scenarios like draggable, droppable, resizable, selectable, and sortable elements.
 */
public class RobotClassExampleMouseOperations {
	/**
	 * Disabled test: Demonstrates drag and drop using Actions by offset coordinates.
	 * Navigates to a draggable demo, switches to the iframe, performs a drag, then resets context.
	 */
	@Test(enabled =false)
	public void test1() throws InterruptedException {
		// Set up Chrome driver and navigate to draggable demo page
		//Actions class to Drag and drop feature
		RemoteWebDriver driver = Browserutil.getDriver("chrome");
		
		driver.get("https://jqueryui.com/draggable/");
		// Switch to the iframe containing the draggable element
		//iframe is used do switch inside the frame
		driver.switchTo().frame(0);
		WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']/p"));
		System.out.println(draggable.toString());
		Thread.sleep(5000);
		// Create Actions to perform drag-and-drop by offset (100, 50)
		//initiate the Actions.
		Actions actions = new Actions(driver);
		//From target location to drag at 100, 50 location)
		actions.dragAndDropBy(draggable, 100, 50).build().perform();
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
		
	}
	/**
	 * Disabled test: Drag and drop source element to target element inside an iframe.
	 * Used for droppable demo on jQuery UI.
	 */
	@Test(enabled =false)
	public void test2() throws InterruptedException {
		// Set up Chrome driver and navigate to droppable demo page
		//Actions class to Drag and drop to target location
		RemoteWebDriver driver = Browserutil.getDriver("chrome");
		driver.get("https://jqueryui.com/droppable/");
		// Switch to iframe
		//iframe is used do switch inside the frame
		driver.switchTo().frame(0);
		WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']/p"));
		System.out.println(draggable.toString());
		WebElement droppable = driver.findElement(By.xpath("//div[@id='droppable']/p"));
		Thread.sleep(5000);
		//initiate the Actions.
		Actions actions = new Actions(driver);
		//From target location to drag at 100, 50 location)
		actions.dragAndDrop(draggable, droppable).build().perform();
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
		
	}
	/**
	 * Disabled test: Demonstrates resizing a UI element inside an iframe.
	 * Uses explicit WebDriverWait for the resize handle to appear.
	 */
	@Test(enabled =false)
	public void test3() throws InterruptedException {
		
		//Actions class to resizable iframe
		RemoteWebDriver driver = Browserutil.getDriver("chrome");
		//driver.get("https://jqueryui.com/resources/demos/resizable/default.html");
		driver.get("https://jqueryui.com/resizable/");
		//iframe is used do switch inside the frame
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		
		WebElement resize = driver.findElement(By.xpath("//div[@id='resizable']"));
		// Wait for the resize handle to be present
		//System.out.println(resize.getSize());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement resizeHandle = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#resizable .ui-resizable-se")));
		System.out.println(resizeHandle.getSize());
		Actions actions = new Actions(driver);
		
		Thread.sleep(5000);
		// Drag the resize handle by (0, -50) pixels
		actions.dragAndDropBy(resizeHandle, 0, -50).build().perform();
		
			
	}
	/**
	 * Disabled test: Demonstrates multi-item selection by click-and-drag in a selectable list.
	 * Also prints out which items are selected.
	 */
	@Test(enabled =false)
	public void test4() throws InterruptedException {
		
		//Actions class to resizable iframe
		RemoteWebDriver driver = Browserutil.getDriver("chrome");
		driver.get("https://jqueryui.com//resources/demos/selectable/default.html");
		//driver.get("https://jqueryui.com/selectable/");
		//iframe is used do switch inside the frame
		Thread.sleep(5000);
		//driver.switchTo().frame(0);
		
		WebElement selectable = driver.findElement(By.xpath("//ol[@class='ui-selectable']"));
		System.out.println(selectable.toString());
		
		List<WebElement> items = driver.findElements(By.cssSelector("#selectable li"));
        System.out.println("Total selectable items: " + items.size());
		// Create an Actions object
        // 4. Create an Actions object
        Actions actions = new Actions(driver);
		// Draw a box from Item 1 to Item 4 to select them
        // Scenario 1: Draw a box to select multiple adjacent items (e.g., Item 1 to Item 4)
        System.out.println("Performing drag-selection from Item 1 to Item 4...");
        WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
        WebElement item4 = driver.findElement(By.xpath("//li[text()='Item 4']"));
	
        // Click and hold on the first item, then move to the last item and release
        actions.clickAndHold(item1).moveToElement(item4).release().build().perform();

        Thread.sleep(2000); // Wait to observe the selection
		// Print selected status for each item
        // Verify selection (optional)
        System.out.println("Checking selected status after drag-selection:");
        for (int i = 0; i < items.size(); i++) {
            WebElement item = items.get(i);
            // Check if the item has the 'ui-selected' class
            if (item.getAttribute("class").contains("ui-selected")) {
                System.out.println("Item " + (i + 1) + " is selected.");
            } else {
                System.out.println("Item " + (i + 1) + " is NOT selected.");
            }
        }
        Thread.sleep(2000); // Give time to read output

        driver.switchTo().defaultContent(); // Switch back to main content before closing
        driver.quit();
    }
	/**
	 * Enabled test: Demonstrates drag-and-drop reordering in a sortable list.
	 * Drags 'Item 1' to after 'Item 5' and prints the initial and new order of items.
	 */
	@Test(enabled =true)
	public void test5() throws InterruptedException {
		
		//Actions class to resizable iframe
		RemoteWebDriver driver = Browserutil.getDriver("chrome");
		//driver.get("https://jqueryui.com/resources/demos/sortable/default.html");
		driver.get("https://jqueryui.com/sortable/");
		//iframe is used do switch inside the frame
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		
		//WebElement selectable = driver.findElement(By.xpath("//ol[@class='ui-selectable']"));
		//System.out.println(selectable.toString());
		// Get the list items to sort and print initial order
		List<WebElement> items = driver.findElements(By.cssSelector("#selectable li"));
        System.out.println("Total selectable items: " + items.size());
        // Print the initial order
		// 4. Create an Actions object
        System.out.println("Initial order of items:");
        items.forEach(item -> System.out.println(item.getText()));
		 // Select the item to be dragged and target
        // Choose the item to drag (e.g., "Item 1")
        WebElement itemToDrag = driver.findElement(By.xpath("//li[text()='Item 1']"));

        System.out.println(itemToDrag.toString());
        // Choose the target location or a reference item.
        // For example, let's drag "Item 1" to be after "Item 5".
        WebElement targetItem = driver.findElement(By.xpath("//li[text()='Item 5']"));
        System.out.println(targetItem.toString());
        // 3. Create an Actions object
        
        Actions actions = new Actions(driver);

        // 4. Perform the drag and drop to reorder
        System.out.println("\nDragging 'Item 1' to the position after 'Item 5'...");

        // Method 1: Using dragAndDrop(source, target)
        // This is generally the most straightforward for sortable lists.
        // It drags the source element and drops it onto the target element's position.
        try {
            // Give a very slight pause before the drag, sometimes helps with JS initialization
            Thread.sleep(500);

            actions.dragAndDrop(itemToDrag, targetItem)
                   .build()
                   .perform();

            System.out.println("Drag and drop action performed.");
            Thread.sleep(3000); // Longer pause to observe the change
        } catch (Exception e) {
            System.err.println("An error occurred during drag and drop: " + e.getMessage());
            e.printStackTrace();
        }   
        
        
        
        List<WebElement> newOrderItems = driver.findElements(By.cssSelector("#sortable li"));
        newOrderItems.forEach(item -> System.out.println(item.getText()));
	}
}

