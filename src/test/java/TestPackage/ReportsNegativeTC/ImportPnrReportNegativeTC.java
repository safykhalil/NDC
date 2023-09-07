package TestPackage.ReportsNegativeTC;
import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.Reports.ImportPnrReportPage;
import TestPackage.BasePage.TCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ImportPnrReportNegativeTC extends TCBase {
    LoginPage loginObj ;
    DashboardPage dashObj;
    ImportPnrReportPage importPnrReportObj;
    @BeforeTest
    public void beforeTest()throws InterruptedException{
        loginObj = new LoginPage(driver);
        loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
        dashObj = new DashboardPage(driver);
    }
    @Test
    public void searchWithEmptyBranch() {
        dashObj.openReportsPage();
        importPnrReportObj = new ImportPnrReportPage(driver);
        importPnrReportObj.openImportPnrReports();
        importPnrReportObj.searchWithEmptyBranch();
        Assert.assertEquals(importPnrReportObj.alertText,"Please select branch name");
    }
    @Test
    public void searchWithEmptyFromDate() throws InterruptedException {
        dashObj.openReportsPage();
        importPnrReportObj = new ImportPnrReportPage(driver);
        importPnrReportObj.openImportPnrReports();
        importPnrReportObj.searchWithEmptyFromDate();
        Assert.assertEquals(importPnrReportObj.alertText,"Please select Invoice From Date");
    }
    @Test
    public void searchWithEmptyToDate() {
        dashObj.openReportsPage();
        importPnrReportObj = new ImportPnrReportPage(driver);
        importPnrReportObj.openImportPnrReports();
        importPnrReportObj.searchWithEmptyToDate();
        Assert.assertEquals(importPnrReportObj.alertText,"Please select Invoice To Date");
    }
    @Test
    public void searchWithDatePeriodMoreThen60() {
        dashObj.openReportsPage();
        importPnrReportObj = new ImportPnrReportPage(driver);
        importPnrReportObj.openImportPnrReports();
        importPnrReportObj.searchWithDatePeriodMoreThen60();
        Assert.assertEquals(importPnrReportObj.alertText,"Invoice From and Invoice To Dates Difference should not be greater than 60 Days");
    }
}
