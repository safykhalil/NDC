package Pages.Admin.Country;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class AddNewCountry extends BasePage {
    public AddNewCountry(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By OperatingCountryName = By.id("groupName");
    By SelectCountry = By.id("orgModal.country");
    By SelectCurrency = By.id("orgModal.currencyId");
    By SendForApprovalBttn = By.xpath("/html/body/div/section/div/div[2]/div/div/form/div[2]/input[1]");
    public By confmssg = By.id("statusMsg");

    public void AddaNewCountry(String countryname, String country, String currency) {
        driver.element().type(OperatingCountryName, countryname);
        driver.element().select(SelectCountry, "Egypt");
        driver.element().select(SelectCurrency, "Egyptian Pound (EGP)");
        driver.element().click(SendForApprovalBttn);

    }
}