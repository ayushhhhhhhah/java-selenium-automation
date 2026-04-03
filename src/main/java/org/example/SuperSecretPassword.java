package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SuperSecretPassword {

    static WebDriver driver;

    public static void main(String[] args) {

        setup();

        // Positive test
        login("tomsmith", "SuperSecretPassword!");

        // Negative test
        login("wronguser", "wrongpass");

        closeBrowser();
    }

    // Open browser
    public static void setup() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
    }

    // Login function
    public static void login(String user, String pass) {

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));

        username.clear();
        password.clear();

        username.sendKeys(user);
        password.sendKeys(pass);
        loginBtn.click();

        // Check result
        String message = driver.findElement(By.id("flash")).getText();

        if (message.contains("You logged into a secure area!")) {
            System.out.println("Login Successful ✅");
        } else {
            System.out.println("Login Failed ❌");
        }
    }

    // Close browser
    public static void closeBrowser() {
        driver.quit();
    }
}