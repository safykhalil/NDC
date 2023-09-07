package PortalPackage.ReportsTC;

import Portal.PortalLoginPage;
import Portal.ReportsPages.QuotationReport;
import Portal.ReportsPages.StatementReport;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.text.ParseException;
import org.testng.asserts.SoftAssert;
import PortalPackage.Base.PortalTCBase;

public class QuotationReportTC extends PortalTCBase {
    SoftAssert softAssert = new SoftAssert();
    PortalLoginPage logObj;
    QuotationReport quotObj;

    @BeforeTest
    public void openReportsPage() throws InterruptedException {
        logObj = new PortalLoginPage(driver);
        logObj.PortalLoginWithValidData();
    }
    @Test
    public void searchWithValidCredentials() throws InterruptedException {
        quotObj = new QuotationReport(driver);
        quotObj.checkSearchWithValidData();
        Thread.sleep(3000);
        Validations.verifyThat().element(driver.getDriver(), quotObj.searchTable).exists().perform();
    }

    @Test
    public void checkRetrievedDataFromTable() {
        quotObj = new QuotationReport(driver);
        quotObj.checkSearchWithValidQuotNo();
        softAssert.assertTrue(quotObj.identicalData, "Retrieved Data Are Not As The Provided Data!");
        quotObj.checkSearchWithValidEmail();
        softAssert.assertTrue(quotObj.identicalData, "Retrieved Data Are Not As The Provided Data!");
        quotObj.checkSearchWithValidName();
        softAssert.assertTrue(quotObj.identicalData, "Retrieved Data Are Not As The Provided Data!");
        softAssert.assertAll();
    }

}
