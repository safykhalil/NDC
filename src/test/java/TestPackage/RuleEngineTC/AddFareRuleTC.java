package TestPackage.RuleEngineTC;

import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.RuleEngine.AddRuleEngine.AddFareRuleMasterPage;
import Pages.RuleEngine.SearchRuleEngine.MarkupSearchPage;
import TestPackage.BasePage.TCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddFareRuleTC extends TCBase {

    LoginPage loginobj;
    DashboardPage dashObj;
    AddFareRuleMasterPage fareRuleObj;
    // change these data before running the test case
    String chargeName = "rule 3";
    String supplierName = "Amadeus";
    String airline = "Cale";
    String countryFrom = "Angola";
    String countryTo = "Australia";
    @BeforeTest
    public void beforeTest()throws InterruptedException{
        loginobj = new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openAddFareRulesPage();
    }
    @Test
    public void addFareRuleWithValidData() throws InterruptedException {
        fareRuleObj = new AddFareRuleMasterPage(driver);
        fareRuleObj.addFareRuleWithValidData(chargeName,supplierName,airline,countryFrom,countryTo);
        Assert.assertEquals(driver.element().getText(fareRuleObj.statusMsg),"Fare Rule Master added successfully.");

    }

}

