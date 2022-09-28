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

        //We have to enter this line every time we want open chrome
        //hey webdrivermanager can you make chrome ready for me for automation
        WebDriverManager.chromedriver().setup();

        //WEBDRIVER represent the browser
        //we are creating driver for chrome browser
        //new chromeDriver() --> this part will open chrome browser
        WebDriver driver = new ChromeDriver(); //poly
        driver.get("https://www.eurotechstudy.com");




    }
}
