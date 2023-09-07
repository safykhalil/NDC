package TestPackage.AdminPackage.Topup;

import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.Admin.Topup.TopUpSearchPage;
import TestPackage.BasePage.TCBase;
import org.testng.annotations.Test;

public class TopUpSearchTC extends TCBase {
    DashboardPage dashObj;
    LoginPage loginObj;
    TopUpSearchPage topUpObj;
    @Test
    public void searchAboutValidTopUp() throws InterruptedException {
        loginObj = new LoginPage(driver);
        loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openTopUpPage();
        topUpObj = new TopUpSearchPage(driver);
        topUpObj.searchAboutValidTopUp();
        driver.assertThat().element(topUpObj.resultsTable).isVisible();

    }
    @Test
    public void approveTopupRequest() throws InterruptedException {
        loginObj = new LoginPage(driver);
        loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openTopUpPage();
        topUpObj = new TopUpSearchPage(driver);
        topUpObj.searchAboutValidTopUp();
        driver.assertThat().element(topUpObj.resultsTable).isVisible();
        topUpObj.approveTopUpRequest();


    }

}
