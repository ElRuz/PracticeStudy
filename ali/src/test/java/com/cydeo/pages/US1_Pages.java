package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// http://qa3.trycloud.net/index.php/login?clear=1
public class US1_Pages {

    @FindBy(id = "user")
    public WebElement userInput;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "submit-form")
    public WebElement loginButton;

    public US1_Pages() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}