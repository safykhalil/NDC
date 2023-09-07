package TestPackage.ReportsTC;

import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.Reports.BookingReportPage;
import TestPackage.BasePage.TCBase;

import com.shaft.validation.Validations;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.ParseException;

public class BookingReportTC extends TCBase {
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
    public void bookingReportSearchWithValidData() throws InterruptedException, ParseException {
        dashObj.openReportsPage();
        bookingReportObj = new BookingReportPage(driver);
        bookingReportObj.searchWithValidData();
        Thread.sleep(1000);
        Validations.verifyThat().element(driver.getDriver(), bookingReportObj.searchTable).isVisible().perform();
        Validations.verifyThat().element(driver.getDriver(), bookingReportObj.exportToExcelBtn).isVisible().perform();
        Validations.verifyThat().element(driver.getDriver(), bookingReportObj.exportToExcelBtn).isEnabled().perform();
    }
}