package TestPackage.ReportsNegativeTC;

import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.Reports.AgencyDetailedReportPage;
import TestPackage.BasePage.TCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class AgencyDetailedNegativeTC extends TCBase {
    LoginPage loginObj;
    DashboardPage dashObj;
    AgencyDetailedReportPage agencyDetailedObj;

    @BeforeTest
    public void openReportsPage() throws InterruptedException {
        loginObj = new LoginPage(driver);
        loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
        dashObj = new DashboardPage(driver);
    }
    @Test
    public void searchWithNotBranch() throws InterruptedException {
        dashObj.openReportsPage();
        agencyDetailedObj = new AgencyDetailedReportPage(driver);
        agencyDetailedObj.searchWithoutSelectingBranch();
        Thread.sleep(1000);
        Assert.assertEquals(agencyDetailedObj.alertText, "Please select branch name");
    }

    @Test
    public void searchWithNoDates() throws InterruptedException {
        dashObj.openReportsPage();
        agencyDetailedObj = new AgencyDetailedReportPage(driver);
        agencyDetailedObj.searchWithoutDates();
        Thread.sleep(1000);
        Assert.assertEquals(agencyDetailedObj.alertText, "Please select Invoice From Date");
    }

    @Test
    public void searchWithDatesMoreThan60Days() throws InterruptedException {
        dashObj.openReportsPage();
        agencyDetailedObj = new AgencyDetailedReportPage(driver);
        agencyDetailedObj.searchWithDatePeriodMoreThan60();
        Thread.sleep(1000);
        Assert.assertEquals(agencyDetailedObj.alertText, "Invoice From and Invoice To Dates Difference should not be greater than 60 Days");
    }
}
