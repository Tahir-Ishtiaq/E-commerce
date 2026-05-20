package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutStepTwo extends BaseClass{
    public CheckoutStepTwo(WebDriver driver){
        super(driver);
    }
    @FindBy(id = "finish")
    WebElement Finishbutton;

    public CheckoutComplete Finish(){
        clickOn(Finishbutton);
        return new CheckoutComplete(driver);
    }
}
