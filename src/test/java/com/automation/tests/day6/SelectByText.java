package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;
import java.util.List;

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
        // and select option 1
        selectSimpleDropdown.selectByVisibleText("Option 1");

        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));

        selectDay.selectByVisibleText("1");
        selectMonth.selectByVisibleText("February");
        selectYear.selectByVisibleText("2003");

        // select all months one by one
        List<WebElement> months = selectMonth.getOptions();
        for (WebElement eachmonth:months){
            // get the month name and select based on that
            String monthName = eachmonth.getText();
            selectMonth.selectByVisibleText(eachmonth.getText());
            BrowserUtils.wait(1);
        }





        BrowserUtils.wait(3);
        driver.quit();

    }
}