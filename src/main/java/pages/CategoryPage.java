package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Utils;

import java.util.List;

public class CategoryPage extends ParentPage {

    @FindBy(xpath = "//div[@class='product-card-container']")
    private List<WebElement> contentBlock;

    @FindBy(xpath = "//button[@title='Завантажити більше']")
    private WebElement loadMoreButton;

    public CategoryPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/product-category/[a-zA-Z0-9]*/";
    }

    public void waitUntilLoadMoreButtonIsVisible() {
        waitUntilElementIsVisible(loadMoreButton, "Load more button");
    }

    public CategoryPage checkIsRedirectToCategoryPage() {
        checkUrlWithPattern();
        logger.info(webDriver.getCurrentUrl() + " category page is opened");
        return this;
    }

    public int getCategoryPageContentBlockSize() {
        return contentBlock.size();
    }

    public void clickOnLoadMoreButton() {
        clickOnElementByJavaScript(loadMoreButton, "Load more button");
        Utils.waitABit(3);
    }

    public int checkContentBlockSizeMoreThan(int sizeBefore, int sizeAfter) {
        logger.info("Content size before click on Load More button: " + sizeBefore);
        logger.info("Content size after click on Load More button: " + sizeAfter);
        Assert.assertTrue("Content size after click on Load More button is not more than before",
                sizeAfter > sizeBefore);
        logger.info("Content size after click on Load More button is more than before");
        return sizeAfter;
    }
}
