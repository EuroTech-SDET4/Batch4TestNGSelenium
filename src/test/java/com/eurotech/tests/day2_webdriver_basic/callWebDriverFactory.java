package com.eurotech.tests.day2_webdriver_basic;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class callWebDriverFactory {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("firefox");
        driver.get("http://eurotech.study/");

        Thread.sleep(2000);
        driver.close();


    }
}
