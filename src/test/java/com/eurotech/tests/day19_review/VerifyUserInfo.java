package com.eurotech.tests.day19_review;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.ProfilePage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyUserInfo extends TestBase {


    /*
    Login as a teacher
    Verify that login is successful
    Click on  Edit Profile button
    Verify that github name is eurotech2022
    Click on go back button
    Verify that user's title is Test Automation Engineer

     */
    @Test
    public void userInfo(){
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        ProfilePage profilePage = new ProfilePage();


        extentLogger = report.createTest("User info Verification");

        extentLogger.info("Click understand button");
        loginPage.understandBtn.click();

        extentLogger.info("Enter Username");
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));

        extentLogger.info("Enter Password");
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));

        extentLogger.info("Click login button");
        loginPage.loginBtn.click();

        //1 way to verify log in successfully
        extentLogger.info("Verify that login is successful");
        BrowserUtils.waitFor(1);
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/dashboard");

        //2 way to verify log in successfully
        String expectedMessage="Welcome Teacher";
        extentLogger.info("Verify that login is successful from Dashboard Page and message is "+expectedMessage);
     //   String actualMessage= new DashboardPage().welcomeMessage.getText();
          String actualMessage = dashboardPage.welcomeMessage.getText();
          Assert.assertEquals(actualMessage,"Welcome Teacher");

          //                       DASHBOARD PAGE                //
        extentLogger.info("Click Edit Profile");
        dashboardPage.dashboardMenu("Edit Profile");

        String expectedGithubUsername= "eurotech2022";
        extentLogger.info("Verify that github username is "+expectedGithubUsername);
        Assert.assertEquals(profilePage.githubUsername.getAttribute("value"),expectedGithubUsername);


        extentLogger.info("Click Go Back Button");
        profilePage.goBackButton.click();

        String expectedJobTitle= "Test Automation Engineer";
        extentLogger.info("Verify that job title is "+expectedJobTitle);
        Assert.assertEquals(profilePage.jobTitle.getText(),expectedJobTitle);

        extentLogger.info("Passed");





    }
}
