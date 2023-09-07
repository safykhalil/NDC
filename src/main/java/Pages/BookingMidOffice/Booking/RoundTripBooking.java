package Pages.BookingMidOffice.Booking;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class RoundTripBooking extends BasePage {
    public RoundTripBooking(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By Type4TripRound = By.xpath("//*[@id=\"flight-landing-wrap\"]/div/div/div/div[2]/div/div[1]/ul/li[2]");

    By Branch = By.id("branchListId");

    By Agency = By.id("agencyListId");

    By AgencyStaff = By.id("selectagenId");

    By StartingFrom1 = By.id("startingFrom_2");

    By Destenation1 = By.id("goingTo_2");


    By DateOfJourneyS1 = By.id("dateofjourney_1"); // first trip date
    By DateOfJourneyS2 = By.id("dateofjourney_2"); // return trip date

    By SearchBttn = By.xpath("//*[@id=\"flightWidgetFormRoundTrip\"]/div[14]/input");
    By errorMssg = By.xpath("//*[@id=\"content_wrap\"]/div/div[2]/div[2]/div[12]/div/div[2]/div[2]/p[1]"); //no search results error message
    By bookNowBttn = By.xpath("//*[@id=\"one-way\"]/div[2]/div/div[1]/div/div[2]/div[2]/div[2]/div/a");  // press on it to navigate to terms page
    By nearByAirportCheckBox = By.id("nearByAirport2"); // checkbox of nearby airport option
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
    By passportExpiry =(By.id("passengerPassExp_0")); // select date from it
    By Nationality = By.id("passengerNationality_0"); // type in it then select first
    By bookAndPayBttn = By.id("bookButtonShowHide"); // click on it to pay and complete the cycle of booking
    By bookAndHoldBttn = By.xpath("//*[@id=\"flightCashFormTrav\"]/div[2]/div/div[2]/input[2]"); // click on it to take a trip mas hold and complete the cycle of booking
    By pnr = By.xpath("/html/body/div/section/div/div/div/div/div[2]/div[2]/div/div/div[1]/table/tbody/tr[3]/td[1]/strong");
    By successMssg = By.xpath("/html/body/div/section/div/div/div/div/div[2]/div[2]/div/div/div[1]/table/tbody/tr[2]/td");
    By tripPrice = By.cssSelector("#flightCashForm > div > div.net-payable > ul > li:nth-child(2) > p > span:nth-child(1)");

    LocalDate dob = LocalDate.now().minusYears(18);
    LocalDate expiryDate = LocalDate.now().plusYears(10);
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    DateTimeFormatter DOBFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    DateTimeFormatter expiryFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    List<String> refundableFlights = new ArrayList<>(Arrays.asList("WT-1E-REFUNDABLE", "WT 1U-REFUNDABLE", "WT-2E-REFUNDABLE", "WT-3-REFUNDABLE"));
    String path, displayName, PNR, successBookingMssg, TripPrice;


    private String getNextRoundTripFlight(int index) {
        StringBuilder path = new StringBuilder();
        path.append("//*[@id=\"round-trip\"]/div[2]/div/div[");
        path.append(index);
        path.append("]");
        return path.toString();
    }


    public void bookingARefundableRoundTripUsingBranchOnly(String brName, String source, String destination, String title, String passFirstName, String passLastName,
                                                           String countCode, String passMobile,
                                                           String gender, String passport, String nationality) throws InterruptedException {
        LocalDate dateOfJourney1 = LocalDate.now().plusDays(20);
        LocalDate dateOfJourney2 = LocalDate.now().plusDays(30);
        driver.element().select(Branch, brName);
        Thread.sleep(10000);
        try {
            driver.element().scrollToElement(Type4TripRound).click(Type4TripRound);

        } catch (ElementNotInteractableException e) {
            driver.element().click(Type4TripRound);

        }
        driver.element().type(StartingFrom1, source)
                .keyPress(StartingFrom1, Keys.ARROW_DOWN)
                .keyPress(StartingFrom1, Keys.ENTER);
        Thread.sleep(1000);
        driver.element().type(Destenation1, destination)
                .keyPress(Destenation1, Keys.ARROW_DOWN)
                .keyPress(Destenation1, Keys.ENTER);
        driver.element().type(DateOfJourneyS1, dateOfJourney1.format(myFormatObj))
                .keyPress(DateOfJourneyS1, Keys.ENTER)
                .type(DateOfJourneyS2, dateOfJourney2.format(myFormatObj))
                .scrollToElement(nearByAirportCheckBox).doubleClick(nearByAirportCheckBox);
        Thread.sleep(1000);
        driver.element().click(SearchBttn);
        Thread.sleep(100000);

        if (isElementPresent(errorMssg) && !isElementPresent(bookNowBttn)) {
            driver.quit();
        } else {
            int index = 1;
            Map<String, String> allFlights = new HashMap<>();
            path = getNextRoundTripFlight(index);
            displayName = "";
            while (isElementPresent(By.xpath(path))) {
                displayName = driver.getDriver().findElement(By.
                        xpath(path + "/div/div[2]/div[2]/div[2]/div/div/p")).getText();
                if (refundableFlights.contains(displayName)) {
                    allFlights.put(displayName, path + "/div/div[2]/div[2]/div[2]/div/a");
                    break;
                }
                index++;
                path = getNextRoundTripFlight(index);
            }
            if (!allFlights.isEmpty()) {

                driver.element().click(By.xpath(allFlights.get(displayName)));
                Thread.sleep(1000);
                Thread.sleep(1000);
                driver.element().scrollToElement(acceptCheckBox).click(acceptCheckBox);
                Thread.sleep(1000);
                driver.element().click(continueBttn);
                Thread.sleep(1000);
                driver.element().select(passengerTitle, title)
                        .type(passengerFirstName, passFirstName)
                        .type(passengerLastName, passLastName)
                        .click(dateOfBirth).type(dateOfBirth, dob.format(DOBFormatter))
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
                TripPrice = driver.element().getText(tripPrice);
                driver.element().click(bookAndPayBttn)
                        .alert().acceptAlert();
                Thread.sleep(10000);
                try {
                    successBookingMssg = driver.element().getText(successMssg);
                    PNR= driver.element().getText(pnr);
                } catch (NoSuchElementException e) {
                    Thread.sleep(1000);
                    successBookingMssg = driver.element().getText(successMssg);
                    PNR= driver.element().getText(pnr);
                }

            } else {
                driver.quit();
            }
        }





            }

    public void bookingARefundableRoundTripUsingAgencyOnly(String brName, String agnName,String staffName,String source, String destination, String title, String passFirstName, String passLastName,
                                                           String countCode, String passMobile,
                                                           String gender, String passport, String nationality) throws InterruptedException {
        LocalDate dateOfJourney1 = LocalDate.now().plusDays(20);
        LocalDate dateOfJourney2 = LocalDate.now().plusDays(30);
        driver.element().select(Branch, brName);
        Thread.sleep(10000);
        driver.element().select(Agency, agnName);
        Thread.sleep(1000);
        driver.element().select(AgencyStaff, staffName);
        Thread.sleep(1000);
        try {
            driver.element().scrollToElement(Type4TripRound).click(Type4TripRound);

        } catch (ElementNotInteractableException e) {
            driver.element().click(Type4TripRound);

        }
        driver.element().type(StartingFrom1, source)
                .keyPress(StartingFrom1, Keys.ARROW_DOWN)
                .keyPress(StartingFrom1, Keys.ENTER);
        Thread.sleep(1000);
        driver.element().type(Destenation1, destination)
                .keyPress(Destenation1, Keys.ARROW_DOWN)
                .keyPress(Destenation1, Keys.ENTER);
        driver.element().type(DateOfJourneyS1, dateOfJourney1.format(myFormatObj))
                .keyPress(DateOfJourneyS1, Keys.ENTER)
                .type(DateOfJourneyS2, dateOfJourney2.format(myFormatObj))
                .scrollToElement(nearByAirportCheckBox).doubleClick(nearByAirportCheckBox);
        Thread.sleep(10000);
        driver.element().click(SearchBttn);
        Thread.sleep(100000);

        if (isElementPresent(errorMssg) && !isElementPresent(bookNowBttn)) {
            driver.quit();
        } else {
            int index = 1;
            Map<String, String> allFlights = new HashMap<>();
            path = getNextRoundTripFlight(index);
            displayName = "";
            while (isElementPresent(By.xpath(path))) {
                displayName = driver.getDriver().findElement(By.
                        xpath(path + "/div/div[2]/div[2]/div[2]/div/div/p")).getText();
                if (refundableFlights.contains(displayName)) {
                    allFlights.put(displayName, path + "/div/div[2]/div[2]/div[2]/div/a");
                    break;
                }
                index++;
                path = getNextRoundTripFlight(index);
            }
            if (!allFlights.isEmpty()) {

                driver.element().click(By.xpath(allFlights.get(displayName)));
                Thread.sleep(1000);
                Thread.sleep(1000);
                driver.element().scrollToElement(acceptCheckBox).click(acceptCheckBox);
                Thread.sleep(1000);
                driver.element().click(continueBttn);
                Thread.sleep(1000);
                driver.element().select(passengerTitle, title)
                        .type(passengerFirstName, passFirstName)
                        .type(passengerLastName, passLastName)
                        .click(dateOfBirth).type(dateOfBirth, dob.format(DOBFormatter))
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
                TripPrice = driver.element().getText(tripPrice);
                driver.element().click(bookAndPayBttn)
                        .alert().acceptAlert();
                Thread.sleep(10000);
                try {
                    successBookingMssg = driver.element().getText(successMssg);
                    PNR= driver.element().getText(pnr);
                } catch (NoSuchElementException e) {
                    Thread.sleep(1000);
                    successBookingMssg = driver.element().getText(successMssg);
                    PNR= driver.element().getText(pnr);
                }

            } else {
                driver.quit();
            }
        }





    }
            }


