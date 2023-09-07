package Pages.Reports;
import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import java.time.LocalDate;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class FinanceReportsPage extends BasePage {
    public FinanceReportsPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }
    By financeReport = By.xpath("//*[@id=\"content_wrap\"]/div/div[2]/div[2]/a[8]");
    By branchNameInput = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/div[2]/div[2]/div[2]/form/div/div[1]/div[1]/div[1]/div/div/a");
    By branchName = By.id("branchIDChk13");
    By allCheckBox = By.id("branchIDChk");
    By fromDateInput = By.id("datepickerA");
    By toDateInput = By.id("datepickerB");
    By prevDateBtn = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span");

    By fromDate = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[3]/a");
    By toDate = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[3]/a");
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    By searchBtn = By.xpath("//*[@id=\"content_wrap\"]/div/div[2]/div[2]/div[3]/div/div/input");
    public By exportBtn = By.xpath("//input[@value='Export To excel']");
    public By tableOfResults = By.id("bookingDataTable_wrapper");
    By firstDateInTable = By.xpath("//*[@id=\"bookingDataTable\"]/tbody/tr[1]/td[7]");
    By lastDateInTable = By.xpath("//*[@id=\"bookingDataTable\"]/tbody/tr[3]/td[7]");
    public String attName;
    SimpleDateFormat dtobj = new SimpleDateFormat("dd-MM-yyyy");
    Alert alert;
    public String alertText;

    public void financeReportsSearch() throws InterruptedException {
        LocalDate today = LocalDate.now().minusDays(20);
        LocalDate tomorrow = LocalDate.now();
        driver.element().click(financeReport);
        Thread.sleep(2000);
        driver.element().click(branchNameInput)
                .click(allCheckBox)
                .click(branchName)
                .click(fromDateInput)
                .click(prevDateBtn)
                .click(fromDate)
                .click(toDateInput)
                .click(prevDateBtn)
                .click(toDate)
                .click(searchBtn);
        attName = driver.element().getAttribute(exportBtn,"disabled");

    }
    public void exportToExcelBtn() {
        driver.element().click(exportBtn);
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

    public void searchWithoutBranch() throws InterruptedException{
        driver.element().click(financeReport);
        Thread.sleep(2000);
        driver.element().click(branchNameInput)
                .click(allCheckBox)
                .click(fromDateInput)
                .click(prevDateBtn)
                .click(fromDate)
                .click(toDateInput)
                .click(prevDateBtn)
                .click(toDate)
                .click(searchBtn);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
        alert.accept();
    }
    public void searchWithoutDate() throws InterruptedException {
        driver.element().click(financeReport);
        Thread.sleep(2000);
        driver.element().click(branchNameInput)
                .click(allCheckBox)
                .click(branchName)
                .click(searchBtn);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
        alert.accept();
    }
    public void searchWithDatePeriodMoreThen60() throws InterruptedException {
        driver.element().click(financeReport);
        Thread.sleep(2000);
        driver.element().click(branchNameInput)
                .click(allCheckBox)
                .click(branchName)
                .click(fromDateInput)
                .click(prevDateBtn)
                .click(prevDateBtn)
                .click(prevDateBtn)
                .click(fromDate)
                .click(toDateInput)
                .click(prevDateBtn)
                .click(toDate);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
        alert.accept();
    }
}


