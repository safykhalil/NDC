package TestPackage.ReportsTC;

import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.Reports.AgencyDetailedReportPage;
import Pages.Reports.TotalDueToNDCReportPage;
import TestPackage.BasePage.TCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.ParseException;

public class TotalDueToNDCReportsTC extends TCBase {
    LoginPage loginObj;
    DashboardPage dashObj;
    TotalDueToNDCReportPage totalDueToNDCObj;
    @BeforeTest
    public void openReportPage() throws InterruptedException{
        loginObj = new LoginPage(driver);
        loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openReportsPage();
    }
    @Test
    public void searchWithValidData() throws InterruptedException, ParseException {
        totalDueToNDCObj = new TotalDueToNDCReportPage(driver);
        totalDueToNDCObj.totalDueToNDCSearch();
        Thread.sleep(1000);
        driver.assertThat().element(totalDueToNDCObj.searchTableResults).isVisible();
        driver.assertThat().element(totalDueToNDCObj.exportToExcelBtn).isVisible();
        driver.assertThat().element(totalDueToNDCObj.exportToExcelBtn).isEnabled();
        Assert.assertTrue(totalDueToNDCObj.CheckInvoiceDatesInTable());
    }
}