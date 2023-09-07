package PortalPackage.ReportsTC;

import Portal.PortalLoginPage;
import Portal.ReportsPages.StatementReport;
import com.shaft.validation.Validations;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.text.ParseException;
import org.testng.asserts.SoftAssert;
import PortalPackage.Base.PortalTCBase;


public class StatementReportTC extends PortalTCBase {
    SoftAssert softAssert = new SoftAssert();
    PortalLoginPage logObj;
    StatementReport statementObj;
    @BeforeTest
    public void openReportsPage() throws InterruptedException {
        logObj = new PortalLoginPage(driver);
        logObj.PortalLoginWithValidData();
        statementObj = new StatementReport(driver);
    }
    //search with mandatory fields
    @Test
    public void statementSearchWithValidCredentials() throws InterruptedException, ParseException {
        statementObj = new StatementReport(driver);
        statementObj.statementSearchWithValidData();
        Thread.sleep(2000);
        statementObj.checkDatesInTable();
        Validations.verifyThat().element(driver.getDriver(), statementObj.searchTable).isVisible();
        Validations.verifyThat().element(driver.getDriver(), statementObj.exportToExcelBtn).isVisible();
        Validations.verifyThat().element(driver.getDriver(), statementObj.searchTable).isEnabled();
    }

    //check retrieved data from table
    @Test
    public void searchWithSpecificPassengerName() throws InterruptedException {
        statementObj = new StatementReport(driver);
        statementObj.checkPassengerName();
        Assert.assertTrue(statementObj.identicalData);
    }
    @Test
    public void checkRetrievedDataFromTable() throws InterruptedException {
        statementObj = new StatementReport(driver);
        statementObj.statementSearchWithValidData();
        statementObj.checkAgencyName();
        statementObj.checkBranchName();
        softAssert.assertTrue(statementObj.identicalData);
        softAssert.assertAll();
    }
}