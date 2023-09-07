package Pages.Reports;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.interactions.Actions;

public class ReleasedPNRReportsPage extends BasePage {
    public ReleasedPNRReportsPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By releasedPnrReport = By.xpath("//*[@id=\"content_wrap\"]/div/div[2]/div[2]/a[12]/div/div[1]/label");
    By fromDateInput = By.id("datepickerA");
    By fromDate = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[6]/a");
    By toDateInput = By.id("datepickerB");
    By toDate = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[2]/a");
    By prevIcon = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span");
    By searchBtn = By.xpath("//*[@id=\"reportreleasedpnr\"]/div/div[2]/div/input");
    public By exportToExcelBtn = By.xpath("//*[@id=\"reportreleasedpnr\"]/div/div[2]/div[2]/input");
    By firstDateInTable = By.xpath("//*[@id=\"salesDataTable\"]/tbody/tr[1]/td[9]");
    By lastDateInTable = By.xpath("//*[@id=\"salesDataTable\"]/tbody/tr[8]/td[9]");
    By lastPagination = By.xpath("//*[@id=\"content_wrap\"]/div/div[2]/div[2]/div[2]/div[1]/nav/ul/li[6]/a");
    SimpleDateFormat dtobj = new SimpleDateFormat("dd-MM-yyyy");
    public By searchTableRes = By.id("salesDataTable_wrapper");
    By orderIdInput = By.id("orderId");
    public By noResMsg = By.className("no_result");
    Alert alert;
    public String alertText;

    public void openReleasedPnrReport() {
        driver.element().click(releasedPnrReport);
    }

    public void searchPNR_ReportWithValidData() {
        driver.element().click(fromDateInput).click(prevIcon).click(prevIcon).click(prevIcon).click(fromDate).click(toDateInput).click(prevIcon).click(prevIcon).click(toDate).click(searchBtn);
    }

    public void exportToExcel() throws InterruptedException {
        driver.element().click(exportToExcelBtn);
        Thread.sleep(2000);
        Actions action = new Actions(driver.getDriver());
        action.setActiveKeyboard("ENTER");
    }

    public boolean checkDatesOfReleaseInTable() throws ParseException {
        String firstDateSplit = driver.element().getText(firstDateInTable);
        String[] firstDateParts = firstDateSplit.split(" ");
        Date firstDate = dtobj.parse(firstDateParts[0]);
        driver.element().click(lastPagination);
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

    public void searchWithEmptyData() {
        driver.element().click(searchBtn);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
    }

    public void searchWithInvalidOrderID() {
        driver.element().click(fromDateInput).click(prevIcon).click(prevIcon).click(fromDate).click(toDateInput).click(prevIcon).click(toDate).type(orderIdInput, "l").click(searchBtn);
    }

    public void searchWithDatePeriodMoreThen60() {
        driver.element().click(fromDateInput).click(prevIcon).click(prevIcon).click(prevIcon).click(prevIcon).click(fromDate).click(toDateInput).click(prevIcon).click(toDate);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
        alert.accept();
    }
}
