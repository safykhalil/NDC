package Pages.Reports;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import java.time.LocalDate;

public class AgencyWalletReportsPage extends BasePage {
    public AgencyWalletReportsPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By agencyWalletReport = By.xpath("//*[@id=\"content_wrap\"]/div/div[2]/div[2]/a[2]/div");
    By branchNameInput = By.xpath("/html/body/div/section/div/div[2]/div/div/div[4]/div[2]/div[2]/form/div/div/div[1]/div[1]/div");
    By branchName = By.id("branchIDChk12");
    By allCheckBox = By.id("branchIDChk");
    By currencyInput = By.id("currencyId");
    By searchBtn = By.xpath("//*[@id=\"walletReport\"]/div/div/div[2]/div[1]/input");
    Alert alert;
    public String alertText;
    public By exportBtn = By.xpath("//*[@id=\"walletReport\"]/div/div/div[2]/div[2]/input");
    public By tableOfResults = By.id("bookingDataTable_wrapper");

    public void agencyWalletReportsSearch() throws InterruptedException {
        driver.element().click(agencyWalletReport);
        Thread.sleep(2000);
        driver.element().click(branchNameInput)
                .click(allCheckBox)
                .click(branchName)
                .select(currencyInput, "USD")
                .click(searchBtn);
    }

    public void exportToExcelBtn() throws InterruptedException {
        Thread.sleep(10000);
        driver.element().click(exportBtn);
    }

    public void SearchWithEmptyCurrency() throws InterruptedException {
        driver.element().click(agencyWalletReport);
        Thread.sleep(2000);
//        driver.element().click(branchNameInput)
//                .click(allCheckBox)
//                .click(branchName)
//                .select(currencyInput,"USD")
        driver.element().click(searchBtn);
    }

    public void SearchWithEmptyBranchField() throws InterruptedException {
        driver.element().click(agencyWalletReport);
        Thread.sleep(2000);
        driver.element().click(branchNameInput)
                .click(allCheckBox)
                .select(currencyInput, "USD")
                .click(searchBtn);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
    }
}
