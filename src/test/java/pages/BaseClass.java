package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BaseClass {
    public WebDriver driver;
    public WebDriverWait wait;

    public BaseClass(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // 1. A simple, easy-to-remember pause helper
    public void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) { /* Ignore errors */ }
    }

    public void inputValue(WebElement locator, String input) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
        element.clear();

        // 2. Simple human typing logic: Split by empty string to get letters
        for (String letter : input.split("")) {
            element.sendKeys(letter);
            pause(50); // Clean and readable pause call
        }
    }

    public void clickOn(WebElement locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
        pause(1000); // 1-second pause before clicking so you can see it
        element.click();
    }
}



    /*public void inputValue(WebElement locator, String input){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
        prepareElement(element);
        element.clear();
        element.sendKeys(input);
    }*/