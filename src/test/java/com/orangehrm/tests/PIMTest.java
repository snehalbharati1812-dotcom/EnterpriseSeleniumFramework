package com.orangehrm.tests;

import com.orangehrm.utils.WaitUtils;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PIMTest extends BaseTest {

    @BeforeMethod
    public void loginBeforeTest() {

        performLogin("Admin", "admin123");


        By pimMenu = By.xpath("//a[contains(@href, 'pim')]");
        WaitUtils.waitForElementToBeClickable(getDriver(), pimMenu).click();
    }

    @Test(groups = {"regression"})
    public void testPIMPage() {

    }
}