package logintest;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class masterRegionCountryPage extends BasePage {
    public masterRegionCountryPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By country = By.xpath("//*[@id=\"region_content\"]/ul/li[1]");
    By state = By.xpath("//*[@id=\"region_content\"]/ul/li[2]");
    By Miscellaneous = By.id("Miscellaneous");
    By region = By.id("regionMisc");
    By countryName = By.id("search_country");
    By countryCode = By.id("search_country_code");
    By search = By.xpath("//*[@id=\"searchCountryForm\"]/div[2]/input");
    By inActive = By.xpath("//*[@id=\"searchCountryForm\"]/div[1]/div[3]/div/ul/li[1]/label/label");
    By Both =By.xpath("//*[@id=\"searchCountryForm\"]/div[1]/div[3]/div/ul/li[3]/label/label");
    By add =By.id("add_country");
    By SendForApproval =By.xpath("//*[@id=\"createCountryForm\"]/div[5]/input");

    By addCountryName = By.id("create_country_name");
    By addCountryCode =By.id("create_country_code");
    public By CountryCodeCh=By.id("countryCodeErr");
    public By NotFoundTxt = By.id("search_country_fail");
    public By countryNameTable = By.xpath("//*[@id=\"tr_67\"]/td[3]");
    public By table = By.id("country_table");
   public By nameAlreadyExist = By.xpath("//*[@id=\"unique_country_name\"]/span");


    //happy scenarios
    public void searchWithAllCountries() throws InterruptedException {
        driver.element().click(Miscellaneous)
                .click(region);
        Thread.sleep(2000);
        driver.element().click(search);
    }
    public void searchingWithSpecificCountryCode(){
        driver.element().click(Miscellaneous)
                .click(region)
                .type(countryCode,"AD")
                .click(Both)
                .click(search);
    }
    public void searchWithCountryName() {
        driver.element().click(Miscellaneous)
                .click(region)
                .type(countryName, "Egypt")
                .click(search);
    }

    //negative scenarios
    public void searchWithInvalidDataUsingSpecificActive() {
        driver.element().click(Miscellaneous)
                .click(region)
                .type(countryName, "Egypt")
                .click(inActive)
                .click(search);

    }

    public void addCountryAndCountryCodeWithOneCh() throws InterruptedException {
        driver.element().click(Miscellaneous)
                .click(region);
        Thread.sleep(2000);
        driver.element().click(add);
        Thread.sleep(3000);
        driver.element().type(addCountryName,"Turkiye")
                .type(addCountryCode,"T")
                .click(SendForApproval);

    }
    public void addCountryAlreadyExists() throws InterruptedException {
        driver.element().click(Miscellaneous)
                .click(region);
        Thread.sleep (2000);
        driver.element().click(add);
        Thread.sleep(3000);
        driver.element().type(addCountryName,"Armenia")
                .type(addCountryCode,"AM")
                .click(SendForApproval);
    }
}
