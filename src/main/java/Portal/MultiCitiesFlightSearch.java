package Portal;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class MultiCitiesFlightSearch {

    public SHAFT.GUI.WebDriver driver;

    public MultiCitiesFlightSearch(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    By Flights = By.xpath("//*[@id=\"flight\"]/a");
    By MultiCity = By.xpath("//*[@id=\"flight-landing-wrap\"]/div[1]/div/div/div[3]/div/div[1]/ul/li[3]");
    By StartingFromS1 = By.id("startingFrom_4");
    By CAI = By.xpath("//*[@id=\"ui-id-2\"]");
    By GoingToS1 = By.id("goingTo_4");
    By DXB = By.xpath("//*[@id=\"ui-id-45\"]");
    By DateOfJourneyS1 = By.id("dateOfJourney_3");
    By SelectedMonthS1 = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]");
    By SelectedDayS1 = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[3]/a");
    By GoingToS2 = By.id("goingTo_5");
    By StartingFromS2 = By.id("startingFrom_5");

    By JED = By.xpath("//*[@id=\"ui-id-116\"]");
    By DateOfJourneyS2 = By.id("dateOfJourney_4");
    By SelectedMonthS2 = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]");
    By SelectedDayS2 = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[4]/a");
    By SearchBttn = By.xpath("//*[@id=\"flightWidgetFormMultiCity\"]/div[10]/input");
    By Checkbox = By.xpath("//*[@id=\"round-trip\"]/div[2]/div/div[1]/div/div[2]/div[1]/div/div/div[1]/div[1]/input");


    public void searchMCFlightsSearch() {
        driver.element().click(Flights)
                .click(MultiCity)
                .type(StartingFromS1, "CAI")
                .keyPress(StartingFromS1,Keys.ARROW_DOWN)
                .keyPress(StartingFromS1,Keys.ENTER)
                .click(GoingToS1)
                .type(GoingToS1, "JED")
                .keyPress(GoingToS1, Keys.ARROW_DOWN)
                .keyPress(GoingToS1, Keys.ENTER)
                .type(StartingFromS2,"JED")
                .keyPress(StartingFromS2,Keys.ARROW_DOWN)
                .keyPress(StartingFromS2,Keys.ENTER)
                .click(DateOfJourneyS1)
                .select(SelectedMonthS1, "May")
                .click(SelectedDayS1)
                .click(GoingToS2)
                .type(GoingToS2, "CAI")
                .keyPress(GoingToS2,Keys.ARROW_DOWN)
                .keyPress(GoingToS2, Keys.ENTER)
                .click(DateOfJourneyS2)
                .select(SelectedMonthS2, "Nov")
                .click(SelectedDayS2)
                .click(SearchBttn)
                .click(Checkbox);


    }

}
