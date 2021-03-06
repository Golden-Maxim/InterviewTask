package PageObjects;

import Enums.Pages;
import Helpers.Grids;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
@Slf4j
public class PagesPageObject extends Grids {
    @FindBy(xpath = "//div[contains(@class,'account')]/ul/li[1]/a")
    private WebElement customer_Service;
    @FindBy(xpath = "//div[contains(@class,'account')]/ul/li[2]/a")
    private WebElement regional_Settings;
    @FindBy(xpath = "//div[contains(@class,'account')]/ul/li[3]/a")
    private WebElement create_Account;
    @FindBy(xpath = "//div[contains(@class,'account')]/ul/li[4]/a")
    private WebElement login;
    @FindBy(xpath = "//div[contains(@class,'information')]/ul/li[1]/a")
    private WebElement about_Us;
    @FindBy(xpath = "//div[contains(@class,'information')]/ul/li[2]/a")
    private WebElement delivery_Information;
    @FindBy(xpath = "//div[contains(@class,'information')]/ul/li[3]/a")
    private WebElement privacy_Policy;
    @FindBy(xpath = "//div[contains(@class,'information')]/ul/li[4]/a")
    private WebElement termsConditions;
    @FindBy(xpath = "//div[contains(@class,'categories')]/ul/li[1]/a")
    private WebElement rubberDucks;

    public void clickToTheCorrespondingPage(String nameOfPage) {
        Pages pages = Pages.getPagesName(nameOfPage);
        switch (pages) {
            case ABOUT_US:
                getAbout_Us().click();
                break;
            case PRIVACY_POLICY:
                getPrivacy_Policy().click();
                break;
            case LOGIN:
                getLogin().click();
                break;
            case RUBBER_DUCKS:
                getRubberDucks().click();
                break;
            case CREATE_ACCOUNT:
                getCreate_Account().click();
                break;
            case CUSTOMER_SERVICE:
                getCustomer_Service().click();
                break;
            case TERMS_CONDITIONS:
                getTermsConditions().click();
                break;
            case REGIONAL_SETTINGS:
                getRegional_Settings().click();
                break;
            case DELIVERY_INFORMATION:
                getDelivery_Information().click();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + pages);
        }
    }
}
