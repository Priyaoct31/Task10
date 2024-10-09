package jatTask10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task10_1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/datepicker/");
		
		WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
		
        driver.switchTo().frame(iframe);
        
        WebElement datepicker = driver.findElement(By.id("datepicker"));
        
        datepicker.click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ui-datepicker-next")));
        nextButton.click();
		
        WebElement dateToSelect = driver.findElement(By.xpath("//a[text()='22']"));
        dateToSelect.click();
        
        String selectedDate = datepicker.getAttribute("value");
        
        System.out.println("Selected date is: " + selectedDate);
        
        driver.quit();

	}

}
