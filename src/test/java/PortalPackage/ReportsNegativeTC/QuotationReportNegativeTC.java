package PortalPackage.ReportsNegativeTC;

import Portal.ReportsPages.QuotationReport;
import PortalPackage.Base.PortalTCBase;
import Portal.PortalLoginPage;
import Portal.ReportsPages.StatementReport;
import com.shaft.validation.Validations;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.text.ParseException;
import org.testng.asserts.SoftAssert;

public class QuotationReportNegativeTC extends PortalTCBase {
    PortalLoginPage logObj;
    QuotationReport quotObj;

    @BeforeTest
    public void openReportsPage() throws InterruptedException {
        logObj = new PortalLoginPage(driver);
        quotObj = new QuotationReport(driver);
        logObj.PortalLoginWithValidData();
    }
    @Test
    public void searchWithNoData(){
        quotObj = new QuotationReport(driver);
        quotObj.searchWithoutData();
        Validations.verifyThat().element(driver.getDriver(), quotObj.provideDataMsg).exists().perform();
    }
    @Test
    public void searchWithInvalidQuotNo(){
        quotObj = new QuotationReport(driver);
        quotObj.searchWithInvalidQuotNo();
        Validations.verifyThat().element(driver.getDriver(), quotObj.noResultMsg).exists().perform();
    }
    @Test
    public void searchWithInvalidName(){
        quotObj = new QuotationReport(driver);
        quotObj.searchWithInvalidName();
        Validations.verifyThat().element(driver.getDriver(), quotObj.noResultMsg).exists().perform();
    }
    @Test
    public void searchWithInvalidEmailID(){
        quotObj = new QuotationReport(driver);
        quotObj.searchWithInvalidEmail();
        Validations.verifyThat().element(driver.getDriver(), quotObj.noResultMsg).exists().perform();
    }
    @Test
    public void searchWithInvalidCompanyName(){
        quotObj = new QuotationReport(driver);
        quotObj.searchWithInvalidCompany();
        Validations.verifyThat().element(driver.getDriver(), quotObj.noResultMsg).exists().perform();
    }


}
