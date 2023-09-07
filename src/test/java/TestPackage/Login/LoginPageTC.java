package TestPackage.Login;

import Pages.Login.LoginPage;
import TestPackage.BasePage.TCBase;
import org.testng.annotations.Test;


public class LoginPageTC extends TCBase {
    LoginPage loginObj;



    @Test
    public void loginWithValidCredentials() throws InterruptedException {
        loginObj = new LoginPage(driver);
        loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
    }

}