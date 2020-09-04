package stepDef;


import Helpers.Product;
import PageObjects.BasketPage;
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
public class BasketStepDef {
    BasketPage basketPage = new BasketPage();
    MainPage mainPage = new MainPage();

    @When("^I want to buy a (.+)")
    public void buyProduct(String nameOfProduct) {
        Product product = basketPage.getProductsList().stream()
                .filter(p -> p.getName().equals(nameOfProduct))
                .findAny().orElse(null);

        if (product.getName().equals("Yellow Duck")) {
            product.getLinkToProduct().click();
            basketPage.waitUntilSizeIsExist();
            basketPage.clickToLargeSize();
            basketPage.clickToAddToCard();
            basketPage.waitForUntilProductGetBasket();
            mainPage.clickToBasket();
        } else {
            product.getLinkToProduct().click();
            basketPage.clickToAddToCard();
            basketPage.waitForUntilProductGetBasket();
            mainPage.clickToBasket();
        }
        Allure.addAttachment("Screenshot of page ", new ByteArrayInputStream(((TakesScreenshot) DriverManager.getChromeDriver()).getScreenshotAs(OutputType.BYTES)));

    }


    @Then("^I check that Basket contains (.+)")
    public void checkProduct(String nameOfProduct) {
        basketPage.waitElementInTheTable();
        Allure.addAttachment("Screenshot of page ", new ByteArrayInputStream(((TakesScreenshot) DriverManager.getChromeDriver()).getScreenshotAs(OutputType.BYTES)));
        Assert.assertEquals(nameOfProduct, basketPage.getNameOfTheInTheTable().getText());
    }

    @Then("I delete a product and check that product is not in the Basket")
    public void deleteProductFromBasket() {
        basketPage.waitElementInTheTable();

        basketPage.waitButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        basketPage.getButtonDeleteProduct().click();
        basketPage.checkThatEmpty();

        Allure.addAttachment("Screenshot of page ", new ByteArrayInputStream(((TakesScreenshot) DriverManager.getChromeDriver()).getScreenshotAs(OutputType.BYTES)));
        Assert.assertTrue(basketPage.getEmptyBasket().getText().equals("There are no items in your cart."));

    }
}
