package TestPackage.RuleEngineNegativeTC;

import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.RuleEngine.SearchRuleEngine.SearchDiscountPage;
import TestPackage.BasePage.TCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchDiscountNegativeTC extends TCBase {

    LoginPage loginobj;
    DashboardPage dashObj;
    SearchDiscountPage searchDisObj;

    @BeforeTest
    public void beforeTest()throws InterruptedException{
        loginobj= new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj= new DashboardPage(driver);
        dashObj.openDiscountSearchPage();
    }

    @Test
    public void searchAboutActiveDiscountInInactive()throws InterruptedException{
        searchDisObj = new SearchDiscountPage(driver);
        searchDisObj.searchAboutActiveDiscountInInactive();
        Assert.assertEquals(driver.element().getText(searchDisObj.noResultsMsg),"No Results Found.");
    }
    @Test
    public void searchAboutInActiveDiscountInActiveStatus()throws InterruptedException{
        searchDisObj = new SearchDiscountPage(driver);
        searchDisObj.searchAboutInActiveDiscountInActiveStatus();
        Assert.assertEquals(driver.element().getText(searchDisObj.noResultsMsg),"No Results Found.");
    }
    @Test
    public void searchAboutInvalidDiscountCode()throws InterruptedException{
        searchDisObj = new SearchDiscountPage(driver);
        searchDisObj.searchAboutInvalidDiscountCode();
        Assert.assertEquals(driver.element().getText(searchDisObj.noResultsMsg),"No Results Found.");
    }
    @Test
    public void searchWithWrongDiscountCodeInASpecificCountry()throws InterruptedException{
        searchDisObj = new SearchDiscountPage(driver);
        searchDisObj.searchWithWrongDiscountCodeInASpecificCountry();
        Assert.assertEquals(driver.element().getText(searchDisObj.noResultsMsg),"No Results Found.");
    }
}
