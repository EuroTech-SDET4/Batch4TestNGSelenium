package com.eurotech.tests.day8_typeOfElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisableElements {


    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement disableElement = driver.findElement(By.cssSelector("#input-example>input"));

        Assert.assertFalse(disableElement.isEnabled(),"verify that element is NOT enable or element is disable");


        WebElement enableButton = driver.findElement(By.cssSelector("#input-example>button"));
        enableButton.click();

        Thread.sleep(4000);

        Assert.assertTrue(disableElement.isEnabled(),"verify that element is enable");



        driver.close();

    }


}
