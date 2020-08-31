package PageObjects;

import Helpers.Grids;
import Helpers.Product;
import driverFactory.DriverManager;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

@Getter
@Slf4j
public class BasketPage extends Grids {

    @FindBy(name = "add_cart_product")
    private WebElement addToCart;
    @FindBy(xpath = "//span[@class='quantity']")
    private WebElement quantity;
    @FindBy(xpath = "//tbody/tr/td[2]/div/strong/a")
    private WebElement nameOfTheInTheTable;
    @FindBy(xpath = "//select[@name='options[Size]']")
    private WebElement isSizeExist;
    @FindBy(xpath = "//button[@name = 'remove_cart_item']")
    private WebElement buttonDeleteProduct;
    @FindBy(xpath = "//div[@id = 'box-checkout']//em")
    private WebElement emptyBasket;
    @FindBy(xpath = "//select[@name='options[Size]']/option[2]")
    private WebElement smallSize;
    @FindBy(xpath = "//select[@name='options[Size]']/option[3]")
    private WebElement mediumSize;
    @FindBy(xpath = "//select[@name='options[Size]']/option[4]")
    private WebElement largeSize;


    public List<Product> getProductsList() {
        List<Product> productsList = new ArrayList<>();
        for (WebElement singleContainer : getProductContainer()) {
            productsList.add(new Product(singleContainer));
        }
        return productsList;
    }


    public void waitForUntilProductGetBasket() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getChromeDriver(), 10);
        wait.until(ExpectedConditions.textToBePresentInElement(getQuantity(), "1"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitElementInTheTable() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getChromeDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(getNameOfTheInTheTable()));
    }

    public void waitButton() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getChromeDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(getButtonDeleteProduct()));
    }

    public void checkThatEmpty() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getChromeDriver(), 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(getEmptyBasket()));
    }

    public void waitUntilSizeIsExist() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getChromeDriver(), 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(getIsSizeExist()));
    }


}
