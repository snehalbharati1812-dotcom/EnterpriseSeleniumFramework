package com.orangehrm.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    private static final String BASE_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        ChromeOptions options = new ChromeOptions();

        // PAGE LOAD STRATEGY: NORMAL ठेवली आहे जेणेकरून डोम पूर्ण लोड होईल
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-gpu");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);

        // implicit wait 0 ठेवून फक्त Explicit Waits वापरल्याने Timeout चे इश्यू टाळता येतात
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        driver.get(BASE_URL);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void performLogin(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // १. पेज योग्य URL वर असल्याची खात्री करा
        if (!driver.getCurrentUrl().contains("/auth/login")) {
            driver.get(BASE_URL);
        }

        // २. Username फिल्ड पूर्णपणे Visible आणि Enabled होण्याची वाट पाहा
        WebElement usernameField = wait.until(
                ExpectedConditions.elementToBeClickable(By.name("username"))
        );
        usernameField.clear();
        usernameField.sendKeys(username);

        // ३. Password टाकणे
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.clear();
        passwordField.sendKeys(password);

        // ४. Login बटणावर क्लिक करणे
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // ५. Dashboard Load होईपर्यंत Wait करा
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Dashboard']")));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}