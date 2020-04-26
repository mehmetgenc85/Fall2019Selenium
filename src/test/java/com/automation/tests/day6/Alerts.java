package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(3);

        System.out.println("SYSTEM TEST 1");
        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        buttons.get(0).click(); // to click on the first button
        BrowserUtils.wait(3);
        // TO GET THE TEXT FROM POPUP MESSAGE

        String popupText = driver.switchTo().alert().getText();
        System.out.println(popupText);

        driver.switchTo().alert().accept(); // to click OK
        String expected = "You successfully clicked an alert"; // it will fail because of there is a typo
        String actual = driver.findElement(By.id("result")).getText();

        // it will fail because of there is a typo
        if(expected.equals(actual)) {
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
            System.out.println("Expected: "+expected);
            System.out.println("Actual:" +actual);
        }
        BrowserUtils.wait(3);

        System.out.println("SYSTEM TEST 2");

        buttons.get(1).click(); // to click on the second button
        BrowserUtils.wait(3);
        // to click cancel
        driver.switchTo().alert().dismiss(); // result must be" You clicked: Cancel

        String expected2 = "You clicked: Cancel";
        String actual2 = driver.findElement(By.id("result")).getText();

        if(expected2.equals(actual2)) {
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
            System.out.println("Expected: "+expected2);
            System.out.println("Actual:" +actual2);
        }
        System.out.println("SYSTEM TEST 3");
        //TASK: click on button #3
        //Enter some text: Hello, World!
        // Verify that result text  ends with Hello World!

        buttons.get(2).click(); // to click on the third button
        BrowserUtils.wait(3);
        // to click cancel

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello, World!");
        alert.accept(); // click ok

        String actual3 = driver.findElement(By.id("result")).getText();
        String expected3 = "Hello, World!";


        if(actual3.endsWith(expected3)) {
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
            System.out.println("Expected: "+expected3);
            System.out.println("Actual:" +actual3);

        BrowserUtils.wait(3);
        driver.quit();
        }
    }
}
