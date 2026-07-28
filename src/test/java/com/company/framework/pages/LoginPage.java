package com.company.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By submitButton = By.id("submit");
    private By successHeader = By.className("post-title");
    private By errorMessage = By.id("error");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();
    }

    public String getSuccessText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(successHeader));
        return header.getText();
    }

    public String getErrorText() {
        // Explicitly wait up to 10 seconds for the error message element to appear on screen
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElem = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return errorElem.getText();
    }
}