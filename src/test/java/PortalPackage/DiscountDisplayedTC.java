package PortalPackage;


import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.RuleEngine.AddRuleEngine.AddDiscountPage;
import Pages.RuleEngine.SearchRuleEngine.SearchDiscountPage;
import Portal.DiscountActivated;
import Portal.OneWayFlightsSearch;
import Portal.PortalLoginPage;
import TestPackage.BasePage.TCBase;
import com.shaft.driver.SHAFT;
import org.testng.annotations.Test;

import java.util.Random;

public class DiscountDisplayedTC extends TCBase {
    OneWayFlightsSearch oneWay;
    DiscountActivated discountWork;
    AddDiscountPage discount;
    SearchDiscountPage searchDiscount;
    LoginPage loginobj;
    DashboardPage dashObj;
    SHAFT.TestData.JSON discountData;
    PortalLoginPage portalloginobject;

    @Test
    public void MakeSureThatDiscountActivated() throws InterruptedException {
        discountData = new SHAFT.TestData.JSON(System.getProperty("testDataFolderPath") + "AddDiscountData.json");
        loginobj = new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openAddDiscountPage();
        discount = new AddDiscountPage(driver);
        int maxNumber = 100;
        Random rand = new Random();
        int randomNumber = rand.nextInt(maxNumber);
        discount.addDiscountWithValidCriteria
                (discountData.getTestData("productType"),
                        discountData.getTestData("discountName") + randomNumber,
                        discountData.getTestData("discountDescription"),
                        discountData.getTestData("country"),
                        discountData.getTestData("supplier"),
                        discountData.getTestData("fareType"),
                        discountData.getTestData("Amount"),
                        discountData.getTestData("value"));
        Thread.sleep(10000);
        discount.SendForApproval();
        searchDiscount = new SearchDiscountPage(driver);
        searchDiscount.approveNewDiscountRequest();
        driver.browser().navigateToURL("http://192.168.1.60:8080/odeysysportal/"); // navigate to portal to view discount
        portalloginobject = new PortalLoginPage(driver);
        portalloginobject.PortalLoginWithValidData();
        oneWay = new OneWayFlightsSearch(driver);
        oneWay.searchForOneWayFlight("CAI", "DXB");
        discountWork = new DiscountActivated(driver);
        discountWork.MakeSureDiscountIsActivated();
        Thread.sleep(1000);
        driver.assertThat().element(discountWork.discountValue).isVisible();
        driver.assertThat().element(discountWork.discountValue).text().contains(discountData.getTestData("value"));


    }
}