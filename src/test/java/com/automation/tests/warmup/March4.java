package com.automation.tests.warmup;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class March4 {
    static WebDriver driver;

    public static void main(String[] args) throws Exception {
 //       ebayTest();
 //       amazonTest();
        wikiTest();
    }
    /**
     * Go to ebay --->          driver.get("http://ebay.com");
     * enter search term        input.sendKeys("java book");
     * click on search button   searchButton.click();
     * print number of results
     */

    private static void ebayTest() {
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("java book");
        driver.findElement(By.id("gh-btn")).click();
        WebElement searchResults = driver.findElement(By.tagName("h1"));
        System.out.println(searchResults.getText());

        driver.quit();
    }



    /**
     * go to amazon
     * enter search term
     * click on search button
     * verify title contains search term
     */
    private static void amazonTest() throws Exception {
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://amazon.com/");
        // enter text and click ENTER
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book", Keys.ENTER);

        Thread.sleep(2000);


        String title =driver.getTitle();
                if(title.contains("java book")) {
                    System.out.println("TEST PASSED");
                }else {
                    System.out.println("TEST FAILED");
                }

        driver.quit();
    }

    /**
     * Go to wikipedia.org
     * enter search term `selenium webdriver`
     *  search FOR result `Selenium (software)`
     * verify url ends with `Selenium_(software)`
     */
    private static void wikiTest() throws Exception{
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://en.wikipedia.org/wiki/Main_Page");

        driver.findElement(By.id("searchInput")).sendKeys("Selenium (software)",Keys.ENTER);
        String link = driver.getCurrentUrl(); // TO GET LINK AS A STRING

        Thread.sleep(2000);

if (link.endsWith("Selenium_(software)")){
    System.out.println("TEST PASSED");
}else {
    System.out.println("TEST FAILED");
}

        driver.quit();
    }
}
