package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }


    @FindBy(id = "loginpage-input-email")
    public WebElement usernameInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement loginBtn;

    @FindBy(id = "rcc-confirm-button")
    public WebElement understandBtn;

    @FindBy(xpath = "//*[.='Invalid Credentials!']")
    public WebElement warningMessage;

    @FindBy(id = "dashboard-h1")
    public WebElement dashboardText;


    public void login(String username,String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        understandBtn.click();
        loginBtn.click();
    }



}
