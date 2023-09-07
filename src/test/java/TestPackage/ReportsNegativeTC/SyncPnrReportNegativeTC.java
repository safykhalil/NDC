package TestPackage.ReportsNegativeTC;
import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.Reports.SyncPnrReportPage;
import TestPackage.BasePage.TCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SyncPnrReportNegativeTC extends TCBase {
    LoginPage loginObj;
    DashboardPage dashObj;
    SyncPnrReportPage syncPnrReportobj;
    @BeforeTest
    public void openReportsPage() throws InterruptedException{
        loginObj = new LoginPage(driver);
        loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openReportsPage();
    }
    @Test
    public void searchWithEmptyData() {
        dashObj.openReportsPage();
        syncPnrReportobj = new SyncPnrReportPage(driver);
        syncPnrReportobj.openReleasedPnrReport();
        syncPnrReportobj.searchWithEmptyData();
        Assert.assertEquals(syncPnrReportobj.alertText,"Please Select Sync. PNR From Date and Sync. PNR To Date");
    }
    @Test
    public void searchWithEmptyFromDate() {
        dashObj.openReportsPage();
        syncPnrReportobj = new SyncPnrReportPage(driver);
        syncPnrReportobj.openReleasedPnrReport();
        syncPnrReportobj.searchWithEmptyFromDate();
        Assert.assertEquals(syncPnrReportobj.alertText,"Please select Sync. PNR From Date");
    }
    @Test
    public void searchWithEmptyToDate() {
        dashObj.openReportsPage();
        syncPnrReportobj = new SyncPnrReportPage(driver);
        syncPnrReportobj.openReleasedPnrReport();
        syncPnrReportobj.searchWithEmptyToDate();
        Assert.assertEquals(syncPnrReportobj.alertText,"Please select Sync. PNR To Date");
    }
    @Test
    public void searchWithDatePeriodMoreThen60() {
        dashObj.openReportsPage();
        syncPnrReportobj = new SyncPnrReportPage(driver);
        syncPnrReportobj.openReleasedPnrReport();
        syncPnrReportobj.searchWithDatePeriodMoreThen60();
        Assert.assertEquals(syncPnrReportobj.alertText,"Invoice From and Invoice To Dates Difference should not be greater than 60 Days");
    }
    @Test
    public void searchWithEmptyInvalidOrderId() {
        dashObj.openReportsPage();
        syncPnrReportobj = new SyncPnrReportPage(driver);
        syncPnrReportobj.openReleasedPnrReport();
        syncPnrReportobj.searchWithEmptyInvalidOrderId();
        Assert.assertEquals(driver.element().getText(syncPnrReportobj.noResultsMsg),"Search Result Not Found");

    }
}
