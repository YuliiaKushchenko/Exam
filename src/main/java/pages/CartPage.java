package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.HeaderElements;
import org.openqa.selenium.WebDriver;
import utils.Utils;

public class CartPage extends ParentPage {
    private HeaderElements headerElements;

    @FindBy(xpath = "//a[@class='remove']")
    private WebElement deleteIcon;

    public CartPage(WebDriver webDriver) {
        super(webDriver);
        this.headerElements = new HeaderElements(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/cart/";
    }

    public CartPage openCartAndCheckAddedProduct(String text) {
        headerElements.openCart();
        checkIsProductAddedToCart(text);
        return this;
    }

    public CartPage checkIsProductAddedToCart(String text) {
        String locator = String.format("//a[contains(text(), '%s')]", text);
        WebElement productTitle = webDriver.findElement(By.xpath(locator));
        Assert.assertTrue("Product is not added to cart"
                , isElementVisible(productTitle, "Product added to the cart"));
        return this;
    }

    public CartPage openCartAndDeleteProduct(String productName) {
        headerElements.openCart();
        removeProductFromCart(productName);
        checkIsProductDeletedFromCart(productName);
        return this;
    }

    public CartPage checkIsProductDeletedFromCart(String text) {
        String locator = String.format("//td[@class='product-name']//a[contains(text(), '%s')]", text);
        Assert.assertFalse("Product is not deleted from cart"
                , isElementVisible(locator));
        logger.info("Product is deleted from the cart");
        return this;
    }

    private CartPage removeProductFromCart(String productName) {
        logger.info("Click on delete icon for " + productName);
        clickOnElementByJavaScript(deleteIcon, "Delete icon");
        logger.info("Delete icon was clicked");
        Utils.waitABit(5);
        return this;
    }
}
