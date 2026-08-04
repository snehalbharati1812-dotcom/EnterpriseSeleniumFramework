package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LeavePage extends BasePage {

    // Locators for Leave module
    private By leaveMenu = By.xpath("//a[contains(@href, 'leave')]");
    private By leaveHeader = By.xpath("//h6[contains(@class,'oxd-topbar-header-breadcrumb')]");

    public LeavePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToLeaveMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(leaveMenu)).click();
    }

    public boolean isLeaveHeaderDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(leaveHeader)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}