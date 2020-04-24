package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;

public class SelectByText {

    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        //create webelement object for drop-down first
        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));
        // provide webelement object into constructor
        Select selectSimpleDropdown= new Select(simpleDropdown);
        // select by visible text
        selectSimpleDropdown.selectByVisibleText("Option 2");




        BrowserUtils.wait(3);
        driver.quit();

    }
}
