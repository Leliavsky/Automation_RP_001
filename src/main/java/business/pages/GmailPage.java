package business.pages;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
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

    @FindBy(xpath = "//input[@class='agP aFw']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@class='aoT']")
    private WebElement subjectField;

    @FindBy(xpath = "//*[@class='Am Al editable LW-avf tS-tW']")
    private WebElement bodyField;

    @FindBy(xpath = "//a[@href=\"https://mail.google.com/mail/u/0/#drafts\"]")
    private WebElement draftField;

    @FindBy(xpath = "//img[@class=\"Ha\"]")
    private WebElement closeButton;

    @FindBy(xpath = "//tr[@class='zA yO'][1]")
    private WebElement draftEmail;

    @FindBy(xpath = "//div[@class='oL aDm az9']")
    private WebElement draftEmailField;

//    @FindBy(xpath = "//td[@class='xY a4W']")
//    private WebElement draftMail;

    public void enterEmailOfRecipient(final String email) {
        emailField.sendKeys(email);
    }
    public void enterSubject(final String sub) {
        subjectField.sendKeys(sub);
    }

    public void enterBody(final String body) {
        bodyField.sendKeys(body);
//        subjectField.sendKeys(Keys.ENTER);
    }

    public void clickOnWriteButton(){
        writeButton.click();
    }

    public void clickOnCloseButton(){
        closeButton.click();
    }

    public void clickOnDraftField() {
        draftField.click();
    }

    public void clickOnDraftEmail() {
        draftEmail.click();
    }

    public WebElement getGmailField(){
        return emailField;
    }
    public WebElement getDraftEmailField() {
        return draftEmail;
    }
    public String getEmailText(){
        return draftEmailField.getText();
    }
}
