package Pages.BookingMidOffice.Booking;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RepeatSearchOneWayFlightWithDiscountChecking extends BasePage {
    public RepeatSearchOneWayFlightWithDiscountChecking(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By branchList = By.id("branchListId");   // list of branches
    By startingFrom = By.id("startingFrom_1"); // type in it "CAI" then select first choice
    By goingTo = By.id("goingTo_1"); // type in it "DXB" then select first choice
    By dateJourney = By.id("datePicker_1"); // select date from it
    By myDatesAreFlexible = By.xpath("/html/body/div[1]/section/div/div/div/div/div[2]/div[4]/div/div/div/div/div[2]/div/div[3]/div[1]/form/div[7]/div[1]/p/input[1]"); // dates flexible option
    public By errorMssg = By.xpath("//*[@id=\"content_wrap\"]/div/div[2]/div[2]/div[12]/div/div[2]/div[2]/p[1]"); //no search results error message
    public By bookNowBttn = By.xpath("//*[@id=\"one-way\"]/div[2]/div/div[1]/div/div[2]/div[2]/div[2]/div/a");  // press on it to navigate to terms page
    By searchBttn = By.cssSelector("#flightWidgetFormOneWay > div.button-wrap > input"); // search button , press on it waiting results

    public By flashIcon = By.xpath("//*[@id=\"one-way\"]/div[1]/div[2]/div/div[1]/a/img[2]"); // Flash icon presses on it to display discount

    public By discountValue = By.xpath("//*[@id=\"one-way\"]/div[2]/div/div[1]/div/div[2]/div[2]/div[2]/div[1]/p[5]"); // amount of discount


    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public void searchAboutOneWayFlightsUsingDatesFlexibleOptionCheckingDiscountEveryTime(String brName, String source, String destination, int noOfTrying) throws InterruptedException {
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
        driver.element().scrollToElement(myDatesAreFlexible).click(myDatesAreFlexible);
        Thread.sleep(1000);
        driver.element().click(searchBttn);
        Thread.sleep(10000);
    }
}
