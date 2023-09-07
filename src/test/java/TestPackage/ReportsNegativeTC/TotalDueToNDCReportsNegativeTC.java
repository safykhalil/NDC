package TestPackage.ReportsNegativeTC;

import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.Reports.TotalDueToNDCReportPage;
import TestPackage.BasePage.TCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TotalDueToNDCReportsNegativeTC extends TCBase {
    LoginPage loginObj;
    DashboardPage dashObj;
    TotalDueToNDCReportPage totalDueToNDCObj;
    @BeforeTest
    public void openReportPage() throws InterruptedException{
        loginObj = new LoginPage(driver);
        loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
        dashObj = new DashboardPage(driver);

    }
    @Test
    public void searchWithoutBranch() throws InterruptedException{
        dashObj.openReportsPage();
        totalDueToNDCObj = new TotalDueToNDCReportPage(driver);
        totalDueToNDCObj.searchWithNoBranchSelected();
        Thread.sleep(1000);
        Assert.assertEquals(totalDueToNDCObj.alertText, "Please select branch name");
    }
    @Test
    public void searchWithoutProductType() throws InterruptedException{
        dashObj.openReportsPage();
        totalDueToNDCObj = new TotalDueToNDCReportPage(driver);
        totalDueToNDCObj.searchWithNoProductType();
        Thread.sleep(1000);
        Assert.assertEquals(totalDueToNDCObj.alertText, "Please select product type");
    }
    @Test
    public void searchWithoutDates() throws InterruptedException{
        dashObj.openReportsPage();
        totalDueToNDCObj = new TotalDueToNDCReportPage(driver);
        totalDueToNDCObj.searchWithNoDates();
        Thread.sleep(1000);
        Assert.assertEquals(totalDueToNDCObj.alertText, "Please Select Invoice Date From");
    }
    @Test
    public void searchWithMoreThan60Days() throws InterruptedException{
        dashObj.openReportsPage();
        totalDueToNDCObj = new TotalDueToNDCReportPage(driver);
        totalDueToNDCObj.searchWithDaysMoreThan60();
        Thread.sleep(1000);
        Assert.assertEquals(totalDueToNDCObj.alertText, "Invoice From and Invoice To Dates Difference should not be greater than 60 Days");
    }

}
