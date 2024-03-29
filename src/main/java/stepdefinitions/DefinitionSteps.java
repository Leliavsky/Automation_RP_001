package stepdefinitions;

import business.pages.GmailPage;
import business.pages.LoginPage;
import business.pages.SearchingPage;
import business.pages.WikipediaPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import business.manager.PageFactoryManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(60);
    private static final String EXPECTED_URL = "https://mail.google.com/mail/u/0/#inbox";
    private static final String EXPECTED_TEXT = "Немає жодної збереженої чернетки.\nУ чернетках зберігаються повідомлення, які ви ще не готові надіслати.";
    private static final String EXPECTED_WRONG_PASSWORD_TEXT = "Неправильний пароль. Повторіть спробу або натисніть \"Забули пароль?\", щоб скинути його.";
    private static final String EXPECTED_WIKI_TITLE_TEXT = "Зеленський Володимир Олександрович";

    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    LoginPage loginPage;
    GmailPage gmailPage;
    SearchingPage searchingPage;
    WikipediaPage wikipediaPage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException ignored) {}
    }

    @Given("User opens {string} page")
    public void openPage(final String url) {
        loginPage = pageFactoryManager.getLoginPage();
        loginPage.openLoginPage(url);
    }

    @When("User introduces login {string}")
    public void userIntroducesLogin(final String keyword) {
        loginPage.enterTextToLoginField(keyword);
    }

    @And("User write password {string}")
    public void userWritePasswordPassword(final String password) {
        loginPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, loginPage.getPasswordInput());
        loginPage.enterTextToPasswordLine(password);
    }

    @And("User clicks on Login button")
    public void userClicksOnLoginButton() {
        loginPage.clickLoginButton();
    }

    @And("User clicks on Next button")
    public void userClicksOnNextButton() {
        loginPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, loginPage.getNextButton());
        loginPage.clickNextButton();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @And("User clicks on Gmail button")
    public void userClicksOnGmailButton() {
        loginPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, loginPage.getGmailButton());
        loginPage.clickOnGmailButton();
    }

    @And("clicks on Write button")
    public void clicksOnWriteButton() {
        gmailPage = pageFactoryManager.getGmailPage();
        gmailPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        gmailPage.clickOnWriteButton();
    }

    @Then("Verify success login")
    public void verifySuccessLogin() {
        assertEquals(driver.getCurrentUrl(),EXPECTED_URL);
    }

    @And("Create a new mail")
    public void createANewMail() {
        gmailPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, gmailPage.getGmailField());
        gmailPage.enterEmailOfRecipient("test@gmail.com");
        gmailPage.enterSubject("test");
        gmailPage.enterBody("Hello");
    }

    @And("click on close button")
    public void clickOnCloseButton() {
        gmailPage.clickOnCloseButton();
    }

    @And("click on draft section")
    public void clickOnDraftSection() {
        gmailPage.clickOnDraftField();
    }

    @Then("Verify draft mail present")
    public void verifyDraftMailPresent() {
        gmailPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, gmailPage.getDraftEmailField());
        gmailPage.clickOnDraftEmail();
        gmailPage.implicitWait(5);
        assertEquals(gmailPage.getEmailText(),"test@gmail.com");
        assertEquals(gmailPage.getDraftBodyText(),"Hello");
    }

    @And("click on sent the email and verify empty draft")
    public void clickOnSentTheEmail() {
        gmailPage.clickOnSentEmailButton();
        assertEquals(gmailPage.getEmptyDraftFieldText(), EXPECTED_TEXT);
    }

    @And("click on sent field to verify that email is sent")
    public void clickOnSentFieldToVerifyThatEmailIsSent() {
        gmailPage.clickOnSentField();
        gmailPage.implicitWait(5);
        gmailPage.waitNotVisibilityOfElement(DEFAULT_TIMEOUT, gmailPage.getElement());

    }

    @Then("Log off")
    public void logOff() {
        driver.get("https://accounts.google.com/Logout?hl=uk&continue=https://mail.google.com&service=mail&timeStmp=1690467949&secTok=.AG5fkS-gHF60lhhINaxOYGG746bh6kOEiw&ec=GAdAFw&hl=uk");
        gmailPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("Verify messages is displayed")
    public void verifyMessagesIsDisplayed() {
        loginPage.implicitWait(5);
        assertEquals(loginPage.getTextIncorrectPasswordField(),EXPECTED_WRONG_PASSWORD_TEXT);
    }

    @And("User writes {string} in the search field")
    public void userWritesTextInTheSearchField(final String text) {
        loginPage.enterTextToSearchField(text);
    }

    @And("Click on autocomplete hint text")
    public void clickOnAutocompleteHintText() {
        loginPage.implicitWait(3);
        loginPage.clickOnAutocompleteSearchingText();
        loginPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("Move to search results by Google, find wikipedia")
    public void moveToSearchResultsByGoogleFindWikipedia() {
        searchingPage = pageFactoryManager.getSearchingPage();
        searchingPage.scrollMove(driver,800);
        searchingPage.getElementOfWikipedia().click();
        searchingPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("Check page title")
    public void checkPageTitle() {
        wikipediaPage = pageFactoryManager.getWikipediaPage();
        assertEquals(wikipediaPage.getTextFromTitle(), EXPECTED_WIKI_TITLE_TEXT);
    }
}
