package com.cydeo.step_definitions;

import com.cydeo.pages.US1_Pages;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US1_StepDef {

    US1_Pages us1_pages = new US1_Pages();

    @Given("user on the login page")
    public void user_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    @When("user use username {string} and passcode {string}")
    public void user_use_username_and_passcode_userpass123(String username, String password) {
        us1_pages.user.sendKeys(username);
        us1_pages.password.sendKeys(password);
    }
    @When("user click the login button")
    public void user_click_the_login_button() {
        us1_pages.loginButton.click();
    }
    @Then("verify the user should be at the dashboard page")
    public void verify_the_user_should_be_at_the_dashboard_page() {
        Assert.assertEquals("Dashboard - Trycloud QA", Driver.getDriver().getTitle());
    }


}
