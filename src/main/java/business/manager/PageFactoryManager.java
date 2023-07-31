package business.manager;

import business.pages.GmailPage;
import business.pages.LoginPage;
import business.pages.SearchingPage;
import business.pages.WikipediaPage;
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
    public SearchingPage getSearchingPage() {
        return new SearchingPage(driver);
    }
    public WikipediaPage getWikipediaPage(){ return new WikipediaPage(driver);}

}