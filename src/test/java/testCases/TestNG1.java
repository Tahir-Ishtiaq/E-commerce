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
        // Standard clean way to pass profile configurations to an automated browser
        java.util.Map<String, Object> prefs = new java.util.HashMap<String, Object>();
        // 1. Turn off the credential storing services
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        // 2. THIS IS THE KEY: Turn off the data breach scan checking explicitly!
        prefs.put("profile.password_manager_leak_detection", false);
        options.setExperimentalOption("prefs", prefs);
        driver = new org.openqa.selenium.chrome.ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        login = new Login(driver);
    }

    /*@BeforeTest
    public void login(){
        org.openqa.selenium.chrome.ChromeOptions options = new org.openqa.selenium.chrome.ChromeOptions();

        // 1. Force incognito to isolate from local profile leak history
        options.addArguments("--incognito");

        // 2. Bruteforce kill the specific Save/Breach Password UI Bubble component
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-features=PasswordLeakDetection,AutofillPasswordGeneration");

        // 3. Clear out preference mappings entirely
        java.util.Map<String, Object> prefs = new java.util.HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        login = new Login(driver);
    }*/


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
