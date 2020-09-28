package org.projectTest.TestElements;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import webviews.Register;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

public class SignUpNegativeTests extends TestBase{

    private final String email = "AnaPop80@gmail123.com";

    @Test
    public void signUpWithExistingEmail(){
        openRegisterPage();

        Register invalidRegister = PageFactory.initElements(driver, Register.class);

        invalidRegister.inputEmail(email);
        invalidRegister.inputFirstName(fillFormGenerator("Ana", 10));
        invalidRegister.inputLastName(fillFormGenerator("Pop", 11));
        invalidRegister.inputPassword(fillFormGenerator("anapass", 10));
        invalidRegister.inputPasswordConfirmation(fillFormGenerator("anapass", 10));
        invalidRegister.clickNewsLetterCheckBox();
        invalidRegister.clickRegisterButton();

        assertThat("The email already exists.", driver.getPageSource(), containsString("There is already an account with this email address."));
    }
    @Test
    public void signUpWithDifferentPassword(){
        openRegisterPage();

        Register invalidRegister = PageFactory.initElements(driver, Register.class);
        invalidRegister.inputEmail(fillEmailGenerator("Ana", 12));
        invalidRegister.inputFirstName(fillFormGenerator("Ana", 10));
        invalidRegister.inputLastName(fillFormGenerator("Pop", 11));
        invalidRegister.inputPassword(fillFormGenerator("diffpass", 10));
        invalidRegister.inputPasswordConfirmation(fillFormGenerator("diffpass02", 10));
        invalidRegister.clickNewsLetterCheckBox();
        invalidRegister.clickRegisterButton();

       assertThat("The password is incorrect.", driver.getPageSource(), containsString("Please make sure your passwords match."));
    }
}
