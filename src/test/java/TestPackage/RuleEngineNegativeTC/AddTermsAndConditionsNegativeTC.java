package TestPackage.RuleEngineNegativeTC;

import Pages.BookingMidOffice.Booking.oneWayBooking;
import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.RuleEngine.AddRuleEngine.AddTermsAndConditionsPage;
import TestPackage.BasePage.TCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddTermsAndConditionsNegativeTC extends TCBase {
    String branchName = "Test";
    String source ="cai";
    String destination = "ssh";
    LoginPage loginobj;
    DashboardPage dashObj;
    AddTermsAndConditionsPage addTermsAndConditionsObj;
    oneWayBooking oneWayBookingObj;



    @BeforeTest
    public void beforeTest()throws InterruptedException{
        loginobj = new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openTermsAndConditionsPage();
    }

    @Test
    public void addTermsAndConditionsWithEmptyData() throws InterruptedException {
        addTermsAndConditionsObj = new AddTermsAndConditionsPage(driver);
        addTermsAndConditionsObj.addTermsAndConditionsWithEmptyData();
        Assert.assertEquals(driver.getDriver().getCurrentUrl(),"http://192.168.1.50:8080/odeysysadmin/Rules/addRuleTermConditionMaster");

    }
    @Test
    public void deactivateTermsAndConditions() throws InterruptedException {
        dashObj.openTermsAndConditionsPage();
        addTermsAndConditionsObj = new AddTermsAndConditionsPage(driver);
        addTermsAndConditionsObj.searchForActiveTermsAndConditions();
        addTermsAndConditionsObj.editTermsAndConditions();
        addTermsAndConditionsObj.getTermsAndConditionsText();
        addTermsAndConditionsObj.searchForActiveTermsAndConditions();
        addTermsAndConditionsObj.deactivateTermsAndConditions();
        dashObj.openBookingPage();
        oneWayBookingObj = new oneWayBooking(driver);
        oneWayBookingObj.searchOneWayRefundableTrip(branchName,source,destination);
        Assert.assertNotEquals(driver.element().getText(oneWayBookingObj.supplierMsg),addTermsAndConditionsObj.txt);
    }
}
