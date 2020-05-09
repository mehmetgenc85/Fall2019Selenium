package com.automation.tests.vytrack.login;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
// STATIC IMPORT OF ALL ASSERTIONS


public class LoginPageTests {

    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/user/login";
    //    CREDENTIALS FOR store manager
    private String username = "storemanager85";
    private String password = "UserUser123";
    // https is a secured version of http protocol
    // http - it`s hypertext transfer protocol that every single website using nowadays
    // https - data encrypted. no chance gor hackers retrieve info
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    // > in css selector means same thing as / in xpath - direct child
    private By warningMessageBy = By.cssSelector("[class='alert alert-error'] > div");



    @Test(description = "Verify that warning message displays when user enters invalid username")
    public void invalidUsername(){
        driver.findElement(usernameBy).sendKeys("invalidusername");
        driver.findElement(passwordBy).sendKeys("UserUser123", Keys.ENTER);
        BrowserUtils.wait(3);

        WebElement warningElement = driver.findElement(warningMessageBy);
        assertTrue(warningElement.isDisplayed());

        String expected = "Invalid user name or password.";
        String actual = warningElement.getText();
        assertEquals(actual, expected);
    }

    @Test(description = "Login as store manager and verify that tile is equals to Dashboard")
    public void loginAsStoreManager(){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(3);

        String expected = "Dashboard";
        String actual = driver.getTitle();

        assertEquals(actual,expected, "Page title os not correct!!!");
    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void teardown(){
        // if webdriver object alive
        if (driver !=null){
            // close browser, close session
            driver.quit();
            // destroy driver object for sure
            driver=null;
        }
    }





}
