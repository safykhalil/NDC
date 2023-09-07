package TestPackage.BookinMidOffice.Booking;

import Pages.BookingMidOffice.Booking.searchRoundTripBooking;
import Pages.DashboardPage;
import Pages.Login.LoginPage;
import TestPackage.BasePage.TCBase;
import com.shaft.driver.SHAFT;
import org.testng.annotations.Test;

public class SearchAboutRoundTripTC extends TCBase {
    DashboardPage dashObj;
    LoginPage loginobj;
    searchRoundTripBooking roundTripObj;
    SHAFT.TestData.JSON brBookingData, agnBookingData;

    @Test
    public void searchAboutRoundTripBookingUsingBrOnly() throws InterruptedException {
        brBookingData = new SHAFT.TestData.JSON(System.getProperty("testDataFolderPath") + "searchBookingBrData.json");
        loginobj = new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openBookingPage();
        roundTripObj = new searchRoundTripBooking(driver);
        roundTripObj.searchAboutRoundTripUsingBranchOnly(brBookingData.getTestData("brName"), brBookingData.getTestData("source"), brBookingData.getTestData("destination"));

    }

    @Test
    public void searchAboutRoundTripBookingUsingAgnOnly() throws InterruptedException {
        agnBookingData = new SHAFT.TestData.JSON(System.getProperty("testDataFolderPath") + "bookingAgnData.json");
        loginobj = new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openBookingPage();
        roundTripObj = new searchRoundTripBooking(driver);
        roundTripObj.searchAboutRoundTripUsingAgencyOnly(agnBookingData.getTestData("brName"), agnBookingData.getTestData("agnName"),
                agnBookingData.getTestData("staffName"), agnBookingData.getTestData("source"), agnBookingData.getTestData("destination"));

    }
}
