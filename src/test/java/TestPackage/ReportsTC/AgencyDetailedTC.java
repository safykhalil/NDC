package TestPackage.ReportsTC;

import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.Reports.AgencyDetailedReportPage;
import TestPackage.BasePage.TCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.text.ParseException;

public class AgencyDetailedTC extends TCBase {
    LoginPage loginObj;
    DashboardPage dashObj;
    AgencyDetailedReportPage agencyDetailedObj;

    @BeforeTest
    public void openReportsPage() throws InterruptedException {
        loginObj = new LoginPage(driver);
        loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openReportsPage();
    }

    @Test
    public void searchInReleasedPNRWithValidData() throws InterruptedException, ParseException {
        agencyDetailedObj = new AgencyDetailedReportPage(driver);
        agencyDetailedObj.agencyDetailedReportsSearch();
        //  agencyDetailedObj.exportToExcel();
        Thread.sleep(1000);
        driver.assertThat().element(agencyDetailedObj.searchTableRes).isVisible();
        driver.assertThat().element(agencyDetailedObj.exportToExcelBtn).isVisible();
        driver.assertThat().element(agencyDetailedObj.exportToExcelBtn).isEnabled();
        Assert.assertTrue(agencyDetailedObj.CheckDatesOfIssuesInTable());
    }
}
