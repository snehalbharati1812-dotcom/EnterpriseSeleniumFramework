package com.orangehrm.tests;

import com.orangehrm.utils.WaitUtils;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LeaveTest extends BaseTest {

    @BeforeMethod
    public void loginBeforeTest() {
        // १. आधी लॉगिन करा
        performLogin("Admin", "admin123");


        By leaveMenu = By.xpath("//a[contains(@href, 'leave')]");
        WaitUtils.waitForElementToBeClickable(getDriver(), leaveMenu).click();
    }

    @Test(groups = {"regression"})
    public void testLeavePage() {

    }
}