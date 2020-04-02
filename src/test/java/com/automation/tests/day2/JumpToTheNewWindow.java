package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToTheNewWindow {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(5000);

        // every window has some id, this id calls window handle
        // based on window handle, we can switch in between windows

        String WindowHandle = driver.getWindowHandle();

        System.out.println(WindowHandle);

        Set<String> WindowHandles = driver.getWindowHandles();

        System.out.println(WindowHandles);
        System.out.println("BEFORE SWITCH :" + driver.getCurrentUrl());

        // since we have all windows
        // and we know id of original window
        // we can say switch to something that is now equals to old window id

        for (String windowID : WindowHandles) {
            // if it is's not an old window, then switch
            if (windowID.equals(WindowHandle)) {
                // to jump to the new window
                driver.switchTo().window(windowID);
            }
        }

        System.out.println("AFTER SWITCH :" + driver.getCurrentUrl());

        driver.close();
    }

    // THIS METHOD HELPS TO SWITCH IN BETWEEN WINDOWS BASED ON PAGE TITLE

    public static void switchToWindowBasedOnTitle(String pageTitle, WebDriver driver){

        Set<String> windows = driver.getWindowHandles();
        for (String window : windows){
            driver.switchTo().window(window);
            if (driver.getTitle().equals(pageTitle)){
                break;
            }
        }

    }
}
