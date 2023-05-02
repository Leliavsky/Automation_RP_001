package business.manager;

import business.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import business.pages.*;

public class PageFactoryManager {
    WebDriver driver;
    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }
    public LoginPage getLoginPage() {
        return new LoginPage(driver);
    }

}