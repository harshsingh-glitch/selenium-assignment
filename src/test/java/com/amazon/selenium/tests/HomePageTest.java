package com.amazon.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.amazon.selenium.pages.HomePage;
import com.amazon.selenium.pages.ProductPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class HomePageTest extends BaseTest {

       @Test(priority = 1)
    public void searchMobilesAndGetLastItem() {
        HomePage home = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Step 1: Search for “Mobiles”
        home.searchFor("Mobiles");

        // Step 2: Wait for title to contain keyword
        wait.until(ExpectedConditions.titleContains("Mobiles"));

        // Step 3: Assert the search results are loaded
        Assert.assertTrue(driver.getTitle().contains("Mobiles"), "Search for Mobiles successful");
    }
}
