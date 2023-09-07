package Pages.Reports;
import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class SyncPnrReportPage extends BasePage {
    public SyncPnrReportPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }
    By syncReport = By.xpath("//a[@href='../Reports/syncPNRReport?menu=reports']//div[@class='row']");
    By fromDateInput = By.id("datepickerA");
    By toDateInput = By.id("datepickerB");
    By prevDateBtn = By.xpath("//a[@title='Prev']");
    By fromDate = By.xpath("//a[normalize-space()='14']");
    By toDate = By.xpath("//a[normalize-space()='12']");
    By searchBtn = By.xpath("//input[@name='search']");
    SimpleDateFormat dtobj = new SimpleDateFormat("dd-MM-yyyy");

    public By tableOfResults = By.id("salesDataTable_wrapper");
    public By exportBtn = By.xpath("(//input[@value='Export To excel'])[1]");
    public By noResultsMsg = By.xpath("//div[contains(@class,'alert-danger')]");
    By firstDateInTable = By.xpath("//*[@id=\"salesDataTable\"]/tbody/tr[1]/td[5]");
    By lastDateInTable = By.xpath("//*[@id=\"salesDataTable\"]/tbody/tr[10]/td[5]");
    By orderIdInput = By.id("orderId");
    Alert alert;
    public String alertText;

    public void openReleasedPnrReport() {
        driver.element().click(syncReport);
    }
    public void searchWithValidData() {
        driver.element().click(fromDateInput)
                .click(prevDateBtn)
                .click(prevDateBtn)
                .click(fromDate)
                .click(toDateInput)
                .click(prevDateBtn)
                .click(toDate)
                .click(searchBtn);
        WebDriverWait wait = new WebDriverWait(driver.getDriver(),Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(tableOfResults));
    }
    public boolean checkDatesInTable() throws ParseException {
        String firstDateSplit = driver.element().getText(firstDateInTable);
        String [] firstDateParts = firstDateSplit.split(" ");
        Date firstDate = dtobj.parse(firstDateParts[0]);
        String lastDateSplit = driver.element().getText(lastDateInTable);
        String [] lastDateParts = lastDateSplit.split(" ");
        Date lastDate = dtobj.parse(lastDateParts[0]);
        Date fromDateInputTxt = dtobj.parse(driver.element().getText(fromDateInput));
        Date toDateInputTxt = dtobj.parse(driver.element().getText(toDateInput));
        lastDate.before(toDateInputTxt);
        firstDate.after(fromDateInputTxt);
        boolean fromDateRange = (fromDateInputTxt.before(firstDate) || firstDate.equals(fromDateInputTxt));
        boolean toDateRange = (lastDate.after(toDateInputTxt) || lastDate.equals(toDateInputTxt));
        return (fromDateRange && toDateRange);
    }
    public void searchWithEmptyData(){
        driver.element().click(searchBtn);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
    }
    public void searchWithEmptyFromDate(){
        driver.element().click(toDateInput)
                .click(prevDateBtn)
                .click(prevDateBtn)
                .click(toDate)
                .click(searchBtn);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
    }
    public void searchWithEmptyToDate(){
        driver.element().click(fromDateInput)
                .click(prevDateBtn)
                .click(prevDateBtn)
                .click(fromDate)
                .click(searchBtn);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
    }
    public void searchWithEmptyInvalidOrderId(){
        driver.element().click(fromDateInput)
                .click(prevDateBtn)
                .click(prevDateBtn)
                .click(fromDate)
                .click(toDateInput)
                .click(prevDateBtn)
                .click(toDate)
                .type(orderIdInput,"l")
                .click(searchBtn);
    }
    public void searchWithDatePeriodMoreThen60(){
        driver.element().click(fromDateInput)
                .click(prevDateBtn)
                .click(prevDateBtn)
                .click(prevDateBtn)
                .click(prevDateBtn)
                .click(fromDate)
                .click(toDateInput)
                .click(prevDateBtn)
                .click(toDate);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
    }

}
