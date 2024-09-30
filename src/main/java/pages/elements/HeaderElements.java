package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CommonActionsWithElements;
import pages.LoginPage;

import java.util.Arrays;
import java.util.List;

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

    public void checkMenuItems() {
        List<String> menuItems = Arrays.asList(
                "/pro-nas/",
                "/dostavka-i-oplata/",
                "/programa-loyalnosti/",
                "/blog/",
                "/vidguki/",
                "/kontakti/");

        waitUntilPageIsLoaded();
        menuItems.forEach(
                (String menuItem) -> {
                    String menuItemLocator = String.format("//div[@class='top-holder']//a[@href='https://dermal-cosmetics.com.ua%s']", menuItem);
                    WebElement tab = webDriver.findElement(By.xpath(menuItemLocator));
                    ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", tab);
                    waitUntilPageIsLoaded();
                    checkItemUrl(menuItem);
                }
        );
    }
}
