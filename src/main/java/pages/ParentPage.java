package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

abstract public class ParentPage extends CommonActionsWithElements{
    protected Logger logger = Logger.getLogger(getClass());
    String baseUrl = "https://dermal-cosmetics.com.ua";

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }

    protected void checkUrl() {
        Assert.assertEquals("URL is not expected",
                baseUrl + getRelativeUrl(),
                webDriver.getCurrentUrl());
    }

    abstract protected String getRelativeUrl();
}
