package com.automation.pages;

import com.automation.utils.ActionUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    private WebDriver driver;
    private ActionUtils actionUtils;

    @FindBy(id = "welcome-msg")
    private WebElement welcomeMessage;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.actionUtils = new ActionUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public String getWelcomeMessage() {
        actionUtils.waitForVisibility(welcomeMessage);
        return welcomeMessage.getText();
    }
}
