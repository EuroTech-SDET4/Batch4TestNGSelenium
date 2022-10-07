package com.eurotech.tests.day4_basicLocators;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class classNameTest {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");

        Faker fk = new Faker();
        driver.get("http://eurotech.study/login");

        //driver.manage().window().maximize();

        WebElement understandBtn = driver.findElement(By.id("rcc-confirm-button"));
        understandBtn.click();

        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys("eurotech@gmail.com");

        WebElement passwordInputBox = driver.findElement(By.xpath("password"));
        passwordInputBox.sendKeys("Test12345!");

        driver.findElement(By.id("loginpage-form-btn")).click();

        Thread.sleep(2000);

        System.out.println("driver.findElement(By.className(\"my-2\")).getText() = " + driver.findElement(By.className("large text-primary")).getText());

        Thread.sleep(2000);

        driver.close();

    }
}
