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

      //  WebElement sport = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
        WebElement sport = driver.findElement(By.cssSelector("#hobbies-checkbox-1"));
        Assert.assertFalse(sport.isSelected());
        System.out.println("sport.getText() = " + sport.getText());

        WebElement reading = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-2']"));
        WebElement music = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-3']"));

        Assert.assertFalse(reading.isSelected(),"verify that reading is NOT selected");
        Assert.assertFalse(music.isSelected(),"verify that music is NOT selected");

        sport.click();
      //  music.click();
        //reading.click();

        Thread.sleep(4000);

        Assert.assertTrue(sport.isSelected(),"verify that sport is selected");
      //  Assert.assertTrue(reading.isSelected(),"verify that reading is selected");
        //Assert.assertTrue(music.isSelected(),"verify that music is selected");

        Thread.sleep(2000);

        driver.close();

    }
}
