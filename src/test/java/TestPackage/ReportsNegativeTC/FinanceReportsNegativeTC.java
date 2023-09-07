package TestPackage.ReportsNegativeTC;

import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.Reports.FinanceReportsPage;
import TestPackage.BasePage.TCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FinanceReportsNegativeTC extends TCBase {
    LoginPage loginObj;
    DashboardPage dashObj;
    FinanceReportsPage financeReportsObj;
    @BeforeTest
    public void beforeTest()throws InterruptedException{
        loginObj = new LoginPage(driver);
        loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
        dashObj = new DashboardPage(driver);
    }
    @Test
    public void searchWithNoBranch() throws InterruptedException{
        dashObj.openReportsPage();
        financeReportsObj = new FinanceReportsPage(driver);
        financeReportsObj.searchWithoutBranch();
        Assert.assertEquals(financeReportsObj.alertText,"Please select branch name");
        Thread.sleep(2000);
    }
    @Test
    public void searchWithNoDate() throws InterruptedException{
        dashObj.openReportsPage();
        financeReportsObj = new FinanceReportsPage(driver);
        financeReportsObj.searchWithoutDate();
        Assert.assertEquals(financeReportsObj.alertText,"Please select mandatory fields From Booking Date and To Booking Date");
        Thread.sleep(2000);
    }
    @Test
    public void searchWithPeriodMoreThan60Days()throws InterruptedException{
        dashObj.openReportsPage();
        financeReportsObj = new FinanceReportsPage(driver);
        financeReportsObj.searchWithDatePeriodMoreThen60();
        Assert.assertEquals(financeReportsObj.alertText,"Booking From and Booking To Dates Difference should not be greater than 60 Days");
        Thread.sleep(2000);
    }
}