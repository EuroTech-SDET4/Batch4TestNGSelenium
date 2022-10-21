package com.eurotech.tests.day14_PropertiesSingleton;

import org.testng.annotations.Test;

public class SingletonTest {


    @Test
    public void test1() {

    //    Singleton singleton = new Singleton();

        String driver1 = Singleton.getInstance();
        String driver2 = Singleton.getInstance();

        System.out.println("s1 = " + driver1);
        System.out.println("s2 = " + driver2);


    }
}
