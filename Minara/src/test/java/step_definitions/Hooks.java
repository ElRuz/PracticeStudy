package step_definitions;


import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {

    @After
    public static void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            byte[] img = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(img, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }
}
