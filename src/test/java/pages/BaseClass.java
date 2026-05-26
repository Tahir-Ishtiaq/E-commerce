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

    private void prepareElement(WebElement element) {
        try {
            // 1. Highlight the element using JavaScript (gives it a red border)
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].style.border='2px solid Red'", element);

            // 2. Pause for 1 second (1000 milliseconds) so human eyes can track it
            Thread.sleep(1000);

            // 3. Optional: Clear the highlight after the pause
            js.executeScript("arguments[0].style.border=''", element);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            //
        }
    }

    public void inputValue(WebElement locator, String input) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
        prepareElement(element);
        element.clear();
        for (String letter : input.split("")) {
            element.sendKeys(letter);
            pause(50); // Clean and readable pause call
        }
    }

    public void clickOn(WebElement locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
        prepareElement(element);
        pause(1000);
        element.click();

    }

}



    /*public void inputValue(WebElement locator, String input){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
        prepareElement(element);
        element.clear();
        element.sendKeys(input);
    }*/