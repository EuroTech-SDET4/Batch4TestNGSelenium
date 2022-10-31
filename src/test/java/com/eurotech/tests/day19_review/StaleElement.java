package com.eurotech.tests.day19_review;

import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class StaleElement extends TestBase {

    @Test
    public void staleProblem(){

        driver.get("https://freecrm.com/");

        WebElement loginButton= driver.findElement(By.linkText("Login"));
        loginButton.click();

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("Email@gmail.com");

        WebElement passwordInput= driver.findElement(By.name("password"));
        passwordInput.sendKeys("12345");

        driver.navigate().refresh();
        BrowserUtils.waitFor(2);

        emailInput.sendKeys("email@hotmail.com");

    }

    @Test
    public void staleFix() {
        driver.get("https://freecrm.com/");

        WebElement loginButton= driver.findElement(By.linkText("Login"));
        loginButton.click();

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("Email@gmail.com");

        WebElement passwordInput= driver.findElement(By.name("password"));
        passwordInput.sendKeys("12345");

        driver.navigate().refresh();
        BrowserUtils.waitFor(2);

        try {
            emailInput.sendKeys("email@hotmail.com");
        }
        catch (StaleElementReferenceException e){
            emailInput = driver.findElement(By.name("email"));
            emailInput.sendKeys("email@hotmail.com");
        }
    }
}
