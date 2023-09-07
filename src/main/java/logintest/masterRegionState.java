package logintest;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class masterRegionState extends BasePage {
    public masterRegionState(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By state = By.xpath("//*[@id=\"region_content\"]/ul/li[2]/a");
    By Search = By.xpath("//*[@id=\"searchStateForm\"]/div[4]/input");
    By StateName = By.id("search_state");
    By addStateName = By.id("create_state_name");
    public By addStateNameTxt = By.id("unique_state_name");
    By StateCode = By.id("searchStateCode");
    By addStateCode = By.id("create_state_code");
    public By addStateCodeTxt = By.id("stateCodeErr");
    By CountryName = By.id("search_state_country_name");
    By addCountryName = By.id("create_state_country_name");
    By Add = By.id("add_state");
    By senForApproval = By.xpath("//*[@id=\"createStateForm\"]/div[4]/input");
    By inactive = By.xpath("//*[@id=\"searchStateForm\"]/div[3]/div/div/ul/li[1]/label/label");
    By active = By.xpath("//*[@id=\"searchStateForm\"]/div[3]/div/div/ul/li[2]/label/label");
    By both = By.xpath("//*[@id=\"searchStateForm\"]/div[3]/div/div/ul/li[3]/label/label");
    By egypt = By.xpath("//*[@id=\"ui-id-13\"]");
    By Miscellaneous = By.id("Miscellaneous");
    By region = By.id("regionMisc");
    public By table = By.id("DataTables_Table_0");
    public boolean identicalData;
    List<WebElement> rows;
    By tableRows = By.tagName("tr");
    By byTableData = By.tagName("td");
    public By countryNameTable = By.xpath("//*[@id=\"tr_3615\"]/td[4]");
    public By stateNameTable = By.xpath("//*[@id=\"tr_332\"]/td[3]");
    public By notFound = By.xpath("//*[@id=\"search_state_fail\"]");

    public String expectedResult = "http://192.168.1.60:8080/odeysysadmin/Master/addRegion";
    public String actualUrl;


    public void searchWithAllState() throws InterruptedException {
        driver.element().click(Miscellaneous);
        Thread.sleep(2000);
        driver.element().click(region);
        Thread.sleep(2000);
        driver.element().click(state);
        Thread.sleep(2000);
        driver.element().click(both);


    }

    public void searchButton() {
        driver.element().click(Search);
    }

    public void searchWithActiveCountry() throws InterruptedException {
        driver.element().click(Miscellaneous);
        Thread.sleep(1000);
        driver.element().click(region);
        Thread.sleep(1000);
        driver.element().click(state);
        Thread.sleep(2000);
        driver.element().click(active)
                .type(CountryName, "Egypt");
        Thread.sleep(1500);
        driver.element().keyPress(CountryName, Keys.ARROW_DOWN);
        driver.element().keyPress(CountryName, Keys.ENTER);
        Thread.sleep(2000);
        driver.element().click(Search);
        Thread.sleep(2000);
        checkDataInStateTable(3, "Egypt");

    }

    private void checkDataInStateTable(int colNumber, String data) {
        identicalData = true;
        rows = driver.getDriver().findElements(tableRows);
        int index = 1;
        while (!rows.isEmpty() && index < rows.size() && identicalData) {
            WebElement row = rows.get(index);
            List<WebElement> cols = row.findElements(byTableData);
            if (cols.get(colNumber).getText().toLowerCase().equals(data.toLowerCase())) {
                identicalData = true;
            } else {
                identicalData = false;
            }
            index++;
        }
    }

    public void searchWithStateNameAndCodeANdCountry() throws InterruptedException {
        driver.element().click(Miscellaneous);
        Thread.sleep(1000);
        driver.element().click(region);
        Thread.sleep(1000);
        driver.element().click(state)
                .type(StateName, "Adana")
                .type(StateCode, "ADAN")
                .type(CountryName, "Turkey");

    }

    public void searchWithStateCode() throws InterruptedException {
        driver.element().click(Miscellaneous);
        Thread.sleep(1000);
        driver.element().click(region);
        Thread.sleep(1000);
        driver.element().click(state)
                .type(StateCode, "MANA"); //Manama
        driver.element().click(inactive);
        Thread.sleep(1000);
    }

    public void searchWithInactive() throws InterruptedException {
        driver.element().click(Miscellaneous);
        Thread.sleep(1000);
        driver.element().click(region);
        Thread.sleep(1000);
        driver.element().click(state);
        Thread.sleep(1000);
        driver.element().click(inactive);
        Thread.sleep(1000);
        driver.element().click(Search);
    }

    public void addStateName() throws InterruptedException {
        driver.element().click(Miscellaneous);
        Thread.sleep(1000);
        driver.element().click(region);
        Thread.sleep(1000);
        driver.element().click(state);
        Thread.sleep(1000);
        driver.element().click(Add);
        Thread.sleep(1000);
        driver.element().type(addStateName, "Giza");
        Thread.sleep(1000);
        driver.element().type(addStateCode, "GI");
        Thread.sleep(1000);
        driver.element().type(addCountryName, "Egypt");
        Thread.sleep(1500);
        driver.element().keyPress(addCountryName, Keys.ARROW_DOWN);
        driver.element().keyPress(addCountryName, Keys.ENTER);
        Thread.sleep(1000);
        driver.element().click(senForApproval);

    }

    public void addStateNameByStateCode() throws InterruptedException {
        driver.element().click(Miscellaneous);
        Thread.sleep(1000);
        driver.element().click(region);
        Thread.sleep(1000);
        driver.element().click(state);
        Thread.sleep(1000);
        driver.element().click(Add);
        Thread.sleep(1000);
        driver.element().type(addStateName, "Giza");
        Thread.sleep(1000);
        driver.element().type(addStateCode, "G");
        Thread.sleep(1000);
        driver.element().type(addCountryName, "Egypt");
        Thread.sleep(1500);
        driver.element().keyPress(addCountryName, Keys.ARROW_DOWN);
        driver.element().keyPress(addCountryName, Keys.ENTER);
        Thread.sleep(1000);
        driver.element().click(senForApproval);
    }

    public void checkCurrentUrl() throws InterruptedException {
        driver.element().click(Miscellaneous);
        Thread.sleep(1000);
        driver.element().click(region);
        Thread.sleep(1000);
        driver.element().click(state);
        Thread.sleep(1000);
        driver.element().click(Add);
        actualUrl = driver.browser().getCurrentURL();

    }

    public void SearchWithInvalidData() throws InterruptedException {
        driver.element().click(Miscellaneous);
        Thread.sleep(1000);
        driver.element().click(region);
        Thread.sleep(1000);
        driver.element().click(state)
                .type(StateName, "Alexandria")
                .type(StateCode, "ALEX");
        driver.element().type(CountryName, "Egypt");
        Thread.sleep(1500);
        driver.element().keyPress(CountryName, Keys.ARROW_DOWN);
        driver.element().keyPress(CountryName, Keys.ENTER);
        driver.element().click(inactive);


    }

}