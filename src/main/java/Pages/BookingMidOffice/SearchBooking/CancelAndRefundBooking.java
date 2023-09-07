package Pages.BookingMidOffice.SearchBooking;

import Pages.BaseClass;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class CancelAndRefundBooking extends BaseClass {

    public CancelAndRefundBooking (SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By BookingTab = By.xpath("//*[@id=\"MidOfficeBooking\"]/a");
    By SearchBooking = By.xpath("//*[@id=\"Search Booking\"]/a");
    By BranchName = By.xpath("//*[@id=\"branchListValue\"]");
    By TestBranch = By.xpath("//*[@id=\"mutti_select\"]/div/div/ul/li[13]/label");
    By AgencyName = By.xpath("//*[@id=\"agentListValue\"]");
    By TestEgypt = By.xpath("//*[@id=\"agencyIDChk3\"]");
    //*[@id="mutti_select"]/div/div/ul/li[5]/label
    By SearchBttn = By.id("submit");
    By OrderID = By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[2]/a");
    //*[@id="DataTables_Table_0"]/tbody/tr[1]/td[2]/a
    By Lock = By.xpath("//*[@id=\"searchBookingId\"]/h4/a/i");
    By TakeControlOpt = By.xpath("//*[@id=\"unlocked-modal\"]/div/div/div[3]/button[1]");
    By Itinerary = By.xpath("//*[@id=\"itenaryTab\"]/p");
    By ViewPaxDetails = By.xpath("//*[@id=\"itenary\"]/div[3]/div[1]/div[2]/div[4]/a");
    By Checkbox = By.xpath("//*[@id=\"DataTables_Table_1\"]/tbody/tr/td[1]/label");
    By VoidOrCancelBttn = By.xpath("//*[@id=\"button_can\"]/a");
    By OKBttn = By.xpath("//*[@id=\"succes-msg\"]/div/div/div[3]/button");
    By ReleasePNR = By.xpath("//*[@id=\"itenary\"]/div[3]/div[1]/div[2]/div[2]/input");
    By YesBttn = By.xpath("//*[@id=\"releasePnrConfirm\"]/div/div/div[3]/div/a[1]");
    By ReleasedSuccessfullyMSG = By.xpath("//*[@id=\"releasePNRLoader\"]/div/div/div[2]/div/div");
    By OKBttn2 = By.xpath("//*[@id=\"releasePNRLoader\"]/div/div/div[3]/button");
    By Costing = By.xpath("//*[@id=\"costingTab\"]/p");
    By textField = By.xpath("//*[@id=\"costing\"]/div[3]/div[2]/div/table/tbody/tr[4]/td[2]/b");
    By CancellationCharge = By.xpath("//*[@id=\"cancellationCharge1_1\"]");
    By textField2 = By.xpath("//*[@id=\"cancellationCharge1_1\"]");
    By RefundAmount = By.xpath("//*[@id=\"supplierRefundedAmount1\"]");
    By RefundBttn = By.xpath("//*[@id=\"button_can\"]/a");
    By OKBttn3 = By.xpath("//*[@id=\"succes-msg\"]/div/div/div[3]/button");
    By RefundedStatus = By.xpath("//*[@id=\"itenary\"]/div[3]/div[1]/div[2]/table[3]/tbody/tr[2]/td[4]");
    By BookingAmount = By.xpath("//*[@id=\"costing\"]/div[3]/div[2]/div/table/tbody/tr[4]/td[2]/b");
    By TypeRefund = By.xpath("//*[@id=\"supplierRefundedAmount1\"]");
    By getViewPaxDetails= By.xpath("//*[@id=\"itenary\"]/div[3]/div[1]/div[2]/div[4]/a");
    By Unlocking = By.xpath("//*[@id=\"searchBookingId\"]/h4/a/i");
    By ReleaseControl = By.xpath("//*[@id=\"locked-modal\"]/div/div/div[3]/button[1]");


    public void cancelAndRefundBookingWithValidData() throws InterruptedException {

        driver.element().click(BookingTab)
                .click(SearchBooking)
                .click(BranchName)
                .scrollToElement(TestBranch)
                .click(TestBranch)
                .click(AgencyName)
                .scrollToElement(TestEgypt)
                .click(TestEgypt)
                .click(SearchBttn)
                .click(OrderID)
                .click(Lock)
                .click(TakeControlOpt)
                .click(Itinerary)
                .click(ViewPaxDetails)
                .click(Checkbox)
                .click(VoidOrCancelBttn)
                .click(OKBttn)
                .click(ViewPaxDetails)
                .click(ReleasePNR)
                .click(YesBttn)
                .click(OKBttn2)
                .click(Costing);
        String RefundAmnt = driver.element().getText(BookingAmount);
        driver.element().click(Itinerary)
                .click(ViewPaxDetails);
        driver.element()
                .keyPress(TypeRefund,Keys.CLEAR)
                .type(TypeRefund, RefundAmnt);
        // Thread.sleep(5000);
        //driver.element().click(Itinerary);
        //  .click(ViewPaxDetails)
        //  .click(CancellationCharge)
        // .click(RefundAmount);
        driver.element().keyPress(TypeRefund, Keys.ARROW_LEFT)
                .keyPress(TypeRefund, Keys.ARROW_LEFT)
                .keyPress(TypeRefund, Keys.ARROW_LEFT)
                .keyPress(TypeRefund, Keys.ARROW_LEFT)
                .keyPress(TypeRefund, Keys.ARROW_LEFT)
                .keyPress(TypeRefund, Keys.ARROW_LEFT)
                .keyPress(TypeRefund, Keys.BACK_SPACE)
                .keyPress(TypeRefund, Keys.ARROW_RIGHT)
                .keyPress(TypeRefund, Keys.ARROW_RIGHT)
                .keyPress(TypeRefund, Keys.BACK_SPACE)
                .keyPress(TypeRefund, Keys.NUMPAD1);
        //  .keyPress(TypeRefund, Keys.BACK_SPACE);
        Thread.sleep(50000);
        driver.element().click(RefundBttn)
                .click(OKBttn3)
                .click(Unlocking)
                .click(ReleaseControl);


    }

}
