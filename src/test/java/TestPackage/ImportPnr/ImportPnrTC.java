package TestPackage.ImportPnr;

import Pages.DashboardPage;
import Pages.ImportPnr.ImportPnrPage;
import Pages.Login.LoginPage;
import TestPackage.BasePage.TCBase;
import com.shaft.driver.SHAFT;
import org.testng.annotations.Test;

import java.util.Objects;


public class ImportPnrTC extends TCBase {

    LoginPage loginobj;
    DashboardPage dashObj;
    SHAFT.TestData.JSON importPnrData;

    @Test

    public void testImportPnr() throws InterruptedException {
        importPnrData = new SHAFT.TestData.JSON(System.getProperty("testDataFolderPath") + "importPnrdata.json");
        loginobj = new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openImportPnr();
        ImportPnrPage importPnrPage = new ImportPnrPage(driver);
        importPnrPage.enterThePnr(importPnrData.getTestData("Pnr"));
        importPnrPage.selectTheSupplier(importPnrData.getTestData("SuppName"));
        importPnrPage.selectTheBranch(importPnrData.getTestData("BranchName"));
        importPnrPage.selectTheAgency(importPnrData.getTestData("AgencyName"));
        importPnrPage.selectTheAgent(importPnrData.getTestData("AgentName"));
        if (Objects.equals(importPnrData.getTestData("SuppName"), "Galileo")) {
            importPnrPage.selectThePcc(importPnrData.getTestData("Pcc"));
        }
        importPnrPage.clickSubmit();
        importPnrPage.selectTheFlight();
        importPnrPage.payTheTicket1();
        importPnrPage.payTheTicket2();
        Thread.sleep(20000);
    }

}


