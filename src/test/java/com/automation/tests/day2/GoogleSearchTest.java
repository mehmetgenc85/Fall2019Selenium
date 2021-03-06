package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://google.com");

        Thread.sleep(2000);

        //By.name("q") ---> name="q"
        // name - it is one of the selenium locators
        // we use locators to find elements
        // to choose locators, just use By/locator
        WebElement search =driver.findElement(By.name("q"));
        // once we found an element, how to enter text?
        // to enter text, use sendKeys() method
        // how to press enter after entering text?
        //use Key.ENTER
        //Keys.ENTER - Perform keyboard click
        // keysTosend - name of the parameter, we dont specify it

        search.sendKeys("Java", Keys.ENTER);

        // 2000 - 2 seconds
        // 12000 - 12 seconds
        // Thread.sleep () - is used to pause java program
        Thread.sleep(2000);

        WebElement news = driver.findElement(By.linkText("News"));
        news.click(); //to click on element
        Thread.sleep(2000);

        driver.quit();

    }
}
