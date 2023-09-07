package TestPackage.ReportsNegativeTC;

import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.Reports.BookingReportPage;
import TestPackage.BasePage.TCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BookingReportNegativeTC extends TCBase {
    LoginPage loginObj;
    DashboardPage dashObj;
    BookingReportPage bookingReportObj;

    @BeforeTest
    public void openReportsPage() throws InterruptedException {
        loginObj = new LoginPage(driver);
        loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
        dashObj = new DashboardPage(driver);
    }
    @Test
    public void searchWithoutBranch() throws InterruptedException {
        dashObj.openReportsPage();
        bookingReportObj = new BookingReportPage(driver);
        bookingReportObj.searchWithNoBranch();
        Thread.sleep(1000);
        Assert.assertEquals(bookingReportObj.alertText, "Please select branch name");
    }
    @Test
    public void searchWithoutDates() throws InterruptedException {
        dashObj.openReportsPage();
        bookingReportObj = new BookingReportPage(driver);
        bookingReportObj.searchWithNoDates();
        Thread.sleep(1000);
        Assert.assertEquals(bookingReportObj.alertText, "Please select mandatory fields From Booking Date and To Booking Date");
    }
    @Test
    public void searchWithDaysMoreThan60() throws InterruptedException {
        dashObj.openReportsPage();
        bookingReportObj = new BookingReportPage(driver);
        bookingReportObj.searchWithMoreThan60Days();
        Assert.assertEquals(bookingReportObj.alertText,"Booking From and Booking To Dates Difference should not be greater than 60 Days");
    }
}
