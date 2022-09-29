package com.eurotech.tests.day3_webelement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyUrlChanged {

    public static void main(String[] args) throws InterruptedException {

        //open chrome browser
        // go to http://eurotech.study/login
        //enter email as eurotech@gmail.com
        //enter password as Test12345!
        //click login btn
        //verify that Url has changed
        WebDriver driver = WebDriverFactory.getDriver("Chrome");

        driver.get("http://eurotech.study/login");

        WebElement understandBtn = driver.findElement(By.id("rcc-confirm-button"));
        understandBtn.click();

        //enter email
        String email = "eurotech@gmail.com";
        String password = "Test12345!";
        WebElement emailInputBox = driver.findElement(By.id("loginpage-input-email"));
        emailInputBox.sendKeys(email);

        //enter password
        WebElement passwordInputBox= driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("Test12345!");

        //click login button
        WebElement loginBtn = driver.findElement(By.id("loginpage-form-btn"));
        loginBtn.click();

        Thread.sleep(2000);

        String expectedUrl="http://eurotech.study/dashboard";
        String actualUrl=driver.getCurrentUrl();

        if(expectedUrl.equals(actualUrl)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }

        Thread.sleep(2000);
        driver.close();

    }
}
