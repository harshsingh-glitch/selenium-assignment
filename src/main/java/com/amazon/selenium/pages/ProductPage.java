package com.amazon.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class ProductPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By dealItems = By.cssSelector("div[data-csa-c-type='item']");
    private By addToCartButton = By.id("add-to-cart-button");
    private By cartCount = By.id("nav-cart-count");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Select the 3rd deal from Today's Deals list
    public void selectThirdDeal() {
        List<WebElement> deals = driver.findElements(dealItems);
        if (deals.size() >= 3) {
            deals.get(2).click();
        } else {
            throw new RuntimeException("Less than 3 deals available on the page!");
        }
    }

    // Click on Add to Cart
    public void addToCart() {
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addButton.click();
    }

    // Verify cart count
    public String getCartCount() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartCount)).getText();
    }
}
