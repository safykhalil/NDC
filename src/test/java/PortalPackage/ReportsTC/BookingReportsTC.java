package PortalPackage.ReportsTC;
import Portal.PortalLoginPage;
import Portal.ReportsPages.BookingReportsPage;
import PortalPackage.Base.PortalTCBase;
import com.shaft.validation.Validations;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.text.ParseException;

public class BookingReportsTC extends PortalTCBase {
    PortalLoginPage loginObj;
    BookingReportsPage bookingReportsObj;

    @BeforeTest
    public void beforeTest(){
        loginObj = new PortalLoginPage(driver);
        loginObj.PortalLoginWithValidData();
        bookingReportsObj = new BookingReportsPage(driver);
    }
    @Test
    public void searchInBookingReportsWithMandatoryData() throws ParseException {
        bookingReportsObj.openReportPage();
        bookingReportsObj.searchInBookingReportsWithMandatoryData();
        Validations.verifyThat().element(bookingReportsObj.tableOfResults).isVisible();
        Assert.assertTrue(bookingReportsObj.checkDatesInTable());
    }
    @Test
    public void searchInTotalDueToNdcWithRetailCustomerType() throws ParseException {
        bookingReportsObj.openReportPage();
        bookingReportsObj.searchInBookingReportsWithRetailCustomerType();
        Validations.verifyThat().element(bookingReportsObj.tableOfResults).isVisible();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(bookingReportsObj.checkDatesInTable());
        softAssert.assertTrue(bookingReportsObj.identicalData);
        softAssert.assertAll();
    }

    @Test
    public void searchInBookingReportsWithValidCustomerName() {
        bookingReportsObj.openReportPage();
        bookingReportsObj.searchInBookingReportsWithValidCustomerName();
        Validations.verifyThat().element(bookingReportsObj.tableOfResults).isVisible();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(bookingReportsObj.identicalData);
        softAssert.assertAll();
    }
    @Test
    public void searchInBookingReportsWithValidAgentName() {
        bookingReportsObj.openReportPage();
        bookingReportsObj.searchInBookingReportsWithValidAgentName();
        Validations.verifyThat().element(bookingReportsObj.tableOfResults).isVisible();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(bookingReportsObj.identicalData);
        softAssert.assertAll();
    }
    @Test
    public void searchInBookingReportsWithValidInvoiceNumber() {
        bookingReportsObj.openReportPage();
        bookingReportsObj.searchInBookingReportsWithValidInvoiceNumber();
        Validations.verifyThat().element(bookingReportsObj.tableOfResults).isVisible();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(bookingReportsObj.identicalData);
        softAssert.assertAll();
    }
    @Test
    public void searchInBookingReportsWithValidBookingReferenceNumber() {
        bookingReportsObj.openReportPage();
        bookingReportsObj.searchInBookingReportsWithValidBookingReferenceNumber();
        Validations.verifyThat().element(bookingReportsObj.tableOfResults).isVisible();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(bookingReportsObj.identicalData);
        softAssert.assertAll();
    }
    @Test
    public void searchInBookingReportsWithValidTicketStatus() {
        bookingReportsObj.openReportPage();
        bookingReportsObj.searchInBookingReportsWithValidTicketStatus();
        Validations.verifyThat().element(bookingReportsObj.tableOfResults).isVisible();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(bookingReportsObj.identicalData);
        softAssert.assertAll();
    }
}
