package com.eurotech.tests.day18_ExtentReports;

import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WrongUsernameTest extends TestBase {


    @Test
    public void wrongUsername() {
        //name of the test
        LoginPage loginPage = new LoginPage();
        extentLogger= report.createTest("Wrong Username Test");

        BrowserUtils.waitFor(2);
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
        Assert.assertEquals(actualMessage,"Invalid Credential!");


        extentLogger.pass("PASSED");

    }

    @Test
    public void wrongPassword() {
        extentLogger= report.createTest("Wrong Password Test");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("Click Understand button");
        loginPage.understandBtn.click();

        extentLogger.info("Enter valid username");
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));

        extentLogger.info("Enter invalid password");
        loginPage.passwordInput.sendKeys("Wrong password");

        extentLogger.info("Click login button");
        loginPage.loginBtn.click();

        String actualMessage = loginPage.warningMessage.getText();

        extentLogger.info("Verify that not log in");
        Assert.assertEquals(actualMessage,"Invalid Credential!");


        extentLogger.pass("PASSED");

    }
}
