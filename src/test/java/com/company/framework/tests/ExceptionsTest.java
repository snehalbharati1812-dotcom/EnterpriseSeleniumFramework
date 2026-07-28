package com.company.framework.tests;

import com.company.framework.base.BaseTest;
import com.company.framework.pages.ExceptionsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExceptionsTest extends BaseTest {

    @Test(groups = {"regression"}, description = "Add Element Test")
    public void testAddElement() {
        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);
        exceptionsPage.open();
        exceptionsPage.clickAdd();
        Assert.assertTrue(exceptionsPage.isRow2Displayed());
    }
}