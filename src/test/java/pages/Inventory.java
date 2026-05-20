package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Inventory extends BaseClass{
    public Inventory(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//a[@id='item_4_title_link']")
    WebElement Item;

    @FindBy(xpath = "//a[@data-test='shopping-cart-link']")
    WebElement GoToCart;

    public InventoryItem openItem(){
        clickOn(Item);
        return new InventoryItem(driver);
    }
    public Cart cart(){
        clickOn(GoToCart);
        return new Cart(driver);
    }
}
