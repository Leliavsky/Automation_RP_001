package business.pages;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

public class GmailPage extends BasePage {
    public GmailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='T-I T-I-KE L3']")
    private WebElement writeButton;

    @FindBy(xpath = "//*[@class='aoD hl']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@class='aoT']")
    private WebElement subjectField;

    @FindBy(xpath = "//*[@class=\"Ha\"]")
    private WebElement bodyField;

    @FindBy(xpath = "//*[@id=\":56\"]")
    private WebElement closeButton;

    public void enterEmailOfRecipient(final String email) {
        emailField.sendKeys(email);
    }
    public void enterSubject(final String sub) {
        subjectField.sendKeys(sub);
    }

    public void enterBody(final String body) {
        bodyField.sendKeys(body);
    }

    public void clickOnWriteButton(){
        writeButton.click();
    }

    public void clickOnCloseButton(){
        closeButton.click();
    }

    public WebElement getGmailField(){
        return emailField;
    }
}
