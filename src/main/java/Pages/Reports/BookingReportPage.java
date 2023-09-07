package Pages.Reports;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import java.text.SimpleDateFormat;


public class BookingReportPage extends BasePage {
    public BookingReportPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By bookingReport = By.xpath("//*[@id=\"content_wrap\"]/div/div[2]/div[2]/a[5]/div/div[1]/label");
    By branchName = By.id("branchListValue");
    By allChecBox = By.id("branchIDChk");
    By branchNameSelect = By.id("branchIDChk13"); //to select branch test
    By fromBookingDateInput = By.id("datepickerA");
    By fromBookingDate = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[4]/a"); //to select day 14
    By prevClick = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span");
    By toBookingDateInput = By.id("datepickerB");
    By toBookingDate = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[4]/a"); //to select day 9
    By searchBtn = By.xpath("//*[@id=\"content_wrap\"]/div/div[2]/div[2]/div[3]/div/input");
    public By exportToExcelBtn= By.xpath("//*[@id=\"content_wrap\"]/div/div[2]/div[2]/div[3]/div[2]/input");
    public By searchTable = By.id("bookingDataTable");
    By firstDateInTable = By.xpath("//*[@id=\"bookingDataTable\"]/tbody/tr[1]/td[7]");
    By lastPagination = By.xpath("//*[@id=\"content_wrap\"]/div/div[2]/div[2]/nav/ul/li[7]/a");
    By lastDateInTable = By.xpath("//*[@id=\"bookingDataTable\"]/tbody/tr[10]/td[10]");
    SimpleDateFormat dateobj = new SimpleDateFormat("dd-MM-yyyy");
    Alert alert;
    public String alertText;
    public void searchWithValidData() throws InterruptedException {
        driver.element().click(bookingReport);
        Thread.sleep(2000);
        driver.element().click(branchName)
                .click(allChecBox)
                .click(branchNameSelect)
                .click(fromBookingDateInput)
                .click(prevClick)
                .click(prevClick)
                .click(fromBookingDate)
                .click(toBookingDateInput)
                .click(toBookingDate)
                .click(searchBtn);
    }
    public void searchWithNoBranch() throws InterruptedException {
        driver.element().click(bookingReport);
        Thread.sleep(2000);
        driver.element().click(branchName)
                .click(allChecBox)
                .click(fromBookingDateInput)
                .click(prevClick)
                .click(prevClick)
                .click(fromBookingDate)
                .click(toBookingDateInput)
                .click(toBookingDate)
                .click(searchBtn);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
        alert.accept();
    }
    public void searchWithNoDates() throws InterruptedException {
        driver.element().click(bookingReport);
        Thread.sleep(2000);
        driver.element().click(searchBtn);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
        alert.accept();
    }
    public void searchWithMoreThan60Days() throws InterruptedException {
        driver.element().click(bookingReport);
        Thread.sleep(2000);
        driver.element().click(fromBookingDateInput)
                .click(prevClick).click(prevClick).click(prevClick)
                .click(prevClick)
                .click(fromBookingDate)
                .click(toBookingDateInput)
                .click(toBookingDate);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
        alert.accept();
    }
}
