package Pages.Reports;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class StatementReportsPage extends BasePage {
    public  StatementReportsPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }
    By statementReport = By.xpath("//*[@id=\"content_wrap\"]/div/div[2]/div[2]/a[9]/div/div[1]/label");
    By branchNameInput = By.id("branchListValue");
    By allCheckBox = By.id("branchIDChk");
    By fromDateInput = By.id("datepickerA");
    By toDateInput = By.id("datepickerB");
    By prevDateClick = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span");
    By invoiceFromDate = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[4]/a");
    By toDate = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[3]/a");
    By invoiceToDate = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[4]/a");
    public By searchBtn = By.xpath("//*[@id=\"reporttotaldue\"]/div/div[2]/div[1]/input");
    public By exportBtn = By.xpath("//*[@id=\"reporttotaldue\"]/div/div[2]/div[2]/input");
    public By tableOfResults = By.id("salesDataTable_wrapper");
    By firstDateInTable = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/div[2]/div[2]/div[4]/div/table/tbody/tr[1]/td[6]");
    By lastDateInTable = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/div[2]/div[2]/div[4]/div/table/tbody/tr[2]/td[6]");
    SimpleDateFormat dtobj = new SimpleDateFormat("dd-MM-yyyy");
    Alert alert;
    public String alertText;
    public void StatementReportsSearch() throws InterruptedException {
        driver.element().click(statementReport);
        Thread.sleep(2000);
        driver.element().click(fromDateInput)
                .click(prevDateClick)
                .click(invoiceFromDate)
                .click(toDateInput)
                .click(invoiceToDate)
                .click(searchBtn);
    }
    public void exportToExcelBtn() {
        driver.element().click(exportBtn);
    }
    public boolean checkDatesOfIssuesInTable() throws InterruptedException, ParseException {
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

        return (fromDateRange && toDateRange);
    }
    // search Without Entering Branch and Check the URL
    public void searchWithoutBranch () throws InterruptedException{
        driver.element().click(statementReport);
        Thread.sleep(2000);
        driver.element().click(branchNameInput)
                .click(allCheckBox);
        Thread.sleep(2000);
        driver.element().click(fromDateInput)
                .click(prevDateClick)
                .click(invoiceFromDate)
                .click(toDateInput)
                .click(invoiceToDate)
                .click(searchBtn);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
        alert.accept();
    }
    public void searchWithoutDates() throws InterruptedException{
        driver.element().click(statementReport);
        Thread.sleep(2000);
        driver.element().click(searchBtn);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
        alert.accept();
    }
    public void searchWithDatePeriodMoreThen60() throws InterruptedException{
        driver.element().click(statementReport);
        Thread.sleep(2000);
        driver.element().click(fromDateInput)
                .click(prevDateClick)
                .click(prevDateClick)
                .click(prevDateClick)
                .click(invoiceFromDate)
                .click(toDateInput)
                .click(invoiceToDate);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
        alert.accept();
    }
}
