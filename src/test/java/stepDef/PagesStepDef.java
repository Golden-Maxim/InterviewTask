package stepDef;

import Enums.Pages;
import PageObjects.PagesPageObject;
import driverFactory.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;


@Slf4j
public class PagesStepDef {
    PagesPageObject pagesPageObject = new PagesPageObject();

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) DriverManager.getChromeDriver()).getScreenshotAs(OutputType.BYTES);
    }


    @When("^I click to (.+)")
    public void i_click_to_corresponding_page(String nameOfPage) {
        Pages pages = Pages.getPagesName(nameOfPage);
        switch (pages) {
            case ABOUT_US:
                pagesPageObject.getAbout_Us().click();
                break;
            case PRIVACY_POLICY:
                pagesPageObject.getPrivacy_Policy().click();
                break;
            case LOGIN:
                pagesPageObject.getLogin().click();
                break;
            case RUBBER_DUCKS:
                pagesPageObject.getRubberDucks().click();
                break;
            case CREATE_ACCOUNT:
                pagesPageObject.getCreate_Account().click();
                break;
            case CUSTOMER_SERVICE:
                pagesPageObject.getCustomer_Service().click();
                break;
            case TERMS_CONDITIONS:
                pagesPageObject.getTermsConditions().click();
                break;
            case REGIONAL_SETTINGS:
                pagesPageObject.getRegional_Settings().click();
                break;
            case DELIVERY_INFORMATION:
                pagesPageObject.getDelivery_Information().click();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + pages);
        }
        Allure.addAttachment("Screenshot of page ", new ByteArrayInputStream(((TakesScreenshot) DriverManager.getChromeDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Then("^I check that I am on the (.+)")
    public void i_check_that_I_am_on_the_corresponding_page(String nameOfPage) throws InterruptedException {
        Pages pages = Pages.getPagesName(nameOfPage);
        switch (pages) {
            case ABOUT_US:
                Assert.assertTrue(DriverManager.getChromeDriver().getCurrentUrl().contains("about-us"));
                break;
            case PRIVACY_POLICY:
                Assert.assertTrue(DriverManager.getChromeDriver().getCurrentUrl().contains("privacy-policy"));
                break;
            case LOGIN:
                log.info("I am on the login page" + DriverManager.getChromeDriver().getCurrentUrl());
                Assert.assertTrue(DriverManager.getChromeDriver().getCurrentUrl().contains("login"));
                break;
            case RUBBER_DUCKS:
                Assert.assertTrue(DriverManager.getChromeDriver().getCurrentUrl().contains("rubber-ducks"));
                break;
            case CREATE_ACCOUNT:
                log.info("I am on the Create account page" + DriverManager.getChromeDriver().getCurrentUrl());
                Assert.assertTrue(DriverManager.getChromeDriver().getCurrentUrl().contains("create_account"));
                break;
            case CUSTOMER_SERVICE:
                Assert.assertTrue(DriverManager.getChromeDriver().getCurrentUrl().contains("customer-service"));
                break;
            case TERMS_CONDITIONS:
                Assert.assertTrue(DriverManager.getChromeDriver().getCurrentUrl().contains("terms-conditions"));
                break;
            case REGIONAL_SETTINGS:
                Assert.assertTrue(DriverManager.getChromeDriver().getCurrentUrl().contains("regional_settings"));
                break;
            case DELIVERY_INFORMATION:
                Assert.assertTrue(DriverManager.getChromeDriver().getCurrentUrl().contains("delivery-information"));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + pages);
        }
        Allure.addAttachment("Screenshot of page ", new ByteArrayInputStream(((TakesScreenshot) DriverManager.getChromeDriver()).getScreenshotAs(OutputType.BYTES)));

    }
}
