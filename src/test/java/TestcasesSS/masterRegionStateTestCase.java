package TestcasesSS;

import Pages.DashboardPage;
import TestPackage.BasePage.TCBase;
import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import logintest.masterRegionCountryPage;
import logintest.masterRegionState;
import logintest.testLogin;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class masterRegionStateTestCase extends TCBase {
    testLogin loginObj5;
    DashboardPage dashObj5;
    masterRegionState stateObj;
    String stateText = "State name already exists.";
    String CodeTxt = "State Code should be minimum 2 and maximum 50 character";

    String notFoundText = "Search state not found. Please try again.";

    @BeforeTest
    public void beforeTest() throws InterruptedException {
        loginObj5 = new testLogin(driver);
        loginObj5.loginWithValidData();
        dashObj5 = new DashboardPage(driver);
        dashObj5.openMaster();
    }

    @Test
    public void searchWithAllStateAndSelectOptionBoth() throws InterruptedException {
        stateObj = new masterRegionState(driver);
        dashObj5.openMaster();
        stateObj.searchWithAllState();
        Thread.sleep(1000);
        stateObj.searchButton();
        Validations.verifyThat().element(stateObj.table).exists().perform();
    }

    @Test
    public void searchWithActiveCountry() throws InterruptedException {
        stateObj = new masterRegionState(driver);
        dashObj5.openMaster();
        stateObj.searchWithActiveCountry();
        Validations.verifyThat().object(stateObj.identicalData).isTrue().perform();
    }

    @Test
    public void searchWithActiveStateNameAndCodeANdCountry() throws InterruptedException {
        stateObj = new masterRegionState(driver);
        dashObj5.openMaster();
        stateObj.searchWithStateNameAndCodeANdCountry();
        stateObj.searchButton();
        driver.element().assertThat(stateObj.countryNameTable).text().contains("Turkey").perform();
    }

    @Test
    public void searchWithInactiveStateCodeOnly() throws InterruptedException {
        stateObj = new masterRegionState(driver);
        dashObj5.openMaster();
        stateObj.searchWithStateCode(); //Manama
        stateObj.searchButton();
        driver.element().assertThat(stateObj.stateNameTable).text().isEqualTo("Manama").perform();

    }

    @Test
    public void searchWithSelectInactiveOption() throws InterruptedException {
        stateObj = new masterRegionState(driver);
        dashObj5.openMaster();
        stateObj.searchWithInactive();
        stateObj.searchButton();
        Validations.verifyThat().element(stateObj.table).exists().perform();
    }

    @Test
    public void searchWithUsingActiveDataAndSelectInactiveOption() throws InterruptedException {
        stateObj = new masterRegionState(driver);
        dashObj5.openMaster();
        stateObj.SearchWithInvalidData();
        stateObj.searchButton();
        Thread.sleep(1000);
        driver.element().assertThat(stateObj.notFound).text().contains(notFoundText).perform();

    }

    //add
    @Test
    public void addStateNameAlreadyExists() throws InterruptedException {
        stateObj = new masterRegionState(driver);
        dashObj5.openMaster();
        stateObj.addStateName();
        driver.element().assertThat(stateObj.addStateNameTxt).text().contains(stateText).perform();

    }

    @Test
    public void addStateNameUsingInvalidStateCode() throws InterruptedException {
        stateObj = new masterRegionState(driver);
        dashObj5.openMaster();
        stateObj.addStateNameByStateCode();
        driver.element().assertThat(stateObj.addStateCodeTxt).text().contains(CodeTxt).perform();
    }

//    @Test
//    public void checkCurrentUrl() throws InterruptedException {
//        stateObj = new masterRegionState(driver);
//        dashObj5.openMaster();
//        stateObj.checkCurrentUrl();
//        String actualResult = driver.browser().getCurrentURL();
//        Validations.verifyThat().object(stateObj.actualUrl).contains(stateObj.expectedResult).perform();
    }


