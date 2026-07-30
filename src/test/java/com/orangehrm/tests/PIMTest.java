package com.orangehrm.tests;

import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.WaitUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PIMTest extends BaseTest {

    private By pimMenu = By.xpath("//a[contains(@href, 'pim')] | //span[text()='PIM']");
    private By pimHeader = By.xpath("//h6[text()='PIM']");

    @BeforeMethod(alwaysRun = true)
    public void loginBeforeTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();
    }

    @Test(groups = {"regression"})
    public void navigateToPIM() {
        WaitUtils.waitForClickability(driver, pimMenu).click();
        boolean isDisplayed = WaitUtils.waitForVisibility(driver, pimHeader).isDisplayed();
        Assert.assertTrue(isDisplayed, "PIM page header should be displayed.");
    }
}