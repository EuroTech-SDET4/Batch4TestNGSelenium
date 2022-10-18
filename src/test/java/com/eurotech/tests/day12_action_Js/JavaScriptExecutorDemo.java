package com.eurotech.tests.day12_action_Js;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutorDemo {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("https://www.amazon.co.uk/");

        driver.findElement(By.id("sp-cc-accept")).click();

        WebElement germany = driver.findElement(By.linkText("Germany"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", germany);


    }

    @Test
    public void typeWithJS() {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));
        String text = "Hello World!";

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].setAttribute('value', '" + text +"')", inputBox);



    }



    @Test
    public void scrollDownAndUP() throws InterruptedException {

        driver.get("https://www.amazon.co.uk/");
        driver.findElement(By.id("sp-cc-accept")).click();

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        for (int i = 0; i <10 ; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,500)");
        }
        for (int i = 0; i <10 ; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,-500)");
        }



    }
    @Test
    public void scrollToElement() {

        driver.get("https://www.amazon.co.uk/");
        driver.findElement(By.id("sp-cc-accept")).click();



        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement germany = driver.findElement(By.linkText("Germany"));

        jse.executeScript("arguments[0].scrollIntoView(true);", germany);
        jse.executeScript("arguments[0].click();", germany);


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.close();
    }

}
