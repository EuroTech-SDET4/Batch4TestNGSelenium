package com.eurotech.tests;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

   protected WebDriver driver;
   protected Actions actions;
   protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver= Driver.get();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        actions=new Actions(driver);
        wait=new WebDriverWait(driver,15);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {


        Thread.sleep(2000);
        Driver.closeDriver();

    }

}
