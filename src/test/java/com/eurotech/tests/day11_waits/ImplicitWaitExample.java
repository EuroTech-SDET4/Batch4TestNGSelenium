package com.eurotech.tests.day11_waits;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitExample {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

        //setup once, all the findElement that will use this wait
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);





    }

    @Test
    public void testName() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.cssSelector("#checkbox-example>button")).click();

        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // wait maximum 20 seconds, if you find the element in 2 seconds go on.

        WebElement message = driver.findElement(By.id("message"));

        Assert.assertEquals(message.getText(),"It's gone!");




    }



    @AfterMethod
    public void tearDown() throws InterruptedException {


        Thread.sleep(2000);
        driver.close();
    }
}

