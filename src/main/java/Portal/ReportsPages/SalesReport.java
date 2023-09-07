package Portal.ReportsPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SalesReport {
    protected SHAFT.GUI.WebDriver driver;

    public SalesReport(SHAFT.GUI.WebDriver driver) {
        super();
        this.driver = driver;
    }
    By reportsPage = By.xpath("//*[@id=\"reports\"]/a");
    By salesReport = By.xpath("//*[@id=\"new-passenger-details-wrap\"]/div[2]/div/div[2]/a[2]/div/div[1]/label");
    By productTypeInput = By.id("productType");
    By customerNameInput = By.id("customerName");
    By txnID = By.id("transactionId");
    By invoiceNumber = By.id("invoiceNumber");
    By agentName = By.id("userId");
    By productTypeSelect = By.xpath("//*[@id=\"productType\"]/option[2]");
    By fromDateInput = By.id("datepickerA");
    By prevClick = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span");
    By fromDateSelect = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[7]/a"); //to select day 15
    By toDateInput = By.id("datepickerB");
    By toDateSelect = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[2]/a"); // to select day 14
    By searchBtn = By.xpath("//*[@id=\"reporttotaldue\"]/div/div[2]/div[1]/input");
    public By exportToExcelBtn = By.xpath("//*[@id=\"reporttotaldue\"]/div/div[2]/div[2]/input");
    By fromYearInput = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]");
    By fromYearSelect = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]/option[9]"); // to select 2021
    By firstDateInTable = By.xpath("//*[@id=\"salesDataTable\"]/tbody/tr[1]/td[3]");
    By nextPagination = By.xpath("//*[@id=\"salesDataTable_next\"]");
    By lastDateInTable = By.xpath("//*[@id=\"salesDataTable\"]/tbody/tr[7]/td[3]");
    SimpleDateFormat dtobj = new SimpleDateFormat("dd-MM-yyyy");
    public By resultTable = By.id("salesDataTable");
    By tableRows = By.tagName("tr");
    By byTableData = By.tagName("td");
    List <WebElement> rows;
    public boolean identicalData;
    Alert alert;
    public String alertText;
    public By noReultMsg = By.xpath("//*[@id=\"new-passenger-details-wrap\"]/div[2]/div/div[2]/div[2]/div[1]");
    // payment date locators
    By paymentDateInput = By.id("datepickerC");
    By getPaymentDateSelect1 = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[4]/a"); //valid data
    By paymentDateSelect2 = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[4]/a"); //invalid data

    public boolean checkDatesInTable() throws ParseException {
        Date firstDate = dtobj.parse(driver.element().getText(firstDateInTable));
        driver.element().click(nextPagination);
        Date lastDate = dtobj.parse(driver.element().getText(lastDateInTable));
        Date fromDateInputTxt = dtobj.parse(driver.element().getText(fromDateInput));
        Date toDateInputTxt = dtobj.parse(driver.element().getText(toDateInput));
        lastDate.before(toDateInputTxt);
        firstDate.after(fromDateInputTxt);
        boolean fromDateRange = (fromDateInputTxt.before(firstDate) || firstDate.equals(fromDateInputTxt));
        boolean toDateRange = (lastDate.after(toDateInputTxt) || lastDate.equals(toDateInputTxt));
        return (fromDateRange && toDateRange);
    }

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

    //Positive TC
    public void searchWithValidData(){
        driver.element().click(reportsPage)
                .click(salesReport)
                .click(productTypeInput).click(productTypeSelect)
                .click(fromDateInput).click(prevClick).click(fromDateSelect)
                .click(toDateInput).click(toDateSelect)
                .click(searchBtn);
    }
    public void checkCustomerName(){
        driver.element().click(reportsPage)
                .click(salesReport)
                .click(productTypeInput).click(productTypeSelect)
                .type(customerNameInput, "shrook ali")
                .click(fromDateInput).click(prevClick).click(fromDateSelect)
                .click(toDateInput).click(toDateSelect)
                .click(searchBtn);
        identicalData = true;
        checkDataInTable(2, "shr0ok ali");
    }
    public void checkInvoiceNumber(){
        driver.element().click(reportsPage)
                .click(salesReport)
                .click(productTypeInput).click(productTypeSelect)
                .click(fromDateInput).click(prevClick).click(fromDateSelect)
                .click(toDateInput).click(toDateSelect)
                .type(invoiceNumber, "INVNDC1104122")
                .click(searchBtn);
        checkDataInTable(5, "INVNDC1104122");
    }
    public void checkAgentName() throws InterruptedException {
        driver.element().click(reportsPage)
                .click(salesReport)
                .click(productTypeInput).click(productTypeSelect)
                .click(fromDateInput).click(prevClick).click(fromDateSelect)
                .click(toDateInput).click(toDateSelect)
                .select(agentName, String.valueOf(1051))
                .click(searchBtn);
        Thread.sleep(10000);
        checkDataInTable(7, "Essam Saady");
    }
    public void checkPaymentDate(){
        driver.element().click(reportsPage)
                .click(salesReport)
                .click(productTypeInput).click(productTypeSelect)
                .click(fromDateInput).click(prevClick).click(fromDateSelect)
                .click(toDateInput).click(toDateSelect)
                .click(paymentDateInput).click(getPaymentDateSelect1)
                .click(searchBtn);
        identicalData = true;
        checkDataInTable(3,"");
    }
    public void chcekDataWithValidTxnID(){
        driver.element().click(reportsPage)
                .click(salesReport)
                .click(productTypeInput).click(productTypeSelect)
                .click(fromDateInput).click(prevClick).click(fromDateSelect)
                .type(txnID, "NDCEG-T-TRAN76")
                .click(searchBtn);
    }

    //Negative TC
    public void searchWithPeriodMoreThanYear(){
        driver.element().click(reportsPage)
                .click(salesReport)
                .click(productTypeInput).click(productTypeSelect)
                .click(fromDateInput).click(fromYearInput).click(fromYearSelect).click(fromDateSelect)
                .click(toDateInput).click(toDateSelect);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
        alert.accept();
    }
    public void searchWithoutProduct(){
        driver.element().click(reportsPage)
                .click(salesReport)
                .click(searchBtn);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
        alert.accept();
    }
    public void searchWithoutDates(){
        driver.element().click(reportsPage)
                .click(salesReport)
                .click(productTypeInput).click(productTypeSelect)
                .click(searchBtn);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
        alert.accept();
    }
    public void checkDataWithInvalidCustomerName(){
        driver.element().click(reportsPage)
                .click(salesReport)
                .click(productTypeInput).click(productTypeSelect)
                .click(fromDateInput).click(prevClick).click(fromDateSelect)
                .click(toDateInput).click(toDateSelect)
                .type(customerNameInput, "invalid name")
                .click(searchBtn);
    }
    public void chcekDataWithInvalidTxnID() throws InterruptedException {
        driver.element().click(reportsPage)
                .click(salesReport)
                .click(productTypeInput).click(productTypeSelect)
                .click(fromDateInput).click(prevClick).click(fromDateSelect)
                .click(toDateInput).click(toDateSelect)
                .type(txnID, "555")
                .click(searchBtn);
        Thread.sleep(3000);
    }

}
