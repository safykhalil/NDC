package PortalPackage.ReportsNegativeTC;
import Portal.PortalLoginPage;
import Portal.ReportsPages.BookingReportsPage;
import PortalPackage.Base.PortalTCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BookingReportsNegativeTC extends PortalTCBase {
    PortalLoginPage loginObj;
    BookingReportsPage bookingReportsObj;

    @BeforeTest
    public void beforeTest(){
        loginObj = new PortalLoginPage(driver);
        loginObj.PortalLoginWithValidData();
        bookingReportsObj = new BookingReportsPage(driver);
    }
    @Test
    public void searchInBookingReportsWithEmptyFromDate(){
        bookingReportsObj.openReportPage();
        bookingReportsObj.searchInBookingReportsWithEmptyFromDate();
        Assert.assertEquals(bookingReportsObj.alertMsgTxt,"Please select mandatory fields From Booking Date and To Booking Date");
    }
    @Test
    public void searchInBookingReportsWithEmptyToDate(){
        bookingReportsObj.openReportPage();
        bookingReportsObj.searchInBookingReportsWithEmptyToDate();
        Assert.assertEquals(bookingReportsObj.alertMsgTxt,"Please select mandatory fields From Booking Date and To Booking Date");
    }
    @Test
    public void searchInBookingReportsWithDateRangeGreaterThan360Days(){
        bookingReportsObj.openReportPage();
        bookingReportsObj.searchInBookingReportsWithDateRangeGreaterThan360Days();
        Assert.assertEquals(bookingReportsObj.alertMsgTxt,"Booking From and Booking To Dates Difference should not be greater than 365 Days");
    }
    @Test
    public void searchInBookingReportsWithInvalidClientName(){
        bookingReportsObj.openReportPage();
        bookingReportsObj.searchInBookingReportsWithInvalidClientName();
        Assert.assertEquals(driver.element().getText(bookingReportsObj.noResultMsg),"Search Result Not Found");
    }
    @Test
    public void searchInBookingReportsWithInvalidInvoiceNo(){
        bookingReportsObj.openReportPage();
        bookingReportsObj.searchInBookingReportsWithInvalidInvoiceNo();
        Assert.assertEquals(driver.element().getText(bookingReportsObj.noResultMsg),"Search Result Not Found");
    }
    @Test
    public void searchInBookingReportsWithInvalidBookingReferenceNumber(){
        bookingReportsObj.openReportPage();
        bookingReportsObj.searchInBookingReportsWithInvalidBookingReferenceNumber();
        Assert.assertEquals(driver.element().getText(bookingReportsObj.noResultMsg),"Search Result Not Found");
    }

}
