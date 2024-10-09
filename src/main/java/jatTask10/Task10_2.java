package jatTask10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task10_2 {

	public static void main(String[] args) {
		
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 
		 driver.get("https://jqueryui.com/droppable/");
		 
		 
		 WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
         driver.switchTo().frame(iframe);
         
         WebElement sourceElement = driver.findElement(By.id("draggable"));
         WebElement targetElement = driver.findElement(By.id("droppable"));
         
         Actions actions = new Actions(driver);
         actions.dragAndDrop(sourceElement, targetElement).perform();
         
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.attributeToBe(targetElement, "class", "ui-widget-header ui-droppable ui-state-highlight"));

         
         String targetText = targetElement.getText();
         if (targetText.equals("Dropped!")) {
             System.out.println("Drag and drop operation successful. Text changed to: " + targetText);
         } else {
             System.out.println("Drag and drop operation failed.");
         }
         
         driver.quit();         
         
		 

	}

}
