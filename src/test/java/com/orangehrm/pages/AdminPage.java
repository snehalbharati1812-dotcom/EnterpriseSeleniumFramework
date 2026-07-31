package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPage extends BasePage {

    // Using normalize-space() to prevent whitespace/formatting locator mismatches
    private By adminMenu = By.xpath("//span[text()='Admin']/parent::a");
    private By adminHeader = By.xpath("//h6[normalize-space()='Admin']");

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToAdminMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement menuElem = wait.until(ExpectedConditions.elementToBeClickable(adminMenu));
        menuElem.click();
    }

    public boolean isAdminHeaderDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(adminHeader)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}