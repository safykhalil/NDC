package TestPackage.RuleEngineNegativeTC;

import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.RuleEngine.SearchRuleEngine.MarkupSearchPage;
import TestPackage.BasePage.TCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchMarkupNeagtiveTC extends TCBase {
    LoginPage loginobj;
    DashboardPage dashObj;
    MarkupSearchPage markupObj;
    String productType= "Flight";

    @BeforeTest
    public void beforeTest()throws InterruptedException{
        loginobj = new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openMarkupSearchPage();
    }

    @Test
    public void searchAboutActiveMarkupInInactive() throws InterruptedException {

        markupObj = new MarkupSearchPage(driver);
        markupObj.searchAboutActiveMarkupInInactive();
        Assert.assertEquals(driver.element().getText(markupObj.noResultsMsg),"No Results Found.");
    }
    @Test
    public void searchAboutInactiveMarkupInActive() throws InterruptedException {

        markupObj = new MarkupSearchPage(driver);
        markupObj.searchAboutInactiveMarkupInActive();
        Assert.assertEquals(driver.element().getText(markupObj.noResultsMsg),"No Results Found.");
    }
    @Test
    public void searchWithInvalidMarkupCode() throws InterruptedException {

        markupObj = new MarkupSearchPage(driver);
        markupObj.searchWithInavlidMarkupCode();
        Assert.assertEquals(driver.element().getText(markupObj.noResultsMsg),"No Results Found.");
    }
    @Test
    public void searchWithWrongMarkupCodeInASpecificCountry() throws InterruptedException {

        markupObj = new MarkupSearchPage(driver);
        markupObj.searchWithWrongMarkupCodeInASpecificCountry(productType);
        Assert.assertEquals(driver.element().getText(markupObj.noResultsMsg),"No Results Found.");
    }

}
