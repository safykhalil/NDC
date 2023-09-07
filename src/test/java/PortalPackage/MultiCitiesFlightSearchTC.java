package PortalPackage;

import Portal.MultiCitiesFlightSearch;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class MultiCitiesFlightSearchTC extends PortalLoginTC {

    MultiCitiesFlightSearch SearchMCFlightObj;
    PortalLoginTC PortalLoginObj4;

    @Test
    public void SearchForMCFlightWithValidData () throws InterruptedException {
        PortalLoginObj4 = new PortalLoginTC();
        PortalLoginObj4.PortalLoginWithValidCredentials();
        SearchMCFlightObj = new MultiCitiesFlightSearch(driver);
        SearchMCFlightObj.searchMCFlightsSearch();
        driver.assertThat().element(By.xpath("//*[@id=\"round-trip\"]/div[2]/div/div[1]/div/div[2]/div[1]/div/div/div[1]/div[1]/input")).isChecked();
    }
}
