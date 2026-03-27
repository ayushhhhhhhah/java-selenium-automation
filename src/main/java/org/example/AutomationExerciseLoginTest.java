package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class AutomationExerciseLoginTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://automationexercise.com/");

        // Click Signup/Login
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@href='/login']")
        ));
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        // Enter Login Credentials
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@data-qa='login-email']")
        ));

        driver.findElement(By.xpath("//input[@data-qa='login-email']"))
                .sendKeys("testautomation123@gmail.com");

        driver.findElement(By.xpath("//input[@data-qa='login-password']"))
                .sendKeys("test123");

        // Wait login button clickable
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@data-qa='login-button']")
        ));

        // Normal Click (No JS)
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        // Validate login success
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(text(),'Logged in as')]")
        ));

        System.out.println("Login Successful");

        driver.quit();
    }
}