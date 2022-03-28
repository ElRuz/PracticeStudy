package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

public class LoginPageStep {
    LoginPage loginPage = new LoginPage();


    @Given("user on the login page")
    public void user_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }
    @When("user use username {string} and passcode {string}")
    public void user_use_username_and_passcode(String string, String string2) {
        loginPage.user.sendKeys(string);
        loginPage.password.sendKeys(string2);


    }
    @When("user click the login button")
    public void user_click_the_login_button() {
        loginPage.submitForm.click();
        BrowserUtils.waitFor(3);

    }
    @Then("verify the user should be at the dashboard page")
    public void verify_the_user_should_be_at_the_dashboard_page() {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,"Dashbord");



    }


}
