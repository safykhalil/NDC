package TestPackage.RuleEngineTC;

import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.RuleEngine.SearchRuleEngine.SearchCancellationChargePage;
import TestPackage.BasePage.TCBase;
import org.testng.annotations.Test;

public class SearchCancellationChargeTC extends TCBase {
    LoginPage loginobj;
    DashboardPage dashObj;
    SearchCancellationChargePage cancellationObj;
    @Test
    public void searchAboutAllActiveCancellationCharge() throws InterruptedException {
        loginobj = new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openCancellationChargeSearchPage();
        cancellationObj = new SearchCancellationChargePage(driver);
        cancellationObj.searchAboutActiveCancellationCharge();
        driver.assertThat().element(cancellationObj.resultTable).isVisible();
    }
    @Test
    public void searchAboutAllInActiveCancellationCharge() throws InterruptedException {
        loginobj = new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openCancellationChargeSearchPage();
        cancellationObj = new SearchCancellationChargePage(driver);
        cancellationObj.searchAboutInActiveCancellationCharge();
        driver.assertThat().element(cancellationObj.noResultMssg).isVisible();
    }

}
