package TestcasesSS;

import Pages.DashboardPage;
import TestPackage.BasePage.TCBase;
import com.shaft.validation.Validations;
import logintest.RateOfExchangePage;
import logintest.testLogin;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RateOfExchangeTestCase extends TCBase {
    testLogin loginObj3;
    DashboardPage dashObj3;
    RateOfExchangePage rateobj;

    @BeforeTest
    public void beforeTest() throws InterruptedException {

        loginObj3 = new testLogin(driver);
        loginObj3.loginWithValidData();
        dashObj3 = new DashboardPage(driver);
        dashObj3.openMaster();
    }
    //Search Rate of Exchange
    @Test
    public void searchWithAllCurrencies(){
        rateobj = new RateOfExchangePage(driver);
        dashObj3.openMaster();
        rateobj.searchWithAllCurrencies();
        Validations.verifyThat().element(rateobj.table).exists().perform();
    }
    @Test
    public void SearchRateOfExchangeFromDollarToPound(){
        rateobj = new RateOfExchangePage(driver);
        dashObj3.openMaster();
        rateobj.searchFromDollarToPound();
        Validations.verifyThat().element(rateobj.table).exists().perform();
    }
    @Test
    public void addExchangeRateFromDollarToEuro() throws InterruptedException {
        rateobj = new RateOfExchangePage(driver);
        dashObj3.openMaster();
        rateobj.addExchangeRate();
        driver.element().assertThat(rateobj.addSuccessText).text().contains("Rate Of Exchange Saved Successfully!!!").perform();
    }
    //assert Egyptian Pound(EGP)
   @Test
    public void searchWithFromEGPToAllCurrencies(){
       rateobj = new RateOfExchangePage(driver);
       dashObj3.openMaster();
       rateobj.searchWithFromEGP();
    Validations.verifyThat().object(rateobj.identicalData).isTrue().perform();
}

}
