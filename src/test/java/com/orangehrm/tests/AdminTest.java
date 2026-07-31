package com.orangehrm.tests;

import com.orangehrm.utils.WaitUtils;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminTest extends BaseTest {

    @BeforeMethod
    public void navigateToAdmin() {

        performLogin("Admin", "admin123");


        By adminMenu = By.xpath("//a[contains(@href, 'admin')]");
        WaitUtils.waitForElementToBeClickable(getDriver(), adminMenu).click();
    }

    @Test(groups = {"regression"})
    public void testAdminPage() {

    }
}