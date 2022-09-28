package com.eurotech.tests.day2_webdriver_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {

    public static void main(String[] args) throws InterruptedException {
        //go to google
        //go to facebook
        //back
        // you will see google again

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(); //empty browser

        driver.get("https://www.google.com");

        Thread.sleep(3000);

        driver.navigate().to("https://www.facebook.com");

        Thread.sleep(2000);

        driver.navigate().back();

        Thread.sleep(2000);

      //  driver.navigate().forward();

        driver.navigate().refresh();

    }
}
