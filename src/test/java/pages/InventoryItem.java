package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryItem extends BaseClass{
    public InventoryItem(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//button[text()='Add to cart']")
    WebElement Addtocart;

    @FindBy(xpath = "//button[@id='back-to-products']")
    WebElement Backbutton;


    public Inventory addAndGoBack(){
        clickOn(Addtocart);
        clickOn(Backbutton);
        return new Inventory(driver);
    }
}
