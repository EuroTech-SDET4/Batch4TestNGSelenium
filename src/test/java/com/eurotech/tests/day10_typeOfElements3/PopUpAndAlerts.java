package com.eurotech.tests.day10_typeOfElements3;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopUpAndAlerts {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver= WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void PopUP() throws InterruptedException {

        driver.get("http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=04226");

        driver.findElement(By.xpath("(//span[text()='Confirm'])[1]")).click();

        driver.findElement(By.xpath("(//span[text()='Yes'])[2]")).click();

        Thread.sleep(1000);

        //verify that confirm is accepted
        String expectedMessage="You have accepted";

        WebElement actualMessage = driver.findElement(By.xpath("//p[text()='You have accepted']"));

        Assert.assertEquals(actualMessage.getText(),expectedMessage);

    }

    @Test
    public void JsAlerts() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();


        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        alert.accept();

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        Thread.sleep(3000);
        alert.dismiss();

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(3000);
        alert.sendKeys("Eurotech Batch 4");
        Thread.sleep(2000);
        alert.accept();

        //homework
        //verify all results above JS Alerts


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
