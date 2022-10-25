package com.eurotech.tests.day15_POM;

import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

    LoginPage loginPage = new LoginPage();

    @Test
    public void loginTest() throws InterruptedException {


        driver.get(ConfigurationReader.get("url"));
        loginPage.understandBtn.click();
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));
        loginPage.loginBtn.click();


        wait.until(ExpectedConditions.visibilityOf(loginPage.dashboardText));

        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/dashboard");


    }

    @Test
    public void loginWithMethod() {
        driver.get(ConfigurationReader.get("url"));
        String username=ConfigurationReader.get("usernameTeacher");
        String password =ConfigurationReader.get("passwordTeacher");

        loginPage.login(username,password);
        wait.until(ExpectedConditions.visibilityOf(loginPage.dashboardText));
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/dashboard");
    }

    @Test
    public void loginAsTeacher() {
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        wait.until(ExpectedConditions.visibilityOf(loginPage.dashboardText));
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/dashboard");
    }

    @Test
    public void loginAsStudent() {
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsStudent();
        wait.until(ExpectedConditions.visibilityOf(loginPage.dashboardText));
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/dashboard");
    }

    @Test
    public void hover() {

        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement img3= driver.findElement(By.xpath("(//img)[3]"));

        BrowserUtils.hover(img3);

    }
}
