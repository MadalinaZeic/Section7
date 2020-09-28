package webviews;

import com.google.common.collect.Lists;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.JsonOutput;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
}

