package componentTests;

import baseTest.BaseTest;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Test;
import utils.Utils;


public class LoadMoreButtonTest extends BaseTest {


    @Test
    public void TC_005_loadMoreButton() {
        pageProvider.getHomePage().openHomePage().clickOnCategory("Обличчя")
                .checkIsRedirectToCategoryPage();
        pageProvider.getCategoryPage().waitUntilLoadMoreButtonIsVisible();
        int contentSizeBefore = pageProvider.getCategoryPage().checkContentBlockSizeMoreThan(0,
                pageProvider.getCategoryPage().getCategoryPageContentBlockSize());
        pageProvider.getCategoryPage().clickOnLoadMoreButton();
        pageProvider.getCategoryPage().checkContentBlockSizeMoreThan(contentSizeBefore,
                pageProvider.getCategoryPage().getCategoryPageContentBlockSize());

    }
}
