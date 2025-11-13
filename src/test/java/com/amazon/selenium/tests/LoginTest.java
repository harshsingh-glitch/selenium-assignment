package com.amazon.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.amazon.selenium.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(priority = 3)
    public void testLogin() {
        LoginPage login = new LoginPage(driver);
        login.signIn(config.get("username"), config.get("password"));
    }
}
