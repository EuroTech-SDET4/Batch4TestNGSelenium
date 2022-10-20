package com.eurotech.tests.day13_WebTables;

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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTables {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
        driver.findElement(By.cssSelector("#ez-accept-all")).click();
        WebElement demoTable = driver.findElement(By.xpath("//h3[text()='Demo Table 2']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",demoTable);



    }


    @Test
    public void printTable() throws InterruptedException {

        WebElement tableDemo = driver.findElement(By.xpath("//table[@border='1']"));
        System.out.println("tableDemo.getText() = " + tableDemo.getText());

        Assert.assertTrue(tableDemo.getText().contains("Mecca"));


    }

    @Test
    public void getAllHeaders() {

        //How many columns we have

        //get all headers
        List<WebElement> allHeaders = driver.findElements(By.xpath("//table[@border='1']/thead//th"));
        System.out.println("allHeaders.size() = " + allHeaders.size()); //7

        for (WebElement header : allHeaders) {
            System.out.println("header.getText() = " + header.getText());
        }

        System.out.println("***************************");

        //getRow size
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@border='1']/tbody/tr"));
        System.out.println("allRows.size() = " + allRows.size());

        for (WebElement allRow : allRows) {
            System.out.println("allRow.getText() = " + allRow.getText());
        }


    }

    @Test
    public void getRows() {
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@border='1']/tbody/tr"));

        //get second row which is starting tower hotel
        WebElement clockTower = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]"));
        System.out.println("clockTower.getText() = " + clockTower.getText());

        for (int i = 1; i <=allRows.size() ; i++) {

            WebElement row = driver.findElement(By.xpath("//table[@border='1']/tbody/tr["+i+"]"));
            System.out.println(i+"-"+ row.getText());

        }


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.close();
    }
}


