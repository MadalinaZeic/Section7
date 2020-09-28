package webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogIn {

    @FindBy(name = "login[username]")
    private WebElement email;

    @FindBy(name = "login[password]")
    private WebElement password;

    @FindBy(name = "send")
    private WebElement logInButton;

    public void inputEmailAddress(String keyword) {
        email.sendKeys(keyword);
    }
    public void inputPassword(String keyword) {
        password.sendKeys(keyword);
    }
    public void clickLogInButton() {
        logInButton.click();
    }


}
