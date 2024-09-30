package pages;

import data.TestData;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @FindBy(xpath = "//*[@id='username']")
    private WebElement inputLoginInLoginForm;

    @FindBy(xpath = "//*[@id='password']")
    private WebElement inputPasswordInLoginForm;

    @FindBy(name = "login")
    private WebElement buttonSignIn;

    @FindBy(xpath = "//a[text()='Майстерня']")
    private WebElement maysternyaCategory;

    @FindBy(xpath = "//a[text()='Вийти']")
    private WebElement buttonSignOut;

    @FindBy(xpath = "//h1[text()='Мій профіль']")
    private WebElement myProfileText;

    @FindBy(xpath = "//a[text() = 'Втратили свій пароль?']")
    private WebElement lostYourPasswordLink;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/my-account/";
    }

    public LoginPage openLoginPageAndLoginWithValidCreds() {
        openLoginPage();
        enterTextIntoInputLogin(TestData.VALID_LOGIN);
        enterTextIntoInputPassword(TestData.VALID_PASSWORD);
        clickOnButtonSignIn();
        return this;

    }

    public void clickOnButtonSignIn() {
        clickOnElement(buttonSignIn);
    }

    private void enterTextIntoInputPassword(String password) {
        clearAndEnterTextIntoElement(inputPasswordInLoginForm, password);
    }

    public void enterTextIntoInputLogin(String login) {
        clearAndEnterTextIntoElement(inputLoginInLoginForm, login);
    }


    private void openLoginPage() {
        webDriver.get(baseUrl + this.getRelativeUrl());
        logger.info("Login page is opened ");
    }

    public LoginPage checkIsRedirectToLoginPage() {
        checkUrl();
        return this;
    }

    public LoginPage isMaysternyaCategoryVisible() {
        Assert.assertTrue("Maysternya category is not visible", isElementVisible(maysternyaCategory));
        return this;
    }

    public LoginPage isMyProfileTextVisible() {
        Assert.assertTrue("My profile text is not visible", isElementVisible(myProfileText));
        return this;
    }

    public LoginPage isButtonSignOutVisible() {
        Assert.assertTrue("Button Sign Out is not visible", isElementVisible(buttonSignOut));
        return this;
    }

    public LostPasswordPage clickOnLostYourPasswordLink() {
        clickOnElement(lostYourPasswordLink);
        return new LostPasswordPage(webDriver);
    }
}

