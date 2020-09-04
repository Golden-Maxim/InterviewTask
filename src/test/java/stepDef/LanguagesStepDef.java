package stepDef;

import Enums.Languages;
import PageObjects.MainPage;
import driverFactory.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

@Slf4j
public class LanguagesStepDef {
    MainPage mainPage = new MainPage();

    @When("^I switch language to (.+)")
    public void iSwitchLanguageTo(String name) {
        mainPage.clickToButtonChange();
        mainPage.clickToSelect();
        mainPage.iSwitchLanguagesTo(name);
        Allure.addAttachment("Screenshot of page ", new ByteArrayInputStream(((TakesScreenshot) DriverManager.getChromeDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Then("^I check that language is (.+)")
    public void checkThatLanguagesIsSwitched(String name) {
        String url = DriverManager.getChromeDriver().getCurrentUrl();
        switch (name) {
            case "Svenska":
                Assert.assertTrue(url.contains(Languages.SVENSKA.var));
                break;
            case "Suomi":
                Assert.assertTrue(url.contains(Languages.SUOMI.var));
                break;
            case "English":
                Assert.assertTrue(url.contains(Languages.ENGLISH.var));
                break;
            default:
                System.out.println("Language does not exist!");
        }
        Allure.addAttachment("Screenshot of page ", new ByteArrayInputStream(((TakesScreenshot) DriverManager.getChromeDriver()).getScreenshotAs(OutputType.BYTES)));
    }

}
