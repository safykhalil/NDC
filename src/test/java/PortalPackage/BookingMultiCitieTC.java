package PortalPackage;

import Portal.Booking;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
public class BookingMultiCitieTC extends PortalLoginTC{

    MultiCitiesFlightSearchTC MultiCityOb;

    Booking BookingObj;

    @Test
    public void bookingTicketMultiCityValidSData() throws InterruptedException{

        MultiCityOb = new MultiCitiesFlightSearchTC();
        MultiCityOb.SearchForMCFlightWithValidData();
        BookingObj= new Booking(driver);
        BookingObj.placingBookingMultiCityAirCairo();
        driver.assertThat().element(By.xpath("//*[@id=\"order-details\"]/div[1]/table/tbody/tr[3]/td[1]/p")).isVisible();






    }
}