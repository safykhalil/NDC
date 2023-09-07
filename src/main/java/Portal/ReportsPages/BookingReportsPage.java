package Portal.ReportsPages;
import Portal.PortalBasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class BookingReportsPage extends PortalBasePage {
    public BookingReportsPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }
    By reportsPage = By.id("reports");
    By bookingsReport = By.xpath("//*[@id=\"new-passenger-details-wrap\"]/div[2]/div/div[2]/a[3]/div");
    By fromDateInput = By.id("datepickerA");
    By fromDate = By.xpath("//a[normalize-space()='17']");
    By dateMonth = By.className("ui-datepicker-month");
    By toDateInput = By.id("datepickerB");
    By toDate = By.xpath("//a[normalize-space()='14']");
    By searchBtn = By.cssSelector("input[name='search']");
    By firstDateInTable = By.xpath("//*[@id=\"bookingDataTable\"]/tbody/tr[1]/td[5]");
    By lastDateInTable = By.xpath("//*[@id=\"bookingDataTable\"]/tbody/tr[10]/td[5]");
    By typeOfClientInput = By.id("typeOfClient");
    By customerNameInput = By.id("customerName");
    By showAdvancedSearch = By.linkText("Show Advance Search");
    By agentNameInput = By.id("userId");
    By invoiceNumberInput = By.id("invoiceNumber");
    By refNumberInput = By.id("odeysysReferencenumber");
    By ticketStatusInput = By.id("bookingStatus");
    SimpleDateFormat dtobj = new SimpleDateFormat("dd-MM-yyyy");
    List<WebElement> rows;
    By tableRows = By.tagName("tr");
    By byTableData = By.tagName("td");
    By selectYear = By.className("ui-datepicker-year");
    public By noResultMsg = By.className("no_result");
    Alert alertMsg;
    public String alertMsgTxt;

    public By tableOfResults = By.id("bookingDataTable");
    public boolean identicalData;
    String invoiceNumber;
    String bookingReferenceNumber;
    String ticketStatus;
    public void openReportPage() {
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        driver.element().click(reportsPage);
        wait.until(ExpectedConditions.elementToBeClickable(bookingsReport));
        driver.element().click(bookingsReport);
    }
    private void baseTestData(){
        driver.element().click(fromDateInput)
                .select(dateMonth, "Jan")
                .click(fromDate)
                .click(toDateInput)
                .select(dateMonth, "Jul")
                .click(toDate);
    }
    public void searchInBookingReportsWithMandatoryData(){
        baseTestData();
        driver.element().click(searchBtn);
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(tableOfResults));
    }
    public void searchInBookingReportsWithRetailCustomerType() {
        baseTestData();
        identicalData = true;
        driver.element().select(typeOfClientInput,"Retails")
                .click(searchBtn);
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(tableOfResults));
        checkDataInTable(6,"Retail");
    }
    public void searchInBookingReportsWithValidCustomerName() {
        baseTestData();
        identicalData = true;
        driver.element().type(customerNameInput,"test test")
                .click(searchBtn);
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(tableOfResults));
        checkDataInTable(3,"test test");
    }
    public void searchInBookingReportsWithValidAgentName() {
        baseTestData();
        identicalData = true;
        driver.element().select(agentNameInput,"Essam Saady")
                .click(searchBtn);
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(tableOfResults));
        checkDataInTable(9,"Essam Saady");
    }
    public void searchInBookingReportsWithValidInvoiceNumber() {
        baseTestData();
        identicalData = true;
        driver.element().click(searchBtn);
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(tableOfResults));
        invoiceNumber = driver.getDriver().findElements(tableRows).get(1).findElements(byTableData).get(2).getText();
        driver.element().click(showAdvancedSearch)
                .type(invoiceNumberInput,invoiceNumber)
                .click(searchBtn);
        checkDataInTable(2,invoiceNumber);
    }
    public void searchInBookingReportsWithValidBookingReferenceNumber() {
        baseTestData();
        identicalData = true;
        driver.element().click(searchBtn);
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(tableOfResults));
        bookingReferenceNumber = driver.getDriver().findElements(tableRows).get(1).findElements(byTableData).get(1).getText();
        driver.element().click(showAdvancedSearch)
                .type(refNumberInput,bookingReferenceNumber)
                .click(searchBtn);
        checkDataInTable(1,bookingReferenceNumber);
    }
    public void searchInBookingReportsWithValidTicketStatus() {
        baseTestData();
        identicalData = true;
        driver.element().click(searchBtn);
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(tableOfResults));
        ticketStatus = driver.getDriver().findElements(tableRows).get(1).findElements(byTableData).get(10).getText();
        driver.element().click(showAdvancedSearch)
                .select(ticketStatusInput,ticketStatus)
                .click(searchBtn);
        checkDataInTable(10,ticketStatus);
    }
    public void searchInBookingReportsWithEmptyFromDate() {
        driver.element().click(searchBtn);
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        alertMsg = driver.getDriver().switchTo().alert();
        alertMsgTxt = alertMsg.getText();
    }
    public void searchInBookingReportsWithEmptyToDate() {
        driver.element().click(fromDateInput)
                .select(dateMonth, "Jan")
                .click(fromDate)
                .click(searchBtn);
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        alertMsg = driver.getDriver().switchTo().alert();
        alertMsgTxt = alertMsg.getText();
    }
    public void searchInBookingReportsWithDateRangeGreaterThan360Days() {
        driver.element().click(fromDateInput)
                .select(selectYear,"2020")
                .select(dateMonth, "Jan")
                .click(fromDate)
                .click(toDateInput)
                .select(dateMonth, "Jul")
                .click(toDate);
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        alertMsg = driver.getDriver().switchTo().alert();
        alertMsgTxt = alertMsg.getText();
    }
    public void searchInBookingReportsWithInvalidClientName() {
        baseTestData();
        driver.element().type(customerNameInput,"/")
                .click(searchBtn);
    }
    public void searchInBookingReportsWithInvalidInvoiceNo() {
        baseTestData();
        driver.element().click(showAdvancedSearch)
                .type(invoiceNumberInput,"1")
                .click(searchBtn);
    }
    public void searchInBookingReportsWithInvalidBookingReferenceNumber() {
        baseTestData();
        driver.element().click(showAdvancedSearch)
                .type(refNumberInput,"1")
                .click(searchBtn);
    }

    public boolean checkDatesInTable() throws ParseException {
        String firstDateSplit = driver.element().getText(firstDateInTable);
        String[] firstDateParts = firstDateSplit.split(" ");
        Date firstDate = dtobj.parse(firstDateParts[0]);
        String lastDateSplit = driver.element().getText(lastDateInTable);
        String[] lastDateParts = lastDateSplit.split(" ");
        Date lastDate = dtobj.parse(lastDateParts[0]);
        Date fromDateInputTxt = dtobj.parse(driver.element().getText(fromDateInput));
        Date toDateInputTxt = dtobj.parse(driver.element().getText(toDateInput));
        lastDate.before(toDateInputTxt);
        firstDate.after(fromDateInputTxt);
        boolean fromDateRange = (fromDateInputTxt.before(firstDate) || firstDate.equals(fromDateInputTxt));
        boolean toDateRange = (lastDate.after(toDateInputTxt) || lastDate.equals(toDateInputTxt));
        System.out.println("from date range " + fromDateRange);
        System.out.println("to date Range " + toDateRange);
        System.out.println(fromDateRange && toDateRange);
        return (fromDateRange && toDateRange);
    }
    private void checkDataInTable(int colNumber,String data) {
        rows = driver.getDriver().findElements(tableRows);
        int index = 1;
        while (!rows.isEmpty() && index < rows.size() && identicalData) {
            WebElement row = rows.get(index);
            List<WebElement> cols = row.findElements(byTableData);
            if (cols.get(colNumber).getText().toLowerCase().equals(data.toLowerCase())) {
                identicalData = true;
            } else {
                identicalData = false;
            }
            index++;
        }
    }
}
