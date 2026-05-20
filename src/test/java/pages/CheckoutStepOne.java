package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutStepOne extends BaseClass{

    public CheckoutStepOne(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(id = "postal-code")
    WebElement postalCode;

    @FindBy(id = "continue")
    WebElement continueButton;

    public CheckoutStepTwo checkOutOne(String firstNamee, String lastNamee, String postalCodee){
        inputValue(firstName, firstNamee);
        inputValue(lastName, lastNamee);
        inputValue(postalCode, postalCodee);
        clickOn(continueButton);
        return new CheckoutStepTwo(driver);
    }

}
