package TestPackage.ReportsNegativeTC;

import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.Reports.PerformanceReportsPage;
import TestPackage.BasePage.TCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PerformanceReportsNegativeTC extends TCBase {
    LoginPage loginObj;
    DashboardPage dashboardObj;
    PerformanceReportsPage performanceReportObj;
    @BeforeTest
    public void openReportsPage()throws InterruptedException{
        loginObj = new LoginPage(driver);
        loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
        dashboardObj = new DashboardPage(driver);
    }
    @Test
    public void searchWithNoBranch() throws InterruptedException {
        dashboardObj.openReportsPage();
        performanceReportObj = new PerformanceReportsPage(driver);
        performanceReportObj.searchWithoutBranch();
        Thread.sleep(2000);
        Assert.assertEquals(performanceReportObj.alertText, "Please select branch name");


    }
    @Test
    public void searchWithNoYear() throws InterruptedException {
        dashboardObj.openReportsPage();
        performanceReportObj = new PerformanceReportsPage(driver);
        performanceReportObj.searchWithoutYear();
        Thread.sleep(2000);
        Assert.assertEquals(performanceReportObj.alertText, "Please select mandatory field");
    }
}
