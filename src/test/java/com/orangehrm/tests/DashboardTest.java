package com.orangehrm.tests;

import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    // 1. Declare dashboardPage variable here
    private DashboardPage dashboardPage;

    @BeforeMethod(alwaysRun = true)
    public void login() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();
        dashboardPage = new DashboardPage(getDriver());
    }

    @Test(priority = 1)
    public void TC_DASH_01_VerifyDashboardHeader() {
        boolean isHeaderDisplayed = dashboardPage.isDashboardHeaderDisplayed();
        Assert.assertTrue(isHeaderDisplayed, "Dashboard header should be displayed.");
    }

    @Test(priority = 2)
    public void TC_DASH_06_VerifyLogoutFunctionality() {
        dashboardPage.clickUserProfile();
        dashboardPage.clickLogout(); // Calling method without assignment if void

        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "User should be redirected to login page.");
    }
}