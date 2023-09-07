package TestPackage.BookinMidOffice.Booking;

import Pages.BookingMidOffice.Booking.MultiCitySearching;
import Pages.DashboardPage;
import Pages.Login.LoginPage;
import TestPackage.BasePage.TCBase;
import com.shaft.driver.SHAFT;
import org.testng.annotations.Test;

public class MultiCitySearchingTC extends TCBase {
    DashboardPage dashObj;
    LoginPage loginobj;
    MultiCitySearching adminMultiCityWayObj;
    SHAFT.TestData.JSON brBookingData, agnBookingData;



    @Test
    public void searchingAboutMultiCityFlightsUsingBranchOnly() throws InterruptedException{
        brBookingData = new SHAFT.TestData.JSON(System.getProperty("testDataFolderPath") + "multicitydata.json");
        loginobj = new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openBookingPage();
        adminMultiCityWayObj = new MultiCitySearching(driver);
        adminMultiCityWayObj.searchAboutMultiCityFlightUsingBranchOnly(brBookingData.getTestData("brName") ,
                brBookingData.getTestData("firstOriginCity"),brBookingData.getTestData("firstDestinationCity"),
                brBookingData.getTestData("secondOriginCity"),brBookingData.getTestData("secondDestinationCity"));


    }
    @Test
    public void searchingAboutMultiCityFlightsUsingAgencyOnly() throws InterruptedException{
        agnBookingData = new SHAFT.TestData.JSON(System.getProperty("testDataFolderPath") + "multicitydata.json");
        loginobj = new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openBookingPage();
        adminMultiCityWayObj = new MultiCitySearching(driver);
        adminMultiCityWayObj.searchAboutMultiCityFlightUsingAgencyOnly(agnBookingData.getTestData("brName") ,
                agnBookingData.getTestData("agnName") ,agnBookingData.getTestData("staffName") ,agnBookingData.getTestData("firstOriginCity"),
                agnBookingData.getTestData("firstDestinationCity"), agnBookingData.getTestData("secondOriginCity"),agnBookingData.getTestData("secondDestinationCity"));


    }

}
