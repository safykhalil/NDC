package TestPackage.ReportsNegativeTC;
import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.Reports.SalesReportsPage;
import TestPackage.BasePage.TCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SalesReportsNegativeTC extends TCBase {
    LoginPage loginObj;
    DashboardPage dashObj;
    SalesReportsPage salesReportsObj;
    @BeforeTest
    public void openReportsPage() throws InterruptedException{
        loginObj = new LoginPage(driver);
        loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
        dashObj = new DashboardPage(driver);
    }
    @Test
    public void searchWithEmptyBranchName() {
        dashObj.openReportsPage();
        salesReportsObj = new SalesReportsPage(driver);
        salesReportsObj.openReleasedPnrReport();
        salesReportsObj.searchWithEmptyBranch();
        Assert.assertEquals(salesReportsObj.alertText,"Please select branch name");
    }
    @Test
    public void searchWithEmptyProductType() {
        dashObj.openReportsPage();
        salesReportsObj = new SalesReportsPage(driver);
        salesReportsObj.openReleasedPnrReport();
        salesReportsObj.searchWithEmptyProductType();
        Assert.assertEquals(salesReportsObj.alertText,"Please select product type");
    }
    @Test
    public void searchWithEmptyFromDate() {
        dashObj.openReportsPage();
        salesReportsObj = new SalesReportsPage(driver);
        salesReportsObj.openReleasedPnrReport();
        salesReportsObj.searchWithEmptyFromDate();
        Assert.assertEquals(salesReportsObj.alertText,"Please Select Either Invoice From Date and Invoice To Date (or) Payment Date Along with ProductType");
    }
    @Test
    public void searchWithEmptyToDate() {
        dashObj.openReportsPage();
        salesReportsObj = new SalesReportsPage(driver);
        salesReportsObj.openReleasedPnrReport();
        salesReportsObj.searchWithEmptyToDate();
        Assert.assertEquals(salesReportsObj.alertText,"Please select Invoice To Date");
    }
    @Test
    public void searchWithDatePeriodMoreThen60() {
        dashObj.openReportsPage();
        salesReportsObj = new SalesReportsPage(driver);
        salesReportsObj.openReleasedPnrReport();
        salesReportsObj.searchWithDatePeriodMoreThen60();
        Assert.assertEquals(salesReportsObj.alertText,"Invoice From and Invoice To Dates Difference should not be greater than 60 Days");
    }
}
