package TestPackage.ReportsNegativeTC;

import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.Reports.StatementReportsPage;
import TestPackage.BasePage.TCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class StatementReportsNegativeTC extends TCBase {
    LoginPage loginObj;
    DashboardPage dashObj;
    StatementReportsPage statementreportsObj;

    @BeforeTest
    public void OpenReportsPage() throws InterruptedException {
        loginObj = new LoginPage(driver);
        loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
        dashObj = new DashboardPage(driver);
    }
    @Test
    public void searchInStatementReportsWithNoBranch() throws InterruptedException{
        dashObj.openReportsPage();
        statementreportsObj = new StatementReportsPage(driver);
        statementreportsObj.searchWithoutBranch();
        Assert.assertEquals(statementreportsObj.alertText, "Please select branch name");
        Thread.sleep(5000);
    }
    @Test
    public void searchInStatementReportsWithNoDate() throws InterruptedException{
        dashObj.openReportsPage();
        statementreportsObj = new StatementReportsPage(driver);
        statementreportsObj.searchWithoutDates();
        Assert.assertEquals(statementreportsObj.alertText, "Please select Invoice From Date");
        Thread.sleep(5000);
    }
    @Test
    public void searchWithDatesMoreThan60Days() throws InterruptedException{
        dashObj.openReportsPage();
        statementreportsObj = new StatementReportsPage(driver);
        statementreportsObj.searchWithDatePeriodMoreThen60();
        Assert.assertEquals(statementreportsObj.alertText, "Invoice From and Invoice To Dates Difference should not be greater than 60 Days");
        Thread.sleep(5000);
    }
}