package com.eurotech.tests.day3_webelement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class getAttribute {

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("Chrome");

        driver.get("http://eurotech.study/login");

        WebElement understandBtn = driver.findElement(By.id("rcc-confirm-button"));
        understandBtn.click();

        //enter email
        String email = "eurotech@gmail.com";

        Thread.sleep(2000);

        WebElement emailInputBox = driver.findElement(By.id("loginpage-input-email"));
        emailInputBox.sendKeys(email);

        Thread.sleep(2000);

        //getAttrubute --> give me attribute I will give you value
        String value = emailInputBox.getAttribute("placeholder");
        System.out.println("value = " + value);

        driver.close();

    }
}
