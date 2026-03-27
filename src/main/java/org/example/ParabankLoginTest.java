package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ParabankLoginTest {
    public static void main(String[] args) {
        System.out.println("Hello welcome to automation testing project");

        WebDriver driver = new ChromeDriver(); //Declaring which web browser to use

        driver.manage().window().maximize();// making the screen fullscreen

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://parabank.parasoft.com/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

        driver.findElement(By.name("username")).sendKeys("john");
        driver.findElement(By.name("password")).sendKeys("demo");

        driver.findElement(By.xpath("//input[@value='Log In']")).click();


        // LOGIN VALIDATION
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("accountTable")
        ));

        System.out.println("Login Successful");

// WAIT MENU PANEL
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("leftPanel")
        ));

// CLICK OPEN NEW ACCOUNT
        driver.findElement(By.xpath("//a[text()='Open New Account']")).click();

// CLICK OPEN ACCOUNT BUTTON
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@value='Open New Account']")
        ));
        driver.findElement(By.xpath("//input[@value='Open New Account']")).click();


        System.out.println("Account Opened Successfully");

        //Transfer funds clickable link
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Transfer Funds")));
        driver.findElement(By.linkText("Transfer Funds")).click();

        //Enter Amount
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount")));
        driver.findElement(By.id("amount")).sendKeys("50");

        //Transfer Button click
        driver.findElement(By.xpath("//input[@value='Transfer']")).click();

        System.out.println("Funds Transferred Successfully");
        driver.findElement(By.linkText("Log Out")).click();

        System.out.println("Logout Successful");
    }
}
