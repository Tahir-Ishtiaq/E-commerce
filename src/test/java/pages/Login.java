package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends BaseClass{
    public Login(WebDriver driver){
        super(driver);
    }

    @FindBy(id="user-name")
    WebElement Username;

    @FindBy(id="password")
    WebElement Password;

    @FindBy(id="login-button")
    WebElement Loginbutton;

    public Inventory loginUser(String userName, String password){
        inputValue(Username, userName);
        inputValue(Password, password);
        clickOn(Loginbutton);
        return new Inventory(driver);
    }

}
