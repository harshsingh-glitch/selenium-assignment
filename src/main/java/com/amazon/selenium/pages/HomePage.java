package com.amazon.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By todaysDeals = By.linkText("Today's Deals");
    private By searchBox = By.id("twotabsearchtextbox");
    private By searchBtn = By.id("nav-search-submit-button");
    private By hamburgerMenu = By.id("nav-hamburger-menu");

    public void openTodaysDeals() {
        driver.findElement(todaysDeals).click();
    }

    public void searchFor(String term) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(term);
        driver.findElement(searchBtn).click();
    }

    public void openHamburgerMenu() {
        driver.findElement(hamburgerMenu).click();
    }
}
