package logintest;
//test

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class testLogin extends BasePage {

    public testLogin(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By username = By.id("userAlias");
    By password = By.id("password_password");
    By loginButton = By.id("login_id");

    public void loginWithValidData() throws InterruptedException {
        driver.element().type(username, "E.saady")
                .type(password, "a");
        Thread.sleep(1000);
        driver.element().click(loginButton);

    }

    public void loginWithAdmin() throws InterruptedException {
        driver.element().type(username, "odeysysadmin")
                .type(password, "a");
        Thread.sleep(1000);
        driver.element().click(loginButton);
    }
}