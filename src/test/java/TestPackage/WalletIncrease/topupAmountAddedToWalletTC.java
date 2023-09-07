package TestPackage.WalletIncrease;

import Pages.*;
import Pages.Admin.Topup.AddTopUpPage;
import Pages.Admin.Topup.TopUpSearchPage;
import Pages.BookingMidOffice.ManualInvoice.AddManualInvoicePage;
import Pages.Login.LoginPage;
import TestPackage.BasePage.TCBase;
import com.shaft.driver.SHAFT;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;

public class topupAmountAddedToWalletTC extends TCBase {
    LoginPage loginObj;
    DashboardPage dashObj;
    AddManualInvoicePage manualObj;
    AddTopUpPage addTopupObj;
    TopUpSearchPage searchTopupObj;
    SHAFT.TestData.JSON manualData, topupData;
    Float walletBefore;
    Float walletAfter;
    int randomNum = ThreadLocalRandom.current().nextInt(1, 1000 + 1);


    @Test
    public void topupAmountAddedToWallet() throws InterruptedException {

        manualData = new SHAFT.TestData.JSON(System.getProperty("testDataFolderPath") + "manualinvoicedata.json");
        topupData = new SHAFT.TestData.JSON(System.getProperty("testDataFolderPath") + "addTopupToBranch.json");
        loginObj = new LoginPage(driver);
        loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openManualInvoicePage();
        manualObj = new AddManualInvoicePage(driver);
        manualObj.checkWalletOfAspecificBranch(manualData.getTestData("branchName"));
        walletBefore = manualObj.wallet;
        dashObj.openAddTopUpPage();
        addTopupObj = new AddTopUpPage(driver);
        addTopupObj.addTopUpTOBranchWithValidData(topupData.getTestData("branchName"), topupData.getTestData("topAmount"),
                Integer.toString(randomNum));
        searchTopupObj = new TopUpSearchPage(driver);
        searchTopupObj.searchAboutValidTopUpUsingReceiptNoAndApproveIt(Integer.toString(randomNum));
        dashObj.openManualInvoicePage();
        manualObj = new AddManualInvoicePage(driver);
        manualObj.checkWalletOfAspecificBranch(manualData.getTestData("branchName"));
        walletAfter = walletBefore+ Float.valueOf(topupData.getTestData("topAmount"));
        Assert.assertNotEquals(walletBefore, walletAfter, "Wallet balance change");
        Assert.assertEquals(manualObj.wallet,walletAfter);
        Assert.assertTrue(walletAfter > walletBefore, "Wallet balance increase");

    }


}
