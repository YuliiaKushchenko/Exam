package cartTests;

import baseTest.BaseTest;
import org.junit.After;
import org.junit.Test;

public class CartTests extends BaseTest {
    private final String PRODUCT_NAME = "Neauvia Antiox Concentrate Serum 4%";
    private final String DROPDOWN_VALUE = "30-ml";

    @Test
    public void TC_004_addProductToCart() {
        pageProvider.getHomePage()
                .openHomePage();
        pageProvider.getHeaderElements()
                .searchAndOpenProductItem(PRODUCT_NAME);
        pageProvider.getProductPage()
                .addProductToCart(DROPDOWN_VALUE);
        pageProvider.getCartPage()
                .openCartAndCheckAddedProduct(PRODUCT_NAME);
    }

    @After
    public void deleteProductFromCart() {
        pageProvider.getCartPage()
                .openCartAndDeleteProduct(PRODUCT_NAME);
    }
}
