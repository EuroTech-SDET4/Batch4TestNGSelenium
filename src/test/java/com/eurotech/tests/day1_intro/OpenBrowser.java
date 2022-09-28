package com.eurotech.tests.day1_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowser {
    public static void main(String[] args) {


        // WebDriverManager.firefoxdriver().setup();
        //  WebDriver driver = new FirefoxDriver();

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(); //poly

        driver.get("https://www.eurotechstudy.com");



    }
}
