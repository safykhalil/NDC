package PortalPackage.ReportsNegativeTC;
import Portal.PortalLoginPage;
import Portal.ReportsPages.TotalDueToNDCPage;
import PortalPackage.Base.PortalTCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TotalDueToNdcNegativeTC extends PortalTCBase {
    PortalLoginPage loginObj;
    TotalDueToNDCPage totalDueToNDCObj;

    @BeforeTest
    public void beforeTest() throws InterruptedException {
        loginObj = new PortalLoginPage(driver);
        loginObj.PortalLoginWithValidData();
        totalDueToNDCObj = new TotalDueToNDCPage(driver);
    }
    @Test
    public void searchInTotalDueToNdcWithEmptyProductType() {
        totalDueToNDCObj.openReportPage();
        totalDueToNDCObj.searchInTotalDueToNdcWithEmptyProductType();
        Assert.assertEquals(driver.element().getText(totalDueToNDCObj.noResultMsg),"Please select product type");
    }
    @Test
    public void searchInTotalDueToNdcWithEmptyDate() {
        totalDueToNDCObj.openReportPage();
        totalDueToNDCObj.searchInTotalDueToNdcWithEmptyDate();
        Assert.assertEquals(driver.element().getText(totalDueToNDCObj.noResultMsg),"Please Select Invoicefrom and InvoiceTo Dates");
    }
    @Test
    public void searchInTotalDueToNdcWithInvalidInvoiceNumber() {
        totalDueToNDCObj.openReportPage();
        totalDueToNDCObj.searchInTotalDueToNdcWithInvalidInvoiceNumber();
        Assert.assertEquals(driver.element().getText(totalDueToNDCObj.noResultMsg),"Search Result Not Found");
    }
    @Test
    public void searchInTotalDueToNdcWithInvalidCustomerName() {
        totalDueToNDCObj.openReportPage();
        totalDueToNDCObj.searchInTotalDueToNdcWithInvalidCustomerName();
        Assert.assertEquals(driver.element().getText(totalDueToNDCObj.noResultMsg),"Search Result Not Found");
    }
    @Test
    public void searchInTotalDueToNdcWithInvalidBookingRefNumber() {
        totalDueToNDCObj.openReportPage();
        totalDueToNDCObj.searchInTotalDueToNdcWithInvalidBookingRefNumber();
        Assert.assertEquals(driver.element().getText(totalDueToNDCObj.noResultMsg),"Search Result Not Found");
    }
}
