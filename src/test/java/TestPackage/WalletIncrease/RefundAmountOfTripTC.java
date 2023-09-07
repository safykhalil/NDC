package TestPackage.WalletIncrease;

import TestPackage.BasePage.TCBase;
import Pages.BookingMidOffice.Booking.oneWayBooking;
import Pages.BookingMidOffice.ManualInvoice.AddManualInvoicePage;
import Pages.BookingMidOffice.SearchBooking.SearchBookingPage;
import Pages.DashboardPage;
import Pages.Login.LoginPage;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;


public class RefundAmountOfTripTC extends TCBase {
    LoginPage loginObj;
    DashboardPage dashObj;
    oneWayBooking oneWayObj;
    AddManualInvoicePage manualObj;
    SearchBookingPage searchObj;
    SHAFT.TestData.JSON passengerDetails;
    SHAFT.TestData.JSON brOneWayData;
    SHAFT.TestData.JSON agnOneWayData;
    Float refundAmount , walletAfter , walletBefore ;
    int cancellationAmount = 30 ;
    Faker faker = new Faker();
    @Test
    @Description("Verify is ticket refunded")
    public void refundAmountOfTicketAfterBookingAndCancelItByBranch() throws InterruptedException, NullPointerException {
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

        if (oneWayObj.successBookingMssg == null) {
            driver.quit();
            NoTripsBooked();

        }
        else if (oneWayObj.successBookingMssg != null && oneWayObj.successBookingMssg.contains("Your ticket has been successfully booked")) {
            dashObj.openManualInvoicePage();
            manualObj.checkWalletOfAspecificBranch(brOneWayData.getTestData("brName"));
            walletAfter = (walletBefore - Float.parseFloat(oneWayObj.tripPrice));
            Assert.assertEquals(manualObj.wallet, walletAfter);
            ticketBookingSuccess();
            dashObj.openSearchBookingPage();
            searchObj = new SearchBookingPage(driver);
            searchObj.searchAboutSpecificPnrRelatedToBranch(oneWayObj.PNR);
            searchObj.cancelTicketBookingRelatedToBranch();
            refundAmount = Float.parseFloat(oneWayObj.tripPrice)  - 1 ;
            searchObj.refundAmountOfTicketAfterCancellation(Float.parseFloat(oneWayObj.tripPrice ) - 1,30);
            dashObj.openManualInvoicePage();
            manualObj.checkWalletOfAspecificBranch(brOneWayData.getTestData("brName"));
            Assert.assertEquals(manualObj.wallet , ((walletAfter+refundAmount) - cancellationAmount ));
            successfulRefundOfTicket();
            // success case
        } else if ( oneWayObj.successBookingMssg != null && oneWayObj.successBookingMssg.contains("Your transaction has been failed")) {
            dashObj.openManualInvoicePage();
            manualObj.checkWalletOfAspecificBranch(brOneWayData.getTestData("brName"));
            if (oneWayObj.tripPrice != null) {
                walletAfter = (walletBefore - Float.parseFloat(oneWayObj.tripPrice));
                Assert.assertEquals(manualObj.wallet, walletBefore);
                ticketFailedNDCOnly();
                dashObj.openSearchBookingPage();
                searchObj = new SearchBookingPage(driver);
                searchObj.searchAboutSpecificPnrRelatedToBranch(oneWayObj.PNR);
                searchObj.cancelTicketBookingRelatedToBranch();
                successfulCancellationOfTicket();
                // ticket fail with pnr
            }


        } else {
            dashObj.openManualInvoicePage();
            manualObj.checkWalletOfAspecificBranch(brOneWayData.getTestData("brName"));
            if (oneWayObj.tripPrice != null) {
                walletAfter = (walletBefore - Float.parseFloat(oneWayObj.tripPrice));
                Assert.assertEquals(manualObj.wallet, walletBefore);
                ticketFailedNDCAndSupplier();
                // ticket fail without pnr

            }

        }


    }
    @Test
    @Description("Verify is ticket refunded")
    public void refundAmountOfTicketAfterBookingAndCancelItByAgency() throws InterruptedException, NullPointerException {
        agnOneWayData = new SHAFT.TestData.JSON(System.getProperty("testDataFolderPath") + "bookingAgnData.json");
        passengerDetails = new SHAFT.TestData.JSON(System.getProperty("testDataFolderPath") + "passengerDetails.json");
        loginObj = new LoginPage(driver);
        loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openManualInvoicePage();
        manualObj = new AddManualInvoicePage(driver);
        manualObj.checkWalletOfAspecificAgency(agnOneWayData.getTestData("brName") ,agnOneWayData.getTestData("agnName"), agnOneWayData.getTestData("staffName"));
        walletBefore = manualObj.wallet;
        dashObj.openBookingPage();
        oneWayObj = new oneWayBooking(driver);
        oneWayObj.bookingAOneWayRefundableTripUsingAgencyAndOneAdult(agnOneWayData.getTestData("brName"), agnOneWayData.getTestData("agnName"), agnOneWayData.getTestData("staffName"), agnOneWayData.getTestData("source"),
                agnOneWayData.getTestData("destination"), passengerDetails.getTestData("title"), faker.name().firstName()
                , faker.name().lastName(), passengerDetails.getTestData("countCode"), passengerDetails.getTestData("passMobile")
                , passengerDetails.getTestData("gender"), passengerDetails.getTestData("passport"), passengerDetails.getTestData("nationality"));

        if (oneWayObj.successBookingMssg == null) {
            driver.quit();
            NoTripsBooked();

        }
        else if (oneWayObj.successBookingMssg != null && oneWayObj.successBookingMssg.contains("Your ticket has been successfully booked")) {
            dashObj.openManualInvoicePage();
            manualObj.checkWalletOfAspecificAgency(agnOneWayData.getTestData("brName"),agnOneWayData.getTestData("agnName"), agnOneWayData.getTestData("staffName"));
            walletAfter = (walletBefore - Float.parseFloat(oneWayObj.tripPrice));
            Assert.assertEquals(manualObj.wallet, walletAfter);
            ticketBookingSuccess();
            dashObj.openSearchBookingPage();
            searchObj = new SearchBookingPage(driver);
            searchObj.searchAboutSpecificPnrRelatedToAgency(oneWayObj.PNR);
            searchObj.cancelTicketBookingUsingPNRRelatedToAgency(oneWayObj.PNR);
            refundAmount = Float.parseFloat(oneWayObj.tripPrice)  - 1 ;
            searchObj.refundAmountOfTicketAfterCancellation(Float.parseFloat(oneWayObj.tripPrice ) - 1,30);
            dashObj.openManualInvoicePage();
            manualObj.checkWalletOfAspecificAgency(agnOneWayData.getTestData("brName"),agnOneWayData.getTestData("agnName"), agnOneWayData.getTestData("staffName"));
            Assert.assertEquals(manualObj.wallet , ((walletAfter+refundAmount) - cancellationAmount ));
            successfulRefundOfTicket();
            // success case
        } else if ( oneWayObj.successBookingMssg != null && oneWayObj.successBookingMssg.contains("Your transaction has been failed")) {
            dashObj.openManualInvoicePage();
            manualObj.checkWalletOfAspecificAgency(agnOneWayData.getTestData("brName"),agnOneWayData.getTestData("agnName"), agnOneWayData.getTestData("staffName"));
            if (oneWayObj.tripPrice != null) {
                walletAfter = (walletBefore - Float.parseFloat(oneWayObj.tripPrice));
                Assert.assertEquals(manualObj.wallet, walletBefore);
                ticketFailedNDCOnly();
                dashObj.openSearchBookingPage();
                searchObj = new SearchBookingPage(driver);
                searchObj.searchAboutSpecificPnrRelatedToAgency(oneWayObj.PNR);
                searchObj.cancelTicketBookingUsingPNRRelatedToAgency(oneWayObj.PNR);
                successfulCancellationOfTicket();
                // ticket fail with pnr
            }


        } else {
            dashObj.openManualInvoicePage();
            manualObj.checkWalletOfAspecificBranch(brOneWayData.getTestData("brName"));
            if (oneWayObj.tripPrice != null) {
                walletAfter = (walletBefore - Float.parseFloat(oneWayObj.tripPrice));
                Assert.assertEquals(manualObj.wallet, walletBefore);
                ticketFailedNDCAndSupplier();
                // ticket fail without pnr

            }

        }


    }
    @Step("Ticket is booked on NDC side and Supplier side")
    public void ticketBookingSuccess() {
        System.out.println("Ticket is booked successfully with PNR");
    }

    @Step("Ticket failed on NDC side but booked on supplier side")
    public void ticketFailedNDCOnly() {
        System.out.println("Ticket is failed on NDC side and supplier side");
    }

    @Step("Ticket is booked on supplier side but failed on NDC side")
    public void ticketFailedNDCAndSupplier() {
        System.out.println("Ticket is booked on supplier side but failed on NDC side");
    }
    @Step("Ticket cancelled successfully")
    public void successfulCancellationOfTicket() {
        System.out.println("Ticket cancelled successfully");
    }
    @Step("Ticket Refunded successfully")
    public void successfulRefundOfTicket() {
        System.out.println("Ticket Refunded successfully");
    }
    @Step("No Trips booked")
    public void NoTripsBooked() {
        System.out.println("No Trips booked");
    }
}
