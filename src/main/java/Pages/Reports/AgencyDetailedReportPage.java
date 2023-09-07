package Pages.Reports;


import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AgencyDetailedReportPage extends BasePage {
    public AgencyDetailedReportPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By agencyDetailedReport = By.xpath("//*[@id=\"content_wrap\"]/div/div[2]/div[2]/a[10]/div/div[1]/label");
    By branchName = By.id("branchListValue");
    By allCheckBox = By.id("branchIDChk");
    By fromDate = By.id("datepickerA");
    By prevDateClick = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span");
    By fromDateInput = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[4]/a");
    By toDate = By.id("datepickerB");
    By toDateInput = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[6]/a");
    By searchBtn = By.xpath("//*[@id=\"reporttotaldue\"]/div/div[2]/div[1]/input");
    public By exportToExcelBtn = By.xpath("//*[@id=\"reporttotaldue\"]/div/div[2]/div[2]/input");
    By firstDateInTable = By.xpath("//*[@id=\"salesDataTable\"]/tbody/tr[1]/td[6]");
    By lastPagination = By.xpath("//*[@id=\"content_wrap\"]/div/div[2]/div[2]/nav/ul/li[7]/a");
    By lastDateInTable = By.xpath("//*[@id=\"salesDataTable\"]/tbody/tr[10]/td[6]");
    SimpleDateFormat dateobj = new SimpleDateFormat("dd-MM-yyyy");
    public By searchTableRes = By.id("salesDataTable_wrapper");
    Alert alert;
    public String alertText;

    public void agencyDetailedReportsSearch() throws InterruptedException {
        driver.element().click(agencyDetailedReport);
        Thread.sleep(2000);
        driver.element().click(fromDate).click(prevDateClick).click(prevDateClick).click(fromDateInput).click(toDate).click(prevDateClick).click(toDateInput).click(searchBtn);
    }

    public void exportToExcel() throws InterruptedException {
        driver.element().click(exportToExcelBtn);
        Thread.sleep(2000);
    }

    public boolean CheckDatesOfIssuesInTable() throws ParseException {
        String firstDateSplit = driver.element().getText(firstDateInTable);
        String[] firstDateParts = firstDateSplit.split(" ");
        Date firstDate = dateobj.parse(firstDateParts[0]);
        driver.element().click(lastPagination);
        String lastDateSplit = driver.element().getText(lastDateInTable);
        String[] lastDateParts = lastDateSplit.split(" ");
        Date lastDate = dateobj.parse(lastDateParts[0]);
        Date fromDateInputTxt = dateobj.parse(driver.element().getText(fromDate));
        Date toDateInputTxt = dateobj.parse(driver.element().getText(toDate));
        lastDate.before(toDateInputTxt);
        firstDate.after(fromDateInputTxt);
        boolean fromDateRange = (fromDateInputTxt.before(firstDate) || firstDate.equals(fromDateInputTxt));
        boolean toDateRange = (lastDate.after(toDateInputTxt) || lastDate.equals(toDateInputTxt));
        return (fromDateRange && toDateRange);
    }

    public void searchWithoutSelectingBranch() throws InterruptedException {
        driver.element().click(agencyDetailedReport);
        Thread.sleep(2000);
        driver.element().click(branchName).click(allCheckBox).click(fromDate).click(prevDateClick).click(prevDateClick).click(fromDateInput).click(toDate).click(prevDateClick).click(toDateInput).click(searchBtn);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
        alert.accept();
    }

    public void searchWithoutDates() throws InterruptedException {
        driver.element().click(agencyDetailedReport);
        Thread.sleep(2000);
        driver.element().click(searchBtn);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
        alert.accept();
    }

    public void searchWithDatePeriodMoreThan60() throws InterruptedException {
        driver.element().click(agencyDetailedReport);
        Thread.sleep(2000);
        driver.element().click(fromDate).click(prevDateClick);
        Thread.sleep(2000);
        driver.element().click(prevDateClick).click(prevDateClick).click(prevDateClick).click(prevDateClick).click(prevDateClick).click(prevDateClick).click(fromDateInput).click(toDate).click(prevDateClick).click(toDateInput);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
        alert.accept();
//                .click(searchBtn);
    }
}
