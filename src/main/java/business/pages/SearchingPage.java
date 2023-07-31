package business.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchingPage extends BasePage {
    public SearchingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[.='Зеленський Володимир Олександрович - Вікіпедія']")
    private WebElement elementOfWikipedia;

    public WebElement getElementOfWikipedia(){
        return elementOfWikipedia;
    }
}
