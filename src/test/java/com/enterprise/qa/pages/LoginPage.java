package com.enterprise.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // BUG 2: Fragile absolute XPaths that break easily with minor DOM shifts
    private By usernameInput = By.xpath("/html/body/div[2]/div/div/div/div/form/div[1]/input");
    private By passwordInput = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input");
    private By loginButton = By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");

    // BUG 3: Wrong/invalid XPath for the post-login dashboard assertion element
    private By dashboardHeader = By.xpath("//h6[text()='InvalidDashboardTitle']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openApplication() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // BUG 4: Flaky hardcoded sleep instead of dynamic explicit waits
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isDashboardDisplayed() {
        return driver.findElement(dashboardHeader).isDisplayed();
    }
}