package PortalPackage;

import Portal.Booking;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
public class BookingRoundTripTC extends PortalLoginTC{

    RoundTripFlightSearchTC RoundTripObj;
    Booking BookingObj;





    @Test
    public void bookingTicketRoundValidSData() throws InterruptedException{

        RoundTripObj = new RoundTripFlightSearchTC();
        RoundTripObj.SearchForRTFlightWithValidData();
        BookingObj= new Booking(driver);
        BookingObj.placingBookingAirCairoRoundTrip();
        driver.assertThat().element(By.xpath("//*[@id=\"order-details\"]/div[1]/table/tbody/tr[3]/td[1]/p")).isVisible();






    }
}
