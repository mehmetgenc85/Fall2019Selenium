package com.automation.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumScript {
    public static void main(String[] args) {

//        Setup chromedriver
        WebDriverManager.chromedriver().setup();
//        Create ChromeDriver object
        ChromeDriver driver = new ChromeDriver();
//        Open some Website
        driver.get("http://google.com");
    }
}
