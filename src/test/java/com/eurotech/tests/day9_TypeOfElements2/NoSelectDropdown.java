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

public class NoSelectDropdown {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver= WebDriverFactory.getDriver("chrome");
    }


    @Test
    public void test1() throws InterruptedException {

        driver.get("https://demo.aspnetawesome.com/");
        WebElement papayaDropdown = driver.findElement(By.xpath("(//div[text()='Papaya'])[1]"));
        papayaDropdown.click();

        List<WebElement> papayaList = driver.findElements(By.xpath("(//ul[@class='o-mnits'])[10]/li"));
        System.out.println("papayaList.size() = " + papayaList.size());

        Assert.assertEquals(papayaList.size(),5);  //-->short way

        for (WebElement papaya : papayaList) {
            System.out.println("papaya.getText() = " + papaya.getText());
        }

        Assert.assertEquals(papayaList.get(3).getText(),"Nuts");

        papayaList.get(2).click();

        Thread.sleep(1000);

    }

    @Test
    public void test2() throws InterruptedException {

        driver.get("https://demoqa.com/select-menu");

        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[@class=' css-1hwfws3'])[3]")).click();

        driver.findElement(By.xpath("//div[text()='Black']")).click();
        driver.findElement(By.xpath("//div[text()='Blue']")).click();
        driver.findElement(By.xpath("//div[text()='Red']")).click();
        driver.findElement(By.xpath("//div[text()='Green']")).click();


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();
    }
}
