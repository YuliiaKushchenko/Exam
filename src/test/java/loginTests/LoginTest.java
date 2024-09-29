package loginTests;

import baseTest.BaseTest;
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
}
