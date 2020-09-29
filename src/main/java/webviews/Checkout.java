package webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Checkout {

    @FindBy(css = ".top span > span")
    private WebElement checkoutButton;

    @FindBy(id = "login-email")
    private WebElement emailCheckoutLogIn;

    @FindBy(id = "login-password")
    private WebElement passCheckoutLogIn;

    @FindBy(css = ".col-2 span > span")
    private WebElement logInButton;

    @FindBy(css = "#billing-buttons-container span > span")
    private WebElement continueCheckoutButton;

    @FindBy(id = "billing:street1")
    private WebElement addressField;

    @FindBy(id = "billing:city")
    private WebElement cityField;

    @FindBy(id = "billing:region_id")
    private WebElement regionField;

    @FindBy(id = "billing:postcode")
    private WebElement postCodeField;

    @FindBy(id = "billing:country_id")
    private WebElement countryField;

    @FindBy(id = "billing:telephone")
    private WebElement telephoneField;

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    public void insertEmail(String email) {
        emailCheckoutLogIn.sendKeys(email);
    }

    public void insertPass(String pass) {
        passCheckoutLogIn.sendKeys(pass);
    }

    public void clickLogInButton() {
        logInButton.click();
    }

    public void clickContinueCheckoutButton() {
        continueCheckoutButton.click();
    }

    public void fillCheckoutForm() {
        Select dropDownRegion = new Select(regionField);
        Select dropDownCountry = new Select(countryField);

        addressField.sendKeys("Home123");
        cityField.sendKeys("Cluj-Napoca");
        dropDownRegion.selectByVisibleText("Alabama");
        postCodeField.sendKeys("400400");
        dropDownCountry.selectByVisibleText("United States");
        telephoneField.sendKeys("052695124");
    }

    public void clearCheckoutForm() {
        addressField.clear();
        cityField.clear();
        postCodeField.clear();
        telephoneField.clear();
    }
}
