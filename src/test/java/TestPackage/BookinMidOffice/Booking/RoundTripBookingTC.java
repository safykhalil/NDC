package TestPackage.BookinMidOffice.Booking;

import Pages.BookingMidOffice.Booking.RoundTripBooking;
import Pages.DashboardPage;
import Pages.Login.LoginPage;
import TestPackage.BasePage.TCBase;
import com.shaft.driver.SHAFT;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

public class RoundTripBookingTC extends TCBase{
    DashboardPage dashObj;
    LoginPage loginobj;
    RoundTripBooking adminRoundWayObj;
    SHAFT.TestData.JSON brBookingData,agnBookingData ,passengerDetails;
    Faker faker = new Faker();




    @Test
    public void bookingWithRoundWayFlightsUsingBranchOnly() throws InterruptedException{
        brBookingData = new SHAFT.TestData.JSON(System.getProperty("testDataFolderPath") + "searchBookingBrData.json");
        passengerDetails = new SHAFT.TestData.JSON(System.getProperty("testDataFolderPath") + "passengerDetails.json");
        loginobj = new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openBookingPage();
        adminRoundWayObj = new RoundTripBooking(driver);
        adminRoundWayObj.bookingARefundableRoundTripUsingBranchOnly(brBookingData.getTestData("brName"), brBookingData.getTestData("source"),
                brBookingData.getTestData("destination") ,passengerDetails.getTestData("title"), faker.name().firstName()
                , faker.name().lastName(), passengerDetails.getTestData("countCode"), passengerDetails.getTestData("passMobile")
                , passengerDetails.getTestData("gender"), passengerDetails.getTestData("passport"), passengerDetails.getTestData("nationality") );

    }
    @Test
    public void bookingWithRoundWayFlightsUsingAgencyOnly() throws InterruptedException{
        agnBookingData = new SHAFT.TestData.JSON(System.getProperty("testDataFolderPath") + "bookingAgnData.json");
        passengerDetails = new SHAFT.TestData.JSON(System.getProperty("testDataFolderPath") + "passengerDetails.json");
        loginobj = new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openBookingPage();
        adminRoundWayObj = new RoundTripBooking(driver);
        adminRoundWayObj.bookingARefundableRoundTripUsingAgencyOnly(agnBookingData.getTestData("brName"), agnBookingData.getTestData("agnName"),agnBookingData.getTestData("staffName"),agnBookingData.getTestData("source"),
                agnBookingData.getTestData("destination") ,passengerDetails.getTestData("title"), faker.name().firstName()
                , faker.name().lastName(), passengerDetails.getTestData("countCode"), passengerDetails.getTestData("passMobile")
                , passengerDetails.getTestData("gender"), passengerDetails.getTestData("passport"), passengerDetails.getTestData("nationality") );

    }

}
