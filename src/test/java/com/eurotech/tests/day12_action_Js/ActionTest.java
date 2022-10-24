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

public class ActionTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/hovers");

        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));

        //Action --> class that contains all the user interactions
        Actions actions = new Actions(driver);
        Thread.sleep(2000);

        //perform() -->perform the action,complete the action
        //moveToElement() --> move you mouse to web element (hover over)
        actions.moveToElement(img2).perform();

        WebElement view_profile1 = driver.findElement(By.linkText("View profile"));


        System.out.println("view_profile1.getText() = " + view_profile1.getText());

        Assert.assertTrue(view_profile1.isDisplayed(),"verify that element is DISPLAYED");


    }

    @Test
    public void dragAndDrop() {

        driver.get("https://demoqa.com/droppable");

        WebElement source = driver.findElement(By.cssSelector("#draggable"));
        WebElement target = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(source,target).perform();

        WebElement verifyMessage = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        System.out.println("verifyMessage.getText() = " + verifyMessage.getText());

        //for the verify 1. way
        Assert.assertTrue(verifyMessage.isDisplayed());

        //2.way
        //Assert.assertEquals(verifyMessage.getText(),"Dropped!","verify that element has dropped");

    }

    @Test
    public void dragAndDrop2() {

        driver.get("https://demoqa.com/droppable");

        WebElement source = driver.findElement(By.cssSelector("#draggable"));
        WebElement target = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(3000).release().perform();


        WebElement verifyMessage = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        System.out.println("verifyMessage.getText() = " + verifyMessage.getText());

        Assert.assertTrue(verifyMessage.isDisplayed());
    }



    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.close();
    }
}
