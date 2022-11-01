package com.eurotech.tests.day20_DDF;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest extends TestBase {



    @DataProvider
    public Object [][] userData(){


        ExcelUtil testData = new ExcelUtil("src/test/resources/EurotechTest.xls","Test Data");

        return testData.getDataArrayWithoutFirstRow();
    }

    @Test(dataProvider = "userData")
    public void ddfLoginTest(String username,String password,String title,String company,String name) {

        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        extentLogger= report.createTest(name+"'s Login Test");

        extentLogger.info("Click understand button");
        loginPage.understandBtn.click();

        extentLogger.info("Enter username");
        loginPage.usernameInput.sendKeys(username);

        extentLogger.info("Enter Password");
        loginPage.passwordInput.sendKeys(password);

        extentLogger.info("Click login button");
        loginPage.loginBtn.click();

        String expectedMessage = "Welcome "+name;
        extentLogger.info("verify that welcome message is "+expectedMessage);

        Assert.assertEquals(dashboardPage.welcomeMessage.getText(),expectedMessage);

        extentLogger.info("Verify that title is "+title);
        Assert.assertEquals(dashboardPage.getTitle(title),title);

        extentLogger.info("Verify that "+name+" is working at"+company);
        Assert.assertEquals(dashboardPage.getCompany(company),company);



        extentLogger.pass("PASSED");





    }
}
