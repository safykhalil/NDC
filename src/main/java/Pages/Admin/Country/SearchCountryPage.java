package Pages.Admin.Country;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SearchCountryPage extends BasePage {

    public SearchCountryPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By SearchBttn = By.name("searchButton");
    public By countriesTable = By.id("air_tb");


    public void CountrySearch() {
        driver.element().click(SearchBttn);
    }


}
