package com.eurotech.tests.day2_webdriver_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class closeAndQuit {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://eurotech.study/");

        Thread.sleep(2000);
        //close current tab
        driver.close();

     //   driver=new ChromeDriver();
        driver.get("https://www.facebook.com");

        Thread.sleep(2000);

        //close all tabs
        driver.quit();




    }
}
