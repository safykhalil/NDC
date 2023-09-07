package Portal.ReportsPages;
import Portal.PortalBasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class TotalDueToNDCPage extends PortalBasePage {
    public TotalDueToNDCPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By reportsPage = By.id("reports");
    By openTotalDueToNdc = By.xpath("//a[@href='../dashboard/totalDueToOdeysys?menu=reports']");
    By productType = By.id("productType");
    By fromDateInput = By.id("datepickerA");
    By fromDate = By.xpath("//a[normalize-space()='17']");
    By dateMonth = By.className("ui-datepicker-month");
    By toDateInput = By.id("datepickerB");
    By toDate = By.xpath("//a[normalize-space()='14']");
    By firstDateInTable = By.xpath("//*[@id=\"totalDueDataTable\"]/tbody/tr[1]/td[3]");
    By lastDateInTable = By.xpath("//*[@id=\"totalDueDataTable\"]/tbody/tr[10]/td[3]");
    By invoiceNumberInput = By.id("invoiceNumber");
    By customerNameInput = By.id("customerName");
    By bookingReferenceInput = By.id("odeysysReferencenumber");
    By customerTypeInput = By.id("customerType");
    SimpleDateFormat dtobj = new SimpleDateFormat("dd-MM-yyyy");
    List<WebElement> rows;
    By tableRows = By.tagName("tr");
    By byTableData = By.tagName("td");
    public By noResultMsg = By.className("no_result");
    String invoiceNumber;
    String customerName;
    String bookingReference;
    By searchBtn = By.cssSelector("input[name='search']");
    public By tableOfResults = By.id("totalDueDataTable");
    public boolean identicalData;

    public void openReportPage() {
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        driver.element().click(reportsPage);
        wait.until(ExpectedConditions.elementToBeClickable(openTotalDueToNdc));
        driver.element().click(openTotalDueToNdc);
    }
    private void baseTestData(){
        driver.element().select(productType, "Flights")
                .click(fromDateInput)
                .select(dateMonth, "Jan")
                .click(fromDate)
                .click(toDateInput)
                .select(dateMonth, "Jul")
                .click(toDate);
    }
    public void searchInTotalDueToNdcWithMandatoryData() {
        baseTestData();
        identicalData = true;
        driver.element().click(searchBtn);
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(tableOfResults));
        checkDataInTable(1,"Flight");
    }
    public void searchInTotalDueToNdcWithRetailCustomerType() {
        baseTestData();
        identicalData = true;
        driver.element().select(customerTypeInput,"Retail")
                .click(searchBtn);
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(tableOfResults));
        checkDataInTable(1,"Flight");
        checkDataInTable(6,"Retail");
    }
    public void searchInTotalDueToNdcWithValidInvoiceNumber() {
        baseTestData();
        identicalData = true;
        driver.element().click(searchBtn);
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(tableOfResults));
        invoiceNumber = driver.getDriver().findElements(tableRows).get(1).findElements(byTableData).get(3).getText();
        driver.element().type(invoiceNumberInput,invoiceNumber)
                .click(searchBtn);
        checkDataInTable(3,invoiceNumber);
    }
    public void searchInTotalDueToNdcWithValidCustomerName() {
        baseTestData();
        identicalData = true;
        driver.element().click(searchBtn);
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(tableOfResults));
        customerName = driver.getDriver().findElements(tableRows).get(1).findElements(byTableData).get(4).getText();
        driver.element().type(customerNameInput,customerName)
                .click(searchBtn);
        wait.until(ExpectedConditions.presenceOfElementLocated(tableOfResults));
        checkDataInTable(4,customerName);
    }
    public void searchInTotalDueToNdcWithValidBookingReference() {
        baseTestData();
        identicalData = true;
        driver.element().click(searchBtn);
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(tableOfResults));
        bookingReference = driver.getDriver().findElements(tableRows).get(1).findElements(byTableData).get(5).getText();
        driver.element().type(bookingReferenceInput,bookingReference)
                .click(searchBtn);
        wait.until(ExpectedConditions.presenceOfElementLocated(tableOfResults));
        checkDataInTable(5,bookingReference);
    }
    public void searchInTotalDueToNdcWithEmptyProductType() {
        driver.element().click(searchBtn);
    }
    public void searchInTotalDueToNdcWithEmptyDate() {
        driver.element().select(productType, "Flights")
                .click(searchBtn);
    }
    public void searchInTotalDueToNdcWithInvalidInvoiceNumber() {
        baseTestData();
        driver.element().type(invoiceNumberInput,"1")
                .click(searchBtn);
    }
    public void searchInTotalDueToNdcWithInvalidCustomerName() {
        baseTestData();
        driver.element().type(customerNameInput,"x")
                .click(searchBtn);
    }
    public void searchInTotalDueToNdcWithInvalidBookingRefNumber() {
        baseTestData();
        driver.element().type(bookingReferenceInput,"x")
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
