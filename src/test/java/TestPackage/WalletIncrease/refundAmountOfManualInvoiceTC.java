package TestPackage.WalletIncrease;

import Pages.BookingMidOffice.ManualInvoice.AddManualInvoicePage;
import Pages.BookingMidOffice.SearchBooking.SearchBookingPage;
import Pages.DashboardPage;
import Pages.Login.LoginPage;
import TestPackage.BasePage.TCBase;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class refundAmountOfManualInvoiceTC extends TCBase {
    LoginPage loginObj;
    SearchBookingPage searchObj;
    DashboardPage dashObj;
    AddManualInvoicePage manualPageObj;
    int cancellationAmount = 0;
    SHAFT.TestData.JSON manualData;
    Float walletBefore, walletAfter;


    @Test
    @Description("Validate If refund process occurs or not")
    public void refundAmountOfManualInvoice() throws InterruptedException {
        manualData = new SHAFT.TestData.JSON(System.getProperty("testDataFolderPath") + "manualinvoicedata.json");
        loginObj = new LoginPage(driver);
        loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openManualInvoicePage();
        manualPageObj = new AddManualInvoicePage(driver);
        manualPageObj.checkWalletOfAspecificBranch(manualData.getTestData("branchName"));
        walletBefore = manualPageObj.wallet;
        manualPageObj.addManualInvoiceWithValidCriteriaToBranch(manualData.getTestData("branchName")
                , manualData.getTestData("source"), manualData.getTestData("destination"), manualData.getTestData("airLine")
                , manualData.getTestData("base"), manualData.getTestData("taxes"),
                manualData.getTestData("markup"), manualData.getTestData("serviceCharge"), manualData.getTestData("discount"), manualData.getTestData("GdsPnr"), manualData.getTestData("airLinePnr"),
                manualData.getTestData("flightNo"), manualData.getTestData("title"), manualData.getTestData("firstName"), manualData.getTestData("LastName"), manualData.getTestData("countryCode"),
                manualData.getTestData("passMobile"), manualData.getTestData("gender"), manualData.getTestData("passport"), manualData.getTestData("nationality"), manualData.getTestData("ticketNO"));
        dashObj.openImportPnr();
        dashObj.openManualInvoicePage();
        manualPageObj.checkWalletOfAspecificBranch(manualData.getTestData("branchName"));
        Assert.assertEquals(manualPageObj.wallet, (walletBefore - manualPageObj.totalCost));
        walletAfter = manualPageObj.wallet;
        searchObj = new SearchBookingPage(driver);
        dashObj.openSearchBookingPage();
        searchObj.searchWithNDCReferenceRelatedToBranch(manualPageObj.ndcRef);
        try {
            searchObj.cancelTicketBookingRelatedToBranch();
            searchObj.refundAmountOfTicketAfterCancellation(manualPageObj.totalCost, cancellationAmount);
            dashObj.openManualInvoicePage();
            manualPageObj.checkWalletOfAspecificBranch(manualData.getTestData("branchName"));
            Assert.assertEquals(manualPageObj.wallet, (walletAfter + (manualPageObj.totalCost - cancellationAmount)));
            successfulRefund();
        } catch (IllegalArgumentException e) {
            failedRefund();
        }

    }

    @Step("refund process occurs successfully")
    public void successfulRefund() {
        System.out.println("refund process occurs successfully");
    }

    @Step("refund process doesn't occur successfully")
    public void failedRefund() {
        System.out.println("refund process doesn't occur successfully");
    }


}

