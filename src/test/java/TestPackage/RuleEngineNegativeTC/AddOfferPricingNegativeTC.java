package TestPackage.RuleEngineNegativeTC;

import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.RuleEngine.AddRuleEngine.AddOfferPricingPage;
import TestPackage.BasePage.TCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddOfferPricingNegativeTC extends TCBase {
    String productType = "Flight";
    String description = "Negative Test";
    int discountId = 668;
    LoginPage loginobj;
    DashboardPage dashObj;
    AddOfferPricingPage addOfferObj;
    public String ExpectedURL = "http://192.168.1.50:8080/odeysysadmin/Rules/addOfferPricing";

    @BeforeTest
    public void openBrowser() throws InterruptedException {
        loginobj = new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj = new DashboardPage(driver);
    }

    @Test
    public void addOfferPricingWithoutProduct() throws InterruptedException {
        dashObj.openAddOfferPricingPage();
        addOfferObj = new AddOfferPricingPage(driver);
        addOfferObj.addOfferPricingWithNoProduct(description, discountId);
        driver.assertThat().browser().url().isEqualTo(ExpectedURL);
    }

    @Test
    public void addOfferPricingWithoutDiscountID() throws InterruptedException {
        dashObj.openAddOfferPricingPage();
        addOfferObj = new AddOfferPricingPage(driver);
        addOfferObj.addOfferPricingWithNoDiscountID(productType, description);
        driver.assertThat().browser().url().isEqualTo(ExpectedURL);
    }

    @Test
    public void addOfferPricingWithoutDisc() throws InterruptedException {
        dashObj.openAddOfferPricingPage();
        addOfferObj = new AddOfferPricingPage(driver);
        addOfferObj.addOfferPricingWithNoDes(productType, discountId);
        driver.assertThat().browser().url().isEqualTo(ExpectedURL);

    }
}
