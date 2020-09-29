package org.projectTest.TestElements;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import webviews.Cart;
import webviews.Checkout;
import webviews.LogIn;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckoutTests extends TestBase {

    @Test
    public void checkoutButton() {
        openSalePage();
        Cart cart = PageFactory.initElements(driver, Cart.class);
        cart.getAddToCartButton().click();
        cart.updateQty(1);

        Checkout checkout1 = PageFactory.initElements(driver, Checkout.class);
        checkout1.clickCheckoutButton();

        assertThat("The checkout button does not lad to checkout page.", driver.getCurrentUrl(), is("https://demo.cart2quote.com/checkout/onepage/"));
    }

    @Test
    public void checkOutWithLogIn() {
        checkoutButton();
        Checkout checkout2 = PageFactory.initElements(driver, Checkout.class);
        checkout2.insertEmail("AnaPop467421@cocox.com");
        checkout2.insertPass("anapass467");
        checkout2.clickLogInButton();

        assertThat("Could not login.", driver.getPageSource(), containsString("Billing Information"));
    }

    @Test
    public void checkoutPageWithLoginFormNotFilled() {
        checkOutWithLogIn();

        Checkout checkout3 = PageFactory.initElements(driver, Checkout.class);

        checkout3.clearCheckoutForm();
        checkout3.clickContinueCheckoutButton();

        assertThat("Form not filled.", driver.getPageSource(), containsString("This is a required field."));
    }

    @Test
    public void checkoutPageWithLoginFormFilled() {
        checkOutWithLogIn();

        Checkout checkout4 = PageFactory.initElements(driver, Checkout.class);

        checkout4.clearCheckoutForm();
        checkout4.fillCheckoutForm();
        checkout4.clickContinueCheckoutButton();

        assertThat("The checkout failed.", driver.getPageSource(), containsString("Your Checkout Progress"));
    }
}
