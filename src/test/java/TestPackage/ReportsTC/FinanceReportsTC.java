package TestPackage.ReportsTC;


import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.Reports.FinanceReportsPage;
import TestPackage.BasePage.TCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.text.ParseException;

public class FinanceReportsTC extends TCBase {
    LoginPage loginObj ;
    DashboardPage dashObj;
    FinanceReportsPage financeReportsObj;
    @BeforeTest
    public void beforeTest()throws InterruptedException{
        loginObj = new LoginPage(driver);
        loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openReportsPage();
    }
    @Test
    public void searchInFinanceReportsWithValidData() throws InterruptedException, ParseException {
        financeReportsObj = new FinanceReportsPage(driver);
        financeReportsObj.financeReportsSearch();
        financeReportsObj.exportToExcelBtn();
        Assert.assertEquals(driver.element().getAttribute(financeReportsObj.exportBtn,"disabled"),"true");
        driver.assertThat().element(financeReportsObj.tableOfResults).isVisible();
        driver.assertThat().element(financeReportsObj.exportBtn).isVisible();
        Assert.assertTrue(financeReportsObj.checkDatesInTable());
    }
}