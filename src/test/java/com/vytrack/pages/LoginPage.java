package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id="prependedInput")
    public WebElement userName;



    @FindBy(id="prependedInput2")
    public WebElement password;

    @FindBy(name = "_submit")
    public WebElement submit;


    public void login(String userNameStr, String passwordStr) {
        userName.sendKeys(userNameStr);
        BrowserUtils.waitFor(2);
        password.sendKeys(passwordStr, Keys.ENTER);

    }

    public void login() {
        String username = System.getProperty("username") != null ? System.getProperty("username") : ConfigurationReader.get("driver_username");
        String password = System.getProperty("password") != null ? System.getProperty("password") : ConfigurationReader.get("driver_password");
        login(username, password);
    }

}