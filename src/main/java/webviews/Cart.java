package webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cart {

    @FindBy(css = ".actions:nth-child(4) > .btn-cart-first > span > span")
    private WebElement addToCartButton;


    @FindBy(css = ".cart-footer-actions .btn-empty")
    private WebElement removeButton;

    @FindBy(css = ".product-cart-actions > .input-text")
    private WebElement quantityField;

    @FindBy(css = ".product-cart-actions > .button")
    private WebElement updateQtyButton;



    public void updateQty(int newQty){
        quantityField.clear();
        quantityField.sendKeys(String.valueOf(newQty));
        updateQtyButton.click();
    }

    public WebElement getQuantityField() {
        return quantityField;
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public WebElement getRemoveButton() {
        return removeButton;
    }

}

