package com.eurotech.tests.day9_TypeOfElements2;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropdownTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver= WebDriverFactory.getDriver("chrome");

    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("https://demoqa.com/select-menu");

        //1 locate element which has select tag name
        WebElement colorDropdown = driver.findElement(By.cssSelector("#oldSelectMenu"));

        Select color = new Select(colorDropdown);

        List<WebElement> colorList = color.getOptions();

        //verify that size is 11
        System.out.println("colorList.size() = " + colorList.size());
        Assert.assertEquals(colorList.size(),11);

        for (WebElement element : colorList) {
            System.out.println("element.getText() = " + element.getText());
        }

        //verify that default color is Red
        String expectedColor= "Red";
        String actualColor = color.getFirstSelectedOption().getText();

        Assert.assertEquals(actualColor,expectedColor,"verify that default color is Red");

        //how can we click each of element

        //1 using visible text
        Thread.sleep(2000);
        color.selectByVisibleText("Yellow"); //select yellow

        expectedColor ="Yellow";
        actualColor =color.getFirstSelectedOption().getText();

        Assert.assertEquals(actualColor,expectedColor);

        //2 using index
        Thread.sleep(2000);
        color.selectByIndex(0);
        expectedColor ="Red";
        actualColor=color.getFirstSelectedOption().getText();

        Assert.assertEquals(actualColor,expectedColor);

        //3 select by value
        Thread.sleep(2000);
        color.selectByValue("7");
        expectedColor="Voilet";
        actualColor=color.getFirstSelectedOption().getText();

        Assert.assertEquals(actualColor,expectedColor);



    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

    }
}
