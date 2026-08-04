package com.orangehrm.tests;

import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @BeforeMethod(alwaysRun = true)
    public void loginBeforeTest() {
        loginPage = new LoginPage(getDriver());
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        dashboardPage = loginPage.clickLogin();
    }

    @Test(priority = 1, groups = {"smoke", "regression"})
    public void verifyDashboardHeader() {
        boolean isHeaderDisplayed = dashboardPage.isDashboardHeaderDisplayed();
        Assert.assertTrue(isHeaderDisplayed, "Dashboard header should be displayed.");
    }

    @Test(priority = 2, groups = {"smoke", "regression"})
    public void verifyLogout() {
        dashboardPage.clickUserProfile();
        dashboardPage.clickLogout();

        // Instantiate fresh LoginPage instance post-logout to evaluate redirected URL/elements
        LoginPage postLogoutLoginPage = new LoginPage(getDriver());
        boolean isLoginPageDisplayed = postLogoutLoginPage.isLoginPageDisplayed();

        Assert.assertTrue(isLoginPageDisplayed, "User should be redirected to Login page after logout.");
    }
}