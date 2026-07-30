package com.orangehrm.tests;

import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RecruitmentTest extends BaseTest {

    private By recruitmentMenu = By.xpath("//a[contains(@href, 'recruitment')] | //span[text()='Recruitment']");
    private By searchBtn = By.xpath("//button[@type='submit']");
    private By resultContainer = By.xpath("//div[@class='oxd-table-body']");

    @BeforeMethod(alwaysRun = true)
    public void loginBeforeTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();

        WaitUtils.waitForClickability(driver, recruitmentMenu).click();
    }

    @Test(groups = {"regression"})
    public void TC_REC_04_SearchCandidateByStatus() {
        WaitUtils.waitForClickability(driver, searchBtn).click();

        // Wait for results container to render
        WebElement tableContainer = WaitUtils.waitForVisibility(driver, resultContainer);
        Assert.assertNotNull(tableContainer, "Candidate table container should be displayed after search.");
    }
}