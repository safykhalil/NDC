package TestPackage.WalletDeduct;

import Pages.BookingMidOffice.ManualInvoice.AddManualInvoicePage;
import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.BookingMidOffice.Booking.oneWayBooking;
import TestPackage.BasePage.TCBase;
import com.github.javafaker.Faker;
import com.shaft.driver.SHAFT;
import org.testng.Assert;
import org.testng.annotations.Test;

public class checkWalletDeductedAfterBookingTC extends TCBase {
    LoginPage loginObj;
    DashboardPage dashObj;
    oneWayBooking oneWayObj;
    AddManualInvoicePage manualObj;
    SHAFT.TestData.JSON passengerDetails;
    SHAFT.TestData.JSON brOneWayData;
    SHAFT.TestData.JSON agnOneWayData;
    Float walletBefore;
    Float walletAfter;

    Faker faker = new Faker();


    @Test
    public void bookingOneWayUsingBrWithOneAdult() throws InterruptedException, NullPointerException {
        brOneWayData = new SHAFT.TestData.JSON(System.getProperty("testDataFolderPath") + "searchBookingBrData.json");
        passengerDetails = new SHAFT.TestData.JSON(System.getProperty("testDataFolderPath") + "passengerDetails.json");
        loginObj = new LoginPage(driver);
        loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openManualInvoicePage();
        manualObj = new AddManualInvoicePage(driver);
        manualObj.checkWalletOfAspecificBranch(brOneWayData.getTestData("brName"));
        walletBefore = manualObj.wallet;
        dashObj.openBookingPage();
        oneWayObj = new oneWayBooking(driver);
        oneWayObj.bookingRefundableOneWayTripUsingBranchOnlyAndOneAdult(brOneWayData.getTestData("brName"), brOneWayData.getTestData("source"),
                brOneWayData.getTestData("destination"), passengerDetails.getTestData("title"), faker.name().firstName()
                , faker.name().lastName(), passengerDetails.getTestData("countCode"), passengerDetails.getTestData("passMobile")
                , passengerDetails.getTestData("gender"), passengerDetails.getTestData("passport"), passengerDetails.getTestData("nationality"));

        if (oneWayObj.successBookingMssg != null && oneWayObj.successBookingMssg.contains("Your ticket has been successfully booked")) {
            dashObj.openManualInvoicePage();
            manualObj.checkWalletOfAspecificBranch(brOneWayData.getTestData("brName"));
            walletAfter = (walletBefore - Float.parseFloat(oneWayObj.tripPrice));
            Assert.assertEquals(manualObj.wallet, walletAfter);
        } else {
            dashObj.openManualInvoicePage();
            manualObj.checkWalletOfAspecificBranch(brOneWayData.getTestData("brName"));
            if (oneWayObj.tripPrice != null) {
                walletAfter = (walletBefore - Float.parseFloat(oneWayObj.tripPrice));
                Assert.assertEquals(manualObj.wallet, walletBefore);
            }
        }


    }

    @Test
    public void bookingOneWayUsingAgnWithOneAdult() throws InterruptedException, NullPointerException {
        agnOneWayData = new SHAFT.TestData.JSON(System.getProperty("testDataFolderPath") + "bookingAgnData.json");
        passengerDetails = new SHAFT.TestData.JSON(System.getProperty("testDataFolderPath") + "passengerDetails.json");
        loginObj = new LoginPage(driver);
        loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openManualInvoicePage();
        manualObj = new AddManualInvoicePage(driver);
        manualObj.checkWalletOfAspecificAgency(agnOneWayData.getTestData("brName"), agnOneWayData.getTestData("agnName"), agnOneWayData.getTestData("staffName"));
        walletBefore = manualObj.wallet;
        dashObj.openBookingPage();
        oneWayObj = new oneWayBooking(driver);
        oneWayObj.bookingAOneWayRefundableTripUsingAgencyAndOneAdult(agnOneWayData.getTestData("brName"), agnOneWayData.getTestData("agnName"),
                agnOneWayData.getTestData("staffName"), agnOneWayData.getTestData("source"), agnOneWayData.getTestData("destination")
                , passengerDetails.getTestData("title"), faker.name().firstName()
                , faker.name().lastName(), passengerDetails.getTestData("countCode"), passengerDetails.getTestData("passMobile")
                , passengerDetails.getTestData("gender"), passengerDetails.getTestData("passport"), passengerDetails.getTestData("nationality"));
        if (oneWayObj.successBookingMssg != null && oneWayObj.successBookingMssg.contains("Your ticket has been successfully booked")) {
            dashObj.openManualInvoicePage();
            manualObj.checkWalletOfAspecificAgency(agnOneWayData.getTestData("brName"), agnOneWayData.getTestData("agnName"), agnOneWayData.getTestData("staffName"));
            walletAfter = (walletBefore - Float.parseFloat(oneWayObj.tripPrice));
            Assert.assertEquals(manualObj.wallet, walletAfter);
        } else {
            dashObj.openManualInvoicePage();
            manualObj.checkWalletOfAspecificAgency(agnOneWayData.getTestData("brName"), agnOneWayData.getTestData("agnName"), agnOneWayData.getTestData("staffName"));
            if (oneWayObj.tripPrice != null) {
                walletAfter = (walletBefore - Float.parseFloat(oneWayObj.tripPrice));
                Assert.assertEquals(manualObj.wallet, walletBefore);
            }


        }
    }
}
