package com.orangehrm.tests;

import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void TC_LOGIN_01_ValidLogin() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        DashboardPage dashboardPage = loginPage.clickLogin();
        Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard should be displayed after valid login");
    }

    @Test
    public void TC_LOGIN_02_InvalidUsername() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterUsername("InvalidUser");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed for invalid username");
    }

    @Test
    public void TC_LOGIN_03_InvalidPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("WrongPass");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed for invalid password");
    }

    @Test
    public void TC_LOGIN_04_EmptyCredentials() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.isRequiredFieldErrorDisplayed(), "Required warning should be displayed");
    }

    @Test
    public void TC_LOGIN_05_ForgotPasswordNavigation() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickForgotPassword();
        Assert.assertTrue(loginPage.isResetPasswordPageDisplayed(), "Reset Password page should be displayed");
    }
}