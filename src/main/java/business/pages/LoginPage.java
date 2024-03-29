package business.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openLoginPage(String url) {
        driver.get(url);
    }

    @FindBy(xpath = "//input[@type='email']")
    private WebElement loginLine;

    @FindBy(xpath = "//*[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 qIypjc TrZEUc lw1w4b']")
    private WebElement nextButton;
    @FindBy(xpath = "//input[@name='Passwd']")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@class='gb_Od']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class='gb_z gb_A'][1]")
    private WebElement gmailButton;

    @FindBy(xpath = "//div[@class='OyEIQ uSvLId']//div[@jsname='B34EJ']")
    private WebElement incorrectPasswordField;//textarea[@class='gLFyf']

    @FindBy(xpath = "//textarea[@class='gLFyf']")
    private WebElement searchingField;//div[@id='jZ2SBf']

    @FindBy(xpath = "//div[@id='jZ2SBf']")
    private WebElement autocompleteField;

    public void enterTextToLoginField(final String loginText) {
        loginLine.clear();
        loginLine.sendKeys(loginText);
    }

    public void enterTextToPasswordLine(final String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void clickOnGmailButton(){
        gmailButton.click();
    }
    public void clickNextButton(){
        nextButton.click();
    }
    public WebElement getPasswordInput(){
        return passwordInput;
    }
    public WebElement getGmailButton(){
        return gmailButton;
    }
    public WebElement getNextButton(){
        return nextButton;
    }
    public String getTextIncorrectPasswordField(){
        return incorrectPasswordField.getText();
    }

    public void enterTextToSearchField(final String searchText) {
        searchingField.clear();
        searchingField.sendKeys(searchText);
    }
    public void clickOnAutocompleteSearchingText(){
        autocompleteField.click();
    }
}
