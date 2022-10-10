package com.eurotech.tests.day5_xpathLocators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonHw {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        String product ="Apple";

        driver.get("https://www.amazon.co.uk/");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='sp-cc-accept']")).click();

        driver.findElement(By.xpath("//input[@type='text'][@id='twotabsearchtextbox']")).sendKeys(product);

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        String actualText= driver.findElement(By.xpath("//span[contains(text(),'results for')]/..")).getText();

        System.out.println(actualText);

        if(actualText.contains(product)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }

        driver.close();

    }
}
