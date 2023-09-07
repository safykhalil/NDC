package TestPackage.RuleEngineTC;

import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.RuleEngine.SearchRuleEngine.SearchServiceChargePage;
import TestPackage.BasePage.TCBase;
import org.testng.annotations.Test;

public class SearchServiceChargeTC extends TCBase {
    LoginPage loginobj;
    DashboardPage dashObj;
    SearchServiceChargePage searchService;
    @Test
    public void searchAboutAllActiveServiceCharge() throws InterruptedException {
        loginobj= new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj= new DashboardPage(driver);
        dashObj.openServiceChargeSearchPage();
        searchService = new SearchServiceChargePage(driver);
        searchService.searchAboutActiveServiceCharge();
        driver.assertThat().element(searchService.resultTable).isVisible();
    }
    @Test
    public void searchAboutAllInActiveDiscount() throws InterruptedException {
        loginobj= new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj= new DashboardPage(driver);
        dashObj.openServiceChargeSearchPage();
        searchService = new SearchServiceChargePage(driver);
        searchService.searchAboutInActiveServiceCharge();
        driver.assertThat().element(searchService.resultTable).isVisible();
    }
}
