package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cart extends BaseClass{

    public Cart(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//button[@id='checkout']")
    WebElement Checkout;

    @FindBy(xpath = "//button[@id='continue-shopping']")
    WebElement Gobackbutton;

    public CheckoutStepOne checkOut(){
        clickOn(Checkout);
        return new CheckoutStepOne(driver);
    }
}
