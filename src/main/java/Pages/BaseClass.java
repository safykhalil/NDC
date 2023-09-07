package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import io.qameta.allure.Step;
public class BaseClass {
    protected SHAFT.GUI.WebDriver driver;


    public BaseClass(SHAFT.GUI.WebDriver driver) {

        this.driver = driver;

    }

    public void navigateToPage(String URL) {
        driver.browser().navigateToURL(URL);
    }





}

