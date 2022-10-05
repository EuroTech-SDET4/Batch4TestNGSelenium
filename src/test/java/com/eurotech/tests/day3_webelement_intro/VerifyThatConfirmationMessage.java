package com.eurotech.tests.day3_webelement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatConfirmationMessage {


    public static void main(String[] args) throws InterruptedException {

        //open chrome browser
        // go to http://eurotech.study/login
        //enter email as eurotech@gmail.com
        //enter password as Test12345!
        //click login btn
        //verify that welcome message is "Welcome Eurotech"

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


        //two ways to get text from web elements
        //1. getText() --> it will work %99 work and it will return string
        //2. getAttribute("value") --? second way of getting text especially input box
        String expectedText ="Welcome Eurotech";
        WebElement welcomeText = driver.findElement(By.id("dashboard-p1"));
        System.out.println("welcomeText.getText() = " + welcomeText.getText());


        String actualText=welcomeText.getText();

        if(expectedText.equals(actualText)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }


        driver.close();





    }
}
