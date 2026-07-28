package com.company.framework.tests;

import com.company.framework.base.BaseTest;
import com.company.framework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(groups = {"smoke", "regression"}, description = "Valid Login Test")
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("student", "Password123");
        Assert.assertEquals(loginPage.getSuccessText(), "Logged In Successfully");
    }

    @Test(groups = {"regression"}, description = "Invalid Username Login Test")
    public void testInvalidUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("wrongUser", "Password123");
        Assert.assertEquals(loginPage.getErrorText(), "Your username is invalid!");
    }
}