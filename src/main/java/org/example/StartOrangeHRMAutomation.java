package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StartOrangeHRMAutomation {
    public static void main(String[] args) {
        System.out.println("Hello this is the automation testing using java");

        WebDriver driver = new ChromeDriver(); // This is used to select the web browser

        driver.manage().window().maximize(); //This is used to maximize the screen or the window

        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        //This helps for the web driver to wait still the explanition left or unlearned

        driver.get("https://opensource-demo.orangehrmlive.com/"); // The link of the webpage which we are perrforming testing on

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        //This will wait until the element username visible

        driver.findElement(By.name("username")).sendKeys("Adam");
        driver.findElement(By.name("password")).sendKeys("adam123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));

        System.out.println("Login Successful");

        //Click on PIM
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='PIM']")));
        driver.findElement(By.xpath("//span[text()='PIM']")).click();

        //Click on add employee
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add Employee']")));
        driver.findElement(By.xpath("//a[text()='Add Employee']")).click();

        //Add employee details
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));

        driver.findElement(By.name("firstName")).sendKeys("Ayush");
        driver.findElement(By.name("lastName")).sendKeys("Dere");

        // Click Save
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Wait for navigation
        wait.until(ExpectedConditions.urlContains("viewPersonalDetails"));

        System.out.println("Employee Added Successfully");
    }
}
