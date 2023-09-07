package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;

public class DashboardPage extends BasePage {
    public DashboardPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By userManagement = By.xpath("//*[@id=\"UserManagement\"]/a");
    By navigation = By.id("navigation");
    By AdminEle = navigation.id("Admin");
    By LeftSide = By.id("accordion");
    By BranchEle = LeftSide.xpath("/html/body/div/section/div/div[1]/nav/div/div[2]/a/div/h4");
    By addBranchBttn = By.id("add_click");
    By addCountryBttn = By.id("airport_add");
    By topUpEle = LeftSide.id("advanceCreditLimit");
    By addTopUpBttn = By.id("add_click");
    By RulesEle = navigation.id("Rules");
    By addMarkup = By.id("add_click");
    By leftCornerOfRules = By.id("side_nav");
    By discount = leftCornerOfRules.xpath("/html/body/div/section/div/div[1]/nav/div/div[2]");
    By serviceCharge = leftCornerOfRules.xpath("/html/body/div/section/div/div[1]/nav/div/div[3]");
    By cancellationCharge = leftCornerOfRules.xpath("/html/body/div/section/div/div[1]/nav/div/div[4]");
    By fareRuleMaster = leftCornerOfRules.xpath("//*[@id=\"accordion\"]/div[5]/a/div");
    By offerPricing = leftCornerOfRules.xpath("/html/body/div/section/div/div[1]/nav/div/div[6]/a/div/h4");
    By BookingMidOffice = navigation.xpath("/html/body/div[1]/header/div[2]/div/div[2]/div[3]/ul/li[6]");
    By manualInvoice = BookingMidOffice.id("Manual BookingInvoice");
    By searchBooking = BookingMidOffice.id("Search Booking");
    By booking = BookingMidOffice.id("Booking");
    By importPnr = By.id("ImportPnr");
    By termsAndConditions = By.xpath("/html/body/div[1]/section/div/div[1]/nav/div/div[7]/a/div/h4");
    By Reports = By.id("Reports");
    By Master =By.id("Master");


    public void openAddNewCountryPage() {
        driver.element().click(AdminEle)
                .click(addCountryBttn);
    }

    public void openSearchNewCountryPage() {
        driver.element().click(AdminEle);


    }

    public void openSearchBranchPage() {
        driver.element().click(AdminEle)
                .click(BranchEle);


    }

    public void openAddBranchPage() {
        driver.element().click(AdminEle)
                .click(BranchEle)
                .scrollToElement(addBranchBttn).click(addBranchBttn);
    }

    public void openTopUpPage() {
        driver.element().click(AdminEle)
                .click(topUpEle);


    }

    public void openAddTopUpPage() {
        driver.element().click(AdminEle)
                .click(topUpEle)
                .click(addTopUpBttn);


    }

    public void openMarkupSearchPage() {
        driver.element().click(RulesEle);

    }

    public void openAddMarkupPage() {
        driver.element().click(RulesEle)
                .click(addMarkup);


    }

    public void openDiscountSearchPage() {
        driver.element().click(RulesEle)
                .click(discount);


    }

    public void openAddDiscountPage() {
        driver.element().click(RulesEle)
                .click(discount)
                .click(addMarkup);

    }

    public void openServiceChargeSearchPage() {
        driver.element().click(RulesEle)
                .click(serviceCharge);


    }

    public void openAddServiceChargePage() {
        driver.element().click(RulesEle)
                .click(serviceCharge)
                .click(addMarkup);


    }

    public void openCancellationChargeSearchPage() {
        driver.element().click(RulesEle)
                .click(cancellationCharge);


    }

    public void openAddCancellationChargePage() {
        driver.element().click(RulesEle)
                .click(cancellationCharge)
                .click(addMarkup);
    }

    public void openAddFareRulesPage() {
        driver.element().click(RulesEle)
                .click(fareRuleMaster)
                .click(addTopUpBttn);


    }

    public void openOfferPricingSearchPage() {
        driver.element().click(RulesEle)
                .click(offerPricing);


    }

    public void openAddOfferPricingPage() {
        driver.element().click(RulesEle)
                .click(offerPricing)
                .click(addMarkup);

    }

    public void openTermsAndConditionsPage() {
        driver.element().click(RulesEle)
                .click(termsAndConditions);

    }

    public void openManualInvoicePage() throws IllegalArgumentException {
        try {
            driver.element().click(BookingMidOffice)
                    .click(manualInvoice);
        } catch (IllegalArgumentException ex) {
            // Handle exception
            System.err.println("Invalid arguments: " + ex.getMessage());
        }


    }

    public void openSearchBookingPage() throws InterruptedException {
        try {
            driver.element().click(BookingMidOffice)
                    .click(searchBooking);
        } catch (ElementNotInteractableException e) {
            Thread.sleep(1000);
            driver.element().click(BookingMidOffice)
                    .click(searchBooking);
        }


    }

    public void openBookingPage() {
        try {
            driver.element().click(BookingMidOffice)
                    .click(booking);
        } catch (ElementNotInteractableException e) {
            driver.element().click(BookingMidOffice)
                    .click(booking);
        }


    }

    public void openImportPnr() {
        driver.element().scrollToElement(importPnr).click(importPnr);
    }

    public void openReportsPage() {
        driver.element().click(Reports);
    }

    public void openUserManagment() {
        driver.element().click(userManagement);

    }
public void openMaster()   {

        driver.element().click(Master);

}

}
