package TestPackage.RuleEngineNegativeTC;

import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.RuleEngine.AddRuleEngine.AddFareRuleMasterPage;
import TestPackage.BasePage.TCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddFareRuleNegativeTC extends TCBase {
    LoginPage loginobj;
    DashboardPage dashObj;

    AddFareRuleMasterPage fareRuleObj;
    String chargeName = "rul";
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
    @Test (priority = 1)
    public void addFareRuleWithEmptyFields() throws InterruptedException {
        fareRuleObj = new AddFareRuleMasterPage(driver);
        fareRuleObj.addFareRuleWithEmptyFields();
        Assert.assertEquals(driver.getDriver().getCurrentUrl(),"http://192.168.1.50:8080/odeysysadmin/Rules/addFareRuleMaster");
        Thread.sleep(2000);
    }
    @Test (priority = 2)
    public void addFareRuleWithAlreadyExistsData() throws InterruptedException {
        fareRuleObj = new AddFareRuleMasterPage(driver);
        fareRuleObj.addFareRuleWithValidData(chargeName,supplierName,airline,countryFrom,countryTo);
        Assert.assertEquals(driver.element().getText(fareRuleObj.errorStatusMsg),"Fare rule already exist with same details.");
        Thread.sleep(2000);
    }
}
