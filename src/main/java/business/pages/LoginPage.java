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

    @FindBy(xpath = "//input[@name='login']")
    private WebElement loginLine;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@class='bigButton__big-button--ivY7j bigButton__rounded-corners--3wKBL bigButton__color-organish--4iYXy']")
    private WebElement loginButton;

    public void enterTextToLoginField(final String loginText) {
        loginLine.clear();
        loginLine.sendKeys(loginText);
    }

    public void enterTextToPasswordLine(final String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void setLoginButton(){
        loginButton.click();
    }
}
