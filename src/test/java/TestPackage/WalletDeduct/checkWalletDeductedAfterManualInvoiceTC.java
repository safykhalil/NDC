package TestPackage.WalletDeduct;

import Pages.BookingMidOffice.ManualInvoice.AddManualInvoicePage;
import Pages.DashboardPage;
import Pages.Login.LoginPage;
import TestPackage.BasePage.TCBase;
import com.shaft.driver.SHAFT;
import org.testng.Assert;
import org.testng.annotations.Test;

public class checkWalletDeductedAfterManualInvoiceTC extends TCBase {

    LoginPage loginObj;
    DashboardPage dashObj;
    AddManualInvoicePage manualObj;
    Float walletBefore;
    Float walletAfter;
    SHAFT.TestData.JSON manualData;

    @Test

    public void checkDeductionAfterManual() throws InterruptedException {
        manualData = new SHAFT.TestData.JSON(System.getProperty("testDataFolderPath") + "manualinvoicedata.json");
        loginObj = new LoginPage(driver);
        loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openManualInvoicePage();
        manualObj = new AddManualInvoicePage(driver);
        manualObj.checkWalletOfAspecificBranch(manualData.getTestData("branchName"));
        walletBefore = manualObj.wallet;
        manualObj.addManualInvoiceWithValidCriteriaToBranch(manualData.getTestData("branchName"),
                manualData.getTestData("source"), manualData.getTestData("destination"), manualData.getTestData("airLine")
                , manualData.getTestData("base"), manualData.getTestData("taxes"),
                manualData.getTestData("markup"), manualData.getTestData("serviceCharge"),
                manualData.getTestData("discount"), manualData.getTestData("GdsPnr"), manualData.getTestData("airLinePnr"),
                manualData.getTestData("flightNo"), manualData.getTestData("title"), manualData.getTestData("firstName"),
                manualData.getTestData("LastName"), manualData.getTestData("countryCode"),
                manualData.getTestData("passMobile"), manualData.getTestData("gender"), manualData.getTestData("passport"),
                manualData.getTestData("nationality"), manualData.getTestData("ticketNO"));
        dashObj.openManualInvoicePage();
        manualObj.checkWalletOfAspecificBranch(manualData.getTestData("branchName"));
        walletAfter = (walletBefore - (Integer.parseInt(manualData.getTestData("base")) + Integer.parseInt(manualData.getTestData("taxes")) +
                Integer.parseInt(manualData.getTestData("markup")) + Integer.parseInt(manualData.getTestData("serviceCharge"))
                - Integer.parseInt(manualData.getTestData("discount"))));

        Assert.assertEquals(manualObj.wallet, walletAfter);


    }
}

