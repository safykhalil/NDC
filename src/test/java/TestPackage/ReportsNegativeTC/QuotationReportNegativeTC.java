package TestPackage.ReportsNegativeTC;

import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.Reports.QuotationReportsPage;
import TestPackage.BasePage.TCBase;
import com.shaft.validation.Validations;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class QuotationReportNegativeTC extends TCBase {
    LoginPage loginObj;
    DashboardPage dashObj;
    QuotationReportsPage quotationreportObj;

    @BeforeTest
    public void openReportsPage() throws InterruptedException {
        loginObj = new LoginPage(driver);
        loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
        dashObj = new DashboardPage(driver);
    }
    @Test
    public void searchWithoutBranch() throws InterruptedException {
        dashObj.openReportsPage();
        quotationreportObj = new QuotationReportsPage(driver);
        quotationreportObj.openQuotationReportsPage();
        quotationreportObj.searchWitNoBranch();
        Thread.sleep(1000);
        driver.assertThat().element(quotationreportObj.table).isHidden();
        Thread.sleep(1000);
        Assert.assertEquals(quotationreportObj.alertText, "Please select branch name");
    }
    @Test
    public void searchWithoutAgency()throws InterruptedException{
        dashObj.openReportsPage();
        quotationreportObj = new QuotationReportsPage(driver);
        quotationreportObj.openQuotationReportsPage();
        quotationreportObj.searchWithNoAgency();
        Thread.sleep(1000);
        driver.assertThat().element(quotationreportObj.table).isHidden();
        Assert.assertEquals(quotationreportObj.alertText, "Please select agency name");
    }
    @Test
    public void searchWithInvalidQuoteNumber()throws InterruptedException{
        dashObj.openReportsPage();
        quotationreportObj = new QuotationReportsPage(driver);
        quotationreportObj.openQuotationReportsPage();
        quotationreportObj.searchWithInvalidNumber();
        Thread.sleep(1000);
        driver.assertThat().element(quotationreportObj.table).isHidden();
        driver.assertThat().element(quotationreportObj.noResultsMsg).isVisible();
    }
    @Test
    public void searchWithInvalidClientName() throws InterruptedException {
        dashObj.openReportsPage();
        quotationreportObj = new QuotationReportsPage(driver);
        quotationreportObj.openQuotationReportsPage();
        quotationreportObj.searchWithInvalidName();
        Thread.sleep(1000);
        driver.assertThat().element(quotationreportObj.table).isHidden();
        driver.assertThat().element(quotationreportObj.noResultsMsg).isVisible();
    }
    @Test
    public void searchWithInvalidEmailID() throws InterruptedException{
        dashObj.openReportsPage();
        quotationreportObj = new QuotationReportsPage(driver);
        quotationreportObj.openQuotationReportsPage();
        quotationreportObj.searchWithInvalidEmail();
        Thread.sleep(1000);
        Validations.verifyThat().element(driver.getDriver(), quotationreportObj.noResultsMsg).exists().perform();
    }
}
