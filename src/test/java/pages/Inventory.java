package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Inventory extends BaseClass{
    public Inventory(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//button[text()='Add to cart']")
    WebElement Addtocart;

    @FindBy(xpath = "//a[@id='item_4_title_link']")
    WebElement Item;


    public InventoryItem openItem(){
        clickOn(Item);
        clickOn(Addtocart);
        return new InventoryItem();
    }
}
