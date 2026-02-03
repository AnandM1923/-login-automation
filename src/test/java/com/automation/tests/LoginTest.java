package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.DashboardPage;
import com.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("testuser", "Password123");

        DashboardPage dashboardPage = new DashboardPage(driver);
        String welcomeMsg = dashboardPage.getWelcomeMessage();
        Assert.assertTrue(welcomeMsg.contains("testuser"), "Dashboard should welcome the user");
    }

    @Test
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("wronguser", "wrongpass");

        String errorMsg = loginPage.getErrorMessage();
        Assert.assertEquals(errorMsg, "Invalid username or password.");
    }
}
