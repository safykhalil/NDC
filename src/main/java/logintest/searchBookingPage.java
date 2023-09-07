package logintest;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.stringtemplate.v4.ST;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class searchBookingPage extends BasePage {
    By branchName = By.id("branchListValue");
    By agencyName = By.id("agentListValue");
    By searchButton = By.id("submit");
    By all = By.id("branchIDChk");
    By mansoura = By.xpath("//*[@id=\"branchIDChk0\"]");
    By moaatazTest = By.id("branchIDChk60");
    By orderId = By.xpath("//*[@id=\"region_content\"]/div/div[2]/div[1]/input");
    By flightDay =By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[2]"); //28
    List<WebElement> rows;
    By tableRows = By.tagName("tr");
    public boolean identicalData;
    By byTableData = By.tagName("td");
    By bookingDateFrom = By.id("bookingDateFrom");
    By month = By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/select[1]");
    By year = By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/select[2]");
  public   By textOneYear = By.xpath("//*[@id=\"country_table\"]");
    By flight =By.xpath("//*[@id=\"accordionSearchBooking\"]/div[1]/div[1]");
    By ticketNo =By.id("ticketNo");
    By flightDate =By.id("flightReturnDate");
    By bookingReference =By.xpath("//*[@id=\"region_content\"]/div/div[2]/div[2]/input");
    public By notFound=By.xpath("//*[@id=\"country_table\"]");
    public By tableResult =By.xpath("//*[@id=\"DataTables_Table_0\"]");
    public By orderId1 = By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[2]/a");
    public By clientNameTable =By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[5]");
    By airLinePnr =By.id("airlinePNR");

    Alert alert;
    public String alertText;


    public searchBookingPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    public void searchWithSpecificBranchAndSelectDate() throws InterruptedException {
        Thread.sleep(4000);
        driver.element().click(branchName)
                .click(all)
                .click(moaatazTest);
                 Thread.sleep(4000);
                driver.element().click(bookingDateFrom);
                driver.element().select(year, "2023")
                .select(month, "Jun")
                .click(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[5]/a"));
                Thread.sleep(4000);

    }


    public void searchWithSpecificBranch() throws InterruptedException {
        Thread.sleep(4000);
        driver.element().click(branchName)
                .scrollToElement(all)
                .click(all)
                .click(moaatazTest)
        .click(searchButton);
        Thread.sleep(2000);
        checkDataInTable(2, "moataztest");
    }

    public void searchButton() throws InterruptedException {
        driver.element().click(searchButton);

    }

    public void alertAccept() throws InterruptedException {
        Thread.sleep(4000);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
        alert.accept();

    }


    public void searchWithOrderId(String Order) throws InterruptedException {
        Thread.sleep(4000);
        driver.element().type(orderId, Order);
    }

    private void checkDataInTable(int colNumber, String data) {
        identicalData = true;
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

    public void validateYearMassageDisplayed() throws InterruptedException {
        Thread.sleep(4000);

        driver.element().click(branchName)
                .scrollToElement(all)
                .click(all)
                .click(moaatazTest);
                Thread.sleep(4000);
                driver.element().click(bookingDateFrom)
                .select(year, "2022")
                .select(month, "Jun")
                .click(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[4]/a"));
    }
    public void searchWithTicketNo(String ticket) throws InterruptedException {
        Thread.sleep(3000);
        driver.element().click(branchName);
        driver.element() .scrollToElement(all)
                .click(all);
        Thread.sleep(3000);
        driver.element()   .click(moaatazTest);
        driver.element().click(flight);
        Thread.sleep(3000);
        driver.element() .type(ticketNo ,ticket);
        Thread.sleep(3000);

    }
    public void searchWithValidDataUsingFlightDate() throws InterruptedException {
        Thread.sleep(3000);
        driver.element().click(branchName)
                .scrollToElement(all)
                .click(all)
                .click(moaatazTest);
        driver.element().click(flight);
        Thread.sleep(3000);
        driver.element().click(flightDate)
                .click(flightDay);  //28

    }

    public void SearchWithEnterInValidTicketNo(String ticket , String pnr) throws InterruptedException {
        Thread.sleep(3000);
        driver.element().click(branchName)
                .scrollToElement(all)
                .click(all)
                .click(moaatazTest)
                .click(flight)
                .type(airLinePnr ,pnr)
                .type(ticketNo , ticket);   //3812403486102 //381240348610
        Thread.sleep(3000);
    }
    public void searchWithBookingReference() throws InterruptedException {
        Thread.sleep(3000);
        driver.element().click(branchName)
                .scrollToElement(all)
                .click(all)
                .click(moaatazTest)
                .type(bookingReference,"NDCEG-T-BR-F135")
                .click(flight)
                .type(airLinePnr ,"SM14643D23828P")
                .type(ticketNo , "3812403486102");
        Thread.sleep(3000);

    }
}
