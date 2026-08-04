package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPage extends BasePage {

    // Locators
    private By adminMenu = By.xpath("//span[text()='Admin']/parent::a");
    private By adminHeader = By.xpath("//h6[normalize-space()='Admin']");
    private By usernameSearchInput = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private By searchButton = By.xpath("//button[normalize-space()='Search']");
    private By userRecordCount = By.xpath("//span[contains(., 'Record Found') or contains(., 'Records Found')]");

    // Constructor
    public AdminPage(WebDriver driver) {
        super(driver);
    }

    // Navigates to the Admin Section
    public void navigateToAdminMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement menuElem = wait.until(ExpectedConditions.elementToBeClickable(adminMenu));
        menuElem.click();
    }

    // Verifies Admin Header Visibility
    public boolean isAdminHeaderDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(adminHeader)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Verifies Search Button Visibility
    public boolean isSearchButtonDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // NEW METHOD: Types username into search box and clicks Search
    public void searchUserByUsername(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameSearchInput));
        input.clear();
        input.sendKeys(username);

        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchBtn.click();
    }

    // NEW METHOD: Checks if search results records count is displayed
    public boolean isRecordFoundDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(userRecordCount)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}