package TestPackage.ReportsTC;

import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.Reports.PerformanceReportsPage;
import TestPackage.BasePage.TCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PerformanceReportsTC extends TCBase {
    LoginPage loginObj;
    DashboardPage dashboardObj;
    PerformanceReportsPage performanceReportObj;
    @BeforeTest
    public void openReportsPage()throws InterruptedException{
        loginObj = new LoginPage(driver);
        loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
        dashboardObj = new DashboardPage(driver);
        dashboardObj.openReportsPage();
    }
    @Test
    public void searchWithValidDate() throws InterruptedException{
        performanceReportObj = new PerformanceReportsPage(driver);
        performanceReportObj.searchWithValidData();
        Thread.sleep(2000);
        performanceReportObj.checkBranchNameResults();
    }
}
