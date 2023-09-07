package logintest;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class dashBoardTest extends BasePage {
    public dashBoardTest(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By Country = By.id("countryList");
    By egypt = By.id("countryIDk11");
    By Branch = By.id("branchList");
    By alexBranch = By.xpath("//*[@id=\"branchIDChk1\"]");

    By BookingFromDate = By.id("dp1550047732422");
    By bookingToDate = By.id("dp1550047732423");
    By SearchButton = By.xpath("//*[@id=\"content_wrap\"]/div/div[1]/div[4]/div/input");
    By prevButton = By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/a[1]");
    By TicketedDocument = By.xpath("//*[@id=\"activ_0_2\"]/a/p");
    LocalDate today = LocalDate.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");


    public void searchOnDashBoardPage() throws InterruptedException {
        driver.element().click(Country);
        Thread.sleep(1000);
        driver.element().click(egypt);
        Thread.sleep(1000);
        driver.element().click(Branch);
        Thread.sleep(1000);
        driver.element().click(alexBranch);
        Thread.sleep(1000);
        driver.element().type(BookingFromDate, today.minusDays(15).format(myFormatObj))
                .type(bookingToDate, today.format(myFormatObj));
        Thread.sleep(1000);
        driver.element().click(SearchButton);

    }

//    public void explicit() {
//        WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(30));
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("\"countryIDk11\"")));
//    }
////    public void submitButton(){
////        driver.element().click(SearchButton);
}

