package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// https://www.amazon.com/
public class AmazonHomePage {

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

    public AmazonHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}