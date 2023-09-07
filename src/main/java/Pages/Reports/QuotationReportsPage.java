package Pages.Reports;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class QuotationReportsPage extends BasePage {
    public QuotationReportsPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }
    By quotationReportsPage = By.xpath("//a[@href='../dashboard/myQuote?menu=quoteReport']");

    By branchNameInput = By.id("branchId");
    By agencyNameInput = By.id("mutti_select");
    By agencyName = By.xpath("(//label[normalize-space()='All'])[1]");
    By dateRangeRadioBtn = By.xpath("(//label[normalize-space()='Date Range'])[1]");
    //NEW//
    By quotesNumber = By.id("quotationId");
    By clientName = By.id("clientName");
    By emailID = By.id("clientEmailId");
    By searchBtn = By.id("searchQuoteBtn");
    public By exportToExcelBtn = By.id("dwonload11");
    public By table = By.id("reporQuotation");
    public By noResultsMsg = By.xpath("//span[@class='red ng-binding']");
    Alert alert;
    public String alertText;
    public void openQuotationReportsPage(){
        driver.element().click(quotationReportsPage);
    }
    // search  without selecting a branch
    public void searchWitNoBranch() throws InterruptedException {
        driver.element().click(dateRangeRadioBtn)
                .click(searchBtn);
        Thread.sleep(1000);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
        alert.accept();
    }
    //search without selecting agency name
    public void searchWithNoAgency() throws InterruptedException {
        driver.element().select(branchNameInput, "Test")
                .click(dateRangeRadioBtn)
                .click(searchBtn);
        Thread.sleep(1000);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
        alert.accept();
    }
    //search  with invalid quotes number
    public void searchWithInvalidNumber() throws InterruptedException {
        driver.element().select(branchNameInput,"Test")
                .click(agencyNameInput)
                .click(agencyName)
                .type(quotesNumber, String.valueOf(1))
                .click(searchBtn);
    }
    //search with invalid client name
    public void searchWithInvalidName(){
        driver.element().select(branchNameInput,"Test")
                .click(agencyNameInput)
                .click(agencyName)
                .type(clientName, "test2")
                .click(searchBtn);
    }
    // search with invalid email
    public void searchWithInvalidEmail(){
        driver.element().select(branchNameInput,"Test")
                .click(agencyNameInput)
                .click(agencyName)
                .type(emailID, "test@")
                .click(searchBtn);
    }
}

