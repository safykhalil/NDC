package PortalPackage.ReportsTC;
import Portal.PortalLoginPage;
import Portal.ReportsPages.TotalDueToNDCPage;
import PortalPackage.Base.PortalTCBase;
import com.shaft.validation.Validations;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.text.ParseException;

public class TotalDueToNdcTC extends PortalTCBase {
    PortalLoginPage loginObj;
    TotalDueToNDCPage totalDueToNDCObj;

    @BeforeTest
    public void beforeTest() throws InterruptedException {
        loginObj = new PortalLoginPage(driver);
        loginObj.PortalLoginWithValidData();
        totalDueToNDCObj = new TotalDueToNDCPage(driver);
    }

    @Test
    public void searchInTotalDueToNdcWithMandatoryData() throws ParseException {
        totalDueToNDCObj.openReportPage();
        totalDueToNDCObj.searchInTotalDueToNdcWithMandatoryData();
        Validations.verifyThat().element(driver.getDriver(), totalDueToNDCObj.tableOfResults).exists().perform();
        Assert.assertTrue(totalDueToNDCObj.checkDatesInTable());
        Assert.assertTrue(totalDueToNDCObj.identicalData);
    }
    @Test
    public void searchInTotalDueToNdcWithRetailCustomerType() throws ParseException {
        totalDueToNDCObj.openReportPage();
        totalDueToNDCObj.searchInTotalDueToNdcWithRetailCustomerType();
        Validations.verifyThat().element(driver.getDriver(), totalDueToNDCObj.tableOfResults).exists().perform();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(totalDueToNDCObj.checkDatesInTable());
        softAssert.assertTrue(totalDueToNDCObj.identicalData);
        softAssert.assertTrue(totalDueToNDCObj.identicalData);
        softAssert.assertAll();
    }
    @Test
    public void searchInTotalDueToNdcWithValidInvoiceNumber(){
        totalDueToNDCObj.openReportPage();
        totalDueToNDCObj.searchInTotalDueToNdcWithValidInvoiceNumber();
        Validations.verifyThat().element(driver.getDriver(), totalDueToNDCObj.tableOfResults).exists().perform();
        Assert.assertTrue(totalDueToNDCObj.identicalData);
    }
    @Test
    public void searchInTotalDueToNdcWithValidCustomerName(){
        totalDueToNDCObj.openReportPage();
        totalDueToNDCObj.searchInTotalDueToNdcWithValidCustomerName();
        Validations.verifyThat().element(driver.getDriver(), totalDueToNDCObj.tableOfResults).exists().perform();
        Assert.assertTrue(totalDueToNDCObj.identicalData);
    }
    @Test
    public void searchInTotalDueToNdcWithValidBookingReference(){
        totalDueToNDCObj.openReportPage();
        totalDueToNDCObj.searchInTotalDueToNdcWithValidBookingReference();
        Validations.verifyThat().element(driver.getDriver(), totalDueToNDCObj.tableOfResults).exists().perform();
        Assert.assertTrue(totalDueToNDCObj.identicalData);
    }
}
