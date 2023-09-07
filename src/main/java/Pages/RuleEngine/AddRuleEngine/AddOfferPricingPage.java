package Pages.RuleEngine.AddRuleEngine;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class AddOfferPricingPage extends BasePage {
    public AddOfferPricingPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By productList = By.id("productid"); // select "Flight" from this list
    By description = By.id("desc"); // description of this offer pricing
    By discountId = By.id("discount1Id"); // select first choice
    By sendForApprovalBttn = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[3]/button[1]");
    public By statusMssg = By.id("statusMsg");

    public void addOfferPricingWithValidData(String productType, String desc, int discId) {
        driver.element().select(productList, productType)
                .type(description, desc)
                .type(discountId, String.valueOf(discId));
        new ElementActions().keyPress(discountId, Keys.ARROW_DOWN).keyPress(discountId, Keys.ENTER);
        driver.element().click(sendForApprovalBttn);
    }

    public void addOfferPricingWithNoProduct(String desc, int discId) {
        driver.element().type(description, desc)
                .type(discountId, String.valueOf(discId));
        new ElementActions().keyPress(discountId, Keys.ARROW_DOWN).keyPress(discountId, Keys.ENTER);
        driver.element().click(sendForApprovalBttn);
    }

    public void addOfferPricingWithNoDiscountID(String productType, String desc) {
        driver.element().select(productList, productType)
                .type(description, desc)
                .click(sendForApprovalBttn);

    }
    public void addOfferPricingWithNoDes(String productType, int discId){
        driver.element().select(productList, productType)
                .type(discountId, String.valueOf(discId))
                .keyPress(discountId, Keys.ARROW_DOWN).keyPress(discountId, Keys.ENTER)
                .click(sendForApprovalBttn);
    }
}

