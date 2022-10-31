package com.eurotech.tests.day18_ExtentReports;

import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import org.testng.annotations.Test;

public class PositiveTest extends TestBase {


    @Test
    public void test1() {
        LoginPage loginPage=new LoginPage();
        extentLogger= report.createTest("Test");

        loginPage.loginAsTeacher();
        System.out.println("1");
    }

    @Test
    public void test2() {
        LoginPage loginPage=new LoginPage();
        extentLogger= report.createTest("Test 21");
        loginPage.loginAsTeacher();
        System.out.println("2");
    }
}
