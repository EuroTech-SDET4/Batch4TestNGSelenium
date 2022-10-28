package com.eurotech.tests.day12_action_Js;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FileUpload {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement chooseFile = driver.findElement(By.cssSelector("#file-upload"));


        chooseFile.sendKeys("/Users/erhanilgar/Desktop/Eurotech.txt");



    }

    @Test
    public void test2() {

        System.out.println("System.setProperty(\"user.dir\") = " + System.getProperty("user.dir"));

        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));


        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement chooseFile = driver.findElement(By.cssSelector("#file-upload"));

        String projectPath = System.getProperty("user.dir");
        String filePath ="src/test/resources/Eurotech.txt";

        String fullPath = projectPath+"/"+filePath;

        System.out.println(fullPath);

        chooseFile.sendKeys(fullPath);

        driver.findElement(By.id("file-submit")).click();

        String actualText = driver.findElement(By.id("uploaded-files")).getText();

        Assert.assertEquals(actualText,"Eurotech.txt");







    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(3000);
        driver.close();
    }
}

