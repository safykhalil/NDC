package TestPackage.ReportsTC;

import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.Reports.AgencyWalletReportsPage;
import Pages.Reports.FinanceReportsPage;
import TestPackage.BasePage.TCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class AgencyWalletReportsTC extends TCBase {
    LoginPage loginObj ;
    DashboardPage dashObj;
    AgencyWalletReportsPage agencyWalletReportsObj;
    @BeforeTest
    public void beforeTest()throws InterruptedException{
        loginObj = new LoginPage(driver);
        loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openReportsPage();
    }
    @Test
    public void searchInFinanceReportsWithValidData() throws InterruptedException {
        agencyWalletReportsObj = new AgencyWalletReportsPage(driver);
        agencyWalletReportsObj.agencyWalletReportsSearch();
        Thread.sleep(10000);
        agencyWalletReportsObj.exportToExcelBtn();
        Thread.sleep(2000 );
        driver.assertThat().element(agencyWalletReportsObj.tableOfResults).isVisible();
        driver.assertThat().element(agencyWalletReportsObj.exportBtn).isVisible();
    }
}
