package org.projectTest.TestElements;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import webviews.LogIn;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

public class LogInTest extends TestBase {
    private final String email = "AnaPop80@gmail123.com";
    private final String password = "anapass01";

    private final String invalidEmail = "AnaPop78@gmail123.com";
    private final String invalidPassword = "anapass00";

    @Test
    public void logIn() {
        openLogInPage();
        LogIn logIn = PageFactory.initElements(driver, LogIn.class);

        logIn.inputEmailAddress(email);
        logIn.inputPassword(password);
        logIn.clickLogInButton();

        assertThat("The page displayed is incorrect.", driver.getCurrentUrl(), containsString("https://demo.cart2quote.com/customer/account/"));
        assertThat("There is no confirmation message.", driver.getPageSource(), containsString("Hello, Ana Pop!"));
        assertThat("The email address is incorrect.", driver.getPageSource(), containsString(email));
    }

    @Test
    public void logInFailedWithInvalidCredentials() {
        openLogInPage();
        LogIn logIn = PageFactory.initElements(driver, LogIn.class);

        logIn.inputEmailAddress(invalidEmail);
        logIn.inputPassword(invalidPassword);
        logIn.clickLogInButton();

        assertThat("There is no confirmation message.", driver.getPageSource(), containsString("Invalid login or password."));
    }
    @Test
    public void logInFailedWithInvalidEmail(){
        openLogInPage();
        LogIn logIn = PageFactory.initElements(driver, LogIn.class);

        logIn.inputEmailAddress(invalidEmail);
        logIn.inputPassword(password);
        logIn.clickLogInButton();

        assertThat("There is no confirmation message.", driver.getPageSource(), containsString("Invalid login or password."));
    }
    @Test
    public void logInFailedWithInvalidPassword(){
        openLogInPage();
        LogIn logIn = PageFactory.initElements(driver, LogIn.class);

        logIn.inputEmailAddress(email);
        logIn.inputPassword(invalidPassword);
        logIn.clickLogInButton();

        assertThat("There is no confirmation message.", driver.getPageSource(), containsString("Invalid login or password."));
    }
    @Test
    public void logInFailedWithEmptyCredentials(){
        openLogInPage();
        LogIn logIn = PageFactory.initElements(driver, LogIn.class);

        logIn.inputEmailAddress("");
        logIn.inputPassword("");
        logIn.clickLogInButton();

        assertThat("There is no confirmation message.", driver.getPageSource(), containsString("This is a required field."));
    }
}

