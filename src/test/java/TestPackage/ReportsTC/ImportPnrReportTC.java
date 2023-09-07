package TestPackage.ReportsTC;
import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.Reports.ImportPnrReportPage;
import TestPackage.BasePage.TCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.text.ParseException;

public class ImportPnrReportTC extends TCBase {
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
    public void searchWithValidData() throws ParseException {
        importPnrReportObj = new ImportPnrReportPage(driver);
        dashObj.openReportsPage();
        importPnrReportObj.openImportPnrReports();
        importPnrReportObj.searchWithValidData();
        driver.assertThat().element(importPnrReportObj.exportToExcel).isVisible();
        driver.assertThat().element(importPnrReportObj.tableOfResults).isVisible();
        importPnrReportObj.exportToExcelBtn();
        Assert.assertTrue(importPnrReportObj.checkDatesInTable());
    }
}