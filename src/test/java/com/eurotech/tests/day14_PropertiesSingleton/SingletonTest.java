package com.eurotech.tests.day14_PropertiesSingleton;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {

//
//  //  @Test
//    public void test1() {
//
//    //    Singleton singleton = new Singleton();
//
//        String driver1 = Singleton.getInstance();
//        String driver2 = Singleton.getInstance();
//
//        System.out.println("s1 = " + driver1);
//        System.out.println("s2 = " + driver2);
//
//
//
//    }
//
//  //  @Test
//    public void test2() {
//        //WebDriver driver = WebDriverFactory.getDriver("chrome");
//
//        WebDriver driver = Driver.get();
//        driver.get(ConfigurationReader.get("url"));
//
//
//    }

    @Test
    public void test3() {
        WebDriver driver = Driver.get();
        driver.get("http://www.google.com");

        Driver.get().get("http://www.google.com");


        Driver.closeDriver();

    }

    @Test
    public void test4() {
        WebDriver driver = Driver.get();
        driver.get("http://www.amazon.com");
    }
}
