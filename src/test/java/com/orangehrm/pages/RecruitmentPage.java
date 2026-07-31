package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RecruitmentPage extends BasePage {

    private By recruitmentMenu = By.xpath("//a[contains(@href, 'recruitment')]");
    private By recruitmentHeader = By.xpath("//h6[contains(@class,'oxd-topbar-header-breadcrumb')]");

    public RecruitmentPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToRecruitmentMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(recruitmentMenu)).click();
    }

    public boolean isRecruitmentHeaderDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(recruitmentHeader)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}