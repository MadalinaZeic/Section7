package org.projectTest.TestElements;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import webviews.Search;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class SearchTests extends TestBase {

    private String product = "SUEDE LOAFER, NAVY";

    @Test
    public void searchSpecificProduct() {
        openHomepage();
        Search search = PageFactory.initElements(driver, Search.class);
        search.searchProduct(product);
        search.getButton().click();

        assertThat("The desired product does not appear", driver.getPageSource(), containsString("Make a statement, even when relaxed and casual."));
        assertThat("The desired product does not appear", driver.getPageSource(), containsString("Suede Loafer, Navy"));
    }

    @Test
    public void searchSimilarProducts() {
        openHomepage();
        Search search = PageFactory.initElements(driver, Search.class);
        search.searchSimilarProducts("shirts");

        assertThat("The products displayed are not in the searched category", search.getResults(), hasSize(Matchers.greaterThan(0)));
    }

    @Test
    public void searchNonExistentProducts() {
        openHomepage();
        Search search = PageFactory.initElements(driver, Search.class);
        search.searchSimilarProducts("?.=!");

        assertThat("There are products for this search.", search.getResults(), hasSize(Matchers.equalTo(0)));
        assertThat("There are products for this search.", driver.getPageSource(), containsString("Your search returns no results."));
    }

    @Test
    public void emptySearch() {
        openHomepage();
        Search search = PageFactory.initElements(driver, Search.class);
        search.searchSimilarProducts("");

        assertThat("Search is working.", search.getSearchField().getAttribute("class"), containsString("input-text required-entry validation-failed"));
    }
}


