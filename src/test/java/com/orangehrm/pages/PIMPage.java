package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PIMPage extends BasePage {
    private By pimMenu = By.xpath("//a[contains(@href, 'pim')]");
    private By pimHeader = By.xpath("//h6[contains(@class,'oxd-topbar-header-breadcrumb')]");

    public PIMPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToPIMMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(pimMenu)).click();
    }

    public boolean isPIMHeaderDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(pimHeader)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}