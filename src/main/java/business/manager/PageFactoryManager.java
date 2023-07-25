package business.manager;

import business.pages.GmailPage;
import business.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class PageFactoryManager {
    WebDriver driver;
    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }
    public LoginPage getLoginPage() {
        return new LoginPage(driver);
    }
    public GmailPage getGmailPage() {
        return new GmailPage(driver);
    }

}