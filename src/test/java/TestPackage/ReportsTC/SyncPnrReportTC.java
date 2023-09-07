package TestPackage.ReportsTC;
import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.Reports.SyncPnrReportPage;
import TestPackage.BasePage.TCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.text.ParseException;

public class SyncPnrReportTC extends TCBase {
    LoginPage loginObj;
    DashboardPage dashObj;
    SyncPnrReportPage syncPnrReportobj;
    @BeforeTest
    public void beforeTest()throws InterruptedException{
        loginObj = new LoginPage(driver);
        loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openReportsPage();
    }
    @Test
    public void searchInFinanceReportsWithValidData() throws ParseException {
        syncPnrReportobj = new SyncPnrReportPage(driver);
        syncPnrReportobj.openReleasedPnrReport();
        syncPnrReportobj.searchWithValidData();
        driver.assertThat().element(syncPnrReportobj.tableOfResults).isVisible();
        driver.assertThat().element(syncPnrReportobj.exportBtn).isVisible();
        Assert.assertTrue(syncPnrReportobj.checkDatesInTable());
    }
}
