package org.projectTest.TestElements;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.PageFactory;
import webviews.LogIn;
import webviews.Register;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)

public class SignUpTest extends TestBase {
    private String firstName;
    private String lastName;
    private String email;

    public SignUpTest(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Ana","Pop", "AnaPop"}, {"Maria", "Ionescu", "MariaIonescu"}
        });
    }

    @Test
    public void formFill() {
        openRegisterPage();

        Register register = PageFactory.initElements(driver, Register.class);

        register.inputFirstName(fillFormGenerator(firstName, 10));
        register.inputLastName(fillFormGenerator(lastName, 11));
        register.inputEmail(fillEmailGenerator(email, 15));
        register.inputPassword(fillFormGenerator("anapass", 10));
        register.inputPasswordConfirmation(fillFormGenerator("anapass", 10));
        register.clickNewsLetterCheckBox();
        register.clickRegisterButton();

        assertThat("The page displayed is incorrect.", driver.getCurrentUrl(), containsString("https://demo.cart2quote.com/customer/account/index/"));
        assertThat("There is no confirmation message", driver.getPageSource(), containsString("Thank you for registering with Madison Island."));
        assertThat("The first name is not present.", driver.getPageSource(), containsString(firstName));
        assertThat("The last name is not present.", driver.getPageSource(), containsString(lastName));
        assertThat("The email address is not present.", driver.getPageSource(), containsString(email));
    }
}

