package PortalPackage;

import Portal.OneWayFlightsSearch;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class OneWayFlightSearchTC extends PortalLoginTC {

    OneWayFlightsSearch SearchOWFlightObj;
    PortalLoginTC PortalLoginObj2;


    @Test
    public void SearchForOneWayFlightWithValidData() throws InterruptedException {
        PortalLoginObj2 = new PortalLoginTC();
        PortalLoginObj2.PortalLoginWithValidCredentials();
        SearchOWFlightObj = new OneWayFlightsSearch(driver);
        SearchOWFlightObj.searchForOneWayFlight("CAI" ,"SSH");
        driver.assertThat().element(By.xpath("//*[@id=\"one-way\"]/div[2]/div/div[1]/div/div[2]/div[1]/div/div/div[1]/div[1]/input")).isChecked();
    }

}

