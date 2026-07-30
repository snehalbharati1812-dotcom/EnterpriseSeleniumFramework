package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMPage extends BasePage {

    private By pimHeader = By.xpath("//h6[contains(@class,'oxd-topbar-header-breadcrumb-module')]");
    private By addEmployeeTab = By.xpath("//a[text()='Add Employee']");
    private By employeeNameInput = By.xpath("(//input[@placeholder='Type for hints...'])[1]");
    private By searchButton = By.xpath("//button[@type='submit']");

    public PIMPage(WebDriver driver) {
        super(driver);
    }

    public String getPIMHeaderText() {
        return getText(pimHeader);
    }

    public void clickAddEmployee() {
        click(addEmployeeTab);
    }

    public void searchEmployee(String name) {
        type(employeeNameInput, name);
        click(searchButton);
    }
}