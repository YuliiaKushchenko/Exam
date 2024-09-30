package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LostPasswordPage extends ParentPage{

    @FindBy(id = "user_login")
    private WebElement inputEmail;

    @FindBy(xpath = "//button[@class='woocommerce-Button button wp-element-button']")
    private WebElement resetPasswordButton;

    @FindBy(xpath = "//div[@role='alert']")
    private WebElement alertMessage;

    public LostPasswordPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/my-account/lost-password/";
    }

    public LostPasswordPage checkIsRedirectToLostPasswordPage() {
        checkUrl();
        return this;
    }

    public void enterEmailInToInputEmailAndSubmit(String email) {
        clearAndEnterTextIntoElement(inputEmail, email);
        clickOnElement(resetPasswordButton);
    }

    public boolean isAlertMessageVisible() {
        return isElementVisible(alertMessage, "Alert message");
    }

    public LostPasswordPage checkIsAlertMessageDisplayed(String alertMessage) {
        Assert.assertTrue("Alert message is not displayed", isAlertMessageVisible());
        return this;
    }

    public LostPasswordPage checkIsButtonSubmitIsNotVisible() {
        Assert.assertFalse("Button Submit is visible", isElementVisible(resetPasswordButton, "Reset password button"));
        return this;
    }

}
