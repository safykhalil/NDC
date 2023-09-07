package TestPackage.WalletIncrease;

import Pages.BookingMidOffice.SearchBooking.CancelAndRefundBooking;
import TestPackage.Login.LoginPageTC;
import TestPackage.BasePage.TCBase;
import org.testng.annotations.Test;


public class CancelAndRefundBookingTC extends TCBase {
    CancelAndRefundBooking CancelAndRefundBookingObj;
    LoginPageTC loginObject;

    @Test
    public void CancelAndRefundBookingWithValidCriteria() throws InterruptedException {
        loginObject  = new LoginPageTC();
        loginObject.loginWithValidCredentials();
        CancelAndRefundBookingObj = new CancelAndRefundBooking (driver);
        CancelAndRefundBookingObj.cancelAndRefundBookingWithValidData();
        //driver.assertThat().element(By.xpath("//*[@id=\"itenary\"]/div[3]/div[1]/div[2]/table[3]/tbody/tr[2]/td[4]")).isVisible();
    }

}
