package TestcasesSS;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class searchAirportPage extends BasePage {
    public searchAirportPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By flightButton = By.id("Flight");
    By airPortButton = By.id("airportMaster");
    By IATACode = By.id("iataCode");
    By airportName = By.id("airportNameAuto");
    public By airportCodeError = By.id("airportCodeError");
    By country = By.id("countryID");
    By city = By.id("cityId");
    By add = By.id("airport_add");
    By type = By.xpath("//*[@id=\"select_option_wrap-button\"]/span[2]");
    By station = By.xpath("//*[@id=\"stationType-button\"]/span[2]");
    public By stationAdd = By.xpath("//*[@id=\"select_option_wrap-button\"]/span[2]");
    By actionEdit = By.xpath("//*[@id=\"tr_8686\"]/td[7]/a/img");
    By search = By.xpath("//*[@id=\"airPortSearch\"]/div[4]/input");
    By inactive = By.xpath("//*[@id=\"airPortSearch\"]/div[3]/div/div/ul/li[1]/label");
    By active = By.xpath("//*[@id=\"airPortSearch\"]/div[3]/div/div/ul/li[2]/label");
    By yemen = By.xpath("//*[@id=\"ui-id-4\"]");
    By train = By.xpath("//*[@id=\"ui-id-6\"]");
    By bus = By.xpath("//*[@id=\"ui-id-7\"]");
    By view = By.xpath("//*[@id=\"air_tb\"]/input[2]");
    By activeTable = By.xpath("(//span[@class='bg_active'])[1]");
    public By viewTable = By.xpath("//*[@id=\"viewTable\"]/div/div");
    By both = By.xpath("//*[@id=\"airPortSearch\"]/div[3]/div/div/ul/li[3]/label");
    public By table = By.id("air_tb");
    public By msgNoTFound = By.id("msg");
    public By IATACodeTable = By.xpath("//*[@id=\"tr_3135\"]/td[2]");
    public By countryTable = By.xpath("//*[@id=\"tr_6819\"]/td[4]");
    public By IATACodeTableABS = By.xpath("//*[@id=\"tr_42\"]/td[2]");
    public By cancelView = By.xpath("//*[@id=\"viewTable\"]/div/div/div[1]/button/span[1]");

//    public boolean identicalData;
//    List<WebElement> rows;
//    By tableRows = By.tagName("tr");
//    By byTableData = By.tagName("td");


    public void searchButton() {
        driver.element().click(search);
    }

    public void searchWithAllAirport() {
        driver.element().click(both);
    }

    public void openAirlineSearchPage() throws InterruptedException {
//        driver.element().click(flightButton);
//                Thread.sleep(10000);
        driver.element().click(airPortButton);
    }

    public void searchWithSpecificIATACode() {
        driver.element().click(IATACode)
                .type(IATACode, "IST")
                .click(both);
    }

    public void searchWithSpecificCountry() throws InterruptedException {
        driver.element().type(country, "Yem");
        Thread.sleep(1000);
        driver.element().keyPress(country, Keys.ARROW_DOWN);
        Thread.sleep(1000);
        driver.element().keyPress(country, Keys.ENTER);
        Thread.sleep(1000);
        driver.element().click(both)
                .click(search);
//        Thread.sleep(1000);
//        checkDataInTable(2, "Yemen");

    }

//    private void checkDataInTable(int colNumber, String data) {
//        identicalData = true;
//        rows = driver.getDriver().findElements(tableRows);
//        int index = 1;
//        while (!rows.isEmpty() && index < rows.size() && identicalData) {
//            WebElement row = rows.get(index);
//            List<WebElement> cols = row.findElements(byTableData);
//            if (cols.get(colNumber).getText().toLowerCase().equals(data.toLowerCase())) {
//                identicalData = true;
//            } else {
//                identicalData = false;
//            }
//            index++;
//        }
//    }

    public void searchWithActiveCityAndCountry() throws InterruptedException {
        driver.element().type(country, "Egyp");
        Thread.sleep(1000);
        driver.element().keyPress(country, Keys.ARROW_DOWN);
        Thread.sleep(1000);
        driver.element().keyPress(country, Keys.ENTER)
                .click(active)
                .type(city, "Abu Simb");
        Thread.sleep(1000);
        driver.element().keyPress(city, Keys.ARROW_DOWN)
                .keyPress(city, Keys.ENTER);
    }

    public void searchWithActiveCodCountryAndCity() throws InterruptedException {
        driver.element().click(IATACode)
                .type(IATACode, "BSR");
        Thread.sleep(1000);
        driver.element().type(country, "Ira");
        Thread.sleep(1000);
        driver.element().keyPress(country, Keys.ARROW_DOWN);
        Thread.sleep(1000);
        driver.element().keyPress(country, Keys.ENTER)
                .click(active)
                .type(city, "Basr");
        Thread.sleep(1000);
        driver.element().keyPress(city, Keys.ARROW_DOWN)
                .keyPress(city, Keys.ENTER)
                .click(active);
    }

    public void searchWithTrainStation() {
        driver.element().click(station)
                .click(train);

    }

    public void searchWithActiveDataToCheckViewTable() {
        driver.element().click(active)
                .click(search)
                .click(view);
    }

    public void searchWithBusStation() {
        driver.element().click(station)
                .click(bus)
                .click(search)
                .click(actionEdit);


    }

    public void searchWithInValidIATACode() {
        driver.element().click(IATACode)
                .type(IATACode, "WOY");
    }

    public void searchInIATACodeWithNumber() {
        driver.element().click(IATACode)
                .type(IATACode, "111");
    }

    public void searchWithActiveIATAAndChangeStatusToInactive() throws InterruptedException {
        driver.element().click(IATACode)
                .type(IATACode, "TAI")
                .type(country, "Yem");
        Thread.sleep(1000);
        driver.element().keyPress(country, Keys.ARROW_DOWN);
        Thread.sleep(1000);
        driver.element().keyPress(country, Keys.ENTER)
                .type(city, "Taiz");
        Thread.sleep(1000);
        driver.element().keyPress(city, Keys.ARROW_DOWN)
                .keyPress(city, Keys.ENTER)
                .click(active)
                .click(activeTable);
        driver.element().click(IATACode)
                .type(IATACode, "TAI")
                .type(country, "Yem");
        Thread.sleep(1000);
        driver.element().keyPress(country, Keys.ARROW_DOWN);
        Thread.sleep(1000);
        driver.element().keyPress(country, Keys.ENTER)
                .type(city, "Taiz");
        Thread.sleep(1000);
        driver.element().keyPress(city, Keys.ARROW_DOWN)
                .keyPress(city, Keys.ENTER)
                .click(inactive);




    }
}