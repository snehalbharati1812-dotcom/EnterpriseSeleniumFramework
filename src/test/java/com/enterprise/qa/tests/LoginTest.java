package com.enterprise.qa.tests;

import com.enterprise.qa.base.BaseTest;
import com.enterprise.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testUserLoginWithBugs() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.openApplication();
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();

        // Will throw NoSuchElementException / Assertion failure
        Assert.assertTrue(loginPage.isDashboardDisplayed(), "Dashboard header was not displayed!");
    }
}