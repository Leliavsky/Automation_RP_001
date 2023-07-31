package business.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.Field;

public class WikipediaPage extends BasePage{
    public WikipediaPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//span[@class='mw-page-title-main']")
    private WebElement titleField;

    public String getTextFromTitle(){
        return titleField.getText();
    }
}
