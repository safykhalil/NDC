package TestcasesSS;

import Pages.DashboardPage;
import TestPackage.BasePage.TCBase;
import com.shaft.validation.Validations;
import logintest.importPNRtest;
import logintest.testLogin;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//test
public class PNRtestcase extends TCBase {

    testLogin loginObj;
    DashboardPage dashObj;
    importPNRtest PnrObj;
    String pnr = "";

    @BeforeTest
    public void beforeTest() throws InterruptedException {
        loginObj = new testLogin(driver);
        loginObj.loginWithValidData();
        dashObj = new DashboardPage(driver);
        dashObj.openImportPnr();

    }

    @Test
    public void importWithValidData() throws InterruptedException {
        PnrObj = new importPNRtest(driver);
        Thread.sleep(2000);
        PnrObj.enterPnr("pnr");
        PnrObj.selectSupplier("Galileo");
        PnrObj.selectBranch("Mansoura");
        PnrObj.submitButton();
        Thread.sleep(1000);
        PnrObj.actualResult = driver.element().getText(PnrObj.actual);
        Validations.assertThat().object(PnrObj.actualResult).isEqualTo(PnrObj.expectedResult).perform();
    }

    //Assertion Message select branch
    @Test
    public void assertMessage() throws InterruptedException {
        PnrObj = new importPNRtest(driver);
        dashObj.openImportPnr();
        PnrObj.enterPnr("pnr");
        PnrObj.selectSupplier("Galileo");
        PnrObj.submitButton();
        Validations.verifyThat().element(By.xpath("//*[@id=\"importPnrSearchForm\"]/div[3]/div[1]/div[3]/div[1]/div")).exists().perform();
    }

    //Assertion search with Empty PNR
    @Test
    public void pnr() throws InterruptedException {
        PnrObj = new importPNRtest(driver);
        dashObj.openImportPnr();
        PnrObj.enterPnr(pnr);
        PnrObj.submitButton();
        Assert.assertEquals(pnr.length(), 0);
    }



    @Test
    public void GLive() throws InterruptedException {
        PnrObj = new importPNRtest(driver);
        dashObj.openImportPnr();
        PnrObj.enterPnr("pnr");
        PnrObj.selectSupplier("Galileo");
        Validations.verifyThat().element(By.xpath("//*[@id=\"select-pcc-button\"]/span[2]\n")).exists().perform();
    }


    //Assertion pnr already exist
    @Test
    public void searchWithExistPnr() throws InterruptedException {
        PnrObj = new importPNRtest(driver);
        dashObj.openImportPnr();
        PnrObj.enterPnr("N4R3UU");
        PnrObj.selectSupplier("Amadeus");
        PnrObj.selectBranch("Alexandria");
        PnrObj.submitButton();
        Validations.verifyThat().element(By.xpath("//*[@id=\"new-passenger-details-wrap\"]/div/div/div[5]/div")).exists().perform();
    }

}