package com.company.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExceptionsPage {
    private WebDriver driver;

    private By addButton = By.id("add_btn");
    private By row2Input = By.xpath("//div[@id='row2']/input");

    public ExceptionsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
    }

    public void clickAdd() {
        driver.findElement(addButton).click();
    }

    public boolean isRow2Displayed() {
        return driver.findElement(row2Input).isDisplayed();
    }
}