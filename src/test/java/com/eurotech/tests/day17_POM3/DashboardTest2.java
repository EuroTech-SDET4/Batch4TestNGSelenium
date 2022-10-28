package com.eurotech.tests.day17_POM3;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DashboardTest2 extends TestBase {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();


    @Test
    public void verifyList() {

        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        String expectedText = "Welcome Teacher";
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(), expectedText, "Verify that log in successfully");

        List<String> expectedList = new ArrayList<>();
        expectedList.add("Developers");
        expectedList.add("All Posts");
        expectedList.add("My Account");

        List<String> actualList = new ArrayList<>();

        for (WebElement menu : dashboardPage.menuList) {
            System.out.println("menu.getText() = " + menu.getText());
            actualList.add(menu.getText());

        }
        System.out.println("actualList = " + actualList);
        System.out.println("expectedList = " + expectedList);

        Assert.assertEquals(actualList, expectedList, "Verify that lists are matched");

    }

    @Test
    public void listVerify2() {
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        String expectedText = "Welcome Teacher";
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(), expectedText, "Verify that log in successfully");

        List<String> expectedList = new ArrayList<>();
        expectedList.add("Developers");
        expectedList.add("All Posts");
        expectedList.add("My Account");

        //   Assert.assertEquals(BrowserUtils.getElementsText(dashboardPage.menuList),expectedList);

        List<String> actualList = BrowserUtils.getElementsText(dashboardPage.menuList);
        Assert.assertEquals(actualList, expectedList);
    }

    @Test
    public void navigateSubMenu() {
        /**
         Go to http://www.eurotech.study/
         Login with teacher credentials
         Navigate to My Posts and verify that submit button is visible then
         Navigate to Log Out and verify that log out successfully
         */

        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        String expectedText = "Welcome Teacher";
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(), expectedText, "Verify that log in successfully");

        dashboardPage.navigateToMenu("My Account");
        dashboardPage.navigateToSubMenu("My Posts");

        Assert.assertTrue(dashboardPage.submitBtn.isDisplayed(), "verify that submit button is displayed");
        dashboardPage.navigateToMenu("My Account");
        dashboardPage.navigateToSubMenu("Logout");

        Assert.assertTrue(loginPage.loginBtn.isDisplayed(), "Verify that login button is displayed ");


    }
}
