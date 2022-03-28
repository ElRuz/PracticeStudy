package com.cydeo.step_definitions;

import com.cydeo.pages.AmazonHomePage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class AmazonStepDef {

    AmazonHomePage amazonHomePage = new AmazonHomePage();

    @Given("user is on amazon page")
    public void user_is_on_amazon_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
       // Assert.assertEquals("Amazon.com. Spend less. Smile more.", Driver.getDriver().getTitle() );
    }
    @When("user inputs {string} into the search box and hits enter")
    public void user_inputs_into_the_search_box_and_hits_enter(String string) {
        amazonHomePage.searchBox.sendKeys(string + Keys.ENTER);
    }
    @Then("user can see the title of the {string}")
    public void user_can_see_the_title_of_the(String string) {
        Assert.assertEquals("Amazon.com : " + string, Driver.getDriver().getTitle());
    }


}
