package com.automation.base;

import com.automation.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Default to Chrome, can be parameterized
        driver = DriverFactory.createDriver("chrome");
        
        // Open the local login file. 
        // NOTE: In a real CI, this would be a deployed URL. 
        // For this task, we assume we are opening the local file.
        // We'll use absolute path for robustness or relative if we can resolve it.
        String userDir = System.getProperty("user.dir");
        String filePath = "file:///" + userDir.replace("\\", "/") + "/src/main/resources/static/login.html";
        driver.get(filePath);
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
