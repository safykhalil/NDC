package TestPackage.ReportsNegativeTC;
import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.Reports.ReleasedPNRReportsPage;
import TestPackage.BasePage.TCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReleasedPnrNegativeTC extends TCBase {
    LoginPage loginObj ;
    DashboardPage dashObj;
    ReleasedPNRReportsPage releasedPnrObj;

    @BeforeTest
    public void beforeTest()throws InterruptedException{
        loginObj = new LoginPage(driver);
        loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
        dashObj = new DashboardPage(driver);
    }
    @Test
    public void searchWithEmptyData(){
        dashObj.openReportsPage();
        releasedPnrObj = new ReleasedPNRReportsPage(driver);
        releasedPnrObj.openReleasedPnrReport();
        releasedPnrObj.searchWithEmptyData();
        Assert.assertEquals(releasedPnrObj.alertText,"Please Select Released. PNR From Date and Released. PNR To Date");
    }
    @Test
    public void searchWithInValidOrderID(){
        dashObj.openReportsPage();
        releasedPnrObj = new ReleasedPNRReportsPage(driver);
        releasedPnrObj.openReleasedPnrReport();
        releasedPnrObj.searchWithInvalidOrderID();
        Assert.assertEquals(driver.element().getText(releasedPnrObj.noResMsg),"Search Result Not Found");
    }
    // Invalid date range > 60 days
    @Test
    public void searchWithInvalidDateRange() throws InterruptedException {
        dashObj.openReportsPage();
        releasedPnrObj = new ReleasedPNRReportsPage(driver);
        releasedPnrObj.openReleasedPnrReport();
        releasedPnrObj.searchWithDatePeriodMoreThen60();
        Assert.assertEquals(releasedPnrObj.alertText,"Invoice From and Invoice To Dates Difference should not be greater than 60 Days");

    }
}
