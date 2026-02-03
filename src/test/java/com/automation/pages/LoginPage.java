package com.automation.pages;

import com.automation.utils.ActionUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    private ActionUtils actionUtils;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-btn")
    private WebElement loginButton;

    @FindBy(id = "error-msg")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.actionUtils = new ActionUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        actionUtils.sendKeys(usernameInput, username);
        actionUtils.sendKeys(passwordInput, password);
        actionUtils.click(loginButton);
    }

    public String getErrorMessage() {
        actionUtils.waitForVisibility(errorMessage);
        return errorMessage.getText();
    }
}
