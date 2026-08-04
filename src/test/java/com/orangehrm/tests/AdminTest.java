package com.orangehrm.tests;

import com.orangehrm.pages.AdminPage;
import com.orangehrm.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminTest extends BaseTest {

    private AdminPage adminPage;

    @BeforeMethod
    public void navigateToAdmin() {
        // 1. Perform login with admin credentials
        performLogin("Admin", "admin123");

        // 2. Initialize Page Object
        adminPage = new AdminPage(getDriver());

        // 3. Navigate to Admin page using Page Object method
        adminPage.navigateToAdminMenu();
    }

    /**
     * Test Case 1: Verify Admin Page Header and Elements Displayed
     */
    @Test(groups = {"regression", "smoke"}, description = "Verify Admin header and basic UI controls load successfully")
    public void testAdminPage() {
        // Verify Admin Header is visible
        boolean isHeaderDisplayed = adminPage.isAdminHeaderDisplayed();
        Assert.assertTrue(isHeaderDisplayed, "FAILURE: Admin header was not displayed on the page!");

        // Verify Search Button is visible
        boolean isSearchBtnDisplayed = adminPage.isSearchButtonDisplayed();
        Assert.assertTrue(isSearchBtnDisplayed, "FAILURE: Search button was not displayed on Admin page!");
    }

    /**
     * Test Case 2: Verify Searching for Existing User
     */
    @Test(groups = {"regression"}, description = "Verify searching for an existing username returns results in the user table")
    public void testSearchExistingUser() {
        // Search for existing 'Admin' user
        adminPage.searchUserByUsername("Admin");

        // Verify matching record is found in the results table
        boolean isRecordFound = adminPage.isRecordFoundDisplayed();
        Assert.assertTrue(isRecordFound, "FAILURE: Search results table did not display any records for user 'Admin'!");
    }
}