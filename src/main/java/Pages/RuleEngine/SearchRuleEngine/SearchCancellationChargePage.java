package Pages.RuleEngine.SearchRuleEngine;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SearchCancellationChargePage extends BasePage {
    public SearchCancellationChargePage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By activeOption = By.xpath("/html/body/div/section/div/div[2]/div/div/div[2]/form/div[5]/div[2]/div/ul/li[2]/label");
    By inActiveOption = By.xpath("/html/body/div/section/div/div[2]/div/div/div[2]/form/div[5]/div[2]/div/ul/li[1]/label");
    By searchBttn = By.id("searchButton");
    By countryInput = By.id("criteriaLevelValue");
    By cancellationChargeCodeInput = By.id("rulesUid");
    public By resultTable = By.id("air_tb");
    public By noResultMssg = By.xpath("/html/body/div/section/div/div[2]/div/div/div[2]/form/div[7]/div[2]/span");

    public void searchAboutActiveCancellationCharge() {
        driver.element().click(activeOption);
        driver.element().click(searchBttn);
    }

    public void searchAboutInActiveCancellationCharge() {
        driver.element().click(inActiveOption);
        driver.element().click(searchBttn);
    }
    //Search for Cancellation code with active status in inactive status
    public void searchAboutActiveCancellationCodeInInactive() {
        driver.element().type(cancellationChargeCodeInput,"730")
                .click(inActiveOption)
                .click(searchBttn);
    }
    //Search for Cancellation code with inactive status in active status

    public void searchAboutInactiveCancellationCodeInActive() {
        driver.element().type(cancellationChargeCodeInput,"750")
                .click(activeOption)
                .click(searchBttn);
    }

    //Search for Cancellation code with invalid Cancellation code
    public void searchWithInavlidCancellationCode(){
        driver.element().type(cancellationChargeCodeInput,"9999")
                .click(searchBttn);
    }

    //Search with wrong Cancellation code in a specific country
    public void searchWithWrongCancellationCodeInASpecificCountry(){
        driver.element().select(countryInput,"Iraq")
                .type(cancellationChargeCodeInput,"729")
                .click(searchBttn);
    }
}
