package Pages.BookingMidOffice.Booking;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class searchAboutOneWayTrips extends BasePage {

    public searchAboutOneWayTrips(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }
    By branchList = By.id("branchListId");   // list of branches
    By agencyList = By.id("agencyListId");  // list of agencies
    By staffList = By.id("selectagenId");   // List og staff members
    By startingFrom = By.id("startingFrom_1"); // type in it "CAI" then select first choice
    By goingTo = By.id("goingTo_1"); // type in it "DXB" then select first choice
    By dateJourney = By.id("datePicker_1"); // select date from it
    By searchBttn = By.cssSelector("#flightWidgetFormOneWay > div.button-wrap > input"); // search button , press on it waiting results
    By errorMssg = By.xpath("/*[@id=\"content_wrap\"]/div/div[2]/div[2]/div[11]/div/div[2]/div[2]"); //no search results error message
    By bookNowBttn = By.xpath("//*[@id=\"one-way\"]/div[2]/div/div[1]/div/div[2]/div[2]/div[2]/div/a");  // press on it to navigate to terms page
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");


    public void searchingOneWayTripsUsingBrOnly(String brName, String source,
                                            String destination) throws InterruptedException {
    LocalDate dateOfJourney = LocalDate.now().plusDays(60);
    driver.element().select(branchList, brName);
    Thread.sleep(10000);
    driver.element().type(startingFrom, source);
    Thread.sleep(1000);
    new ElementActions().keyPress(startingFrom, Keys.ENTER);
    driver.element().type(goingTo, destination);
    Thread.sleep(1000);
    new ElementActions().keyPress(goingTo, Keys.ENTER);
    driver.element().type(dateJourney, dateOfJourney.format(myFormatObj))
            .click(searchBttn);
    Thread.sleep(1000000);

}
    public void searchingOneWayTripsUsingAgnOnly(String brName, String agnName,String staffName,String source,
                                                String destination) throws InterruptedException {
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

    }
}
