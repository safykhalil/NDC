package PortalPackage.ReportsNegativeTC;

import Portal.PortalLoginPage;
import Portal.ReportsPages.SalesReport;
import PortalPackage.Base.PortalTCBase;
import com.shaft.validation.Validations;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SalesReportNegativeTC extends PortalTCBase {
    PortalLoginPage logObj;
    SalesReport salesObj;

    @BeforeTest
    public void openReportsPage() throws InterruptedException {
        logObj = new PortalLoginPage(driver);
        logObj.PortalLoginWithValidData();

    }

    @Test
    public void searchWithInvalidDatePeriod() throws InterruptedException {
        salesObj = new SalesReport(driver);
        salesObj.searchWithPeriodMoreThanYear();
        Assert.assertEquals(salesObj.alertText, "Invoice From and Invoice To Dates Difference should not be greater than 365 Days");
    }

    @Test
    public void searchWithNoProductType() throws InterruptedException {
        salesObj = new SalesReport(driver);
        salesObj.searchWithoutProduct();
        Assert.assertEquals(salesObj.alertText,"Please Select Mandatory Fields");
    }

    @Test
    public void searchWithNoDates() throws InterruptedException {
        salesObj = new SalesReport(driver);
        salesObj.searchWithoutDates();
        Assert.assertEquals(salesObj.alertText, "Please Select  Invoice From Date and Invoice To Date");
    }
    @Test
    public void checkInvalidCustomerName() throws InterruptedException {
        salesObj = new SalesReport(driver);
        salesObj.checkDataWithInvalidCustomerName();
        Validations.verifyThat().element(driver.getDriver(), salesObj.noReultMsg).exists().perform();
    }
    @Test
    public void checkInvalidTxnID() throws InterruptedException {
        salesObj = new SalesReport(driver);
        salesObj.chcekDataWithInvalidTxnID();
        Validations.verifyThat().element(driver.getDriver(), salesObj.noReultMsg).exists().perform();
    }
}
