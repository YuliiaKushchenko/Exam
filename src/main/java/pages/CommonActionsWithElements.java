package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


public class CommonActionsWithElements {
    protected Logger logger = Logger.getLogger(getClass());
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait10, webDriverWait15;

    public CommonActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait10 = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        this.webDriverWait15 = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        PageFactory.initElements(webDriver, this);
    }

    protected void clearAndEnterTextIntoElement(WebElement webElement, String text) {
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was entered into element " + getElementName(webElement));
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void clickOnElement(WebElement webElement) {
        try {
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(webElement));
            String elementName = getElementName(webElement);
            webElement.click();
            logger.info(elementName + " element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected boolean isElementVisible(WebElement webElement) {
        try {
            boolean state = webElement.isDisplayed();
            if (state) {
                logger.info(getElementName(webElement) + " element is displayed");
            } else {
                logger.info(getElementName(webElement) + " element is not displayed");
            }
            return state;
        } catch (Exception e) {
            logger.info("Element is not visible");
            return false;
        }
    }

    protected boolean isElementVisible(String locator) {
        try {
            return isElementVisible(webDriver.findElement(By.xpath(locator)));
        } catch (Exception e) {
            logger.info("Element is not visible");
            return false;
        }
    }

    protected boolean isElementVisible(WebElement webElement, String elementName) {
        try {
            boolean state = webElement.isDisplayed();
            if (state) {
                logger.info(elementName + " element is displayed");
            } else {
                logger.info(elementName + " element is not displayed");
            }
            return state;
        } catch (Exception e) {
            logger.info(elementName + " element is not visible");
            return false;
        }
    }

    protected void clickOnElementByJavaScript(WebElement webElement, String elementName) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            js.executeScript("arguments[0].click();", webElement);
            logger.info(elementName + " element was clicked by JavaScript");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected void selectValueFromDropdown(String text) {
        try {
            String locator = String.format("//li[@rel='%s']", text);
            WebElement valueFromDropdown = webDriver.findElement(By.xpath(locator));
            clickOnElementByJavaScript(valueFromDropdown, "Value from dropdown");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }


    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element " + e);
        Assert.fail("Can not work with element " + e);
    }

    private String getElementName(WebElement webElement) {
        String elementName = "";
        try {
            return webElement.getAccessibleName();
        } catch (Exception e) {
            return elementName;
        }
    }

    protected void waitUntilPageIsLoaded() {
        try {
            webDriverWait15.until(webDriver1 -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void waitUntilElementIsVisible(WebElement element, String elementName) {
        webDriverWait10.until(ExpectedConditions.visibilityOf(element));
        logger.info(elementName + " element is visible");
    }

    protected void checkItemUrl(String itemUrl) {
        logger.info("Check url to contain " + itemUrl);
        webDriverWait10.until(ExpectedConditions.urlContains(itemUrl));
        Assert.assertTrue("Current url does not contain " + itemUrl, webDriver.getCurrentUrl().contains(itemUrl));
        logger.info("Check was successful");
    }

}
