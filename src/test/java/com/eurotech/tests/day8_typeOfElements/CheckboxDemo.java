package com.eurotech.tests.day8_typeOfElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxDemo {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/automation-practice-form");


        //THIS IS HOMEWORK

        WebElement sportsCheckBox = driver.findElement(By.cssSelector("#hobbies-checkbox-1"));
        Assert.assertFalse(sportsCheckBox.isSelected(),"verify that sports is NOT selected");

        WebElement sport = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
        sport.click();

        Assert.assertTrue(sportsCheckBox.isSelected(),"verify that sport is selected");

        WebElement readingCheckBox = driver.findElement(By.cssSelector("#hobbies-checkbox-2"));
        WebElement reading = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-2']"));

        reading.click();

        Assert.assertTrue(readingCheckBox.isSelected(),"verify is selected");






        Thread.sleep(2000);
        driver.close();


    }


}
