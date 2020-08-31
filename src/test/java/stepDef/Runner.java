package stepDef;

import driverFactory.DriverManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.qameta.allure.Attachment;
import org.junit.AfterClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(strict = true, features = "src/test/resources/features",
        glue = "stepDef")
public class Runner {


    @AfterClass
    static public void tearDown() {
        DriverManager.getChromeDriver().manage().deleteAllCookies();
        DriverManager.getChromeDriver().close();
        DriverManager.getChromeDriver().quit();
    }
}
