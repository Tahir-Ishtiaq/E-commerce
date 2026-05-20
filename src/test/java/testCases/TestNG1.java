package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Login;


public class TestNG1 {
    WebDriver driver;
    Login login;


    @BeforeTest
    public void login(){
        org.openqa.selenium.chrome.ChromeOptions options = new org.openqa.selenium.chrome.ChromeOptions();
        //options.addArguments("--incognito");
        java.util.Map<String, Object> prefs = new java.util.HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        options.setExperimentalOption("prefs", prefs);
        driver = new org.openqa.selenium.chrome.ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        login = new Login(driver);
    }

    @Test
    public void loginUser(){
        if(driver.getPageSource().contains("Swag Labs") && driver.getPageSource().contains("Accepted usernames are:")){
            System.out.println("Text test PASSED");
        }
        login
        .loginUser("standard_user", "secret_sauce")
        .openItem()
        .addAndGoBack()
        .cart()
        .checkOut()
        .checkOutOne("Tahir", "Ishtiaq", "75550")
        .Finish()
        .backToInventory();
    }

    @AfterTest
    public void closeWindow(){
        driver.close();
    }
}
