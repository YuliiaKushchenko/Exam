package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends ParentPage {

    private String locatorForCategory = "//a[contains(text(), '%s')]";

    Logger logger = Logger.getLogger(getClass());

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "";
    }

    public HomePage openHomePage() {
        webDriver.get(baseUrl);
        logger.info("Home page is opened " + baseUrl);
        return this;
    }

    public CategoryPage clickOnCategory(String categoryName) {
        By categoryLocator = By.xpath(String.format(locatorForCategory, categoryName));
        WebElement categoryElement = webDriver.findElement(categoryLocator);
        clickOnElement(categoryElement);
        return new CategoryPage(webDriver);
    }
}

