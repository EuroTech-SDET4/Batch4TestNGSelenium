package com.eurotech.tests.day8_typeOfElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demo.aspnetawesome.com/");

        //verify that legumes is selected
        Thread.sleep(3000);

        WebElement vegetablesRadio = driver.findElement(By.xpath("//div[text()='Vegetables']/..//input"));
        WebElement legumeRadio = driver.findElement(By.xpath("//div[text()='Legumes']/..//input"));

        System.out.println("vegetablesRadio.isSelected() = " + vegetablesRadio.isSelected());

        Assert.assertTrue(vegetablesRadio.isSelected(),"verify that vegetables radio is selected");
        Assert.assertFalse(legumeRadio.isSelected(),"verify legumes radio is NOT selected");

        WebElement legume = driver.findElement(By.xpath("//div[text()='Legumes']/..//input/../div[1]"));
        legume.click();

        Thread.sleep(1000);
        Assert.assertTrue(legumeRadio.isSelected(),"verify legumes radio is selected");
        Assert.assertFalse(vegetablesRadio.isSelected(),"verify vegetables radio is NOT selected");


        driver.close();

    }

    @Test
    public void test2() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));

        Assert.assertTrue(checkbox2.isSelected(),"verify that checkbox 2 is selected");
        Assert.assertFalse(checkbox1.isSelected(),"verify that checkbox 1 is NOT selected");

        Thread.sleep(2000);
        checkbox1.click();

        Thread.sleep(2000);
        checkbox2.click();

        Assert.assertFalse(checkbox2.isSelected());
        Assert.assertTrue(checkbox1.isSelected());

        Thread.sleep(1000);
        driver.close();


    }
}
