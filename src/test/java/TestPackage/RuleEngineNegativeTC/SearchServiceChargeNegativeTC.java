package TestPackage.RuleEngineNegativeTC;

import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.RuleEngine.SearchRuleEngine.MarkupSearchPage;
import Pages.RuleEngine.SearchRuleEngine.SearchCancellationChargePage;
import Pages.RuleEngine.SearchRuleEngine.SearchServiceChargePage;
import TestPackage.BasePage.TCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchServiceChargeNegativeTC extends TCBase {

    LoginPage loginobj;
    DashboardPage dashObj;
    SearchServiceChargePage serviceChargePageObj;

    @BeforeTest
    public void beforeTest()throws InterruptedException{
        loginobj = new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openServiceChargeSearchPage();
    }

    @Test
    public void searchAboutActiveCancellationCodeInInactiveStatus(){
        serviceChargePageObj = new SearchServiceChargePage(driver);
        serviceChargePageObj.searchAboutActiveServiceChargeCodeInInactive();
        Assert.assertEquals(driver.element().getText(serviceChargePageObj.noResultMssg),"No Results Found.");
    }

    @Test
    public void searchAboutInactiveCancellationCodeInActiveStatus() throws InterruptedException {

        serviceChargePageObj = new SearchServiceChargePage(driver);
        serviceChargePageObj.searchAboutInactiveServiceChargeCodeInActive();
        Assert.assertEquals(driver.element().getText(serviceChargePageObj.noResultMssg),"No Results Found.");
    }

    @Test
    public void searchWithInvalidCancellationCode() throws InterruptedException {

        serviceChargePageObj = new SearchServiceChargePage(driver);
        serviceChargePageObj.searchWithInavlidServiceChargeCode();
        Assert.assertEquals(driver.element().getText(serviceChargePageObj.noResultMssg),"No Results Found.");
    }

    @Test
    public void searchWithWrongCancellationCodeInASpecificCountry() throws InterruptedException {

        serviceChargePageObj = new SearchServiceChargePage(driver);
        serviceChargePageObj.searchWithWrongServiceChargeCodeInASpecificCountry();
        Assert.assertEquals(driver.element().getText(serviceChargePageObj.noResultMssg),"No Results Found.");
    }

}
