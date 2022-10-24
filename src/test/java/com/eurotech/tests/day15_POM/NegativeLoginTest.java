package com.eurotech.tests.day15_POM;

import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    LoginPage loginPage = new LoginPage();

    @Test
    public void wrongPassword() {
        driver.get(ConfigurationReader.get("url"));



        loginPage.understandBtn.click();
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
        loginPage.passwordInput.sendKeys("somePassword");
        loginPage.loginBtn.click();


//        WebElement usernameInput = driver.findElement(By.id("loginpage-input-email"));
//        WebElement passwordInput = driver.findElement(By.id("loginpage-form-pw-input"));
//        usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
//        passwordInput.sendKeys("somePassword");
//        driver.findElement(By.id("rcc-confirm-button")).click();
//        driver.findElement(By.id("loginpage-form-btn")).click();
//
//        WebElement warningMessage = driver.findElement(By.xpath("//*[.='Invalid Credentials!']"));
//
//        Assert.assertEquals(warningMessage.getText(),"Invalid Credentials!","Verify that user is NOT login");

        String actualText = loginPage.warningMessage.getText();
        Assert.assertEquals(actualText,"Invalid Credentials!");


    }

    @Test
    public void wrongUsername() {
         driver.get(ConfigurationReader.get("url"));
         loginPage.usernameInput.sendKeys("SomeUser@gmail.com");
         loginPage.passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));
         loginPage.understandBtn.click();
         loginPage.loginBtn.click();
         String actualMessage= loginPage.warningMessage.getText();

         Assert.assertEquals(actualMessage,"Invalid Credentials!");
    }
}
