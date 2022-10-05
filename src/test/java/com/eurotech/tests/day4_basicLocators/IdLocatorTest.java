package com.eurotech.tests.day4_basicLocators;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IdLocatorTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        Faker fk = new Faker();
        driver.get("https://demoqa.com/text-box");

      //  driver.manage().window().maximize();

        WebElement inputUserName = driver.findElement(By.id("userName"));



        inputUserName.sendKeys(fk.name().fullName());

        WebElement inputUserEmail = driver.findElement(By.id("userEmail"));


        inputUserEmail.sendKeys(fk.internet().emailAddress());

        Thread.sleep(2000);

        driver.close();

    }
}
