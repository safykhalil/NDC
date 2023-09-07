package PortalPackage.ReportsTC;

import Portal.PortalLoginPage;
import Portal.ReportsPages.SalesReport;
import Portal.ReportsPages.StatementReport;
import PortalPackage.Base.PortalTCBase;
import com.shaft.validation.Validations;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.text.ParseException;

public class SalesReportTC extends PortalTCBase {
    SoftAssert softAssert = new SoftAssert();
    PortalLoginPage logObj;
    SalesReport salesObj;
    @BeforeTest
    public void openReportsPage() throws InterruptedException {
        logObj = new PortalLoginPage(driver);
        salesObj = new SalesReport(driver);
        logObj.PortalLoginWithValidData();
    }
    @Test
    public void searchWithValidCredentials() throws ParseException, InterruptedException {
        salesObj.searchWithValidData();
        Thread.sleep(3000);
        salesObj.checkDatesInTable();
        Validations.verifyThat().element(driver.getDriver(),salesObj.exportToExcelBtn).isVisible().perform();
        Validations.verifyThat().element(driver.getDriver(),salesObj.exportToExcelBtn).isEnabled().perform();
    }
    @Test
    public void checkRetrievedDataFromTable() throws InterruptedException {
        salesObj.checkCustomerName();
        Thread.sleep(3000);
        softAssert.assertTrue(salesObj.identicalData,"Customer Name Does Not Match!");
//        salesObj.checkInvoiceNumber();
//        Thread.sleep(3000);
//        softAssert.assertTrue(salesObj.identicalData,"Invoice Number Does Not Match!");
//        salesObj.checkAgentName();
//        Thread.sleep(3000);
//        softAssert.assertTrue(salesObj.identicalData,"Agent Name Does Not Match!");
//        salesObj.chcekDataWithValidTxnID();
//        Thread.sleep(3000);
//        softAssert.assertTrue(salesObj.identicalData,"TXN ID Does Not Match!");
//
//        softAssert.assertAll();
    }
}
