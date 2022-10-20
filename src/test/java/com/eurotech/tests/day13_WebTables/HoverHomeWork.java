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

public class HoverHomeWork {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }


    @Test
    public void testName() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/hovers");

        driver.findElement(By.xpath("(//img)[2]"));
        List<WebElement> imgList = driver.findElements(By.tagName("img"));

        //img size = 4



        for (int i = 2; i <=imgList.size() ; i++) {

            String imgXpath="(//img)["+i+"]";
            System.out.println("xpath = " + imgXpath);

            WebElement img=driver.findElement(By.xpath(imgXpath));

            Actions actions = new Actions(driver);
            Thread.sleep(1000);
            actions.moveToElement(img).perform();

            String textPath= "//h5[text()='name: user"+(i-1)+"";
            //    //h5[text()='name: user"+i+"']   //h5[text()='name: user2']

            WebElement text = driver.findElement(By.xpath("//h5[text()='name: user"+(i-1)+"']"));

            System.out.println("textPath = " + textPath);
            Assert.assertTrue(text.isDisplayed(),"verify that user "+(i-1)+" is displayed");
            System.out.println("verify that user "+(i-1)+" is displayed");


        }

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.close();
    }
}
