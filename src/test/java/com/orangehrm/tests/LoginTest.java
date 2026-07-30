package com.orangehrm.tests;

import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void TC_LOGIN_01_ValidLogin() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();

        DashboardPage dashboardPage = new DashboardPage(getDriver());
        Assert.assertTrue(dashboardPage.isDashboardHeaderDisplayed(), "Dashboard header should be displayed on valid login.");
    }

    @Test(priority = 2)
    public void TC_LOGIN_02_InvalidUsername() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterUsername("InvalidAdmin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();

        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualMessage, "Invalid credentials", "Error message should display for invalid username.");
    }

    @Test(priority = 3)
    public void TC_LOGIN_03_InvalidPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("WrongPassword123");
        loginPage.clickLogin();

        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualMessage, "Invalid credentials", "Error message should display for invalid password.");
    }

    @Test(priority = 4)
    public void TC_LOGIN_04_EmptyCredentials() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickLogin();

        // Verifying mandatory field input warnings if present
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "User should remain on login page when submitting empty credentials.");
    }

    @Test(priority = 5)
    public void TC_LOGIN_05_ForgotPasswordNavigation() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickForgotPassword();

        String currentUrl = getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("requestPasswordResetCode"), "User should be navigated to Forgot Password page.");
    }
}