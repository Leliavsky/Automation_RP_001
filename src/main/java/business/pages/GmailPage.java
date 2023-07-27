package business.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;
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

    @FindBy(xpath = "//a[@href='https://mail.google.com/mail/u/0/#sent']")
    private WebElement sentField;
    @FindBy(xpath = "//img[@class=\"Ha\"]")
    private WebElement closeButton;

    @FindBy(xpath = "//tr[@class='zA yO'][1]")
    private WebElement draftEmail;

    @FindBy(xpath = "//div[@class='oL aDm az9']")
    private WebElement draftEmailField;

    @FindBy(xpath = "//input[@name='subject']")
    private WebElement draftSubjectField;

    @FindBy(xpath = "//div[@class='Ar Au']")
    private WebElement draftBodyField;

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']")
    private WebElement sentEmailButton;

    @FindBy(xpath = "//td[@class='TC']")
    private WebElement emptyDraftField;

    @FindBy(xpath = "//td[@class='TC']")
    private WebElement emptySentField;

    @FindBy(xpath = "//tr[@class='zA yO x7']")
    private WebElement sentDraftField;

    @FindBy(xpath = "//table[@class='F cf zt']")
    private WebElement elementSentEmailField;

    @FindBy(xpath = "//a[@class='gb_d gb_La gb_A']")
    private WebElement accountMenuButton;

    @FindBy(xpath = "//a[@class='V5tzAf jFfZdd']")
    private WebElement logOutButton;
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

    public String getDraftBodyText(){
        return bodyField.getText();
    }

    public void clickOnSentEmailButton(){
        sentEmailButton.click();
    }

    public String getEmptyDraftFieldText(){
        return emptyDraftField.getText();
    }

    public void clickOnSentField(){
        sentField.click();
    }
    public WebElement getElement(){
        return emptySentField;
    }

    public void clickOnAccountButton(){
        accountMenuButton.click();
    }
    public void clickOnLogOutButton(){
        logOutButton.click();
    }
    public boolean verifyOnVisibleElement(){
        return logOutButton.isDisplayed();
    }
}
