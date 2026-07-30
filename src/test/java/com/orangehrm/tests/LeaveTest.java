package com.orangehrm.tests;

import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.WaitUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LeaveTest extends BaseTest {

    private By leaveMenu = By.xpath("//a[contains(@href, 'leave')] | //span[text()='Leave']");
    private By leaveHeader = By.xpath("//h6[contains(., 'Leave')]");

    @BeforeMethod(alwaysRun = true)
    public void loginBeforeTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();
    }

    @Test(groups = {"regression"})
    public void navigateToLeave() {
        WaitUtils.waitForClickability(driver, leaveMenu).click();
        boolean isDisplayed = WaitUtils.waitForVisibility(driver, leaveHeader).isDisplayed();
        Assert.assertTrue(isDisplayed, "Leave page header should be displayed.");
    }
}