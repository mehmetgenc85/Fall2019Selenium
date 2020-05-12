package com.automation.tests.vytrack.fleet;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VehiclePageTests {

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

    private By fleetBy= By.xpath("//span[@class='title title-level-1' and contains(text(),'Fleet')]");

    private By subTitleBy = By.className("oro-subtitle");


    @Test(description = "Check Fleet-->Vehicles page subtitle is equals to All Cars")

    public void verifyPageSubtitle(){
        // login
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(5);

        // click on fleet
        //driver.findElement(fleetBy).click();

        //Action class is used for more advanced browser interactions
        Actions actions = new Actions(driver);
        // move to element instead of click
        actions.moveToElement(driver.findElement(fleetBy)).perform();
        // perform -to execute command

        BrowserUtils.wait(5);

        // click on vehicles
        driver.findElement(By.linkText("Vehicles")).click();
        // put more wait time if you are getting cars, dashboard..
        // this application is slow...

        BrowserUtils.wait(5);

        // find subtitle element
        WebElement subTitleElement = driver.findElement(subTitleBy);
        System.out.println(subTitleElement.getText());

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
