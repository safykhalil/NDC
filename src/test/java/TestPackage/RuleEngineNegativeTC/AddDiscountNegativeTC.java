package TestPackage.RuleEngineNegativeTC;

import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.RuleEngine.AddRuleEngine.AddDiscountPage;
import TestPackage.BasePage.TCBase;
import com.shaft.driver.SHAFT;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddDiscountNegativeTC extends TCBase {
    SoftAssert softAssert = new SoftAssert();
    LoginPage loginobj;
    DashboardPage dashObj;
    AddDiscountPage addDiscountObj;
    SHAFT.TestData.JSON discountData;
    String productType = "Flight";
    String discountName = "Test Data";
    String discountDescription = "Test DATA";
    String country = "egy";
    String supplier = "Supplier";
    String fareType = "Total Fare";
    String Amount = "Amount";
    String value = "50";
    String ExpectedURL = "http://192.168.1.60:8080/odeysysadmin/Rules/createRuleDiscount";
    String text = "Branch Criteria is required.";

    @BeforeTest
    public void openPage() throws InterruptedException {
        loginobj = new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj = new DashboardPage(driver);
    }
    @Test
    public void addDiscountWithoutDiscountName() throws InterruptedException {
        dashObj.openAddDiscountPage();
        addDiscountObj = new AddDiscountPage(driver);
        addDiscountObj.addDiscountWithNoDiscountName(productType, discountDescription, country, supplier, fareType, Amount, value);
        addDiscountObj.SendForApproval();
        Assert.assertEquals(driver.getDriver().getCurrentUrl(), ExpectedURL, "URL DOES NOT MATCH");
    }
    @Test
    public void addDiscountWithoutDiscountDescription() throws InterruptedException {
        dashObj.openAddDiscountPage();
        addDiscountObj = new AddDiscountPage(driver);
        addDiscountObj.addDiscountWithNoDiscountDescription(productType, discountName, country, supplier, fareType, Amount, value);
        addDiscountObj.SendForApproval();
        Assert.assertEquals(driver.getDriver().getCurrentUrl(), ExpectedURL, "URL DOES NOT MATCH");
    }

    @Test
    public void addMarkupWithoutValidityPeriod() throws InterruptedException {
        dashObj.openAddDiscountPage();
        addDiscountObj = new AddDiscountPage(driver);
        addDiscountObj.addDiscountWithNoValidityPeriod(productType, discountName, discountDescription, country, supplier, fareType, Amount, value);
        addDiscountObj.SendForApproval();
        Assert.assertEquals(driver.getDriver().getCurrentUrl(), ExpectedURL, "URL DOES NOT MATCH");
    }

        @Test
        public void addDiscountWithoutFareType () throws InterruptedException {
            dashObj.openAddDiscountPage();
            addDiscountObj = new AddDiscountPage(driver);
            addDiscountObj.addDiscountWithNoFareType(productType, discountName, discountDescription, country, supplier, Amount, value);
            addDiscountObj.SendForApproval();
            Assert.assertEquals(driver.getDriver().getCurrentUrl(), ExpectedURL, "URL DOES NOT MATCH");

        }
        @Test
        public void addDiscountWithoutAmount () throws InterruptedException {
            dashObj.openAddDiscountPage();
            addDiscountObj = new AddDiscountPage(driver);
            addDiscountObj.addDiscountWithNoAmount(productType, discountName, discountDescription, country, supplier, fareType, value);
            addDiscountObj.SendForApproval();
            Assert.assertEquals(driver.getDriver().getCurrentUrl(), ExpectedURL, "URL DOES NOT MATCH");

        }
        @Test
        public void addDiscountWithoutValue () throws InterruptedException {
            dashObj.openAddDiscountPage();
            addDiscountObj = new AddDiscountPage(driver);
            addDiscountObj.addDiscountWithNoValue(productType, discountName, discountDescription, country, supplier, fareType, Amount);
            addDiscountObj.SendForApproval();
            Assert.assertEquals(driver.getDriver().getCurrentUrl(), ExpectedURL, "URL DOES NOT MATCH");
        }
    }
