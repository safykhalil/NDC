package Pages.Reports;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TotalDueToNDCReportPage extends BasePage {
    public TotalDueToNDCReportPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }
    By totalDueToNDCReport = By.xpath("//*[@id=\"content_wrap\"]/div/div[2]/div[2]/a[1]/div/div[1]/label");
    By branchName = By.id("branchListValue");
    By allCheckbox = By.id("branchIDChk");
    By branchNameSelect = By.id("branchIDChk13");
    By productType = By.id("productType");
    By productTypeSelect = By.xpath("//*[@id=\"productType\"]/option[2]"); //to select Flight
    By fromDateInput = By.id("datepickerA");
    By fromDate = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[4]/a"); // to select day 19
    By prevDateClick = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span");
    By toDateInput = By.id("datepickerB");
    By toDate = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[1]/a"); //to select day 6
    By searchBtn = By.xpath("//*[@id=\"reporttotaldue\"]/div/div[2]/div/input");
    public By searchTableResults = By.id("totalDueDataTable_wrapper"); // To Check That Search Returns Data
    public By exportToExcelBtn = By.xpath("//*[@id=\"reporttotaldue\"]/div/div[2]/div[2]/input"); //u might not use it
    By firstInvoiceDate = By.xpath("//*[@id=\"totalDueDataTable\"]/tbody/tr[1]/td[5]");
    By nextPagination = By.id("totalDueDataTable_next"); //to go to last pagination
    By lastInvoiceDate = By.xpath("//*[@id=\"totalDueDataTable\"]/tbody/tr[6]/td[5]");
    SimpleDateFormat dateobj = new SimpleDateFormat("dd-MM-yyyy");
    Alert alert;
    public String alertText;

// Search With Valid Data
    public void totalDueToNDCSearch() throws InterruptedException{
        driver.element().click(totalDueToNDCReport);
        Thread.sleep(2000);
        driver.element().click(branchName)
                .click(allCheckbox)
                .click(branchNameSelect)
                .click(productType)
                .click(productTypeSelect)
                .click(fromDateInput)
                .click(prevDateClick)
                .click(prevDateClick)
                .click(fromDate)
                .click(toDateInput)
                .click(toDate)
                .click(searchBtn);
    }
    //Check Invoice Dates In Table If It's In Range Or Not
    public boolean CheckInvoiceDatesInTable() throws ParseException {
        String firstDateSplit = driver.element().getText(firstInvoiceDate);
        String[] firstDateParts = firstDateSplit.split(" ");
        Date firstDate = dateobj.parse(firstDateParts[0]);
        driver.element().click(nextPagination);
        String lastDateSplit = driver.element().getText(lastInvoiceDate);
        String[] lastDateParts = lastDateSplit.split(" ");
        Date lastDate = dateobj.parse(lastDateParts[0]);
        Date fromDateInputTxt = dateobj.parse(driver.element().getText(fromDateInput));
        Date toDateInputTxt = dateobj.parse(driver.element().getText(toDateInput));
        lastDate.before(toDateInputTxt);
        firstDate.after(fromDateInputTxt);
        boolean fromDateRange = (fromDateInputTxt.before(firstDate) || firstDate.equals(fromDateInputTxt));
        boolean toDateRange = (lastDate.after(toDateInputTxt) || lastDate.equals(toDateInputTxt));
        return (fromDateRange && toDateRange);
    }
    //Search Without Selecting any Branch
    public void searchWithNoBranchSelected() throws InterruptedException{
        driver.element().click(totalDueToNDCReport);
        Thread.sleep(2000);
        driver.element().click(branchName)
                .click(allCheckbox)
                .click(productType)
                .click(productTypeSelect)
                .click(fromDateInput)
                .click(prevDateClick)
                .click(prevDateClick)
                .click(fromDate)
                .click(toDateInput)
                .click(toDate)
                .click(searchBtn);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
        alert.accept();
    }
    // Search Without Selecting a Product Type
    public void searchWithNoProductType() throws InterruptedException{
        driver.element().click(totalDueToNDCReport);
        Thread.sleep(2000);
        driver.element().click(branchName)
                .click(allCheckbox)
                .click(branchNameSelect)
                .click(fromDateInput)
                .click(prevDateClick)
                .click(prevDateClick)
                .click(fromDate)
                .click(toDateInput)
                .click(toDate)
                .click(searchBtn);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
        alert.accept();
    }
    //Search Without Selecting a From & To Dates
    public void searchWithNoDates() throws InterruptedException{
        driver.element().click(totalDueToNDCReport);
        Thread.sleep(2000);
        driver.element().click(productType)
                .click(productTypeSelect)
                .click(searchBtn);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
        alert.accept();
    }
    //Search With Date Period More Than 60 Days
    public void searchWithDaysMoreThan60() throws InterruptedException{
        driver.element().click(totalDueToNDCReport);
        Thread.sleep(2000);
        driver.element().click(branchName)
                .click(allCheckbox)
                .click(branchNameSelect)
                .click(productType)
                .click(productTypeSelect)
                .click(fromDateInput)
                .click(prevDateClick)
                .click(prevDateClick)
                .click(prevDateClick)
                .click(fromDate)
                .click(toDateInput)
                .click(toDate);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
        alert.accept();
    }

}
