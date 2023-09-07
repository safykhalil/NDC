package PortalPackage;

import Portal.RoundTripFlightSearch;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class RoundTripFlightSearchTC extends PortalLoginTC {

    RoundTripFlightSearch  SearchRTFlightObj;
    PortalLoginTC PortalLoginObj3;

    @Test
    public void SearchForRTFlightWithValidData () throws InterruptedException {
        PortalLoginObj3 = new PortalLoginTC();
        PortalLoginObj3.PortalLoginWithValidCredentials();
        SearchRTFlightObj = new RoundTripFlightSearch(driver);
        SearchRTFlightObj.searchRoundTripFlightSearch();
        driver.assertThat().element(By.xpath("//*[@id=\"round-trip\"]/div[2]/div/div[1]/div/div[2]/div[1]/div/div/div[1]/div[1]/input")).isChecked();
    }
}

