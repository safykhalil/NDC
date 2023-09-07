package Pages.BookingMidOffice.ManualInvoice;

import Pages.BasePage;
import com.shaft.cli.FileActions;
import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddManualInvoicePage extends BasePage {
    public AddManualInvoicePage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    String fileName = "images.png";
    By branchList = By.id("branchListId"); // list select Test from it

    public By walletAmount = By.id("walletAmount"); // wallet amount
    By agencyList = By.id("agencyListId"); // list select from it Test Egypt agency
    By staffList = By.id("selectagenId"); // list select from it Essam Saady
    By startingFrom = By.id("startingFrom_1"); // type in it "CAI" then select first choice
    By goingTo = By.id("goingTo_1"); // type in it "DXB" then select first choice
    By dateJourney = By.id("datePicker_1"); // select date from it
    By airline = By.id("preffered"); // type in it "egy" then select second choice
    By uploadBttn = By.id("chooseDoct"); // upload on it any file
    By adultBaseFare = By.id("adultbasefare"); // type in it amount
    By adultTax = By.id("adulttax"); // type in it amount
    By adultMarkup = By.id("adultMarkup"); // type in it amount
    By adultServiceCharge = By.id("adultServiceCharge"); //type in it amount
    By Discount = By.id("adultDiscount"); //type in it
    By GdsPnr = By.id("gdsPNR"); //type in it minimum 6 digit
    By AirlinePnr = By.id("airLinePNR"); //type in it minimum 6 digit
    By flightNumber = By.id("flightNo"); //type in it maximum 13 digit
    By addTravelerBttn = By.xpath("/html/body/div[1]/section/div/div/div/div/div[2]/div[4]/div/div/div/div/div[2]/div/div[2]/div[1]/form/div[16]/input"); //click on it
    By titleList = By.id("passengerTitle_0"); // select MR from list
    By passengerFirstName = By.id("passengerFirstName_0"); // type in it first name
    By passengerLastName = By.id("passengerLastName_0"); // type in it Last name
    By dateOfBirth = By.id("passengerDob_0"); // select date from it
    By countryCode = By.id("passengerCountryCode_0"); // type in it egypt then select first choice
    By passengerMobile = By.id("passengerMobile_0"); // type in it phone no
    By passengerGender = By.id("passengerGender_0"); // select from it Male
    By Passport = By.id("passengerPassport_0"); // type in it
    By passportExpiry = By.id("passengerPassExp_0"); // select date from it
    By Nationality = By.id("passengerNationality_0"); // type in it then select first
    By ticketNumber = By.id("ticketNo_0"); // type in it
    By payBttn = By.xpath("/html/body/div[1]/section/div/div/div/div/div[2]/div[2]/form[1]/div[2]/div/div[2]/input"); //click on it
    LocalDate dob = LocalDate.now().minusYears(18);
    LocalDate expiryDate = LocalDate.now().plusYears(10);
    LocalDate DateJourney = LocalDate.now().plusDays(30);
    DateTimeFormatter DOBFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter expiryFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    DateTimeFormatter journeyDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public String ndcRef;

    public Float wallet;
    public int totalCost;

    public void addManualInvoiceWithValidCriteriaToAgency(String brName, String agnName, String staffName, String source, String destination, String airLine
            , String Base, String Taxes, String Markup, String ServiceCharge, String discount, String gdsPnr
            , String airlinePnr, String flightNo, String title, String passFirstName, String passLastName, String countCode, String passMobile,
                                                          String gender, String passport, String nationality, String ticketNo) throws InterruptedException {
        driver.element().select(branchList, brName);
        Thread.sleep(1000);
        driver.element().select(agencyList, agnName);
        Thread.sleep(1000);
        driver.element().select(staffList, staffName);
        Thread.sleep(1000);
        driver.element().type(startingFrom, source);
        Thread.sleep(1000);
        new ElementActions().keyPress(startingFrom, Keys.ENTER)
                .type(goingTo, destination);
        Thread.sleep(1000);
        new ElementActions().keyPress(goingTo, Keys.ENTER)
                .type(dateJourney, DateJourney.format(journeyDate));
        Thread.sleep(1000);
        driver.element().type(airline, airLine);
        Thread.sleep(1000);
        new ElementActions().keyPress(airline, Keys.ARROW_DOWN).keyPress(airline, Keys.ENTER);
        Thread.sleep(1000);
        driver.element().typeFileLocationForUpload(uploadBttn, FileActions.getInstance().getAbsolutePath(SHAFT.Properties.paths.testData(), fileName));
        Thread.sleep(1000);
        driver.element().type(adultBaseFare, Base)
                .type(adultTax, Taxes)
                .type(adultMarkup, Markup)
                .type(adultServiceCharge, ServiceCharge)
                .type(Discount, discount)
                .type(GdsPnr, gdsPnr)
                .type(AirlinePnr, airlinePnr)
                .type(flightNumber, flightNo)
                .click(addTravelerBttn)
                .select(titleList, title)
                .type(passengerFirstName, passFirstName)
                .type(passengerLastName, passLastName)
                .type(dateOfBirth, dob.format(DOBFormatter))
                .type(countryCode, countCode);
        Thread.sleep(1000);
        new ElementActions().keyPress(countryCode, Keys.ARROW_DOWN).keyPress(countryCode, Keys.ENTER)
                .type(passengerMobile, passMobile)
                .select(passengerGender, gender)
                .type(Passport, (passport))
                .type(Nationality, nationality);
        Thread.sleep(1000);
        new ElementActions().keyPress(Nationality, Keys.ARROW_DOWN).keyPress(Nationality, Keys.ENTER)
                .type(ticketNumber, ticketNo)
                .type(passportExpiry, expiryDate.format(expiryFormatter))
                .click(payBttn);
        driver.getDriver().switchTo().alert().accept();
        String[] ndcReferences = driver.getDriver().switchTo().alert().getText().replace(".", "").split(" ");
        ndcRef = ndcReferences[ndcReferences.length - 1];
        driver.getDriver().switchTo().alert().accept();



    }

    public void addManualInvoiceWithValidCriteriaToBranch(String brName, String source, String destination, String airLine
            , String Base, String Taxes, String Markup, String ServiceCharge, String discount, String gdsPnr
            , String airlinePnr, String flightNo, String title, String passFirstName, String passLastName, String countCode, String passMobile,
                                                          String gender, String passport, String nationality, String ticketNo) throws InterruptedException {
        driver.element().select(branchList, brName);
        Thread.sleep(1000);
        driver.element().type(startingFrom, source);
        Thread.sleep(1000);
        new ElementActions().keyPress(startingFrom, Keys.ENTER)
                .type(goingTo, destination);
        Thread.sleep(1000);
        new ElementActions().keyPress(goingTo, Keys.ENTER)
                .type(dateJourney, DateJourney.format(journeyDate))
                .type(airline, airLine);
        Thread.sleep(1000);
        new ElementActions().keyPress(airline, Keys.ARROW_DOWN).keyPress(airline, Keys.ENTER)
                .typeFileLocationForUpload(uploadBttn, FileActions.getInstance().getAbsolutePath(SHAFT.Properties.paths.testData(), fileName))
                .type(adultBaseFare, Base)
                .type(adultTax, Taxes)
                .type(adultMarkup, Markup)
                .type(adultServiceCharge, ServiceCharge)
                .type(Discount, discount)
                .type(GdsPnr, gdsPnr)
                .type(AirlinePnr, airlinePnr)
                .type(flightNumber, flightNo)
                .click(addTravelerBttn)
                .select(titleList, title)
                .type(passengerFirstName, passFirstName)
                .type(passengerLastName, passLastName)
                .type(dateOfBirth, dob.format(DOBFormatter))
                .type(countryCode, countCode);
        Thread.sleep(1000);
        new ElementActions().keyPress(countryCode, Keys.ARROW_DOWN).keyPress(countryCode, Keys.ENTER)
                .type(passengerMobile, passMobile)
                .select(passengerGender, gender)
                .type(Passport, (passport))
                .type(Nationality, nationality);
        Thread.sleep(1000);
        new ElementActions().keyPress(Nationality, Keys.ARROW_DOWN).keyPress(Nationality, Keys.ENTER)
                .type(ticketNumber, ticketNo)
                .type(passportExpiry, expiryDate.format(expiryFormatter))
                .click(payBttn);
        try {
            driver.alert().acceptAlert();
            String[] ndcReferences = driver.alert().getAlertText().replace("." , "").split(" ") ;
            ndcRef = ndcReferences [ndcReferences.length -1];
            driver.alert().acceptAlert();

        }
        catch (NoAlertPresentException e){
            driver.alert().acceptAlert();
            String[] ndcReferences = driver.alert().getAlertText().replace("." , "").split(" ") ;
            ndcRef = ndcReferences [ndcReferences.length -1];
            driver.alert().acceptAlert();
        }
        catch (UnhandledAlertException e){
            driver.alert().acceptAlert();
            String[] ndcReferences = driver.alert().getAlertText().replace("." , "").split(" ") ;
            ndcRef = ndcReferences [ndcReferences.length -1];
            driver.alert().acceptAlert();
        }
          totalCost = ((Integer.parseInt(Base) + Integer.parseInt(Taxes) + Integer.parseInt(Markup) + Integer.parseInt(ServiceCharge)) - Integer.parseInt(discount));



    }

    public void checkWalletOfAspecificBranch(String brName) throws InterruptedException {
        try {
            driver.element().select(branchList, brName);
            Thread.sleep(10000);
            driver.assertThat().element(walletAmount).isVisible();
            wallet = Float.parseFloat(driver.getDriver().findElement(By.id("walletAmount")).getText());
        } catch (IllegalArgumentException ex) {
            // Handle exception
            System.err.println("Invalid arguments: " + ex.getMessage());
        }


    }

    public void checkWalletOfAspecificAgency(String brName, String agnName, String staffName) throws InterruptedException {
        try {
            driver.element().select(branchList, brName);
            Thread.sleep(1000);
            driver.element().select(agencyList, agnName);
            Thread.sleep(1000);
            driver.element().select(staffList, staffName);
            Thread.sleep(1000);
            driver.assertThat().element(walletAmount).isVisible();
            wallet = Float.parseFloat(driver.getDriver().findElement(By.id("walletAmount")).getText());

        } catch (IllegalArgumentException ex) {
            // Handle exception
            System.err.println("Invalid arguments: " + ex.getMessage());
        }
    }


}
