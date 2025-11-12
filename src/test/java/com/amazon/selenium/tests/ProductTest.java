package com.amazon.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.amazon.selenium.pages.HomePage;
import com.amazon.selenium.pages.ProductPage;

public class ProductTest extends BaseTest {

    @Test(priority = 4)
    public void verifyDealNavigation() {
        HomePage home = new HomePage(driver);
        ProductPage product = new ProductPage(driver);

        home.openTodaysDeals();
        product.selectThirdDeal();
        Assert.assertTrue(driver.getCurrentUrl().contains("deal"), "Deal page loaded");
    }
}
