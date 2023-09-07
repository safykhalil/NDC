package TestPackage.BookinMidOffice.Booking;

import Pages.BookingMidOffice.Booking.RepeatSearchOneWayFlightWithDiscountChecking;
import Pages.DashboardPage;
import Pages.Login.LoginPage;
import TestPackage.BasePage.TCBase;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RepeatSearchOneWayFlightWithDiscountCheckingTC extends TCBase {
    LoginPage loginObj;
    DashboardPage dashObj;
    RepeatSearchOneWayFlightWithDiscountChecking searchOneWayObj;
    int i, finalValue = 10;
    SHAFT.TestData.JSON brOneWayData, discountData;

    @Test
    @Description("Versify Status")
    public void searchAboutOneWayFlights() throws InterruptedException {
        brOneWayData = new SHAFT.TestData.JSON(System.getProperty("testDataFolderPath") + "searchBookingBrData.json");
        discountData = new SHAFT.TestData.JSON(System.getProperty("testDataFolderPath") + "AddDiscountData.json");
        loginObj = new LoginPage(driver);
        loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openBookingPage();
        searchOneWayObj = new RepeatSearchOneWayFlightWithDiscountChecking(driver);
        for (i = 1; i <= finalValue; i++) {
            searchOneWayObj.searchAboutOneWayFlightsUsingDatesFlexibleOptionCheckingDiscountEveryTime(brOneWayData.getTestData("brName"), brOneWayData.getTestData("source")
                    , brOneWayData.getTestData("destination"), finalValue);
            if (isElementPresent(searchOneWayObj.errorMssg) && !isElementPresent(searchOneWayObj.bookNowBttn)) {
                NoSearchResults();
            } else {
                driver.element().click(searchOneWayObj.flashIcon);
                String discValue = driver.getDriver().findElement(By.xpath("//*[@id=\"one-way\"]/div[2]/div/div[1]/div/div[2]/div[2]/div[2]/div[1]/p[5]")).getText();
                Assert.assertTrue((discValue.contains(discountData.getTestData("value"))));
                driver.assertThat().element(searchOneWayObj.discountValue).isVisible();
                driver.assertThat().element(searchOneWayObj.discountValue).text().contains(discountData.getTestData("value"));
                resultsDisplayedSuccessfully();
            }
            dashObj.openBookingPage();

        }

    }

    @Step("No Search Results")
    public void NoSearchResults() {
        System.out.println("No Search Results");
    }

    @Step("Results displayed successfully")
    public void resultsDisplayedSuccessfully() {
        System.out.println("Results displayed successfully");
    }
}
