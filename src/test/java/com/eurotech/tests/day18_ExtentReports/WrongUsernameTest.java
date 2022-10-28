package com.eurotech.tests.day18_ExtentReports;

import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WrongUsernameTest extends TestBase {


    @Test
    public void wrongUsername() {
        //name of the test

        extentLogger= report.createTest("Wrong Username Test");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("Click Understand button");
        loginPage.understandBtn.click();

        extentLogger.info("Enter wrong username");
        loginPage.usernameInput.sendKeys("eurot@gmail.com");

        extentLogger.info("Enter correct password");
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));

        extentLogger.info("Click login button");
        loginPage.loginBtn.click();

        String actualMessage = loginPage.warningMessage.getText();

        extentLogger.info("Verify that not log in");
        Assert.assertEquals(actualMessage,"Invalid Credentials!");


        extentLogger.pass("PASSED");

    }



}
