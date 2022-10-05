package com.eurotech.tests.day4_basicLocators;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Duplicate {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");

        Faker fk = new Faker();
        driver.get("https://demo.aspnetawesome.com/");

        Thread.sleep(3000);
        driver.findElement(By.id("btnCookie")).click();

        System.out.println("driver.findElement(By.name(\"itemParentCat\")).getText() = " + driver.findElement(By.name("itemParentCat")).getText());


        Thread.sleep(3000);

        driver.close();
    }
}
