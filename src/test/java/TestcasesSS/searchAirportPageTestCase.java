package TestcasesSS;

import Pages.DashboardPage;
import TestPackage.BasePage.TCBase;
import com.shaft.validation.Validations;
import logintest.SupplierPage;
import logintest.testLogin;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class searchAirportPageTestCase extends TCBase {
    testLogin loginObj8;
    DashboardPage dashObj8;
    searchAirportPage airportObj;
    String notFound = "No Results Found";

    @BeforeTest
    public void beforeTest() throws InterruptedException {
        loginObj8 = new testLogin(driver);
        loginObj8.loginWithValidData();
        dashObj8 = new DashboardPage(driver);
        dashObj8.openMaster();
    }

    @Test
    public void searchWithAllAirportWithSelectStatusBoth() throws InterruptedException {
        airportObj = new searchAirportPage(driver);
        dashObj8.openMaster();
        airportObj.openAirlineSearchPage();
        airportObj.searchWithAllAirport();
        airportObj.searchButton();
        Validations.verifyThat().element(airportObj.table).exists().perform();
    }

    @Test
    public void searchWithSpecificIATACodeOnly() throws InterruptedException {
        airportObj = new searchAirportPage(driver);
        Thread.sleep(1000);
        dashObj8.openMaster();
        airportObj.openAirlineSearchPage();
        airportObj.searchWithSpecificIATACode();
        airportObj.searchButton();
        driver.element().assertThat(airportObj.IATACodeTable).text().contains("IST").perform();
    }

    @Test
    public void searchWithSpecificCountryOnly() throws InterruptedException {
        airportObj = new searchAirportPage(driver);
        Thread.sleep(1000);
        dashObj8.openMaster();
        airportObj.openAirlineSearchPage();
        airportObj.searchWithSpecificCountry();
        Thread.sleep(1000);
        //  Validations.verifyThat().object(airportObj.identicalData).isTrue().perform();
        driver.element().assertThat(airportObj.countryTable).text().contains("Yemen").perform();

    }

    @Test
    public void searchWithActiveCityAndCountryOnly() throws InterruptedException {
        airportObj = new searchAirportPage(driver);
        dashObj8.openMaster();
        airportObj.openAirlineSearchPage();
        airportObj.searchWithActiveCityAndCountry();
        airportObj.searchButton();
        driver.element().assertThat(airportObj.IATACodeTableABS).text().contains("ABS").perform();
    }

    @Test
    public void searchWithActiveCodCountryAndCity() throws InterruptedException {
        airportObj = new searchAirportPage(driver);
        Thread.sleep(1000);
        dashObj8.openMaster();
        airportObj.openAirlineSearchPage();
        airportObj.searchWithActiveCodCountryAndCity();
        airportObj.searchButton();
        Validations.verifyThat().element(airportObj.table).exists().perform();

    }

    @Test
    public void searchWithSelectTrainStation() throws InterruptedException {
        airportObj = new searchAirportPage(driver);
        Thread.sleep(1000);
        dashObj8.openMaster();
        airportObj.openAirlineSearchPage();
        airportObj.searchWithTrainStation();
        airportObj.searchButton();
        Validations.verifyThat().element(airportObj.table).exists().perform();

    }

    @Test
    public void searchWithActiveStatusToCheckDataInViewTable() throws InterruptedException {
        airportObj = new searchAirportPage(driver);
        dashObj8.openMaster();
        airportObj.openAirlineSearchPage();
        airportObj.searchWithActiveDataToCheckViewTable();
        Validations.verifyThat().element(airportObj.viewTable).exists().perform();
        driver.element().click(airportObj.cancelView);
    }

    @Test
    public void searchWithSelectBusStation() throws InterruptedException {
        airportObj = new searchAirportPage(driver);
        Thread.sleep(1000);
        dashObj8.openMaster();
        airportObj.openAirlineSearchPage();
        airportObj.searchWithBusStation();
        driver.element().assertThat(airportObj.stationAdd).text().contains("Bus").perform();
    }

    //character
    @Test
    public void searchWithInvalidInput() throws InterruptedException {
        airportObj = new searchAirportPage(driver);
        Thread.sleep(1000);
        dashObj8.openMaster();
        airportObj.openAirlineSearchPage();
        airportObj.searchWithInValidIATACode();
        airportObj.searchButton();
        driver.element().assertThat(airportObj.msgNoTFound).text().contains(notFound).perform();

    }

    //number
    @Test
    public void SearchWithInValidInputInIATACode() throws InterruptedException {
        airportObj = new searchAirportPage(driver);
        Thread.sleep(1000);
        dashObj8.openMaster();
        airportObj.openAirlineSearchPage();
        airportObj.searchInIATACodeWithNumber();
        airportObj.searchButton();
        Validations.verifyThat().element(airportObj.airportCodeError).exists().perform();
    }


}




