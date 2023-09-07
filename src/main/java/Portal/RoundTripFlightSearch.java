package Portal;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.concurrent.TimeUnit;

public class RoundTripFlightSearch {

    public SHAFT.GUI.WebDriver driver;

    public RoundTripFlightSearch(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    By Flights = By.xpath("//*[@id=\"flight\"]/a/img");
    By RoundTrip = By.xpath("//*[@id=\"flight-landing-wrap\"]/div[1]/div/div/div[3]/div/div[1]/ul/li[2]");
    By StartingFrom = By.id("startingFrom_2");
    By CAI = By.xpath("//*[@id=\"ui-id-2\"]");
    By GoingTo = By.id("goingTo_2");
    By DXB = By.xpath("//*[@id=\"ui-id-31\"]");
    By DateOfJourney1 = By.xpath("//*[@id=\"dateofjourney_1\"]");
    By Next = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span");
    By SelectedDate = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[4]/a");
    By DateOfJourney2 = By.id("dateofjourney_2");
    By SelectedMonth = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]");
    By SelectedDay = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[4]/a");
    By SearchBttn = By.xpath("//*[@id=\"flightWidgetFormRoundTrip\"]/div[14]/input");
    By Checkbox = By.xpath("//*[@id=\"round-trip\"]/div[2]/div/div[1]/div/div[2]/div[1]/div/div/div[1]/div[1]/input");


    public void searchRoundTripFlightSearch() {
        driver.getDriver().manage().timeouts().implicitlyWait(80000, TimeUnit.SECONDS);
        driver.element().click(Flights)
                .click(RoundTrip)
                .click(StartingFrom)
                .type(StartingFrom, "CAI")
                .click(CAI)
                .click(GoingTo)
                .type(GoingTo, "JED")
                .keyPress(GoingTo,Keys.ARROW_DOWN)
                .keyPress(GoingTo, Keys.ENTER)
                //.click(JED);
                .click(DateOfJourney1)
                .click(Next)
                .click(SelectedDate)
                .click(DateOfJourney2)
                .select(SelectedMonth, "Aug")
                .click(SelectedDay)
                .click(SearchBttn)
                .click(Checkbox);




    }

}
