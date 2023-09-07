package TestPackage.ReportsNegativeTC;

import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.Reports.AgencyWalletReportsPage;
import TestPackage.BasePage.TCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AgencyWalletReportsNeagtiveTC extends TCBase {
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
    @Test (priority = 1)
    public void searchInFinanceReportsWithEmptyCurrency() throws InterruptedException {
        dashObj.openReportsPage();
        agencyWalletReportsObj = new AgencyWalletReportsPage(driver);
        agencyWalletReportsObj.SearchWithEmptyCurrency();
        Assert.assertEquals(driver.getDriver().getCurrentUrl(),"http://192.168.1.50:8080/odeysysadmin/Reports/agencyWalletReport?menu=reports");
    }
    @Test (priority = 2)
    public void searchInFinanceReportsWithEmptyBranch() throws InterruptedException {
        dashObj.openReportsPage();
        agencyWalletReportsObj = new AgencyWalletReportsPage(driver);
        agencyWalletReportsObj.SearchWithEmptyBranchField();
        Assert.assertEquals(agencyWalletReportsObj.alertText,"Please select branch name");
    }
}
