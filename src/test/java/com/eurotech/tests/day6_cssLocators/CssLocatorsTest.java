package com.eurotech.tests.day6_cssLocators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CssLocatorsTest {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://eurotech.study/login");

        driver.findElement(By.cssSelector("#loginpage-input-email ")).sendKeys("eurotech");



        driver.close();
    }
}
