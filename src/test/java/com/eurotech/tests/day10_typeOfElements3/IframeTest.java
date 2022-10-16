package com.eurotech.tests.day10_typeOfElements3;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver= WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void iframe() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/iframe");

        //how to switch the iframe

        //first way using name or id
        driver.switchTo().frame("mce_0_ifr");


        WebElement textArea = driver.findElement(By.cssSelector("#tinymce"));
        textArea.clear();
        textArea.sendKeys("Eurotech Was Here");

        //2 way switching Index
        driver.switchTo().parentFrame();
        Thread.sleep(1000);
        driver.switchTo().frame(0);
        textArea.clear();
        textArea.sendKeys("Eurotech Was Here");

        driver.switchTo().parentFrame();

        //3 way using web Element
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        textArea.clear();
        textArea.sendKeys("This is third way");


    }

    @Test
    public void nestedIframe() {

        driver.get("https://the-internet.herokuapp.com/nested_frames");

        //switch the middle frame and get MIDDLE text

        driver.switchTo().frame("frame-top");


        driver.switchTo().frame("frame-middle");

        System.out.println("driver.findElement(By.cssSelector(\"content\")).getText() = " + driver.findElement(By.cssSelector("#content")).getText());


        //go to Right frame and get text
        driver.switchTo().parentFrame();      //selenium switch the parent
      //  driver.switchTo().defaultContent(); // selenium switch the top
      //  driver.switchTo().frame("frame-top");
        driver.switchTo().frame(2);
        System.out.println("driver.findElement(By.tagName(\"body\")).getText() = " + driver.findElement(By.tagName("body")).getText());


        //go to bottom frame and get text
        driver.switchTo().defaultContent();
       // driver.switchTo().frame(1);
        driver.switchTo().frame("frame-bottom");
        System.out.println("driver.findElement(By.tagName(\"body\")).getText() = " + driver.findElement(By.tagName("body")).getText());


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {


        Thread.sleep(2000);
        driver.close();
    }
}
