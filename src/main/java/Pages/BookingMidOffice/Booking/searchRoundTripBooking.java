package Pages.BookingMidOffice.Booking;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class searchRoundTripBooking extends BasePage {
    public searchRoundTripBooking(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By roundTripBttn = By.xpath("//*[@id=\"flight-landing-wrap\"]/div/div/div/div[2]/div/div[1]/ul/li[2]"); //navigate to round trip form

    By Branch = By.id("branchListId"); // list of branches

    By Agency = By.id("agencyListId"); // list of agencies

    By AgencyStaff = By.id("selectagenId"); // list of staff related to agencies

    By StartingFrom1 = By.id("startingFrom_2"); // source of the trip

    By Destination = By.id("goingTo_2"); // destination of the trip


    By DateOfJourneyS1 = By.id("dateofjourney_1"); // first trip date
    By DateOfJourneyS2 = By.id("dateofjourney_2"); // return trip date

    By SearchBttn = By.xpath("//*[@id=\"flightWidgetFormRoundTrip\"]/div[14]/input"); // search button press on it to view results
    By nearByAirportCheckBox = By.id("nearByAirport2"); // checkbox of nearby airport option


    LocalDate journeyDate = LocalDate.now().plusDays(20);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");


    public void searchAboutRoundTripUsingBranchOnly(String brName, String source, String destination) throws InterruptedException {

        driver.element().select(Branch, brName);
        Thread.sleep(1000);
        try {
            driver.element().click(roundTripBttn);
        } catch (ElementNotInteractableException e) {
            driver.element().click(roundTripBttn);

        }
        driver.element().type(StartingFrom1, source)
                .keyPress(StartingFrom1, Keys.ARROW_DOWN)
                .keyPress(StartingFrom1, Keys.ENTER);
        Thread.sleep(1000);
        driver.element().type(Destination, destination)
                .keyPress(Destination, Keys.ARROW_DOWN)
                .keyPress(Destination, Keys.ENTER)
                .type(DateOfJourneyS1, journeyDate.format(formatter))
                .keyPress(DateOfJourneyS1, Keys.ENTER)
                .type(DateOfJourneyS2, journeyDate.plusDays(5).format(formatter))
                .scrollToElement(nearByAirportCheckBox).doubleClick(nearByAirportCheckBox)
                .click(SearchBttn);
        Thread.sleep(10000);
    }

    public void searchAboutRoundTripUsingAgencyOnly(String brName, String agnName, String staffName, String source, String destination) throws InterruptedException {

        driver.element().select(Branch, brName);
        Thread.sleep(1000);
        driver.element().select(Agency, agnName)
                .select(AgencyStaff, staffName);
        try {
            driver.element().click(roundTripBttn);

        } catch (ElementNotInteractableException e) {
            driver.element().click(roundTripBttn);

        }

        driver.element().type(StartingFrom1, source)
                .keyPress(StartingFrom1, Keys.ARROW_DOWN)
                .keyPress(StartingFrom1, Keys.ENTER);
        Thread.sleep(1000);
        driver.element().type(Destination, destination)
                .keyPress(Destination, Keys.ARROW_DOWN)
                .keyPress(Destination, Keys.ENTER)
                .type(DateOfJourneyS1, journeyDate.format(formatter))
                .keyPress(DateOfJourneyS1, Keys.ENTER)
                .type(DateOfJourneyS2, journeyDate.plusDays(5).format(formatter))
                .scrollToElement(nearByAirportCheckBox).doubleClick(nearByAirportCheckBox)
                .click(SearchBttn);
        Thread.sleep(10000);



    }


}
