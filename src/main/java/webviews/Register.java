package webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Register {
    @FindBy(id = "firstname")
    private WebElement firstName;

    @FindBy(id = "lastname")
    private WebElement lastName;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(id = "confirmation")
    private WebElement passConfirmation;

    @FindBy(css = "#form-validate > div.buttons-set > button > span > span")
    private WebElement registerButton;

    @FindBy(id = "is_subscribed")
    private WebElement newsLetterCheckBox;

    public void inputFirstName(String keyword) {
        firstName.sendKeys(keyword);
    }
    public void inputLastName(String keyword) {
        lastName.sendKeys(keyword);
    }
    public void inputEmail(String keyword) {
        email.sendKeys(keyword);
    }
    public void inputPassword(String keyword) {
        password.sendKeys(keyword);
    }
    public void inputPasswordConfirmation(String keyword) {
        passConfirmation.sendKeys(keyword);
    }
    public void clickRegisterButton() {
        registerButton.click();
    }
    public void clickNewsLetterCheckBox() {
        newsLetterCheckBox.click();
    }
}
