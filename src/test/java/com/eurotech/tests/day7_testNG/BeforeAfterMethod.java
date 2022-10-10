package com.eurotech.tests.day7_testNG;

import org.testng.annotations.*;

public class BeforeAfterMethod {

    @BeforeClass
    public void setUpClass(){
        System.out.println("---BEFORE CLASS---");
    }
    @Test
    public void test1() {
        System.out.println("First Test Case");
        System.out.println("go to amazon");
        System.out.println("write selenium in the search box");
        System.out.println("verify that result text has selenium");
    }

    @Test
    public void test2(){
        System.out.println("Second Test Case");
    }

    @Test
    public void test3(){
        System.out.println("Third Test Case");
    }
    @BeforeMethod
    public void setup(){
        System.out.println("Before Method");
        System.out.println("WebDriver,Opening Browser");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("After Method");
        System.out.println("Closing browser, quit");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("---AFTER CLASS---");
    }




}
