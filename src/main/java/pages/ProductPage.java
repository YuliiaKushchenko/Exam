package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends ParentPage {

    @FindBy(xpath = "//div[@class='select-styled']")
    private WebElement chooseTheOptionDropdown;

    @FindBy(xpath = "//button[contains(text(), 'Додати в кошик')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[contains(text(), 'Переглянути кошик')]")
    private WebElement seeYourCartButton;

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/product/[a-zA-Z0-9]*/";
    }

    public void openProductPage(String productTitle) {
        String dynamicProductUrl = baseUrl + "/product/" + productTitle + "/";
        webDriver.get(dynamicProductUrl);
        logger.info(productTitle + " product page is opened");
    }

    public void addProductToCart(String dropdownValue) {
        selectOptionFromDropdown(dropdownValue);
        clickOnAddToCartButton();
        checkIsSeeCartButtonDisplayed();
    }

    public CartPage clickOnAddToCartButton() {
        clickOnElement(addToCartButton);
        logger.info("Add to cart button was clicked");
        return new CartPage(webDriver);
    }

    public ProductPage checkIsSeeCartButtonDisplayed() {
        Assert.assertTrue("Success message is not displayed"
                , isElementVisible(seeYourCartButton, "Success message"));
        return this;
    }

    private void selectOptionFromDropdown(String text) { // 30-ml
      clickOnElementByJavaScript(chooseTheOptionDropdown, "Choose the option dropdown");
        selectValueFromDropdown(text);
    }
}

