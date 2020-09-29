package webviews;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class Search {

    @FindBy(id = "search")
    private WebElement searchField;

    @FindBy(id = "navy")
    private WebElement suedeLoafer;

    @FindBy(linkText = "https://demo.cart2quote.com/suede-loafer-navy-645.html")
    private WebElement productList;

    @FindBy(xpath = "//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/ul/li[2]/div/div[2]/a")
    private WebElement button;

    @FindBys({@FindBy(className = "price")})
    private List<WebElement> results;

    public List<WebElement> getResults() {
        return results;
    }

    public WebElement getButton() {
        return button;
    }

    public WebElement getProductList() {
        return productList;
    }

    public void searchProduct(String keyword) {
        searchField.sendKeys("SUEDE LOAFER, NAVY" + Keys.ENTER);
    }

    public void searchSimilarProducts(String keyword) {
        searchField.sendKeys(keyword + Keys.ENTER);
    }

    public WebElement getSearchField() {
        return searchField;
    }
}

