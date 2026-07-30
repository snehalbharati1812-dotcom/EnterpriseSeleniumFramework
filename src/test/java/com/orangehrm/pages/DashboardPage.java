package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    private By header = By.xpath("//h6[text()='Dashboard']");
    private By userProfileDropdown = By.className("oxd-userdropdown-tab");
    private By logoutLink = By.xpath("//a[text()='Logout']");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDashboardHeaderDisplayed() {
        try {
            return driver.findElement(header).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickUserProfile() {
        driver.findElement(userProfileDropdown).click();
    }

    public void clickLogout() {
        driver.findElement(logoutLink).click();
    }
}