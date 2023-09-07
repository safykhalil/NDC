package Pages.BookingMidOffice.Booking;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class oneWayBooking extends BasePage {
    public oneWayBooking(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By branchList = By.id("branchListId");   // list of branches
    By agencyList = By.id("agencyListId");  // list of agencies
    By staffList = By.id("selectagenId");   // List og staff members
    By startingFrom = By.id("startingFrom_1"); // type in it "CAI" then select first choice
    By goingTo = By.id("goingTo_1"); // type in it "DXB" then select first choice
    By dateJourney = By.id("datePicker_1"); // select date from it
    By adultList = By.id("noOfAdults"); // list of adults
    By childList = By.id("noOfChilds"); // list of child
    By infantList = By.id("noOfInfants"); // list of infant
    By searchBttn = By.cssSelector("#flightWidgetFormOneWay > div.button-wrap > input"); // search button , press on it waiting results
    By resultCount = By.cssSelector("#one-way > div.row.pm-action-btns.ng-scope > div.col-md-4.col.ng-scope"); // count of results after searching
    public By tripsGrid = By.cssSelector("#one-way > div:nth-child(2) > div"); // grid contains trips retrieved after searching process
    By bookNowBttn = By.xpath("//*[@id=\"one-way\"]/div[2]/div/div[1]/div/div[2]/div[2]/div[2]/div/a");  // press on it to navigate to terms page
    public By termsForm = By.cssSelector("#content_wrap > div > div.airline_search1.main > div:nth-child(11) > div.review-wrapper"); // form to accept terms and conditions
    By acceptCheckBox = By.id("iAccept"); // accept terms and conditions to navigate to passenger details page
    By continueBttn = By.cssSelector("#content_wrap > div > div.airline_search1.main > div:nth-child(11) > div.review-wrapper > div:nth-child(4) > a"); // to continue to passenger details page
    By passengerTitle = By.id("passengerTitle_0"); // select MR from list
    By passengerFirstName = By.id("passengerFirstName_0"); // passenger first name
    By passengerLastName = By.id("passengerLastName_0"); // passenger last name
    By dateOfBirth = By.id("passengerDob_0"); // select date from it
    By countryCode = By.id("passengerCountryCode_0"); // type in it egypt then select first choice
    By passengerMobile = By.id("passengerMobile_0"); // type in it phone no
    By passengerGender = By.id("passengerGender_0"); // select from it Male
    By Passport = By.id("passengerPassport_0"); // type in it
    By passportExpiry = By.id("passengerPassExp_0"); // select date from it
    By Nationality = By.id("passengerNationality_0"); // type in it then select first
    By bookAndPayBttn = By.id("bookButtonShowHide"); // click on it to pay and complete the cycle of booking
    By bookAndHoldBttn = By.xpath("//*[@id=\"flightCashFormTrav\"]/div[2]/div/div[2]/input[2]"); // click on it to take a trip mas hold and complete the cycle of booking
    By errorMssg = By.xpath("/*[@id=\"content_wrap\"]/div/div[2]/div[2]/div[11]/div/div[2]/div[2]"); //no search results error message
    By leftCorner = By.xpath("//*[@id=\"content_wrap\"]/div/div[2]/div[2]/div[12]/div/div[1]/div") ; // left corner of filtration
    By termsAndConditions = By.xpath("/html/body/div/section/div/div/div/div/div[2]/div[2]/div[4]/div[3]/div/div/span/div/a");
    public By supplierMsg = By.xpath("/html/body/div[1]/section/div/div/div/div/div[2]/div[2]/div[4]/div[3]/div/div/span/div/div/div/div/div[2]/div/span[1]");
    LocalDate dob = LocalDate.now().minusYears(18);
    LocalDate expiryDate = LocalDate.now().plusYears(10);
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    DateTimeFormatter DOBFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    DateTimeFormatter expiryFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public String tripPrice, successBookingMssg, SuccessHoldMssg, PNR, path, displayName;
//    List<String> refundableFlights = new ArrayList<>(Arrays.asList("WT-1E-REFUNDABLE", "WT 1U-REFUNDABLE", "WT-2E-REFUNDABLE", "WT-3-REFUNDABLE",
//               "FlyDubaiUAE-LITE", "FlyDubaiUAE-VALUE", "FlyDubaiUAE-FLEX"));

    List<String> refundableFlights = new ArrayList<>(Arrays.asList("WT-1E-REFUNDABLE", "WT 1U-REFUNDABLE"));
    private String getNextOneWayFlight(int index) {
        StringBuilder path = new StringBuilder();
        path.append("//*[@id=\"one-way\"]/div[2]/div/div[");
        path.append(index);
        path.append("]");
        return path.toString();
    }

   /*
    public void bookingAOneWayTripUsingBranchOnlyAndOneAdult(String brName, String source, String destination,
                                                             String title, String passFirstName, String passLastName,
                                                             String countCode, String passMobile,
                                                             String gender, String passport, String nationality) throws InterruptedException, NoSuchElementException {

        LocalDate dateOfJourney = LocalDate.now().plusDays(1);
        driver.element().select(branchList, brName);
        Thread.sleep(1000);
        driver.element().type(startingFrom, source);
        Thread.sleep(1000);
        new ElementActions().keyPress(startingFrom, Keys.ENTER);
        Thread.sleep(1000);
        driver.element().type(goingTo, destination);
        Thread.sleep(1000);
        new ElementActions().keyPress(goingTo, Keys.ENTER);
        Thread.sleep(1000);
        driver.element().type(dateJourney, dateOfJourney.format(myFormatObj));
        Thread.sleep(1000);
        driver.element().click(searchBttn);
        Thread.sleep(10000);
        if (isElementPresent(errorMssg) && !isElementPresent(bookNowBttn)) {
            driver.quit();
        } else {
            displayName = driver.getDriver().findElements(By.tagName("p"))
                    .stream()
                    .map(WebElement::getText)
                    .collect(Collectors.toList());
            if (displayName.contains("WT-1E-REFUNDABLE") || displayName.contains("WT-2E-REFUNDABLE") || displayName.contains("WT 1U-REFUNDABLE")
                    || displayName.contains("WT-3-REFUNDABLE")) {
                new ElementActions().keyPress(bookNowBttn, Keys.ARROW_DOWN).keyPress(bookNowBttn, Keys.ARROW_DOWN);
                Thread.sleep(1000);
                driver.element().click(bookNowBttn);
                Thread.sleep(1000);
                driver.element().click(acceptCheckBox);
                Thread.sleep(1000);
                driver.element().click(continueBttn);
                Thread.sleep(1000);
                driver.element().select(passengerTitle, title)
                        .type(passengerFirstName, passFirstName)
                        .type(passengerLastName, passLastName)
                        .type(dateOfBirth, dob.format(DOBFormatter))
                        .type(countryCode, countCode);
                Thread.sleep(1000);
                new ElementActions().keyPress(countryCode, Keys.ARROW_DOWN).keyPress(countryCode, Keys.ENTER)
                        .type(passengerMobile, passMobile)
                        .select(passengerGender, gender)
                        .type(Passport, (passport));
                driver.element().type(Nationality, nationality);
                Thread.sleep(1000);
                new ElementActions().keyPress(Nationality, Keys.ARROW_DOWN).keyPress(Nationality, Keys.ENTER);
                driver.element().type(passportExpiry, expiryDate.format(expiryFormatter));
                tripPrice = driver.getDriver().findElement(By.cssSelector("#flightCashForm > div > div.net-payable > ul > li:nth-child(2) > p > span:nth-child(1)")).getText();
                driver.element().click(bookAndPayBttn)
                        .alert().acceptAlert();
                successBookingMssg = driver.getDriver().findElement(By.cssSelector("#order-details > div.bcw-card-head > table > tbody > tr:nth-child(2) > td > p")).getText();
                PNR = driver.getDriver().findElement(By.xpath("//*[@id=\"order-details\"]/div[1]/table/tbody/tr[3]/td[1]/strong")).getText();
            } else {
                driver.quit();
            }
        }
`    }
`
    */


    public void bookingRefundableOneWayTripUsingBranchOnlyAndOneAdult(String brName, String source, String destination,
                                                                      String title, String passFirstName, String passLastName,
                                                                      String countCode, String passMobile,
                                                                      String gender, String passport, String nationality) throws InterruptedException, NoSuchElementException {


        LocalDate dateOfJourney = LocalDate.now().plusDays(60);
        driver.element().select(branchList, brName);
        Thread.sleep(10000);
        driver.element().type(startingFrom, source);
        Thread.sleep(1000);
        new ElementActions().keyPress(startingFrom, Keys.ENTER);
        Thread.sleep(1000);
        driver.element().type(goingTo, destination);
        Thread.sleep(1000);
        new ElementActions().keyPress(goingTo, Keys.ENTER);
        Thread.sleep(1000);
        driver.element().type(dateJourney, dateOfJourney.format(myFormatObj));
        Thread.sleep(1000);
        driver.element().click(searchBttn);
        Thread.sleep(1000);
        if (driver.element().isElementDisplayed(errorMssg)) {
            driver.getDriver().quit();
        } else {
            int index = 1;
            Map<String, String> allFlights = new HashMap<>();
            path = getNextOneWayFlight(index);
            displayName = "";
            while (isElementPresent(By.xpath(path))) {
                displayName = driver.getDriver().findElement(By.
                        xpath(path + "/div/div[2]/div[2]/div[2]/div/div/p")).getText();
                if (refundableFlights.contains(displayName)) {
                    allFlights.put(displayName, path + "/div/div[2]/div[2]/div[2]/div/a");
                    break;
                }
                index++;
                path = getNextOneWayFlight(index);
            }

            if (!allFlights.isEmpty()) {
                new ElementActions().keyPress(bookNowBttn, Keys.ARROW_DOWN).keyPress(bookNowBttn, Keys.ARROW_DOWN);
                Thread.sleep(1000);
                driver.element().click(By.xpath(allFlights.get(displayName)));
                Thread.sleep(1000);
                driver.element().scrollToElement(acceptCheckBox).click(acceptCheckBox);
                Thread.sleep(1000);
                driver.element().click(continueBttn);
                Thread.sleep(1000);
                driver.element().select(passengerTitle, title)
                        .type(passengerFirstName, passFirstName)
                        .type(passengerLastName, passLastName)
                        .type(dateOfBirth, dob.format(DOBFormatter))
                        .type(countryCode, countCode);
                Thread.sleep(1000);
                new ElementActions().keyPress(countryCode, Keys.ARROW_DOWN).keyPress(countryCode, Keys.ENTER)
                        .type(passengerMobile, passMobile)
                        .select(passengerGender, gender)
                        .type(Passport, (passport));
                driver.element().type(Nationality, nationality);
                Thread.sleep(1000);
                new ElementActions().keyPress(Nationality, Keys.ARROW_DOWN).keyPress(Nationality, Keys.ENTER);
                driver.element().type(passportExpiry, expiryDate.format(expiryFormatter));
                tripPrice = driver.getDriver().findElement(By.cssSelector("#flightCashForm > div > div.net-payable > ul > li:nth-child(2) > p > span:nth-child(1)")).getText();
                driver.element().click(bookAndPayBttn)
                        .alert().acceptAlert();
                Thread.sleep(10000);
                try {
                    successBookingMssg = driver.getDriver().findElement(By.xpath("/html/body/div/section/div/div/div/div/div[2]/div[2]/div/div/div[1]/table/tbody/tr[2]/td")).getText();
                    PNR = driver.getDriver().findElement(By.xpath("/html/body/div/section/div/div/div/div/div[2]/div[2]/div/div/div[1]/table/tbody/tr[3]/td[1]/strong")).getText();
                } catch (NoSuchElementException e) {
                    Thread.sleep(1000);
                    successBookingMssg = driver.getDriver().findElement(By.xpath("/html/body/div/section/div/div/div/div/div[2]/div[2]/div/div/div[1]/table/tbody/tr[2]/td")).getText();
                    PNR = driver.getDriver().findElement(By.xpath("/html/body/div/section/div/div/div/div/div[2]/div[2]/div/div/div[1]/table/tbody/tr[3]/td[1]/strong")).getText();
                }

            } else {
                driver.quit();
            }
        }
    }


    public void searchOneWayRefundableTrip(String brName, String source, String destination) throws InterruptedException {
        LocalDate dateOfJourney = LocalDate.now().plusDays(60);
        driver.element().select(branchList, brName);
        Thread.sleep(3000);
        driver.element().type(startingFrom, source);
        Thread.sleep(1000);
        new ElementActions().keyPress(startingFrom, Keys.ENTER);
        Thread.sleep(1000);
        driver.element().type(goingTo, destination);
        Thread.sleep(1000);
        new ElementActions().keyPress(goingTo, Keys.ENTER);
        Thread.sleep(1000);
        driver.element().type(dateJourney, dateOfJourney.format(myFormatObj));
        Thread.sleep(1000);
        driver.element().click(searchBttn);
        Thread.sleep(10000);
        if (isElementPresent(errorMssg) || !isElementPresent(bookNowBttn)) {
            driver.quit();
        } else {
            int index = 1;
            Map<String, String> allFlights = new HashMap<>();
            path = getNextOneWayFlight(index);
            displayName = "";
            while (isElementPresent(By.xpath(path))) {
                displayName = driver.getDriver().findElement(By.
                        xpath(path + "/div/div[2]/div[2]/div[2]/div/div/p")).getText();
                if (refundableFlights.contains(displayName)) {
                    allFlights.put(displayName, path + "/div/div[2]/div[2]/div[2]/div/a");
                    break;
                }
                index++;
                path = getNextOneWayFlight(index);
            }

            if (!allFlights.isEmpty()) {
                new ElementActions().keyPress(bookNowBttn, Keys.ARROW_DOWN).keyPress(bookNowBttn, Keys.ARROW_DOWN);
                Thread.sleep(1000);
                driver.element().click(By.xpath(allFlights.get(displayName)));
                driver.element().click(termsAndConditions);
                Thread.sleep(1000);
            }
        }}

    public void bookingAOneWayRefundableTripUsingAgencyAndOneAdult(String brName, String agnName, String staffName, String source,
                                                                   String destination, String title, String passFirstName, String passLastName,
                                                                   String countCode, String passMobile,
                                                                   String gender, String passport, String nationality) throws InterruptedException {
        LocalDate dateOfJourney = LocalDate.now().plusDays(60);
        driver.element().select(branchList, brName);
        Thread.sleep(1000);
        driver.element().select(agencyList, agnName);
        Thread.sleep(1000);
        driver.element().select(staffList, staffName);
        Thread.sleep(1000);
        driver.element().type(startingFrom, source);
        Thread.sleep(1000);
        new ElementActions().keyPress(startingFrom, Keys.ENTER);
        driver.element().type(goingTo, destination);
        Thread.sleep(1000);
        new ElementActions().keyPress(goingTo, Keys.ENTER);
        driver.element().type(dateJourney, dateOfJourney.format(myFormatObj))
                .click(searchBttn);
        Thread.sleep(10000);
        if (isElementPresent(errorMssg) || !isElementPresent(bookNowBttn)) {
            driver.quit();
        } else {
            int index = 1;
            Map<String, String> allFlights = new HashMap<>();
            path = getNextOneWayFlight(index);
            displayName = "";
            while (isElementPresent(By.xpath(path))) {
                displayName = driver.getDriver().findElement(By.xpath(path + "/div/div[2]/div[2]/div[2]/div/div/p")).getText();
                if (refundableFlights.contains(displayName)) {
                    allFlights.put(displayName, path + "/div/div[2]/div[2]/div[2]/div/a");
                    break;
                }
                index++;
                path = getNextOneWayFlight(index);
            }

            if (!allFlights.isEmpty()) {
                new ElementActions().keyPress(bookNowBttn, Keys.ARROW_DOWN).keyPress(bookNowBttn, Keys.ARROW_DOWN);
                driver.element().click(By.xpath(allFlights.get(displayName)));
                Thread.sleep(1000);
                driver.element().scrollToElement(acceptCheckBox).click(acceptCheckBox);
                Thread.sleep(1000);
                driver.element().click(continueBttn);
                Thread.sleep(1000);
                driver.element().select(passengerTitle, title)
                        .type(passengerFirstName, passFirstName)
                        .type(passengerLastName, passLastName)
                        .type(dateOfBirth, dob.format(DOBFormatter))
                        .type(countryCode, countCode);
                Thread.sleep(1000);
                new ElementActions().keyPress(countryCode, Keys.ARROW_DOWN).keyPress(countryCode, Keys.ENTER)
                        .type(passengerMobile, passMobile)
                        .select(passengerGender, gender)
                        .type(Passport, (passport));
                driver.element().type(Nationality, nationality);
                Thread.sleep(1000);
                new ElementActions().keyPress(Nationality, Keys.ARROW_DOWN).keyPress(Nationality, Keys.ENTER);
                driver.element().type(passportExpiry, expiryDate.format(expiryFormatter));
                tripPrice = driver.getDriver().findElement(By.cssSelector("#flightCashForm > div > div.net-payable > ul > li:nth-child(2) > p > span:nth-child(1)")).getText();
                driver.element().click(bookAndPayBttn)
                        .alert().acceptAlert();
                Thread.sleep(10000);
                try {
                    successBookingMssg = driver.getDriver().findElement(By.xpath("/html/body/div/section/div/div/div/div/div[2]/div[2]/div/div/div[1]/table/tbody/tr[2]/td")).getText();
                    PNR = driver.getDriver().findElement(By.xpath("/html/body/div/section/div/div/div/div/div[2]/div[2]/div/div/div[1]/table/tbody/tr[3]/td[1]/strong")).getText();
                } catch (NoSuchElementException e) {
                    Thread.sleep(1000);
                    successBookingMssg = driver.getDriver().findElement(By.xpath("/html/body/div/section/div/div/div/div/div[2]/div[2]/div/div/div[1]/table/tbody/tr[2]/td")).getText();
                    PNR = driver.getDriver().findElement(By.xpath("/html/body/div/section/div/div/div/div/div[2]/div[2]/div/div/div[1]/table/tbody/tr[3]/td[1]/strong")).getText();
                }
            } else {
                driver.quit();
            }
        }
    }

    public void holdAOneWayRefundableTripUsingBranchOnlyAndOneAdult(String brName, String source, String destination,
                                                                    String title, String passFirstName, String passLastName,
                                                                    String countCode, String passMobile,
                                                                    String gender, String passport, String nationality) throws InterruptedException, NoSuchElementException {
        LocalDate dateOfJourney = LocalDate.now().plusDays(60);
        driver.element().select(branchList, brName);
        Thread.sleep(1000);
        driver.element().type(startingFrom, source);
        Thread.sleep(1000);
        new ElementActions().keyPress(startingFrom, Keys.ENTER);
        Thread.sleep(1000);
        driver.element().type(goingTo, destination);
        Thread.sleep(1000);
        new ElementActions().keyPress(goingTo, Keys.ENTER);
        Thread.sleep(1000);
        driver.element().type(dateJourney, dateOfJourney.format(myFormatObj));
        Thread.sleep(1000);
        driver.element().click(searchBttn);
        Thread.sleep(10000);

        if (isElementPresent(errorMssg) || !isElementPresent(bookNowBttn)) {
            driver.quit();
        } else {
            int index = 1;
            Map<String, String> allFlights = new HashMap<>();
            path = getNextOneWayFlight(index);
            displayName = "";
            while (isElementPresent(By.xpath(path))) {
                displayName = driver.getDriver().findElement(By.xpath(path + "/div/div[2]/div[2]/div[2]/div/div/p")).getText();
                if (refundableFlights.contains(displayName)) {
                    allFlights.put(displayName, path + "/div/div[2]/div[2]/div[2]/div/a");
                    break;
                }
                index++;
                path = getNextOneWayFlight(index);
            }
            if (!allFlights.isEmpty()) {
                new ElementActions().keyPress(bookNowBttn, Keys.ARROW_DOWN).keyPress(bookNowBttn, Keys.ARROW_DOWN);
                Thread.sleep(1000);
                driver.element().click(By.xpath(allFlights.get(displayName)));
                Thread.sleep(1000);
                driver.element().click(acceptCheckBox);
                Thread.sleep(1000);
                driver.element().click(continueBttn);
                Thread.sleep(1000);
                driver.element().select(passengerTitle, title)
                        .type(passengerFirstName, passFirstName)
                        .type(passengerLastName, passLastName)
                        .type(dateOfBirth, dob.format(DOBFormatter))
                        .type(countryCode, countCode);
                Thread.sleep(1000);
                new ElementActions().keyPress(countryCode, Keys.ARROW_DOWN).keyPress(countryCode, Keys.ENTER)
                        .type(passengerMobile, passMobile)
                        .select(passengerGender, gender)
                        .type(Passport, (passport));
                driver.element().type(Nationality, nationality);
                Thread.sleep(1000);
                new ElementActions().keyPress(Nationality, Keys.ARROW_DOWN).keyPress(Nationality, Keys.ENTER);
                driver.element().type(passportExpiry, expiryDate.format(expiryFormatter));
                tripPrice = driver.getDriver().findElement(By.cssSelector("#flightCashForm > div > div.net-payable > ul > li:nth-child(2) > p > span:nth-child(1)")).getText();
                driver.element().click(bookAndHoldBttn);
                Thread.sleep(10000);
                SuccessHoldMssg = driver.getDriver().findElement(By.xpath("/html/body/div/section/div/div/div/div/div[2]/div[2]/div/div/div[1]/table/tbody/tr[2]/td")).getText();
                String[] parts = SuccessHoldMssg.split("PNR number: ");
                PNR = parts[1].substring(0, 6);

            } else {
                driver.quit();
            }
        }

    }


    public void holdAOneWayRefundableTripUsingAgencyAndOneAdult(String brName, String agnName, String staffName, String source,
                                                                String destination, String title, String passFirstName, String passLastName,
                                                                String countCode, String passMobile,
                                                                String gender, String passport, String nationality) throws InterruptedException {
        LocalDate dateOfJourney = LocalDate.now().plusDays(60);
        driver.element().select(branchList, brName);
        Thread.sleep(1000);
        driver.element().select(agencyList, agnName);
        Thread.sleep(1000);
        driver.element().select(staffList, staffName);
        Thread.sleep(1000);
        driver.element().type(startingFrom, source);
        Thread.sleep(1000);
        new ElementActions().keyPress(startingFrom, Keys.ENTER);
        driver.element().type(goingTo, destination);
        Thread.sleep(1000);
        new ElementActions().keyPress(goingTo, Keys.ENTER);
        driver.element().type(dateJourney, dateOfJourney.format(myFormatObj))
                .click(searchBttn);
        Thread.sleep(10000);
        if (isElementPresent(errorMssg) || !isElementPresent(bookNowBttn)) {
            driver.quit();
        } else {
            int index = 1;
            Map<String, String> allFlights = new HashMap<>();
            path = getNextOneWayFlight(index);
            displayName = " ";
            while (isElementPresent(By.xpath(path))) {
                displayName = driver.getDriver().findElement(By.xpath(path + "/div/div[2]/div[2]/div[2]/div/div/p")).getText();
                if (refundableFlights.contains(displayName)) {
                    allFlights.put(displayName, path + "/div/div[2]/div[2]/div[2]/div/a");
                    break;
                }
                index++;
                path = getNextOneWayFlight(index);
            }
            if (!allFlights.isEmpty()) {
                new ElementActions().keyPress(bookNowBttn, Keys.ARROW_DOWN).keyPress(bookNowBttn, Keys.ARROW_DOWN);
                driver.element().click(bookNowBttn);
                Thread.sleep(1000);
                driver.element().click(acceptCheckBox);
                Thread.sleep(1000);
                driver.element().click(continueBttn);
                Thread.sleep(1000);
                driver.element().select(passengerTitle, title)
                        .type(passengerFirstName, passFirstName)
                        .type(passengerLastName, passLastName)
                        .type(dateOfBirth, dob.format(DOBFormatter))
                        .type(countryCode, countCode);
                Thread.sleep(1000);
                new ElementActions().keyPress(countryCode, Keys.ARROW_DOWN).keyPress(countryCode, Keys.ENTER)
                        .type(passengerMobile, passMobile)
                        .select(passengerGender, gender)
                        .type(Passport, (passport));
                driver.element().type(Nationality, nationality);
                Thread.sleep(1000);
                new ElementActions().keyPress(Nationality, Keys.ARROW_DOWN).keyPress(Nationality, Keys.ENTER);
                driver.element().type(passportExpiry, expiryDate.format(expiryFormatter));
                tripPrice = driver.getDriver().findElement(By.cssSelector("#flightCashForm > div > div.net-payable > ul > li:nth-child(2) > p > span:nth-child(1)")).getText();
                driver.element().click(bookAndHoldBttn);
                SuccessHoldMssg = driver.getDriver().findElement(By.cssSelector("#order-details > div.bcw-card-head > table > tbody > tr.ng-scope > td")).getText();
                String[] parts = SuccessHoldMssg.split("PNR number: ");
                PNR = parts[1].substring(0, 6);
            } else {
                driver.quit();
            }
        }
    }
}



