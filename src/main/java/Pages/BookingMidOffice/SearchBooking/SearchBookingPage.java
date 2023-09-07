package Pages.BookingMidOffice.SearchBooking;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SearchBookingPage extends BasePage {
    public SearchBookingPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By branchList = By.xpath("(//*[@id=\"mutti_select\"]/div)[1]"); // select branch or more
    By optionAllBranches = By.xpath("/html/body/div[1]/section/div/div/div/div/div[2]/form[1]/div/div[1]/div/div/div/div/div[1]/div[1]/div[1]/div/div/div/ul/li[1]/label/input"); //click on it
    By agencyList = By.xpath("(//*[@id=\"mutti_select\"]/div)[2]"); // click on it
    By optionAllAgencies = By.xpath("/html/body/div[1]/section/div/div/div/div/div[2]/form[1]/div/div[1]/div/div/div/div/div[1]/div[1]/div[2]/div/div/div/ul/li[1]/label/input"); // click on it
    By clientName = By.name("clientName"); // fill it with client name
    By invoiceNo = By.name("invoiceNo"); // fill it with invoice no data
    By orderId = By.name("orderId"); // fill it with orderId data
    By bookingReference = By.xpath("//*[@id=\"region_content\"]/div/div[2]/div[2]/input"); // fill it with NDC Reference data
    By plusOption = By.xpath("/html/body/div[1]/section/div/div/div/div/div[2]/form[1]/div/div[1]/div/div/div/div/div[6]/div[1]/div[1]/h4/span"); //click on it
    By pnrField = By.id("airlinePNR"); // fill it with pnr data
    By ticketField = By.id("ticketNo"); // fill it with ticket data
    By searchBttn = By.xpath("/html/body/div[1]/section/div/div/div/div/div[2]/form[1]/div/div[1]/div/div/div/div/div[6]/div[2]/input[1]"); //click on it
    By resultTable = By.id("air_tb");  // grid displayed after pressing on search button , assert on it
    By orderIdHyperText = By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[2]/a"); // order  id click on it to view details of booking
    By clientPageDetails = By.id("method-wrap"); // assert on it after pressing on order id is displayed
    By lockIcon = By.xpath("//*[@id=\"searchBookingId\"]/h4/a"); // press on it to take lock of this booking
    By takeControlBttn = By.xpath("//*[@id=\"unlocked-modal\"]/div/div/div[3]/button[1]"); // to take control of a specific booking
    By itinerary = By.xpath("//*[@id=\"itenaryTab\"]"); // list select from it itinerary
    By viewPaxDetails = By.xpath("//*[@id=\"itenary\"]/div[3]/div[1]/div[2]/div[4]/a"); // click on it to cancel
    By passengerCheckBox = By.xpath("//*[@id=\"DataTables_Table_1\"]/tbody/tr/td[1]/label"); // click on it as select passenger
    By voidAndCancelBttn = By.xpath("//*[@id=\"button_can\"]/a"); // click on it to cancel booking
    By okBttn = By.xpath("//*[@id=\"succes-msg\"]/div/div/div[3]/button"); // click on it after void-cancel
    By releaseBttn = By.xpath("//*[@id=\"itenary\"]/div[3]/div[1]/div[2]/div[2]/input"); //release pnr button to complete the cancellation cycle
    By confirmBttn = By.cssSelector("#releasePnrConfirm > div > div > div.modal-footer > div > a:nth-child(1)"); // alert displayed after pressing on release pnr button
    By okAfterRelease = By.cssSelector("#releasePNRLoader > div > div > div.modal-footer > button"); // ok button on confirmation message on alert displayed after pressing on release button
    By successMssgAfterRelease = By.xpath("//*[@id=\"releasePNRLoader\"]/div/div");
    By listOfBookingStatus = By.xpath("/html/body/div[1]/section/div/div/div/div/div[2]/section/div/div/div/div/div[2]/form[7]/div[1]/div/div[5]/div[2]/div[3]/div[3]/div[1]/div[2]/table[1]/tbody/tr[1]/td[1]/select"); // list select from it cancelled in "on hold" case
    By yesBttn = By.id("___btnYes"); // Alert displayed on screen after converting it from on hold to cancelled
    By refundAmount = By.id("supplierRefundedAmount1"); // text field write in it refunded amount
    By cancellationCharge = By.id("cancellationCharge1_1"); // cancellation charge Amount

    By refundBttn = By.xpath("//*[@id=\"button_can\"]/a"); // refund button press on it to refund an amount
    By refundOkBttn = By.xpath("//*[@id=\"succes-msg\"]/div/div/div[3]/button"); // press on it to ensure refunded amount

    public By errorMssg = By.xpath("/html/body/div[1]/section/div/div/div/div/div[2]/form[1]/div/div[2]/div[1]"); // error mssg displayed when no results


    public void searchAboutSpecificPnrRelatedToBranch(String pnr) {
        driver.element().click(branchList)
                .click(optionAllBranches)
                .click(plusOption)
                .type(pnrField, pnr)
                .click(searchBttn);
        if (driver.element().getText(errorMssg).contains("No Data Found")) {
            driver.quit();
        }
    }

    public void searchAboutSpecificPnrRelatedToAgency(String pnr) throws InterruptedException {
        driver.element().click(branchList)
                .click(optionAllBranches);
        Thread.sleep(1000);
        driver.element().click(agencyList);
        Thread.sleep(1000);
        driver.element().click(optionAllAgencies)
                .click(plusOption)
                .type(pnrField, pnr)
                .click(searchBttn);
        Thread.sleep(1000);
        if (driver.element().getText(errorMssg).contains("No Data Found")) {
            driver.quit();
        }
    }

    public void searchWithSpecificTicketNo(String ticketNo) {
        driver.element().click(branchList)
                .click(optionAllBranches)
                .click(agencyList)
                .click(optionAllAgencies)
                .click(plusOption)
                .type(ticketField, ticketNo)
                .click(searchBttn);
        if (driver.element().getText(errorMssg).contains("No Data Found")) {
            driver.quit();
        }
    }

    public void searchWithNDCReferenceRelatedToBranch(String ndcRef) {
        driver.element().click(branchList)
                .click(optionAllBranches)
                .type(bookingReference, ndcRef)
                .click(searchBttn);
        if (driver.element().getText(errorMssg).contains("No Data Found")) {
            driver.quit();
        }

    }

    public void searchWithSpecificClientName(String name) {
        driver.element().click(branchList)
                .click(optionAllBranches)
                .click(agencyList)
                .click(optionAllAgencies)
                .type(clientName, name)
                .click(searchBttn);
        if (driver.element().getText(errorMssg).contains("No Data Found")) {
            driver.quit();
        }
    }

    public void searchWithSpecificInvoiceNo(String invoice) {
        driver.element().click(branchList)
                .click(optionAllBranches)
                .click(agencyList)
                .click(optionAllAgencies)
                .type(invoiceNo, invoice)
                .click(searchBttn);
        if (driver.element().getText(errorMssg).contains("No Data Found")) {
            driver.quit();
        }
    }

    public void searchWithSpecificOrderId(String order) {
        driver.element().click(branchList)
                .click(optionAllBranches)
                .click(agencyList)
                .click(optionAllAgencies)
                .type(orderId, order)
                .click(searchBttn);
        if (driver.element().getText(errorMssg).contains("No Data Found")) {
            driver.quit();
        }
    }

    public void cancelTicketBookingRelatedToBranch() throws InterruptedException {
        if (!isElementPresent(resultTable)) {
            driver.quit();
        } else {
            driver.element().assertThat(resultTable).isVisible();
            driver.element().assertThat(orderIdHyperText).isVisible();
            driver.element().click(orderIdHyperText);
            Thread.sleep(1000);
            driver.element().click(lockIcon);
            Thread.sleep(1000);
            driver.element().click(takeControlBttn);
            Thread.sleep(1000);
            driver.element().click(itinerary);
            Thread.sleep(1000);
            driver.element().scrollToElement(viewPaxDetails);
            Thread.sleep(1000);
            driver.element().click(viewPaxDetails);
            Thread.sleep(1000);
            driver.element().scrollToElement(passengerCheckBox);
            Thread.sleep(1000);
            driver.element().click(passengerCheckBox);
            Thread.sleep(1000);
            driver.element().scrollToElement(passengerCheckBox);
            Thread.sleep(1000);
            driver.element().click(voidAndCancelBttn);
            Thread.sleep(1000);
            driver.element().click(okBttn);
            Thread.sleep(1000);
            if (isElementPresent(releaseBttn)) {
                driver.element().click(releaseBttn)
                        .click(confirmBttn)
                        .click(okAfterRelease);
                driver.assertThat().element(successMssgAfterRelease).isVisible();
            }

        }
    }


    public void cancelTicketBookingUsingPNRRelatedToAgency(String pnr) throws InterruptedException {
        driver.element().assertThat(resultTable).isVisible();
        driver.element().assertThat(orderIdHyperText).isVisible();
        driver.element().click(orderIdHyperText);
        Thread.sleep(1000);
        driver.element().click(lockIcon);
        Thread.sleep(1000);
        driver.element().scrollToElement(takeControlBttn);
        Thread.sleep(1000);
        driver.element().click(takeControlBttn);
        Thread.sleep(1000);
        driver.element().click(itinerary);
        Thread.sleep(1000);
        driver.element().click(viewPaxDetails);
        Thread.sleep(1000);
        driver.element().click(passengerCheckBox);
        Thread.sleep(1000);
        driver.element().click(voidAndCancelBttn);
        Thread.sleep(1000);
        driver.element().scrollToElement(okBttn);
        Thread.sleep(1000);
        driver.element().click(okBttn);
        if (isElementPresent(releaseBttn)) {
            driver.element().click(releaseBttn)
                    .click(confirmBttn)
                    .click(okAfterRelease);
            driver.assertThat().element(successMssgAfterRelease).isVisible();
        }

    }

    public void cancelTicketHoldingUsingPNRRelatedToBranch(String pnr) {
        driver.element().assertThat(resultTable).isVisible();
        driver.element().assertThat(orderIdHyperText).isVisible();
        driver.element().click(orderIdHyperText)
                .assertThat(clientPageDetails).isVisible();
        driver.element().click(lockIcon)
                .click(takeControlBttn)
                .click(itinerary)
                .select(listOfBookingStatus, "Cancelled")
                .click(yesBttn);
        if (isElementPresent(releaseBttn)) {
            driver.element().click(releaseBttn)
                    .click(confirmBttn)
                    .click(okAfterRelease);
            driver.assertThat().element(successMssgAfterRelease).isVisible();
        } else {
            driver.quit();
        }

    }

    public void cancelTicketHoldingUsingPNRRelatedToAgency(String pnr) {
        driver.element().assertThat(resultTable).isVisible();
        driver.element().assertThat(orderIdHyperText).isVisible();
        driver.element().click(orderIdHyperText)
                .click(lockIcon)
                .click(takeControlBttn)
                .click(itinerary)
                .select(listOfBookingStatus, "Cancelled")
                .click(yesBttn);
        if (isElementPresent(releaseBttn)) {
            driver.element().click(releaseBttn)
                    .click(confirmBttn)
                    .click(okAfterRelease);
            driver.assertThat().element(successMssgAfterRelease).isVisible();
        } else {
            driver.quit();
        }
    }

    public void refundAmountOfTicketAfterCancellation(float refundedAmount, int cancellationAmount) throws InterruptedException {
        driver.element().scrollToElement(viewPaxDetails);
        Thread.sleep(1000);
        driver.element().click(viewPaxDetails);
        Thread.sleep(1000);
        driver.element().scrollToElement(refundAmount);
        Thread.sleep(1000);
        driver.element().type(refundAmount, String.valueOf(refundedAmount));
        Thread.sleep(1000);
        driver.element().type(cancellationCharge, String.valueOf(cancellationAmount));
        Thread.sleep(1000);
        driver.element().click(refundBttn);
        Thread.sleep(1000);
        driver.element().click(refundOkBttn);
    }

}
