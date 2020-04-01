package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {

    public static void main(String[] args) throws Exception {
        // to start selenium script we need:
        // setup webdriver(browsert driver) and create webdriver object
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        // In selenium, everything starts from Webdriver interface
        // Chrome driver extends RemoteWebdriver ---> implements Webdriver

        driver.get("http://google.com"); // to open a website
        driver.manage().window().maximize(); // to maximize browser
        //driver.manage().window().fullscreen();

        Thread.sleep( 3000 ); // for demo, wait 3 seconds

        String title = driver.getTitle(); // returns <title> Some title</title> text
        String expectedTitle = "Google";
        System.out.println("Title is..." +title);
        if(expectedTitle.equals(title)) {

            System.out.println("TEST PASSED !");
        }else{
            System.out.println("TEST FAILED !");
        }

        // go to another website within the same window

        driver.navigate().to("http://amazon.com");

        if(driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("TEST PASSED !");
        }else{
            System.out.println("TEST FAILED !");
        }


       //MUST BE AT THE END
        driver.close(); // to close browser

        //browser cannot close itself
    }

    public static void verifyEquals(String arg1, String arg2){

        if (arg1.equals(arg2)){
            System.out.println("TEST PASSED !");
        }else{
            System.out.println("TEST FAILED !");
        }
    }

}

