package com.eurotech.tests.day10_typeOfElements3;

import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver= WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void twoWindows() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/windows");
        String titleBeforeClick = driver.getTitle();
        System.out.println("titleBeforeClick = " + titleBeforeClick);

        WebElement click_here = driver.findElement(By.linkText("Click Here"));
        click_here.click();
        Thread.sleep(1000);
//        String titleAfterClick = driver.getTitle();



        String currentTab = driver.getWindowHandle();  // title The internet and has ID CDwindow-ABD4B0E3A8DA32DB175B50AB75D78CA0

        System.out.println("currentTab = " + currentTab);

        Set<String> windowHandles = driver.getWindowHandles();

        for (String tab : windowHandles) {
            if(!tab.equals(currentTab)){
                driver.switchTo().window(tab);
            }

        }

        System.out.println("titleAfterClick = " + driver.getTitle());

    }

    @Test
    public void multipleWindows() {
        driver.get("https://the-internet.herokuapp.com/windows");

        System.out.println("driver.getTitle() = " + driver.getTitle());

        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());

        WebElement click_here = driver.findElement(By.linkText("Click Here"));
        click_here.click();
        click_here.click();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String tab : windowHandles) {
            driver.switchTo().window(tab);
            if(driver.getCurrentUrl().equals("New Window")){  //title is New Window
                //stop on this window
                break;
            }
        }
        System.out.println("driver.getTitle() = " + driver.getTitle());


    }

    @Test
    public void testUtils() {
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement click_here = driver.findElement(By.linkText("Click Here"));
        click_here.click();

        BrowserUtils.switchToWindow("New Window");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {


        Thread.sleep(2000);
        driver.quit();
    }
}
