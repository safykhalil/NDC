package TestPackage.RuleEngineNegativeTC;

import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.RuleEngine.SearchRuleEngine.SearchCancellationChargePage;
import TestPackage.BasePage.TCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchCancellationChargeNegativeTC extends TCBase {
    LoginPage loginobj;
    DashboardPage dashObj;
    SearchCancellationChargePage cancellationObj;

    @BeforeTest
    public void beforeTest()throws InterruptedException{
        loginobj = new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openCancellationChargeSearchPage();
    }

    @Test
    public void searchAboutActiveCancellationCodeInInactiveStatus(){
        cancellationObj = new SearchCancellationChargePage(driver);
        cancellationObj.searchAboutActiveCancellationCodeInInactive();
        Assert.assertEquals(driver.element().getText(cancellationObj.noResultMssg),"No Results Found.");
    }

    @Test
    public void searchAboutInactiveCancellationCodeInActiveStatus() throws InterruptedException {

        cancellationObj = new SearchCancellationChargePage(driver);
        cancellationObj.searchAboutInactiveCancellationCodeInActive();
        Assert.assertEquals(driver.element().getText(cancellationObj.noResultMssg),"No Results Found.");
    }

    @Test
    public void searchWithInvalidCancellationCode() throws InterruptedException {

        cancellationObj = new SearchCancellationChargePage(driver);
        cancellationObj.searchWithInavlidCancellationCode();
        Assert.assertEquals(driver.element().getText(cancellationObj.noResultMssg),"No Results Found.");
    }

    @Test
    public void searchWithWrongCancellationCodeInASpecificCountry() throws InterruptedException {

        cancellationObj = new SearchCancellationChargePage(driver);
        cancellationObj.searchWithWrongCancellationCodeInASpecificCountry();
        Assert.assertEquals(driver.element().getText(cancellationObj.noResultMssg),"No Results Found.");
    }
}
