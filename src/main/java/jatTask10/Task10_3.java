package jatTask10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class Task10_3 {

public static void main(String[] args) {
        
       
	// Initialize WebDriver
    WebDriver driver = new ChromeDriver();

    try {
        // Step 1: Launch the website
        driver.get("https://www.guvi.in/");
        
      
     
        WebElement signupButton = driver.findElement(By.xpath("//a[contains(text(), 'Sign Up')]")); // Adjust XPath
        
      
        signupButton.click();

        // Step 3: Fill in the signup form
        WebElement nameField = driver.findElement(By.name("name")); // Adjust name attribute
        WebElement emailField = driver.findElement(By.name("email")); // Adjust name attribute
        WebElement passwordField = driver.findElement(By.name("password")); // Adjust name attribute
        
        nameField.sendKeys("Dummy User");
        emailField.sendKeys("dummyuser@example.com");
        passwordField.sendKeys("DummyPassword123");

        // Step 4: Click on the "Signup" button to submit  form
        WebElement signupSubmitButton = driver.findElement(By.xpath("//button[contains(text(), 'Sign Up')]")); // Adjust as needed
        signupSubmitButton.click();

        // Step 5: Wait for the page to load and verify registration
        Thread.sleep(5000); // Wait for 5 seconds (replace with explicit wait if needed)
        assert driver.getPageSource().contains("Registration successful"); // Adjust based on actual message

        // Step 6: Locate the Login button and click it
        WebElement loginButton = driver.findElement(By.xpath("//a[contains(text(), 'Login')]")); // Adjust as needed
        loginButton.click();

        // Step 7: Fill in the login form
        WebElement emailLoginField = driver.findElement(By.name("email")); // Adjust name attribute
        WebElement passwordLoginField = driver.findElement(By.name("password")); // Adjust name attribute
        
        emailLoginField.sendKeys("dummyuser@example.com");
        passwordLoginField.sendKeys("DummyPassword123");

        // Step 8: Click on the "Login" button to submit the form
        WebElement loginSubmitButton = driver.findElement(By.xpath("//button[contains(text(), 'Login')]")); // Adjust as needed
        loginSubmitButton.click();

        // Step 9: Wait for the page to load and verify login
        Thread.sleep(5000); // Wait for 5 seconds (replace with explicit wait if needed)
        assert driver.getPageSource().contains("Welcome"); // Adjust based on actual message or element

        System.out.println("Signup and login process completed successfully.");

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // Step 10: Close the browser
        driver.quit();
    }
}
}