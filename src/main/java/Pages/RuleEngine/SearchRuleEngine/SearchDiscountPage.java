package Pages.RuleEngine.SearchRuleEngine;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SearchDiscountPage extends BasePage {

    public SearchDiscountPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By inActiveOption = By.xpath("/html/body/div/section/div/div[2]/div/div/div[2]/form/div[5]/div/div/ul/li[1]/label");
    By confirmPopUpMsg = By.id("modal-content");
    By approveBody = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/div[2]/form/div[7]/div[2]/table/tbody/tr/td[8]/div[2]/div/div/div[2]");
    By approveBttn = By.id("approveButton");
    By searchBttn = By.id("searchButton");
    By remarksTxt = By.name("approvalRemarks");
    By editIcon = By.xpath("(//img[@alt='Edit' and @title='Edit'])[1]");
    By discountInput = By.id("rulesUid");
    By activeOption = By.xpath("//*[@id=\"searchDiscountForm\"]/div[5]/div/div/ul/li[2]/label");
    public By noResultsMsg = By.xpath("/html/body/div/section/div/div[2]/div/div/div[2]/form/div[7]/span");

    By productInput = By.id("ruleGroupId");
    By countryInput = By.id("countryId");
    public void searchAboutActiveDiscount() {

        driver.element().click(searchBttn);
    }

    public void searchAboutInActiveDiscount() {
        driver.element().click(inActiveOption)
                .click(searchBttn);


    }

    public void approveNewDiscountRequest() {
        driver.element().click(inActiveOption)
                .click(searchBttn)
                .click(editIcon)
                .type(remarksTxt, "Approve")
                .click(approveBttn);

    }
    //Search about Discounts with active status in inactive status
    public void searchAboutActiveDiscountInInactive() {
        driver.element().type(discountInput,"915")
                .click(inActiveOption)
                .click(searchBttn);

    }
    //Search about Discounts with inactive status in active status
    public void searchAboutInActiveDiscountInActiveStatus() {
        driver.element().type(discountInput,"790")
                .click(activeOption)
                .click(searchBttn);

    }
    //Search about Discount with invalid code
    public void searchAboutInvalidDiscountCode() {
        driver.element().type(discountInput,"9999")
                .click(searchBttn);
    }
    //Search about wrong discount code in a specific country
    public void searchWithWrongDiscountCodeInASpecificCountry() {
        driver.element().select(productInput,"Flight")
                .select(countryInput,"Iraq")
                .type(discountInput,"898")
                .click(searchBttn);
    }

}

