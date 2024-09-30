package linkTests;

import baseTest.BaseTest;
import org.junit.Test;

public class LinkTests extends BaseTest {

    @Test
    public void TC_003_checkMenuItemsLinks() {
        pageProvider.getHomePage().openHomePage();
        pageProvider.getHeaderElements().checkMenuItems();

    }

}
