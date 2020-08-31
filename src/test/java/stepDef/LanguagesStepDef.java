package stepDef;

import Enums.Languages;
import PageObjects.MainPage;
import driverFactory.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

@Slf4j
public class LanguagesStepDef {
    MainPage mainPage = new MainPage();

    @When("^I switch language to (.+)")
    public void i_switch_language_to(String name) {
        mainPage.clickToButtonChange();
        mainPage.clickToSelect();
        switch (name) {
            case "Svenska":
                DriverManager.getChromeDriver().findElement(By.xpath
                        ("//select[@name = 'language_code']/option[@value = '" + Languages.SVENSKA.value + "']")).click();
                mainPage.saveLanguage();
                break;
            case "English":
                DriverManager.getChromeDriver().findElement(By.xpath
                        ("//select[@name = 'language_code']/option[@value = '" + Languages.ENGLISH.value + "']")).click();
                mainPage.saveLanguage();
                break;
            case "Suomi":
                DriverManager.getChromeDriver().findElement(By.xpath
                        ("//select[@name = 'language_code']/option[@value = '" + Languages.SUOMI.value + "']")).click();
                mainPage.saveLanguage();
                break;

            default:
                System.out.println("Language does not exist!");
        }
        Allure.addAttachment("Screenshot of page ", new ByteArrayInputStream(((TakesScreenshot) DriverManager.getChromeDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Then("^I check that language is (.+)")
    public void check_That_Languages_is_Switched(String name) {
        String url = DriverManager.getChromeDriver().getCurrentUrl();
        switch (name) {
            case "Svenska":
                Assert.assertTrue(url.contains(Languages.SVENSKA.value));
                break;
            case "Suomi":
                Assert.assertTrue(url.contains(Languages.SUOMI.value));
                break;
            case "English":
                Assert.assertTrue(url.contains(Languages.ENGLISH.value));
                break;
            default:
                System.out.println("Language does not exist!");
        }
        Allure.addAttachment("Screenshot of page ", new ByteArrayInputStream(((TakesScreenshot) DriverManager.getChromeDriver()).getScreenshotAs(OutputType.BYTES)));
    }

}
