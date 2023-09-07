package TestPackage.RuleEngineTC;

import Pages.BookingMidOffice.Booking.oneWayBooking;
import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.RuleEngine.AddRuleEngine.AddTermsAndConditionsPage;
import TestPackage.BasePage.TCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddTermsAndConditionsTC extends TCBase {

    String branchName = "Test";
    String source ="cai";
    String destination = "ssh";
    LoginPage loginobj;
    DashboardPage dashObj;
    AddTermsAndConditionsPage addTermsAndConditionsObj;
    oneWayBooking oneWayBookingObj;
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
        addTermsAndConditionsObj = new AddTermsAndConditionsPage(driver);
        addTermsAndConditionsObj.addTermsAndConditionsWithValidData();
        TermsAndConditionsObj = new AddTermsAndConditionsPage(driver);
        TermsAndConditionsObj.searchForInactiveTermsAndConditions();
        TermsAndConditionsObj.approveTermsAndConditions();
        dashObj.openBookingPage();
        oneWayBookingObj = new oneWayBooking(driver);
        oneWayBookingObj.searchOneWayRefundableTrip(branchName,source,destination);
        Assert.assertEquals(driver.element().getText(oneWayBookingObj.supplierMsg),addTermsAndConditionsObj.decription);
    }
}
