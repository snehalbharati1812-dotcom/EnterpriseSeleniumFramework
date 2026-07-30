package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeavePage extends BasePage {

    private By applyTab = By.xpath("//a[text()='Apply']");
    private By myLeaveTab = By.xpath("//a[text()='My Leave']");

    public LeavePage(WebDriver driver) {
        super(driver);
    }

    public void clickApply() {
        click(applyTab);
    }

    public void clickMyLeave() {
        click(myLeaveTab);
    }
}