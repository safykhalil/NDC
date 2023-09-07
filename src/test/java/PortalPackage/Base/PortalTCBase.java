package PortalPackage.Base;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeSuite;

public class PortalTCBase {

    public String URL = "http://192.168.1.60:8080/odeysysportal/login/loginForm";
    public static SHAFT.GUI.WebDriver driver;
    @BeforeSuite
    public void OpenBrowser() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL(URL);
    }
    public boolean isElementPresent(By locator) {
        return driver.getDriver().findElements(locator).size() > 0;
    }
}

