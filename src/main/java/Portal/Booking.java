package Portal;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


public class Booking {
    public SHAFT.GUI.WebDriver driver;

    public Booking(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    By UncheckboxOneWay = By.xpath("//*[@id=\"one-way\"]/div[2]/div/div[1]/div/div[2]/div[1]/div/div/div[1]/div[1]/input");
    By UncheckboxRound = By.xpath("//*[@id=\"round-trip\"]/div[2]/div/div[1]/div/div[2]/div[1]/div/div/div[1]/div[1]/input");

    By RefundableTrip = By.xpath("//*[@id=\"one-way\"]/div[2]/div/div[4]/div/div[2]/div[2]/div[2]/div/div/p");
    By BookNowRound = By.xpath("//*[@id=\"round-trip\"]/div[2]/div/div[1]/div/div[2]/div[2]/div[2]/div/a");
    By BookNowOneWay = By.xpath("//*[@id=\"one-way\"]/div[2]/div/div[1]/div/div[2]/div[2]/div[2]/div/a");
    By BookNowMulti= By.xpath("//*[@id=\"round-trip\"]/div[2]/div/div[1]/div/div[2]/div[2]/div[2]/div/a");

    By Continue = By.xpath("//*[@id=\"up\"]/div[2]/div/div[1]/div[2]/div/a[1]");
    By CheckboxTNC = By.xpath("//*[@id=\"iAccept\"]");
    By ContinueBttn = By.xpath("//*[@id=\"chklogin\"]/div[1]/div[4]/div[1]/div[4]/a");
    By Title = By.xpath("//*[@id=\"passengerTitle_0\"]");
    By FirstName = By.id("passengerFirstName_0");
    By LastName = By.id("passengerLastName_0");
    By DOB = By.id("passengerDob_0");
    By YearofBirth = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]");
    By DayofBirth = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[3]/a");
    By CountryCode = By.xpath("//*[@id=\"passengerCountryCode_0\"]");
    By EgyptCode = By.xpath("//*[@id=\"ui-id-1419\"]");
    By MobileNo = By.id("passengerMobile_0");
    By Gender = By.id("passengerGender_0");
    By Passport = By.id("passengerPassport_0");
    By ExpiryDate = By.id("passengerPassExp_0");
    By ExpiryYear = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]");
    By ExpiryDay = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[3]/a");
    By Nationality = By.xpath("//*[@id=\"passengerNationality_0\"]");
    By Egypt = By.xpath("//*[@id=\"ui-id-3\"]");
    By BookNPay = By.id("bookButtonShowHide");
    By EgyptAuto = By.xpath("//*[@id=\"ui-id-1\"]");
    By textField = By.xpath("//*[@id=\"order-details\"]/div[1]/table/tbody/tr[3]/td[1]/strong");



    public void placingBooking() throws InterruptedException {
        driver.element().click(UncheckboxOneWay)
                .scrollToElement(RefundableTrip)
                .click(BookNowRound)
                //  .click(Continue)
                .click(CheckboxTNC)
                .click(ContinueBttn)
                .click(Title)
                .select(Title, "Ms")
                .type(FirstName, "Test")
                .type(LastName, "Tesssst")
                .click(DOB)
                .click(YearofBirth)
                .select(YearofBirth, "2000")
                .click(DayofBirth)
                .click(Gender)
                .select(Gender, "Female")
                .type(Passport, "a5464617")
                .click(ExpiryDate)
                .click(ExpiryYear)
                .select(ExpiryYear, "2030")
                .click(ExpiryDay)
                .type(Nationality, "Egy")
                .click(EgyptAuto)
                .click(BookNPay);


        driver.getDriver().switchTo().alert().accept();
        Thread.sleep(20000);

        //driver.element().clipboardActions(textField,"select all");
        // driver.element().clipboardActions(textField, "copy");


    }

    public void placingBookingAirCairo() throws InterruptedException {
        //driver.element().click(UncheckboxRound)
                //.scrollToElement(RefundableTrip)
                //.click(RefundableTrip)
                driver.element().click(BookNowOneWay)
                //  .click(Continue)
                .click(CheckboxTNC)
                .click(ContinueBttn)
                .click(Title)
                .select(Title, "Ms")
                .type(FirstName, "Test")
                .type(LastName, "Tesssst")
                .click(DOB)
                .click(YearofBirth)
                .select(YearofBirth, "2000")
                .click(DayofBirth)
                .click(Gender)
                .select(Gender, "Female")
                .type(Passport, "a5464617")
                .click(ExpiryDate)
                .click(ExpiryYear)
                .select(ExpiryYear, "2030")
                .click(ExpiryDay)
                .type(Nationality, "Egy")
                .click(EgyptAuto)
                .click(BookNPay);


        driver.getDriver().switchTo().alert().accept();
        Thread.sleep(20000);

        //driver.element().clipboardActions(textField,"select all");
        // driver.element().clipboardActions(textField, "copy");


    }

    public void placingBookingMultiCityAirCairo() throws InterruptedException {
        //driver.element().click(UncheckboxRound)
        //.scrollToElement(RefundableTrip)
        //.click(RefundableTrip)
        driver.element().click(BookNowMulti)
                //  .click(Continue)
                .click(CheckboxTNC)
                .click(ContinueBttn)
                .click(Title)
                .select(Title, "Ms")
                .type(FirstName, "Test")
                .type(LastName, "Tesssst")
                .click(DOB)
                .click(YearofBirth)
                .select(YearofBirth, "2000")
                .click(DayofBirth)
                .click(Gender)
                .select(Gender, "Female")
                .type(Passport, "a5464617")
                .click(ExpiryDate)
                .click(ExpiryYear)
                .select(ExpiryYear, "2030")
                .click(ExpiryDay)
                .type(Nationality, "Egy")
                .click(EgyptAuto)
                .click(BookNPay);


        driver.getDriver().switchTo().alert().accept();
        Thread.sleep(20000);

        //driver.element().clipboardActions(textField,"select all");
        // driver.element().clipboardActions(textField, "copy");


    }

    public void placingBookingAirCairoRoundTrip() throws InterruptedException {
        //driver.element().click(UncheckboxRound)
        //.scrollToElement(RefundableTrip)
        //.click(RefundableTrip)
        driver.element().click(BookNowRound)
                //  .click(Continue)
                .click(CheckboxTNC)
                .click(ContinueBttn)
                .click(Title)
                .select(Title, "Ms")
                .type(FirstName, "Test")
                .type(LastName, "Tesssst")
                .click(DOB)
                .click(YearofBirth)
                .select(YearofBirth, "2000")
                .click(DayofBirth)
                .click(Gender)
                .select(Gender, "Female")
                .type(Passport, "a5464617")
                .click(ExpiryDate)
                .click(ExpiryYear)
                .select(ExpiryYear, "2030")
                .click(ExpiryDay)
                .type(Nationality, "Egy")
                .click(EgyptAuto)
                .click(BookNPay);


        driver.getDriver().switchTo().alert().accept();
        Thread.sleep(20000);

        //driver.element().clipboardActions(textField,"select all");
        // driver.element().clipboardActions(textField, "copy");


    }


    public void bookingRoundTripWithValidData() throws InterruptedException {


        driver.element().click(UncheckboxRound)
                .scrollToElement(RefundableTrip)
                .click(RefundableTrip)
                .click(BookNowRound);
    }


}
