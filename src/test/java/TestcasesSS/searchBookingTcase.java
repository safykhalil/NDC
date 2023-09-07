package TestcasesSS;

import Pages.DashboardPage;
import TestPackage.BasePage.TCBase;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import jdk.jfr.Description;
import logintest.searchBookingPage;
import logintest.testLogin;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class searchBookingTcase extends TCBase {

    testLogin loginObj2;
    DashboardPage dashObj2;
    searchBookingPage bookingObj;

    String orderId = "BRN93MOAORD73";
    String alertMassageText = "Please select a single branch to be able to search";
    String validationYear = "plaese choose valid date between one year";
    String ticketNumber = "3812403486102 ";
    String clientName1 = "Oprah Conway";

    @BeforeTest
    public void beforeTest() throws InterruptedException {
        loginObj2 = new testLogin(driver);
        loginObj2.loginWithValidData();
        dashObj2 = new DashboardPage(driver);
        dashObj2.openSearchBookingPage();
    }

    @Test
    public void searchWithValidDataUsingSpecificBranchOnly() throws InterruptedException {
        bookingObj = new searchBookingPage(driver);
        dashObj2.openSearchBookingPage();
        bookingObj.searchWithSpecificBranch();
        Validations.verifyThat().element(bookingObj.tableResult).exists().perform();
        // Thread.sleep(1000);
        Validations.verifyThat().object(bookingObj.identicalData).isTrue().perform();
        Thread.sleep(1000);
    }

    @Test
    public void searchAboutOrderIdSelectingAllBranches() throws InterruptedException {
        bookingObj = new searchBookingPage(driver);
        dashObj2.openSearchBookingPage();
        bookingObj.searchWithOrderId(orderId);
        bookingObj.searchButton();
        driver.element().assertThat(bookingObj.orderId1).text().isEqualTo(orderId).perform();
        Thread.sleep(3000);
    }

    @Test
    public void searchWithALLBranchesAndValidateAlertMassageExist() throws InterruptedException {
        bookingObj = new searchBookingPage(driver);
        dashObj2.openSearchBookingPage();
        bookingObj.searchButton();
        bookingObj.alertAccept();
        Thread.sleep(3000);
        Assert.assertEquals(bookingObj.alertText, alertMassageText);
    }


    @Test
    public void searchWithBranchAndSelectDate() throws InterruptedException {
        bookingObj = new searchBookingPage(driver);
        dashObj2.openSearchBookingPage();
        bookingObj.searchWithSpecificBranchAndSelectDate();
        bookingObj.searchButton();
        Validations.verifyThat().element(bookingObj.tableResult).exists().perform();
        Thread.sleep(3000);
    }

    @Test
    public void searchWithDateOlderDateThanOneYear() throws InterruptedException {
        bookingObj = new searchBookingPage(driver);
        dashObj2.openSearchBookingPage();
        bookingObj.validateYearMassageDisplayed();
        bookingObj.searchButton();
        Thread.sleep(2000);
        driver.element().assertThat(bookingObj.textOneYear).text().contains(validationYear).perform();
        Thread.sleep(3000);

    }

    @Test
    public void searchAboutTicketNoSelectingOneBranch() throws InterruptedException {
        bookingObj = new searchBookingPage(driver);
        dashObj2.openSearchBookingPage();
        bookingObj.searchWithTicketNo(ticketNumber);
        bookingObj.searchButton();
        Thread.sleep(3000);
        driver.element().assertThat(bookingObj.clientNameTable).text().contains(clientName1).perform();
    }

    @Test
    @Description("Verify searching with date")
    public void searchWithValidDataUsingSpecificBranchOnlyAndSelectFlightDate() throws InterruptedException {
        bookingObj = new searchBookingPage(driver);
        dashObj2.openSearchBookingPage();
        bookingObj.searchWithValidDataUsingFlightDate();
        bookingObj.searchButton();
//        if (driver.element().isElementDisplayed(bookingObj.tableResult)) {
//            successfulSearchUsingDate();
//        } else {
//            failedSearchUsingDate();
//
//        }
        if (isElementPresent(bookingObj.tableResult)) {
            successfulSearchUsingDate();
        } else {
            failedSearchUsingDate();
        }
    }

    @Step("Failed to search with using date ")
    public void failedSearchUsingDate() {
        System.out.println("Failed To Search Using Date");
    }

    @Step("Results are displayed correctly ")
    public void successfulSearchUsingDate() {
        System.out.println("Results are displayed correctly");
    }

    //search with Branch And Valid pnr And Invalid TicketNo
    @Test
    public void SearchWithEnterInValidTicketNumber() throws InterruptedException {
        bookingObj = new searchBookingPage(driver);
        dashObj2.openSearchBookingPage();
        bookingObj.SearchWithEnterInValidTicketNo("SM14643D23828P ", "381240348610");
        bookingObj.searchButton();
        Thread.sleep(3000);
        driver.element().assertThat(bookingObj.notFound).text().contains("No Data Found").perform();
    }

    //searching With select branch,enter valid pnr,ticketNo ,BookingReference
    //validate client Name Oprah Conway
    @Test
   // @Description("Verify Client Name is true")
    public void searchWithBookingReference() throws InterruptedException {
        bookingObj = new searchBookingPage(driver);
        dashObj2.openSearchBookingPage();
        bookingObj.searchWithBookingReference();
        bookingObj.searchButton();
       driver.element().assertThat(bookingObj.tableResult).text().contains("Oprah Conway").perform();
//        if (driver.element().getText(bookingObj.tableResult).contains("Oprah Conway")) {
//            successfulFindClientName();
//        } else {
//            failedToFindName();
//        }
//    }
//        @Step("failed to find client Name")
//        public void failedToFindName () {
//            System.out.println("another client Name ");
//        }
//        @Step("Results are displayed correctly")
//        public void successfulFindClientName() {
//            System.out.println("client Name Is correctly");
        }


    }



