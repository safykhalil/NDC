package TestPackage.AdminPackage.Country;

import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.Admin.Country.SearchCountryPage;
import TestPackage.BasePage.TCBase;
import org.testng.annotations.Test;

public class SearchCountryTC extends TCBase {
    LoginPage loginobj;
    DashboardPage dashObj;
    SearchCountryPage searchobj;

    @Test
    public void SearchWithValidData() throws InterruptedException {
        loginobj = new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openSearchNewCountryPage();
        searchobj = new SearchCountryPage(driver);
        searchobj.CountrySearch();
        driver.assertThat().element(searchobj.countriesTable).isVisible();
    }
}
