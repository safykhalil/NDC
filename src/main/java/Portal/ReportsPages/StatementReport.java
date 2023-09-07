package Portal.ReportsPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class StatementReport  {
    protected SHAFT.GUI.WebDriver driver;
    public StatementReport(SHAFT.GUI.WebDriver driver) {
        super();
        this.driver = driver;
    }
    By reportsPage = By.xpath("//*[@id=\"reports\"]/a");
    By statementReport = By.xpath("//*[@id=\"new-passenger-details-wrap\"]/div[2]/div/div[2]/a[6]/div/div[1]/label");
    By invoiceFromDateInput = By.id("datepickerA");
    By fromYearInput = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]");
    By prevClick = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span");
    By fromYearSelect21 = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]/option[9]"); //to select 2021
    By fromDaySelect = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[7]/a");
    By invoiceToDateInput = By.id("datepickerB");
    By invoiceToDate = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[1]/a");
    public By searchBtn = By.xpath("//*[@id=\"reporttotaldue\"]/div/div[2]/div[1]/input");
    public By exportToExcelBtn = By.xpath("//*[@id=\"reporttotaldue\"]/div/div[2]/div[2]/input");
    public By searchTable = By.id("salesDataTable_wrapper");
    By firstDateInTable = By.xpath("//*[@id=\"salesDataTable\"]/tbody/tr[1]/td[6]");
    By nextPagination = By.id("salesDataTable_next");
    By lastDateInTable = By.xpath("//*[@id=\"salesDataTable\"]/tbody/tr[10]/td[6]");
    SimpleDateFormat dtobj = new SimpleDateFormat("dd-MM-yyyy");
    By passengerNameInput = By.id("customerName");
    By tableRows = By.tagName("tr");
    By byTableData = By.tagName("td");
    List <WebElement> rows;
    public boolean identicalData;
    Alert alert;
    public String alertText;

    public void statementSearchWithValidData() throws InterruptedException {
        driver.element().click(reportsPage)
                .click(statementReport)
                .click(invoiceFromDateInput)
                .click(prevClick).click(fromDaySelect)
                .click(invoiceToDateInput)
                .click(invoiceToDate);
        Thread.sleep(1000);
        driver.element().click(searchBtn);
        identicalData = true;
    }
    public void searchWithValidCredentialsWithPassengerName() throws InterruptedException {
        driver.element().click(reportsPage).click(statementReport)
                .click(invoiceFromDateInput).click(prevClick)
                .click(fromDaySelect)
                .click(invoiceToDateInput).click(invoiceToDate)
                .type(passengerNameInput,"shrook Ali");
        driver.element().click(searchBtn);
        identicalData = true;
    }

    //check specific column retrieved  data in table
    public void checkAgencyName() throws InterruptedException {
        identicalData = true;
        checkDataInTable(3,"Test Egypt");
    }

    //check specific column data in table
    public void checkBranchName() throws InterruptedException {
        identicalData = true;
        checkDataInTable(2,"Test");
    }

    //check retrieved data from table of passenger name column
    public void checkPassengerName() throws InterruptedException {
        searchWithValidCredentialsWithPassengerName();
        checkDataInTable(6, "shrook Ali");
    }

    //-ve TC
    public void searchWithInvalidDatePeriod() throws InterruptedException {
        driver.element().click(reportsPage)
                .click(statementReport)
                .click(invoiceFromDateInput)
                .click(fromYearInput).click(fromYearSelect21).click(fromDaySelect)
                .click(invoiceToDateInput)
                .click(invoiceToDate);
        Thread.sleep(1000);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
        alert.accept();
    }

    public void searchWithoutDates(){
        driver.element().click(reportsPage)
                .click(statementReport)
                . click(searchBtn);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
        alert.accept();
    }
    public void checkDataWithInvalidCredentials() throws InterruptedException {
        driver.element().click(reportsPage)
                .click(statementReport)
                .click(invoiceFromDateInput)
                .click(prevClick).click(fromDaySelect)
                .click(invoiceToDateInput)
                .click(invoiceToDate)
                .type(passengerNameInput, "Invalid Name")
                .click(searchBtn);
    }
    //check dates in table to confirm it's in range
    public boolean checkDatesInTable() throws ParseException {
        String firstDateSplit = driver.element().getText(firstDateInTable);
        String[] firstDateParts = firstDateSplit.split(" ");
        Date firstDate = dtobj.parse(firstDateParts[0]);
        driver.element().click(nextPagination);
        String lastDateSplit = driver.element().getText(lastDateInTable);
        String[] lastDateParts = lastDateSplit.split(" ");
        Date lastDate = dtobj.parse(lastDateParts[0]);
        Date fromDateInputTxt = dtobj.parse(driver.element().getText(invoiceFromDateInput));
        Date toDateInputTxt = dtobj.parse(driver.element().getText(invoiceToDateInput));
        lastDate.before(toDateInputTxt);
        firstDate.after(fromDateInputTxt);
        boolean fromDateRange = (fromDateInputTxt.before(firstDate) || firstDate.equals(fromDateInputTxt));
        boolean toDateRange = (lastDate.after(toDateInputTxt) || lastDate.equals(toDateInputTxt));
        return (fromDateRange && toDateRange);
    }

    //check data in the search result table
    public void checkDataInTable(int colNumber,String data) {
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
