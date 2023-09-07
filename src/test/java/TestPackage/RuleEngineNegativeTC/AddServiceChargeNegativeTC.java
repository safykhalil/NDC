package TestPackage.RuleEngineNegativeTC;

import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.RuleEngine.AddRuleEngine.AddServiceChargePage;
import TestPackage.BasePage.TCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddServiceChargeNegativeTC extends TCBase {
    String productType = "Flight";
    String ServiceChargeName = "Test Data";
    String ServiceChargeDescription = "Testing Team";
    String country = "egy";
    String supplier = "Supplier";
    String fareType = "Total Fare";
    String Amount = "Amount";
    int value = 10;
    String ExpectedURL = "http://192.168.1.50:8080/odeysysadmin/Rules/createRuleServiceCharge";
    LoginPage loginobj;
    DashboardPage dashObj;
    AddServiceChargePage addServiceChargeObj;
    @BeforeTest
    public void openPage() throws InterruptedException{
        loginobj = new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj = new DashboardPage(driver);
    }
    @Test
    public void addServiceChargeWithoutName() throws InterruptedException {
        dashObj.openAddServiceChargePage();
        addServiceChargeObj = new AddServiceChargePage(driver);
        addServiceChargeObj.addServiceChargeWithNoServiceName(productType, ServiceChargeDescription, country, supplier, fareType, Amount, value);
        Assert.assertEquals(driver.getDriver().getCurrentUrl(), ExpectedURL, "URL DOES NOT MATCH");
    }
    @Test
    public void addServiceChargeWithoutDescription() throws InterruptedException {
        dashObj.openAddServiceChargePage();
        addServiceChargeObj = new AddServiceChargePage(driver);
        addServiceChargeObj.addServiceChargeWithNoServiceDescription(productType, ServiceChargeName, country, supplier, fareType, Amount, value);
        Assert.assertEquals(driver.getDriver().getCurrentUrl(), ExpectedURL, "URL DOES NOT MATCH");
    }

    @Test
    public void addServiceChargeWithoutValidityPeriod() throws InterruptedException {
        dashObj.openAddServiceChargePage();
        addServiceChargeObj = new AddServiceChargePage(driver);
        addServiceChargeObj.addServiceChargeWithNoValidityPeriod(productType, ServiceChargeName, ServiceChargeDescription, country, supplier, fareType, Amount, value);
        Assert.assertEquals(driver.getDriver().getCurrentUrl(), ExpectedURL, "URL DOES NOT MATCH");
    }

    @Test
    public void addServiceChargeWithoutFareType() throws InterruptedException {
        dashObj.openAddServiceChargePage();
        addServiceChargeObj = new AddServiceChargePage(driver);
        addServiceChargeObj.addServiceChargeWithNoFareType(productType, ServiceChargeName, ServiceChargeDescription, country, supplier, Amount, value);
        Assert.assertEquals(driver.getDriver().getCurrentUrl(), ExpectedURL, "URL DOES NOT MATCH");
    }
    @Test
    public void addServiceChargeWithoutAmount() throws InterruptedException {
        dashObj.openAddServiceChargePage();
        addServiceChargeObj = new AddServiceChargePage(driver);
        addServiceChargeObj.addServiceChargeWithNoAmount(productType, ServiceChargeName, ServiceChargeDescription, country, supplier, fareType, value);
        Assert.assertEquals(driver.getDriver().getCurrentUrl(), ExpectedURL, "URL DOES NOT MATCH");
    }
    @Test
    public void addServiceChargeWithoutValue() throws InterruptedException {
        dashObj.openAddServiceChargePage();
        addServiceChargeObj = new AddServiceChargePage(driver);
        addServiceChargeObj.addServiceChargeWithNoValue(productType, ServiceChargeName, ServiceChargeDescription, country, supplier, fareType, Amount);
        Assert.assertEquals(driver.getDriver().getCurrentUrl(), ExpectedURL, "URL DOES NOT MATCH");
    }
//    @Test
//    public void addServiceChareWithoutData() throws InterruptedException{
//        dashObj.openAddServiceChargePage();
//        addServiceChargeObj = new AddServiceChargePage(driver);
//        addServiceChargeObj.addServiceChargeWithNoData();
//        Assert.assertEquals(driver.getDriver().getCurrentUrl(), ExpectedURL, "URL DOES NOT MATCH");
//    }
}