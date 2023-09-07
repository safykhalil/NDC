package TestPackage.RuleEngineTC;

import Pages.RuleEngine.AddRuleEngine.AddServiceChargePage;
import Pages.DashboardPage;
import Pages.Login.LoginPage;
import TestPackage.BasePage.TCBase;
import org.testng.annotations.Test;

public class AddServiceChargeTC extends TCBase {
    String productType = "Flight";
    String ServiceChargeName = "Tilde Test";
    String ServiceChargeDescription = "Tilde test team";
    String country = "egy";
    String supplier = "Supplier";
    String fareType = "Total Fare";
    String Amount = "Amount";
    int value = 10;
    LoginPage loginobj;
    DashboardPage dashObj;
    AddServiceChargePage addServiceChargeObj;

    @Test
    public void addServiceChargeWithAValidData() throws InterruptedException {
        loginobj = new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openAddServiceChargePage();
        addServiceChargeObj = new AddServiceChargePage(driver);
        addServiceChargeObj.addServiceChargeWithValidCriteria(productType,ServiceChargeName,ServiceChargeDescription,country,supplier,fareType,Amount,value);
        driver.assertThat().element(addServiceChargeObj.statusMssg).isVisible();

    }
}
