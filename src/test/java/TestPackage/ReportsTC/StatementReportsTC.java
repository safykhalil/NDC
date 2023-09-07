package TestPackage.ReportsTC;

import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.Reports.StatementReportsPage;
import TestPackage.BasePage.TCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.ParseException;

public class StatementReportsTC extends TCBase {
        LoginPage loginObj;
        DashboardPage dashObj;
        StatementReportsPage statementreportsObj;

        @BeforeTest
        public void OpenReportsPage() throws InterruptedException {
            loginObj = new LoginPage(driver);
            loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
            dashObj = new DashboardPage(driver);
            dashObj.openReportsPage();
        }

        @Test
        public void searchInStatementReportsWithValidData() throws InterruptedException, ParseException {
            statementreportsObj = new StatementReportsPage(driver);
            statementreportsObj.StatementReportsSearch();
            statementreportsObj.exportToExcelBtn();
            driver.assertThat().element(statementreportsObj.tableOfResults).isVisible();
            driver.assertThat().element(statementreportsObj.exportBtn).isVisible();
            driver.assertThat().element(statementreportsObj.exportBtn).isEnabled();
            Assert.assertTrue(statementreportsObj.checkDatesOfIssuesInTable());
        }
    }