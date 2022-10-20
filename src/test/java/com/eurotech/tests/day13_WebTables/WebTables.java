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

    @Test
    public void getAllCellOnOneRow() {

        //get Burj Khalifa's info as a list
        List<WebElement> burjKhalifa = driver.findElements(By.xpath("//table[@border='1']/tbody/tr[1]/td"));
        System.out.println("burjKhalifa.size() = " + burjKhalifa.size());
        Assert.assertEquals(burjKhalifa.size(),6);

        for (WebElement burj : burjKhalifa) {
            System.out.println("burj.getText() = " + burj.getText());
        }
    }

    @Test
    public void getSingleCell() {

        //get height of Clock Tower Hotel
        //verify that height is 601m
        WebElement heightOfClockTower = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]/td[3]"));
        System.out.println("heightOfClockTower.getText() = " + heightOfClockTower.getText());
        Assert.assertEquals(heightOfClockTower.getText(),"601m");
    }

    @Test
    public void printAllCellByIndex() {

        int rowNumber = getNumberOfRows();
        int columnNumber = getNumberOfColumn();

        System.out.println("rowNumber = " + rowNumber);  //4
        System.out.println("columnNumber = " + columnNumber); //7 28

        //iterate through each row on the table
        for (int i = 1; i <=rowNumber ; i++) {

            //iterate through each cell in the row
            for (int j = 1; j <columnNumber ; j++) {

                String cellXpath= "//table[@border='1']/tbody/tr["+i+"]/td["+j+"]"; //only locator
                System.out.println("cellXpath = " + cellXpath);
                WebElement cell = driver.findElement(By.xpath(cellXpath));
                System.out.println("cell.getText() = " + cell.getText());

            }
        }

    }

    private int getNumberOfColumn() {

        List<WebElement> columns = driver.findElements(By.xpath("//table[@border='1']/thead//th"));

        return columns.size();
    }

    private int getNumberOfRows() {

        List<WebElement> rows = driver.findElements(By.xpath("//table[@border='1']/tbody/tr"));
        return rows.size();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.close();
    }
}


