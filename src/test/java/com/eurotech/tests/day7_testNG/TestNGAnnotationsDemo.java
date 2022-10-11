package com.eurotech.tests.day7_testNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotationsDemo {

    @BeforeMethod
    public void setup(){
        System.out.println("Open Browser");
    }
    @Test
    public void test1(){
        System.out.println("First Assertions");
        Assert.assertEquals("title","title");

        System.out.println("Second Assertions");
        Assert.assertEquals("url","urL");
    }
    @Test
    public void test2(){
        Assert.assertEquals("test2","test2");
    }
    @Test
    public void test3(){
        String expectedTitle = "Buro";
        String actualTitle = "Eurotech";

        Assert.assertTrue(actualTitle.startsWith(expectedTitle),"verify that title starting Euro");

    }
    @Test
    public void test4(){
        //verify that email contains @ sign
        String email = "eurotech@gmail.com";
//        if(email.contains("@")){
//            System.out.println("PASSS");
//        }else {
//            System.out.println("FAIL");
//        }
        Assert.assertTrue(email.contains("@"));
    }
    @Test
    public void test5(){
        Assert.assertFalse(0>1,"verify that 0 is not greater than 1");


    }

    @Test
    public void test6() {
        Assert.assertNotEquals("two","one");

    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Close Browser");
    }
}
