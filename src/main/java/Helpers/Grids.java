package Helpers;

import PageObjects.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class Grids extends BasePage {
    @FindBy(xpath = "//div[@id = 'box-popular-products']//div[contains(@class,'col-xs-halfs')]")
    private List<WebElement> productContainer;

    public Grids() {
        super();
    }
}
