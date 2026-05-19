package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Inventory;
import pages.Login;

import java.sql.SQLOutput;

public class TestNG1 {
    WebDriver driver;
    Login login;

    
    @BeforeTest
    public void login(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        login = new Login(driver);
    }

    @Test
    public void loginUser(){

        if(driver.getPageSource().contains("Swag Labs") && driver.getPageSource().contains("Accepted usernames are:")){
            System.out.println("Text test PASSED");
        }


        Inventory inventory = login.loginUser("standard_user", "secret_sauce");
        inventory.openItem();
    }

    @AfterTest
    public void closeWindow(){
        driver.close();
    }
}
