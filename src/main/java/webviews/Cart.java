package webviews;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.projectTest.DriverFactory;

public class Cart {
//    @FindBy(css = ".add-to-cart-buttons .btn-cart")
    @FindBy(css = ".actions:nth-child(4) > .btn-cart-first > span > span")
    private WebElement addToCartButton;


    @FindBy(css = ".cart-footer-actions .btn-empty")
    private WebElement removeButton;

    @FindBy ()

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public WebElement getRemoveButton() {
        return removeButton;
    }


    /*public WebElement getAddToCartButtonByProductName(WebDriver driver, String productName) {
        return driver.findElement(
                By.xpath("//div[@class='product-info' and ./descendant::*[text()" +
                        "='" + productName + "']]//button[contains(@class, 'btn-cart')]"));
    }*/


}

