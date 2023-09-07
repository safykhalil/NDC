package TestPackage.BasePage;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.BeforeSuite;

public class TCBase {
    public String URL = "http://192.168.1.50:8080/odeysysadmin/";
    public static SHAFT.GUI.WebDriver driver;


    @BeforeSuite
    public void OpenBrowser() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL(URL);

    }
    public boolean isElementPresent(By locator) {
        return driver.getDriver().findElements(locator).size() > 0;   }

    }

