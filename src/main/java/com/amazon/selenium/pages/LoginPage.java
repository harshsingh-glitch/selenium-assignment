package com.amazon.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By accountMenu = By.id("nav-link-accountList");
    private By emailField = By.id("ap_email_login");
    private By continueBtn = By.id("continue");
    private By passwordField = By.id("ap_password");
    private By signInBtn = By.id("signInSubmit");

    public void signIn(String username, String password) {
        driver.findElement(accountMenu).click();
        driver.findElement(emailField).sendKeys(username);
        driver.findElement(continueBtn).click();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInBtn).click();
    }
}
