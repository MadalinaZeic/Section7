package org.projectTest.TestElements;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import webviews.Cart;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class CartTests extends TestBase {


    @Test
    public void addProductToCart() {
        openSalePage();

        Cart cart = PageFactory.initElements(driver, Cart.class);

        String productName = "Jackie O Round Sunglasses";
        cart.getAddToCartButton().click();

        assertThat("The product is not added in Cart.", driver.getPageSource(), containsString(productName));
    }

    @Test
    public void removeProductFromCart() {
        addProductToCart();

        Cart cartPage = PageFactory.initElements(driver, Cart.class);
        cartPage.getRemoveButton().click();

        assertThat("Cart still contains products.", driver.getPageSource(), containsString("Shopping Cart is Empty"));
    }

    @Test
    public void updateQuantityInCartWithUnavailableQty() {
        addProductToCart();

        Cart cartPage = PageFactory.initElements(driver, Cart.class);
        cartPage.updateQty(3);

        assertThat("The quantity was updated.", driver.getPageSource(), containsString("is not available."));
    }

    @Test
    public void updateQuantityInCart() {
        addProductToCart();

        Cart cartPage = PageFactory.initElements(driver, Cart.class);
        cartPage.updateQty(1);

        assertThat("The quantity was not updated.", driver.getPageSource(), containsString("Proceed to Checkout"));
    }

}
