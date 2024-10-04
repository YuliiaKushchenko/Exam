package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CartPage;
import pages.CommonActionsWithElements;
import pages.LoginPage;
import pages.ProductPage;

import java.util.Arrays;
import java.util.List;

public class HeaderElements extends CommonActionsWithElements {

    @FindBy(xpath = "//a[@data-original-title='Авторизуватися']")
    private WebElement authorizationIcon;

    @FindBy(xpath = "//input[@class='search-input']")
    private WebElement inputSearch;

    @FindBy(xpath = "//button[@class='search-submit icon-search']")
    private WebElement searchIcon;

    @FindBy(xpath = "//span[@class='action-button icon-mini-cart']")
    private WebElement cartIcon;


    public HeaderElements(WebDriver webDriver) {
        super(webDriver);
    }


    public LoginPage clickOnAuthorizationIcon() {
        clickOnElement(authorizationIcon);
        logger.info("Authorization icon is clicked");
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

    public ProductPage searchAndOpenProductItem(String text) {
        clearAndEnterTextIntoElement(inputSearch, text);
        clickOnElement(searchIcon);
        String locator = String.format("//a[@title='%s']", text);
        WebElement productTitle = webDriver.findElement(By.xpath(locator));
        clickOnElement(productTitle);
        logger.info("Product " + text + " was found and opened");
        return new ProductPage(webDriver);
    }

    public CartPage openCart() {
        clickOnElement(cartIcon);
        logger.info("Cart page is opened");
        return new CartPage(webDriver);
    }
}
