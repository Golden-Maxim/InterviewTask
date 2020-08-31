package PageObjects;

import driverFactory.DriverManager;
import lombok.Getter;
import org.openqa.selenium.support.PageFactory;

@Getter
public class BasePage {

    public BasePage() {
        PageFactory.initElements(DriverManager.getChromeDriver(), this);
    }
}
