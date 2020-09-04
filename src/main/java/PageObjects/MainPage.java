package PageObjects;

import Helpers.Grids;
import driverFactory.DriverManager;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Enums.Languages.*;

@Getter
@Slf4j
public class MainPage extends Grids {
    @FindBy(name = "email")
    private WebElement email;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(xpath = "//div[@id = 'notices']/div")
    private WebElement alertMessage;
    @FindBy(name = "login")
    private WebElement buttonLogIn;
    @FindBy(xpath = "//div[@class = 'change']/a")
    private WebElement changeLanguage;
    @FindBy(xpath = "//select[@name = 'language_code']")
    private WebElement select;
    @FindBy(name = "save")
    private WebElement saveButton;
    @FindBy(xpath = "//div[@id = 'cart']/a")
    private WebElement basket;
    @FindBy(xpath = "//div[@id= 'box-account']/ul/li[3]/a")
    private WebElement logOut;


    protected SoftAssertions softAssertions = new SoftAssertions();

    public void getSite() {
        DriverManager.getChromeDriver().get("http://kuopassa.net/litecart/en/");
    }

    public void enterNegativeEmailAndPassword(String em, String pass) {
        email.sendKeys(em);
        password.sendKeys(pass);
        buttonLogIn.click();
    }

    public void enterOnlyEmail() {
        email.sendKeys("test@gmail.com");
        buttonLogIn.click();
    }

    public String checkAlertMessage() {
        return alertMessage.getText();
    }


    public void clickToButtonChange() {
        changeLanguage.click();
    }

    public void clickToSelect() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getChromeDriver(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name = 'language_code']")));
        select.click();
    }

    public void saveLanguage() {
        saveButton.click();
    }

    public void waitButtomLogOut() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getChromeDriver(), 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(getLogOut()));
    }

    public void clickToLogOut() {
        logOut.click();
    }

    public void clickToBasket() {
        basket.click();
    }

    public void iSwitchLanguagesTo(String language) {
        String xPaht = "//select[@name = 'language_code']/option[@value = '";
        switch (language) {
            case "Svenska":
                DriverManager.getChromeDriver().findElement(By.xpath
                        (xPaht + SVENSKA.var + "']")).click();
                saveLanguage();
                break;
            case "English":
                DriverManager.getChromeDriver().findElement(By.xpath
                        (xPaht + ENGLISH.var + "']")).click();
                saveLanguage();
                break;
            case "Suomi":
                DriverManager.getChromeDriver().findElement(By.xpath
                        (xPaht + SUOMI.var + "']")).click();
                saveLanguage();
                break;

            default:
                System.out.println("Language does not exist!");
        }
    }
}
