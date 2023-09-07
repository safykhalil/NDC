package TestPackage.BookinMidOffice.Booking;

import Pages.BookingMidOffice.Booking.searchAboutOneWayTrips;
import Pages.DashboardPage;
import Pages.Login.LoginPage;
import TestPackage.BasePage.TCBase;
import com.shaft.driver.SHAFT;
import org.testng.annotations.Test;

public class SearchAboutOneWayTripsTC extends TCBase {

    LoginPage loginObj;
    DashboardPage dashObj;
    searchAboutOneWayTrips searchObj;
    SHAFT.TestData.JSON brOneWayData;
    SHAFT.TestData.JSON agnOneWayData;

    @Test
    public void searchAboutOneWayTripsUsingBranchOnly() throws InterruptedException {
        brOneWayData = new SHAFT.TestData.JSON(System.getProperty("testDataFolderPath") + "searchBookingBrData.json");
        loginObj = new LoginPage(driver);
        loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openBookingPage();
        searchObj = new searchAboutOneWayTrips(driver);
        for (int i = 1 ; i<11 ; i++) {
            searchObj.searchingOneWayTripsUsingBrOnly(brOneWayData.getTestData("brName"), brOneWayData.getTestData("source"), brOneWayData.getTestData("destination"));
            dashObj.openBookingPage();
        }


    }
    @Test
    public void searchAboutOneWayTripsUsingAgencyOnly() throws InterruptedException {
        agnOneWayData = new SHAFT.TestData.JSON(System.getProperty("testDataFolderPath") + "bookingAgnData.json");
        loginObj = new LoginPage(driver);
        loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openBookingPage();
        searchObj = new searchAboutOneWayTrips(driver);
        searchObj.searchingOneWayTripsUsingAgnOnly(brOneWayData.getTestData("brName"),brOneWayData.getTestData("agnName"),brOneWayData.getTestData("staffName"), brOneWayData.getTestData("source"), brOneWayData.getTestData("destination"));


    }
}
