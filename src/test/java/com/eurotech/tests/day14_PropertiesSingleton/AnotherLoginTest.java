package com.eurotech.tests.day14_PropertiesSingleton;

import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AnotherLoginTest extends TestBase {

    @Test
    public void testName() {
        driver.get(ConfigurationReader.get("url"));
        WebElement usernameInput = driver.findElement(By.id("loginpage-input-email"));
        WebElement passwordInput = driver.findElement(By.id("loginpage-form-pw-input"));
        usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
        passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher")+ Keys.ENTER);



    }
}
