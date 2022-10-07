package com.eurotech.tests.day4_basicLocators;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class browserStackTask {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");

        Faker fk = new Faker();
        driver.get("https://www.browserstack.com/users/sign_up");


        driver.findElement(By.name("user[full_name]")).sendKeys(fk.name().fullName());
        driver.findElement(By.name("user[email]")).sendKeys(fk.internet().emailAddress());
        driver.findElement(By.id("user_password")).click();
        driver.findElement(By.id("user_password")).sendKeys(fk.internet().password());

        driver.findElement(By.name("terms_and_conditions")).click();

        Thread.sleep(2000);

    }
}
