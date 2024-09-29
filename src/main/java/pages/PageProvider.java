package pages;

import org.openqa.selenium.WebDriver;
import pages.elements.HeaderElements;

public class PageProvider {
    private WebDriver webDriver;

    public PageProvider(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public LoginPage getLoginPage() {
        return new LoginPage(webDriver);
    }

    public HomePage getHomePage() {
        return new HomePage(webDriver);
    }

    public HeaderElements getHeaderElements() {
        return new HeaderElements(webDriver);

    }
}
