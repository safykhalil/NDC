package TestPackage.BookinMidOffice.ManualInvoice;

import Pages.BookingMidOffice.ManualInvoice.AddManualInvoicePage;
import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.BookingMidOffice.SearchBooking.SearchBookingPage;
import TestPackage.BasePage.TCBase;
import com.shaft.driver.SHAFT;
import org.testng.annotations.Test;

public class AddManualInvoiceTC extends TCBase {

    LoginPage loginObj;
    DashboardPage dashObj;
    AddManualInvoicePage manualObj;
    SHAFT.TestData.JSON manualData;




    @Test()
    public void addManualWithValidCriteriaUsingDDT() throws InterruptedException {
        manualData = new SHAFT.TestData.JSON(System.getProperty("testDataFolderPath") + "manualinvoicedata.json");
        loginObj = new LoginPage(driver);
        loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openManualInvoicePage();
        manualObj = new AddManualInvoicePage(driver);
        manualObj.addManualInvoiceWithValidCriteriaToAgency(manualData.getTestData("branchName"),
                manualData.getTestData("agencyName"), manualData.getTestData("staffName"), manualData.getTestData("source"), manualData.getTestData("destination"), manualData.getTestData("airLine")
                , manualData.getTestData("base"), manualData.getTestData("taxes"),
                manualData.getTestData("markup"), manualData.getTestData("serviceCharge"), manualData.getTestData("discount"), manualData.getTestData("GdsPnr"), manualData.getTestData("airLinePnr"),
                manualData.getTestData("flightNo"), manualData.getTestData("title"), manualData.getTestData("firstName"), manualData.getTestData("LastName"), manualData.getTestData("countryCode"),
                manualData.getTestData("passMobile"), manualData.getTestData("gender"), manualData.getTestData("passport"), manualData.getTestData("nationality"), manualData.getTestData("ticketNO"));

    }



}


