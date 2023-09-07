package PortalPackage.ReportsNegativeTC;

import Portal.PortalLoginPage;
import Portal.ReportsPages.StatementReport;
import PortalPackage.Base.PortalTCBase;
import com.shaft.validation.Validations;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StatementReportNegativeTC extends PortalTCBase {
    PortalLoginPage logObj;
    StatementReport statementObj;
    @BeforeTest
    public void openReportsPage() throws InterruptedException {
        logObj = new PortalLoginPage(driver);
        logObj.PortalLoginWithValidData();
        statementObj = new StatementReport(driver);
    }
    @Test
    public void searchWithInvalidDatePeriod() throws InterruptedException {
        statementObj = new StatementReport(driver);
        statementObj.searchWithInvalidDatePeriod();
        Assert.assertEquals(statementObj.alertText, "Invoice From and Invoice To Dates Difference should not be greater than 365 Days");
    }
    @Test
    public void searchWithNoDates() throws InterruptedException {
        statementObj = new StatementReport(driver);
        statementObj.searchWithoutDates();
        Assert.assertEquals(statementObj.alertText,"Please Select  Invoice From Date and Invoice To Date");
    }

    @Test
    public void searchWithInvalidPassengerName() throws InterruptedException {
        statementObj = new StatementReport(driver);
        statementObj.checkDataWithInvalidCredentials();
        Validations.verifyThat().element(driver.getDriver(), statementObj.searchTable).doesNotExist().perform();
    }
}
