package TestPackage.ReportsTC;
import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.Reports.SalesReportsPage;
import TestPackage.BasePage.TCBase;
import junit.framework.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SalesReportsTC extends TCBase {
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
    public void searchWithValidData() {
        dashObj.openReportsPage();
        salesReportsObj = new SalesReportsPage(driver);
        salesReportsObj.openReleasedPnrReport();
        salesReportsObj.searchWithValidData();
        Assert.assertEquals(salesReportsObj.errTxt,"Search Result Not Found");

    }
}
