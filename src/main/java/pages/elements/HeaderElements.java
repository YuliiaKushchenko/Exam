package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CommonActionsWithElements;
import pages.LoginPage;

public class HeaderElements extends CommonActionsWithElements {

    @FindBy(xpath = "//div[@class='action-button-container']//a[@href='https://dermal-cosmetics.com.ua/my-account/']")
    private WebElement authorizationIcon;

    public HeaderElements(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage clickOnAuthorizationIcon() {
        clickOnElement(authorizationIcon);
        return new LoginPage(webDriver);
    }
}
