package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage extends BasePage {

    private By adminHeader = By.xpath("//h6[contains(@class,'oxd-topbar-header-breadcrumb-module')]");
    private By usernameSearchInput = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private By searchButton = By.xpath("//button[@type='submit']");
    private By resetButton = By.xpath("//button[contains(.,'Reset')]");

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public String getAdminHeaderText() {
        return getText(adminHeader);
    }

    public void searchUser(String username) {
        type(usernameSearchInput, username);
        click(searchButton);
    }

    public void clickReset() {
        click(resetButton);
    }
}