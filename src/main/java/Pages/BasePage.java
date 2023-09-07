package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class BasePage {
    protected SHAFT.GUI.WebDriver driver;

    public BasePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementPresent(By locator) {
        return driver.getDriver().findElements(locator).size() > 0;
    }
}
