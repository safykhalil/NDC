package TestPackage.RuleEngineTC;

import Pages.RuleEngine.AddRuleEngine.AddOfferPricingPage;
import Pages.DashboardPage;
import Pages.Login.LoginPage;
import TestPackage.BasePage.TCBase;
import org.testng.annotations.Test;

public class AddOfferPricingTC extends TCBase {
    String productType = "Flight";
    String description = "Tilde Test Team";
    int discountId = 687;


    LoginPage loginobj;
    DashboardPage dashObj;
    AddOfferPricingPage addOfferObj;

    @Test
    public void addOfferPricingWithValidCriteria() throws InterruptedException {
        loginobj = new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openAddOfferPricingPage();
        addOfferObj = new AddOfferPricingPage(driver);
        addOfferObj.addOfferPricingWithValidData(productType, description, discountId);
        driver.assertThat().element(addOfferObj.statusMssg).isVisible();
    }
}
