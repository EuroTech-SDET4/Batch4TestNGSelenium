package com.eurotech.tests.day13_WebTables;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DynamicWebTables {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }


    @Test
    public void testName() throws InterruptedException {

        driver.get("https://demoqa.com/webtables");

        WebElement aldenName = driver.findElement(By.xpath("//div[@class='rt-tbody']/div[2]/div/div[1]"));
        System.out.println("Before click = " + aldenName.getText());

        WebElement lastName=driver.findElement(By.xpath("//div[text()='Last Name']"));
        lastName.click();

        String name="Alden";

        WebElement alden= driver.findElement(By.xpath("//div[@class='rt-tbody']//div[.='"+name+"']"));
        System.out.println("after click = " + alden.getText());

        Assert.assertEquals(alden.getText(),"Alden");


    }

    @Test
    public void testDynamic() throws InterruptedException {
        driver.get("https://demoqa.com/webtables");
        WebElement alden = driver.findElement(By.xpath("//div[@class='rt-tbody']//div[.='Kierra']"));
        WebElement lastName=driver.findElement(By.xpath("//div[text()='Last Name']"));
        System.out.println("Before click = " + alden.getText());
        lastName.click();

        Thread.sleep(2000);

        System.out.println("After Click= " + alden.getText());

      //  Assert.assertEquals(kierraName.getText(),"29");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.close();
    }
}
