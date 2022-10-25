package com.eurotech.tests.day16_POM2;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DashboardTest extends TestBase {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Test
    public void dashboardMenu() {
        /*
        Task
        Go to http://www.eurotech.study/
        Login with teacher credentials
        Get the text of the dashboard and verify following menu
                      Developers
                      All Posts
                      My Account
         */
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        String expectedText = "Welcome Eurotech";
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(),expectedText,"Verify that log in successfully");

        //1 way
//        List<WebElement> dashboardMenu = dashboardPage.menuList;
//        for (WebElement menu : dashboardMenu) {
//            System.out.println("menu.getText() = " + menu.getText());
//        }
//
        //2. way

        for (WebElement menu : dashboardPage.menuList ) {
            System.out.println("menu.getText() = " + menu.getText());
        }



    }

    @Test
    public void navigateMenu() {

        /**
         Go to http://www.eurotech.study/login
         Login with teacher credentials
         Navigate to All Posts menu and verify url is http://eurotech.study/posts
         Navigate to Developers menu and verify url is http://eurotech.study/profiles
         */

        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        String expectedText = "Welcome Eurotech";
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(),expectedText,"Verify that log in successfully");


        dashboardPage.allPosts.click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/posts");

        dashboardPage.developers.click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/profiles");




    }

    @Test
    public void navigate2() {
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        String expectedText = "Welcome Eurotech";
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(),expectedText,"Verify that log in successfully");


        dashboardPage.navigateToMenu("Developers");
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/profiles");

        dashboardPage.navigateToMenu("All Posts");
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/posts");

        dashboardPage.navigateToMenu("My Account");

    }
}
