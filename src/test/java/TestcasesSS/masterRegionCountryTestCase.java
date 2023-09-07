package TestcasesSS;

import Pages.DashboardPage;
import TestPackage.BasePage.TCBase;
import com.shaft.validation.Validations;
import logintest.masterRegionCountryPage;
import logintest.testLogin;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class masterRegionCountryTestCase extends TCBase {

    testLogin loginObj4;
    DashboardPage dashObj4;
    masterRegionCountryPage regionObj;
    String countyName = "Egypt";
   String noFoundText ="Search country not found. Please try again.";
   String CountryCodeNO="Country Code should be minimum 2 and maximum 3 character";
    @BeforeTest
    public void beforeTest() throws InterruptedException {

        loginObj4 = new testLogin(driver);
        loginObj4.loginWithValidData();
        dashObj4 = new DashboardPage(driver);
        dashObj4.openMaster();
    }

    @Test
    public void searchWithAllCountries() throws InterruptedException {
        regionObj = new masterRegionCountryPage(driver);
        dashObj4.openMaster();
        regionObj.searchWithAllCountries();
        Validations.verifyThat().element(regionObj.table).exists().perform();
    }

    @Test
    public void searchWithSpecificCountryName() {
        regionObj = new masterRegionCountryPage(driver);
        dashObj4.openMaster();
        regionObj.searchWithCountryName();
        driver.element().assertThat(regionObj.countryNameTable).text().isEqualTo(countyName).perform();
    }

    @Test
    public void searchWithUsingSpecificActiveCountryAndSelectInActiveAction() {
        regionObj = new masterRegionCountryPage(driver);
        dashObj4.openMaster();
        regionObj.searchWithInvalidDataUsingSpecificActive();
        driver.element().assertThat(regionObj.NotFoundTxt).text().contains(noFoundText).perform();
    }
    @Test
    public void searchingWithSpecificCountryCodeAndSelectBothOption(){
        regionObj = new masterRegionCountryPage(driver);
        dashObj4.openMaster();
        regionObj.searchingWithSpecificCountryCode();
        Validations.verifyThat().element(regionObj.table).exists().perform();

    }
    @Test
    public void addCountryAndCountryCodeWithOneCharacter() throws InterruptedException {
        regionObj = new masterRegionCountryPage(driver);
        dashObj4.openMaster();
        regionObj.addCountryAndCountryCodeWithOneCh();
        driver.element().assertThat(regionObj.CountryCodeCh).text().contains(CountryCodeNO).perform();

    }
    @Test
    public void tryToAddCountryAlreadyExists() throws InterruptedException {
        regionObj = new masterRegionCountryPage(driver);
        dashObj4.openMaster();
        regionObj.addCountryAlreadyExists();
        Validations.verifyThat().element(regionObj.nameAlreadyExist).exists().perform();
    }
}

