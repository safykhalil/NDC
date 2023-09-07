package TestPackage.AdminPackage.Country;

import Pages.Admin.Country.AddNewCountry;
import Pages.DashboardPage;
import Pages.Login.LoginPage;
import TestPackage.BasePage.TCBase;
import org.testng.annotations.Test;

public class AddNewCountryTC extends TCBase {
    AddNewCountry addNewCountryObj;
    DashboardPage dashObj;
    LoginPage loginobj;

    @Test
    public void addNewCountryWithValidData() throws InterruptedException {
        loginobj = new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openAddNewCountryPage();
        addNewCountryObj = new AddNewCountry(driver);
        addNewCountryObj.AddaNewCountry("Moataz", "Egypt", "EGP");
        driver.assertThat().element(addNewCountryObj.confmssg).isVisible();
    }
}
