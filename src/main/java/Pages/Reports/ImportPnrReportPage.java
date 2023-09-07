package Pages.Reports;
import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ImportPnrReportPage extends BasePage {
    public ImportPnrReportPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }
    By branchNameInput = By.id("branchListValue");
    By branchName = By.id("branchIDChk12");
    By fromDateInput = By.id("datepickerA");
    By toDateInput = By.id("datepickerB");
    By prevDateBtn = By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']");
    By fromDate = By.xpath("//a[normalize-space()='11']");
    By toDate = By.xpath("//a[normalize-space()='19']");
    By importPnrReport = By.xpath("//label[normalize-space()='Import PNR Report']");
    By searchBtn = By.xpath("//input[@name='search']");
    SimpleDateFormat dtobj = new SimpleDateFormat("dd-MM-yyyy");
    By firstDateInTable = By.xpath("//td[normalize-space()='2023-07-11 10:07:19.0']");
    By lastDateInTable = By.xpath("//td[normalize-space()='2023-07-19 15:25:03.0']");
    public String alertText;
    Alert alert;

    public By tableOfResults = By.id("salesDataTable_wrapper");

    public By exportToExcel = By.xpath("//input[@value='Export To excel']");
    public void openImportPnrReports(){
        driver.element().click(importPnrReport);
    }

    public void searchWithValidData(){
        driver.element().click(branchNameInput)
                .click(branchName)
                .click(fromDateInput)
                .click(prevDateBtn)
                .click(fromDate)
                .click(toDateInput)
                .click(prevDateBtn)
                .click(toDate)
                .click(searchBtn);
    }
    public void exportToExcelBtn() {
        driver.element().click(exportToExcel);
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
    public void searchWithEmptyBranch(){
        driver.element().click(searchBtn);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
    }
    public void searchWithEmptyFromDate() throws InterruptedException {
        driver.element().click(branchNameInput)
                .click(branchName)
                .click(fromDateInput)
                .click(searchBtn);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
    }
    public void searchWithEmptyToDate(){
        driver.element().click(branchNameInput)
                .click(branchName)
                .click(fromDateInput)
                .click(prevDateBtn)
                .click(fromDate)
                .click(searchBtn);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
    }
    public void searchWithDatePeriodMoreThen60() {
        driver.element().click(fromDateInput)
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
