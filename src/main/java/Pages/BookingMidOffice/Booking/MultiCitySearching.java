package Pages.BookingMidOffice.Booking;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MultiCitySearching extends BasePage {
    public MultiCitySearching(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By multiCityBttn = By.xpath("//*[@id=\"flight-landing-wrap\"]/div/div/div/div[2]/div/div[1]/ul/li[3]"); // button navigate to multi city form

    By Branch = By.id("branchListId"); // list contains all branches

    By Agency = By.id("agencyListId"); // list contains all agencies

    By AgencyStaff = By.id("selectagenId"); // list contains all staff agents
    By firstSource = By.xpath("//*[@id=\"startingFrom_4\"]"); // first source of trip that trip starts from
    By secondSource = By.xpath("//*[@id=\"startingFrom_5\"]");// second source of trip that return trip starts from
    By firstDestination = By.xpath("//*[@id=\"goingTo_4\"]"); // first destination that first trip ends on it
    By SecondDestination = By.xpath("//*[@id=\"goingTo_5\"]");
    By baggageCheckBox = By.id("baggageFareOnly3"); // checkbox of baggage option
    By SearchBttn = By.cssSelector("#flightWidgetFormMultiCity > div.button-wrap > input"); // search button click on it to view results
    By DateOfJourneyTrip1 = By.id("dateOfJourney_3"); // date of the first trip
    By DateOfJourneyTrip2 = By.id("dateOfJourney_4");  // date of the second trip
    By errorMssg = By.xpath("//*[@id=\"content_wrap\"]/div/div[2]/div[2]/div[11]/div/div[2]/div[2]"); // error message displayed if no results retrieved
//    WebElement overlayElement = driver.getDriver().findElement(By.cssSelector("a.ui-state-default.ui-state-hover")); // element overlay with search bttn
    LocalDate journeyDate = LocalDate.now().plusDays(25);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");


    public void searchAboutMultiCityFlightUsingBranchOnly(String branch, String origin, String destination, String secondOrigin, String secondDestination) throws InterruptedException {
        driver.element().select(Branch, branch);
        Thread.sleep(1000);
        driver.element().click(multiCityBttn);
        Thread.sleep(1000);
        driver.element().type(firstSource, origin)
                .keyPress(firstSource, Keys.ARROW_DOWN)
                .keyPress(firstSource, Keys.ENTER);
        Thread.sleep(1000);
        driver.element().type(firstDestination, destination)
                .keyPress(firstDestination, Keys.ARROW_DOWN)
                .keyPress(firstDestination, Keys.ENTER);
        Thread.sleep(1000);

        driver.element().type(secondSource, secondOrigin)
                .keyPress(secondSource, Keys.ARROW_DOWN)
                .keyPress(secondSource, Keys.ENTER);
        Thread.sleep(1000);
        driver.element().type(SecondDestination, secondDestination)
                .keyPress(SecondDestination, Keys.ARROW_DOWN)
                .keyPress(SecondDestination, Keys.ENTER);
        Thread.sleep(1000);
        driver.element().type(DateOfJourneyTrip1, journeyDate.format(formatter))
                .keyPress(DateOfJourneyTrip1, Keys.ENTER);
        Thread.sleep(1000);
        driver.element().type(DateOfJourneyTrip2, journeyDate.plusDays(5).format(formatter));
        Thread.sleep(1000);
        driver.element().clickUsingJavascript(SearchBttn);
        Thread.sleep(10000);
        if (isElementPresent(errorMssg)) {
            driver.quit();
        }


    }
    public void searchAboutMultiCityFlightUsingAgencyOnly(String branch,String agency,String Staff ,String origin, String destination, String secondOrigin, String secondDestination) throws InterruptedException {
        driver.element().select(Branch, branch);
        Thread.sleep(1000);
        driver.element().select(Agency, agency);
        Thread.sleep(1000);
        driver.element().select(AgencyStaff, Staff);
        Thread.sleep(1000);
        driver.element().click(multiCityBttn);
        Thread.sleep(1000);
        driver.element().type(firstSource, origin)
                .keyPress(firstSource, Keys.ARROW_DOWN)
                .keyPress(firstSource, Keys.ENTER);
        Thread.sleep(1000);
        driver.element().type(firstDestination, destination)
                .keyPress(firstDestination, Keys.ARROW_DOWN)
                .keyPress(firstDestination, Keys.ENTER);
        Thread.sleep(1000);

        driver.element().type(secondSource, secondOrigin)
                .keyPress(secondSource, Keys.ARROW_DOWN)
                .keyPress(secondSource, Keys.ENTER);
        Thread.sleep(1000);
        driver.element().type(SecondDestination, secondDestination)
                .keyPress(SecondDestination, Keys.ARROW_DOWN)
                .keyPress(SecondDestination, Keys.ENTER);
        Thread.sleep(1000);
        driver.element().type(DateOfJourneyTrip1, journeyDate.format(formatter))
                .keyPress(DateOfJourneyTrip1, Keys.ENTER);
        Thread.sleep(1000);
        driver.element().type(DateOfJourneyTrip2, journeyDate.plusDays(5).format(formatter));
        Thread.sleep(1000);
        driver.element().clickUsingJavascript(SearchBttn);
        Thread.sleep(10000);
        if (isElementPresent(errorMssg)) {
            driver.quit();
        }


    }
}
