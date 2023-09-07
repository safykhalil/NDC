package TestPackage.RuleEngineTC;

import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.RuleEngine.AddRuleEngine.AddTermsAndConditionsPage;
import Pages.RuleEngine.SearchRuleEngine.SearchDiscountPage;
import TestPackage.BasePage.TCBase;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchTermsAndConditionsTC extends TCBase {
    LoginPage loginobj;
    DashboardPage dashObj;
    AddTermsAndConditionsPage TermsAndConditionsObj;

    @BeforeTest
    public void beforeTest()throws InterruptedException{
        loginobj = new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openTermsAndConditionsPage();
    }

    @Test
    public void addTermsAndConditionsWithValidData() throws InterruptedException {
        TermsAndConditionsObj = new AddTermsAndConditionsPage(driver);
        TermsAndConditionsObj.addTermsAndConditionsWithValidData();
    }
    @Test
    public void approveTermsAndConditions() throws InterruptedException {
        TermsAndConditionsObj = new AddTermsAndConditionsPage(driver);
        TermsAndConditionsObj.searchForInactiveTermsAndConditions();
        TermsAndConditionsObj.approveTermsAndConditions();
    }
}
