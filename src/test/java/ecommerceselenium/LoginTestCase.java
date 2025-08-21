package ecommerceselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTestCase  {
    public static void main(String[] args) {
        //maximize the window using ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        //launch the browser and ecommerce site
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://automationpractice.pl");
        By signInLocator = By.className("login");
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(signInLocator));
        signInButton.click();

        //Test Case 1:Login With invalid user credentials

        System.out.println("\n=== Test Case 1:Login With invalid user credentials ===");
        //Locate the email locator and add email that is not registered
        WebElement email = null;
        WebElement password;
        try {
            By EmailLocator = By.id("email");
            email = wait.until(ExpectedConditions.elementToBeClickable(EmailLocator));
            email.sendKeys("shrutib2395@gmail.com");
            //Locate the password locator and add email that is not registered
            By passwordLocator = By.id("passwd");
            password = wait.until(ExpectedConditions.elementToBeClickable(passwordLocator));
            password.click();
            password.sendKeys("shrutib2395");
            By submitLocator = By.cssSelector("button[id='SubmitLogin'] span");
            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(submitLocator));
            submitButton.click();
            By errorMessageLocator = By.xpath("//li[normalize-space()='Authentication failed.']");
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
            System.out.println("✅Incorrect Credentials :" + errorMessage.getText());
        } catch (Exception e) {
            System.out.println("Error in Test Case 1: " + e.getMessage());
        }
    }



}
