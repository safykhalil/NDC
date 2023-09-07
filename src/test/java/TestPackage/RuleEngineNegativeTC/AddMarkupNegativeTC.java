package TestPackage.RuleEngineNegativeTC;

import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.RuleEngine.AddRuleEngine.AddMarkupPage;
import TestPackage.BasePage.TCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddMarkupNegativeTC extends TCBase {
    LoginPage loginobj;
    DashboardPage dashObj;
    AddMarkupPage addMarkupObj;
    String productType = "Flight";
    String markupName = "Test Data";
    String markupDescription = "Test DATA";
    String country = "egy";
    String supplier = "Supplier";
    String fareType = "Total Fare";
    String Amount = "Amount";
    String value = "10";
    String expectedURL = "http://192.168.1.50:8080/odeysysadmin/Rules/createRuleAirlineMarkup";
    public String amount;
    @BeforeTest
    public void openPage() throws InterruptedException{
        loginobj = new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj = new DashboardPage(driver);
    }

    @Test
    public void addMarkupWithoutMarkupName() throws InterruptedException {
        dashObj.openAddMarkupPage();
        addMarkupObj = new AddMarkupPage(driver);
        addMarkupObj.addMarkupWithNoMarkupName(productType, markupDescription, country, supplier, fareType, Amount, value);
        Assert.assertEquals(driver.getDriver().getCurrentUrl(), expectedURL, "URL DOES NOT MATCH");
    }

    @Test
    public void addMarkupWithoutMarkupDescription() throws InterruptedException {
        dashObj.openAddMarkupPage();
        addMarkupObj = new AddMarkupPage(driver);
        addMarkupObj.addMarkupWithNoMarkupDescription(productType, markupDescription, country, supplier, fareType, Amount, value);
        Assert.assertEquals(driver.getDriver().getCurrentUrl(), expectedURL, "URL DOES NOT MATCH");
    }

    @Test
    public void addMarkupWithoutMarkupValidityPeriod() throws InterruptedException {
        dashObj.openAddMarkupPage();
        addMarkupObj = new AddMarkupPage(driver);
        addMarkupObj.addMarkupWithNoValidityPeriod(productType, markupName, markupDescription, country, supplier, fareType, Amount, value);
        Assert.assertEquals(driver.getDriver().getCurrentUrl(), expectedURL, "URL DOES NOT MATCH");
    }

    @Test
    public void addMarkupWithoutFareType() throws InterruptedException {
        dashObj.openAddMarkupPage();
        addMarkupObj = new AddMarkupPage(driver);
        addMarkupObj.addMarkupWithNoFareType(productType, markupName, markupDescription,country, supplier , Amount, value);
        Assert.assertEquals(driver.getDriver().getCurrentUrl(), expectedURL, "URL DOES NOT MATCH");
    }
    @Test
    public void addMarkupWithoutPresOrAmount() throws InterruptedException{
        dashObj.openAddMarkupPage();
        addMarkupObj = new AddMarkupPage(driver);
        addMarkupObj.addMarkupWithNoPresOrAmount(productType, markupName, markupDescription,country,supplier,fareType,value);
        Assert.assertEquals(driver.getDriver().getCurrentUrl(), expectedURL, "URL DOES NOT MATCH");
    }
    @Test
    public void addMarkupWithoutValue() throws InterruptedException{
        dashObj.openAddMarkupPage();
        addMarkupObj = new AddMarkupPage(driver);
        addMarkupObj.addMarkupWithNoValue(productType, markupName, markupDescription,country,supplier,fareType,Amount);
        Assert.assertEquals(driver.getDriver().getCurrentUrl(), expectedURL, "URL DOES NOT MATCH");
    }
}
