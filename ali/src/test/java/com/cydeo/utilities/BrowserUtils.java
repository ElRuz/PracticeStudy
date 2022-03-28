package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

     /*
    This method will accept int (in seconds) and execute Thread.sleep for given duration
     */


    public static void  sleep (int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }

    }

/*
This method accepts 3 arguments.
    Arg1: webdriver
    Arg2: expectedInUrl : for verify if the url contains given String.
        - If condition matches, will break loop.
    Arg3: expectedInTitle to be compared against actualTitle
at line 40
 */


    public static void switchWindowAndVerify(String expectedInURL, String expectedTitle){

        Set<String> allWindowsHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowsHandles) {

            Driver.getDriver().switchTo().window(each);

            System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(expectedInURL)){
                break;
            }

        }

        //5. Assert: Title contains “expectedTitle”
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    /*
    This method accept a string "expectedTittle" and Assert if it is true
     */
    public static void verifyTitle(String expectedTitle){

        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);

    }

    /*
    This method will verify if the current URL contains expected value.
     */
    public static void verifyURLContains(String expectedInTitle){
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInTitle));
    }

    /**
     * this method will accept a dropdown as a WebElement and
     * return all the options text in a List of String
     * @param dropdownElement
     * @return
     */

    public static List<String> dropdownOptions(WebElement dropdownElement){
        Select select = new Select(dropdownElement);

        // List of all ACTUAL month <options> as a web element
        List<WebElement> actualOptionsAsWEbElement = select.getOptions();

        // List of all ACTUAL month <options> as a string
        List<String> actualOptions = new ArrayList<>(); // actualOptions == actualMonths

        for (WebElement each : actualOptionsAsWEbElement) {
            actualOptions.add(each.getText());
        }

        return actualOptions;
    }

    /**
     * This method will accept a group of radio button as a List of WebElement.
     * It will loop through the List, and click to the radio button with provided attributeValue
     * @param radioButtons
     * @param attributeValue
     */
    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue){

        for (WebElement each : radioButtons) {

            if (each.getAttribute("value").equalsIgnoreCase(attributeValue)){
                each.click();
            }
        }
    }


}
