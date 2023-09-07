package PortalPackage;

import Portal.Booking;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BookingTC extends PortalLoginTC {

    Booking NewBooking;
    OneWayFlightSearchTC OWFObject;
    PortalLoginTC PortalLoginObject5;


    @Test
    public void placingBookingWithValidData() throws InterruptedException {
        // PortalLoginObject5 = new PortalLoginTC();
        //PortalLoginObject5.PortalLoginWithValidCredentials();
        OWFObject = new OneWayFlightSearchTC();
        OWFObject.SearchForOneWayFlightWithValidData();
        NewBooking = new Booking(driver);
        //NewBooking.placingBooking();
        NewBooking.placingBookingAirCairo();

        driver.assertThat().element(By.xpath("//*[@id=\"order-details\"]/div[1]/table/tbody/tr[3]/td[1]/p")).isVisible();

    }

}
