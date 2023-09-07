package Pages.RuleEngine.SearchRuleEngine;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SearchServiceChargePage extends BasePage {

    public SearchServiceChargePage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By searchBttn = By.id("searchButton");
    By activeOption = By.xpath("/html/body/div/section/div/div[2]/div/div/div[2]/form/div[6]/div/div/ul/li[2]/label");
    By inactiveOption =By.xpath("/html/body/div/section/div/div[2]/div/div/div[2]/form/div[6]/div/div/ul/li[1]/label");
    By serviceChargeCodeInput = By.id("rulesUid");
    By countryInput = By.id("countryId");
    public By noResultMssg = By.xpath("/html/body/div/section/div/div[2]/div/div/div[2]/form/div[8]/span");

    public By resultTable = By.id("air_tb");
    public void searchAboutActiveServiceCharge() {
        driver.element().click(activeOption);
        driver.element().click(searchBttn);
    }

    public void searchAboutInActiveServiceCharge() {
        driver.element().click(inactiveOption);
        driver.element().click(searchBttn);
    }

    public void searchAboutActiveServiceChargeCodeInInactive() {
        driver.element().type(serviceChargeCodeInput,"730")
                .click(inactiveOption)
                .click(searchBttn);
    }
    //Search for Cancellation code with inactive status in active status

    public void searchAboutInactiveServiceChargeCodeInActive() {
        driver.element().type(serviceChargeCodeInput,"750")
                .click(activeOption)
                .click(searchBttn);
    }

    //Search for Cancellation code with invalid Cancellation code
    public void searchWithInavlidServiceChargeCode(){
        driver.element().type(serviceChargeCodeInput,"9999")
                .click(searchBttn);
    }

    //Search with wrong Cancellation code in a specific country
    public void searchWithWrongServiceChargeCodeInASpecificCountry(){
        driver.element().select(countryInput,"Kuwait")
                .type(serviceChargeCodeInput,"910")
                .click(searchBttn);
    }
}
