package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecruitmentPage extends BasePage {

    private By vacanciesTab = By.xpath("//a[text()='Vacancies']");
    private By addCandidateButton = By.xpath("//button[contains(.,'Add')]");

    public RecruitmentPage(WebDriver driver) {
        super(driver);
    }

    public void clickVacancies() {
        click(vacanciesTab);
    }

    public void clickAddCandidate() {
        click(addCandidateButton);
    }
}