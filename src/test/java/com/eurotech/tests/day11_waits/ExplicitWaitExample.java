package com.eurotech.tests.day11_waits;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitExample {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);



    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.cssSelector("#start>button")).click();

        //How to wait explicitly?
        //Create an explicit object wait
        WebDriverWait wait = new WebDriverWait(driver,15);



        WebElement hello = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        wait.until(ExpectedConditions.visibilityOf(hello));  // it will wait up t0 15 seconds until hello element is visible

        System.out.println("hello.getText() = " + hello.getText());

        Assert.assertEquals(hello.getText(),"Hello World!");


    }

    @Test
    public void test2() {


        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//button[text()='Enable']")).click();

        WebDriverWait wait = new WebDriverWait(driver,10);

        WebElement inputBox = driver.findElement(By.cssSelector("input[type=text]"));
        wait.until(ExpectedConditions.elementToBeClickable(inputBox));

        inputBox.sendKeys("Eurotech");

        WebElement message = driver.findElement(By.cssSelector("#message"));
        Assert.assertEquals(message.getText(),"It's enabled!");


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {


     //   Thread.sleep(2000);
        driver.close();
    }
}

