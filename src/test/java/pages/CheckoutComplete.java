package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutComplete extends BaseClass{
    public CheckoutComplete(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "back-to-products")
    WebElement backToProduct;

    public Inventory backToInventory(){
        clickOn(backToProduct);
        return new Inventory(driver);
    }
}
