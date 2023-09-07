package TestPackage.ReportsTC;

import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.Reports.ReleasedPNRReportsPage;
import TestPackage.BasePage.TCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.ParseException;

public class ReleasedPNRTC extends TCBase {
    LoginPage loginObj;
    DashboardPage dashObj;
    ReleasedPNRReportsPage releasedPNR_ReportObj;
    @BeforeTest
    public void openReportsPage() throws InterruptedException{
        loginObj = new LoginPage(driver);
        loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openReportsPage();
    }
    @Test
    public void searchInReleasedPNRWithValidData() throws InterruptedException, ParseException {
        releasedPNR_ReportObj = new ReleasedPNRReportsPage(driver);
        releasedPNR_ReportObj.openReleasedPnrReport();
        releasedPNR_ReportObj.searchPNR_ReportWithValidData();
        releasedPNR_ReportObj.exportToExcel();
        Thread.sleep(1000);
        driver.assertThat().element(releasedPNR_ReportObj.searchTableRes).isVisible();
        driver.assertThat().element(releasedPNR_ReportObj.exportToExcelBtn).isVisible();
        Assert.assertTrue(releasedPNR_ReportObj.checkDatesOfReleaseInTable());
    }
}