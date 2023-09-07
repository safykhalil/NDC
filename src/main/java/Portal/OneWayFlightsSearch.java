package Portal;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class OneWayFlightsSearch {
    public SHAFT.GUI.WebDriver driver;

    public OneWayFlightsSearch(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    By Flights = By.xpath("//*[@id=\"flight\"]/a/img");
    By StartingFrom = By.xpath("//*[@id=\"startingFrom_1\"]");
    By CAI = By.xpath("//*[@id=\"ui-id-2\"]");
    By GoingTo = By.xpath("//*[@id=\"goingTo_1\"]");
    By Destination = By.xpath("//*[@id=\"ui-id-21\"]");
    By DateOfJourney = By.id("datePicker_1");
    By Next = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]");
    By SelectedDate = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[4]/a");
    By SearchBttn = By.xpath("//*[@id=\"flightWidgetFormOneWay\"]/div[11]/input");
    By Checkbox = By.xpath("//*[@id=\"one-way\"]/div[2]/div/div[1]/div/div[2]/div[1]/div/div/div[1]/div[1]/input");

    public void searchForOneWayFlight(String From, String To){
        driver.element().click(Flights)
                .click(StartingFrom)
                .type(StartingFrom, From)
                .click(CAI)
                .click(GoingTo)
                .type(GoingTo, To)
                .keyPress(GoingTo,Keys.ARROW_DOWN)
                .keyPress(GoingTo, Keys.ENTER)
                //.click(Destination)
                .click(DateOfJourney)
                .click(Next)
                .click(Next)
                .click(Next)
                .click(SelectedDate)
                .click(SearchBttn)
                .click(Checkbox);
    }
}
