package org.manager;

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class PageFactoryManager {
    WebDriver driver;
    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }
    public LoginPage getLoginPage() {
        return new LoginPage(driver);
    }

}