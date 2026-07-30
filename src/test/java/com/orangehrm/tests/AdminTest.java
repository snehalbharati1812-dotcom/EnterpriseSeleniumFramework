package com.orangehrm.tests;

import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.WaitUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminTest extends BaseTest {

    private By adminMenu = By.xpath("//a[contains(@href, 'admin')] | //span[text()='Admin']");
    private By adminHeader = By.xpath("//h6[contains(., 'Admin')]");

    @BeforeMethod(alwaysRun = true)
    public void loginBeforeTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();
    }

    @Test(groups = {"regression"})
    public void navigateToAdmin() {
        WaitUtils.waitForClickability(driver, adminMenu).click();
        boolean isDisplayed = WaitUtils.waitForVisibility(driver, adminHeader).isDisplayed();
        Assert.assertTrue(isDisplayed, "Admin page header should be displayed.");
    }
}