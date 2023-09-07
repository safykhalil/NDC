package TestPackage.RuleEngineTC;

import Pages.RuleEngine.AddRuleEngine.AddMarkupPage;
import Pages.DashboardPage;
import Pages.Login.LoginPage;
import TestPackage.BasePage.TCBase;
import org.testng.annotations.Test;

public class AddMarkupTC extends TCBase {
    String productType = "Flight";
    String markupName = "Tilde Test";
    String markupDescription = "Tilde test team";
    String country = "uae";
    String supplier = "Supplier";
    String fareType = "Total Fare";
    String Amount = "Amount";
    String value = "10";


    LoginPage loginobj;
    DashboardPage dashObj;
    AddMarkupPage addMarkupObj;

    @Test
    public void addMarkupWithAValidData() throws InterruptedException {
        loginobj = new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openAddMarkupPage();
        addMarkupObj = new AddMarkupPage(driver);
        addMarkupObj.addMarkupWithValidCriteria(productType, markupName, markupDescription, country, supplier, fareType, Amount, value);
        driver.assertThat().element(addMarkupObj.statusMssg).isVisible();
    }
}