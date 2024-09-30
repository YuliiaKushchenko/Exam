package loginTests;

import baseTest.BaseTest;
import data.TestData;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @Test
    public void TC_001_validLogin() {
        pageProvider.getHomePage().openHomePage();
        pageProvider.getHeaderElements().clickOnAuthorizationIcon().checkIsRedirectToLoginPage();
        pageProvider.getLoginPage().openLoginPageAndLoginWithValidCreds();
        pageProvider.getLoginPage().isMyProfileTextVisible();
        pageProvider.getLoginPage().isMaysternyaCategoryVisible();
        pageProvider.getLoginPage().isButtonSignOutVisible();
    }

    @Test
    public void TC_002_lostPassword() {
        pageProvider.getHomePage().openHomePage();
        pageProvider.getHeaderElements().clickOnAuthorizationIcon().checkIsRedirectToLoginPage();
        pageProvider.getLoginPage().clickOnLostYourPasswordLink().checkIsRedirectToLostPasswordPage();
        pageProvider.getLostPasswordPage().enterEmailInToInputEmailAndSubmit(TestData.VALID_LOGIN);
        pageProvider.getLostPasswordPage().checkIsAlertMessageDisplayed("Лист для відновлення паролю надіслано.")
                .checkIsButtonSubmitIsNotVisible();
    }
}
