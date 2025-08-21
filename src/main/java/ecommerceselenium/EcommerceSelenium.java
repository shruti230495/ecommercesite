package ecommerceselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EcommerceSelenium {
    public static void main(String[] args){
        //maximize the window using ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        //launch the browser and ecommerce site
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://automationpractice.pl");
    }
}
