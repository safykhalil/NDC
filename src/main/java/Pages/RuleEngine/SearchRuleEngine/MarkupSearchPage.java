package Pages.RuleEngine.SearchRuleEngine;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class MarkupSearchPage extends BasePage {
    public MarkupSearchPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }
    By productTypeList = By.id("ruleGroupId");
    By SearchBttn = By.id("searchButton");
    By countryList = By.id("countryId");

    public By resultTable =By.id("air_tb");
    By inactiveOption =By.xpath("/html/body/div/section/div/div[2]/div/div/div[2]/form/div[6]/div/div/ul/li[1]");
    public By mssg = By.id("msg");
    By MarkupCodeInput = By.id("rulesUid");
    public By noResultsMsg = By.xpath("/html/body/div/section/div/div[2]/div/div/div[2]/form/div[8]/span");
    By activeOption = By.xpath("//*[@id=\"searchMarkupForm\"]/div[6]/div/div/ul/li[2]/label");

    public void searchAboutAllActiveMarkups(String ProductType){
        driver.element().select(productTypeList,ProductType);
        driver.element().click(SearchBttn);

    }
    public void searchAboutAllInActiveMarkups(String ProductType){
        driver.element().select(productTypeList,ProductType);
        driver.element().click(inactiveOption);
        driver.element().click(SearchBttn);

    }
    //Search for Markup with active status in inactive status
    public void searchAboutActiveMarkupInInactive(){
        driver.element().type(MarkupCodeInput,"881")
                .click(inactiveOption)
                .click(SearchBttn);

    }
    //Search for Markup with inactive status in active status

    public void searchAboutInactiveMarkupInActive(){
        driver.element().type(MarkupCodeInput,"893")
                .click(activeOption)
                .click(SearchBttn);

    }
    //Search for Markup with invalid Markup code

    public void searchWithInavlidMarkupCode(){
        driver.element().type(MarkupCodeInput,"501")
                .click(SearchBttn);

    }

    //Search with wrong Markup code in a specific country
    public void searchWithWrongMarkupCodeInASpecificCountry(String ProductType){
        driver.element().type(MarkupCodeInput,"701")
                .select(productTypeList,ProductType)
                .select(countryList,"Iraq")
                .click(SearchBttn);

    }
}
