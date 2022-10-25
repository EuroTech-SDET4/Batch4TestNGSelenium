package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashboardPage extends BasePage{



           @FindBy(xpath = "//p[contains(text(),'Welcome')]")
           public WebElement welcomeMessage;

           @FindBy(css = ".nav__menu-item")
           public List<WebElement> menuList;

           @FindBy(xpath = "//a[text()='All Posts']")
           public WebElement allPosts;

           @FindBy(xpath = "//a[text()='Developers']")
           public WebElement developers;



           public void navigateToMenu(String menuName){
               Driver.get().findElement(By.xpath("//*[text()='"+menuName+"']")).click();

           }


}
