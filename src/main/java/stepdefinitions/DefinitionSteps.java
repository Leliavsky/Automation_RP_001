package stepdefinitions;

import business.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import business.manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {

    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    LoginPage loginPage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @Given("User opens {string} page")
    public void openPage(final String url) {
        loginPage = pageFactoryManager.getLoginPage();
        loginPage.openLoginPage(url);
    }

    @When("User introduces login {string}")
    public void userIntroducesLogin(final String keyword) {
        loginPage = pageFactoryManager.getLoginPage();
        loginPage.enterTextToLoginField(keyword);
    }

    @And("User write password {string}")
    public void userWritePasswordPassword(final String password) {
        loginPage.enterTextToPasswordLine(password);
    }

    @And("User clicks on Login button")
    public void userClicksOnLoginButton() {
        loginPage.clickLoginButton();
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
