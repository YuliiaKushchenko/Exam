package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CommonActionsWithElements;
import pages.LoginPage;

public class HeaderElements extends CommonActionsWithElements {

    @FindBy(xpath = "//a[@data-original-title='Авторизуватися']")
    private WebElement authorizationIcon;

    public HeaderElements(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage clickOnAuthorizationIcon() {
        clickOnElement(authorizationIcon);
        return new LoginPage(webDriver);
    }
}
