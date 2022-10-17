package com.eurotech.tests.day11_waits;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThreadSleepExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");



    }

    @Test
    public void testName() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.cssSelector("#start>button")).click();


        Thread.sleep(5000);
        WebElement hello = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        Assert.assertEquals(hello.getText(),"Hello World!");


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {


        Thread.sleep(2000);
        driver.close();
    }
}
