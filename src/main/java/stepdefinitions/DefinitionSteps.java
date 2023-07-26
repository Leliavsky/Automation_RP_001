package stepdefinitions;

import business.pages.GmailPage;
import business.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import business.manager.PageFactoryManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;

public class DefinitionSteps {
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(60);
    private static final String EXPECTED_URL = "https://mail.google.com/mail/u/0/#inbox";

    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    LoginPage loginPage;
    GmailPage gmailPage;

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
        sleep(1);
        System.out.println(gmailPage.getEmailText());
        assertEquals(gmailPage.getEmailText(),"test@gmail.com");
    }
}
