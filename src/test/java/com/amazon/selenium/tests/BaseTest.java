package com.amazon.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.amazon.selenium.utils.ConfigReader;
import com.amazon.selenium.utils.ScreenshotUtils;
import com.amazon.selenium.utils.WebDriverFactory;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected ConfigReader config;

    @BeforeClass
    public void setUp() {
        config = new ConfigReader();
        String browser = config.get("browser");
        driver = WebDriverFactory.createDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(config.get("timeout"))));
        driver.get(config.get("url"));
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            ScreenshotUtils.capture(driver, result.getName());
        }
    }

    @AfterClass
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
