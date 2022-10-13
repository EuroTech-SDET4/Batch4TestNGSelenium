package com.eurotech.tests.day9_TypeOfElements2;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver=WebDriverFactory.getDriver("chrome");
        //driver.manage().window().maximize();

    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/");


        List<WebElement> menuList = driver.findElements(By.xpath("//a[text()='A/B Testing']/../../li"));

     //   List<WebElement> menuList = driver.findElements(By.tagName("li")); second way

        //get size
        System.out.println("menuList.size() = " + menuList.size());

        int expectedSize = 44;
        int actualSize= menuList.size();

        Assert.assertEquals(actualSize,expectedSize,"verify that menu size is 44");


        //print all elements
        for (WebElement element : menuList) {
            System.out.println("element.getText() = " + element.getText());
        }


    }

    @Test
    public void test2() {

        driver.get("https://demoqa.com/elements");
        //task --> go to that url and verify that 6 elements are there

        List<WebElement> menuList = driver.findElements(By.cssSelector(".header-text"));

        System.out.println("menuList.size() = " + menuList.size());

        int expectedSize=6;
        int actualSize= menuList.size();
        Assert.assertEquals(actualSize,expectedSize,"verify that menu size is 6");

        for (WebElement element : menuList) {
            System.out.println("element.getText() = " + element.getText());
            Assert.assertTrue(element.isDisplayed());
        }

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();
    }
}
