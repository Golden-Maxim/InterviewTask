package stepDef;

import PageObjects.MainPage;
import driverFactory.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

@Slf4j
public class LogInLogOutStepDef {
    MainPage mainPage = new MainPage();

    @Given("^I am on the Main Page")
    public void iAmOnTheMainPage() {
        mainPage.getSite();
    }

    @When("I enter email {string} and password {string}")
    public void iLogToTheSite(String email, String password) {
        mainPage.enterNegativeEmailAndPassword(email, password);
        Allure.addAttachment("Screenshot of page ", new ByteArrayInputStream(((TakesScreenshot) DriverManager.getChromeDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @When("I log in to the Site without Password")
    public void iLogInToTheSiteWithoutPassword() {
        mainPage.enterOnlyEmail();
    }

    @Then("^I check the message (.+)")
    public void iSeeTheErrorMessage(String message) {
        Allure.addAttachment("Screenshot of page ", new ByteArrayInputStream(((TakesScreenshot) DriverManager.getChromeDriver()).getScreenshotAs(OutputType.BYTES)));
        Assert.assertTrue(mainPage.checkAlertMessage().contains(message));

    }

    @Then("I log out and check the message {string}")
    public void iLogOut(String message) {
        mainPage.clickToLogOut();
        Assert.assertTrue(mainPage.checkAlertMessage().contains(message));
        Allure.addAttachment("Screenshot of page ", new ByteArrayInputStream(((TakesScreenshot) DriverManager.getChromeDriver()).getScreenshotAs(OutputType.BYTES)));

    }

}
