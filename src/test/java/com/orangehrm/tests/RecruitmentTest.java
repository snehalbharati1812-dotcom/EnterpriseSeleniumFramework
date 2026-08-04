package com.orangehrm.tests;

import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.RecruitmentPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RecruitmentTest extends BaseTest {

    private LoginPage loginPage;
    private RecruitmentPage recruitmentPage;

    @BeforeMethod(alwaysRun = true)
    public void loginBeforeTest() {
        loginPage = new LoginPage(getDriver());
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();

        recruitmentPage = new RecruitmentPage(getDriver());
    }

    @Test(groups = {"regression"})
    public void navigateToRecruitment() {
        recruitmentPage.navigateToRecruitmentMenu();
        boolean isDisplayed = recruitmentPage.isRecruitmentHeaderDisplayed();
        Assert.assertTrue(isDisplayed, "Recruitment page header should be displayed.");
    }
}