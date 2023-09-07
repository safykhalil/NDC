package Portal.ReportsPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class QuotationReport  {
    protected SHAFT.GUI.WebDriver driver;

    public QuotationReport(SHAFT.GUI.WebDriver driver) {
        super();
        this.driver = driver;
    }

    By quotationReport = By.xpath("//*[@id=\"new-passenger-details-wrap\"]/div[2]/div/div[2]/a[5]/div/div[1]/label");
    By reportsPage = By.xpath("//*[@id=\"reports\"]/a");
    By quotNumberInput = By.id("quotationId");
    By quotNameInput = By.id("clientName");
    By companyInput = By.id("clientCompany");
    By emailInput = By.id("clientEmailId");
    By quoteStatusSelect = By.id("quoteStatusValue"); //to select open status
    By dateRangeDuration = By.xpath("//*[@id=\"radio_opr_edit_status_3\"]");
    public By provideDataMsg = By.xpath("//*[@id=\"errorSelection\"]/div");
    public By searchBtn = By.id("searchQuoteBtn");
    public By exportToExcelBtn = By.id("dwonload11");
    public By searchTable = By.id("quoteResult");
    public By noResultMsg = By.xpath("//*[@id=\"searchQuotationForm\"]/div/div[2]/fieldset/div[3]/div/div[3]/div");
    By tableRows = By.cssSelector("#quoteResult > tbody > tr");
    By byTableData = By.tagName("td");
    List <WebElement> rows;
    public boolean identicalData;


    public void checkDataInTable(int colNumber,String data) {
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

    // +ve //
    public void checkSearchWithValidData(){
        driver.element().click(reportsPage)
                .click(quotationReport)
                .select(quoteStatusSelect, "All")
                .click(dateRangeDuration)
                .click(searchBtn);
    }

    public void checkSearchWithValidQuotNo()  {
        driver.element().click(reportsPage)
                .click(quotationReport)
                .select(quoteStatusSelect, "All")
                .click(dateRangeDuration)
                .type(quotNumberInput, "EGAGN2BRN219513")
                .click(searchBtn);
        identicalData = true;
        checkDataInTable(0, "EGAGN2BRN219513");
        }

    public void checkSearchWithValidEmail()  {
        driver.element().click(reportsPage)
                .click(quotationReport)
                .select(quoteStatusSelect, String.valueOf(0))
                .click(dateRangeDuration)
                .type(emailInput, "e.saady@ndceg.com")
                .click(searchBtn);
        identicalData = true;
        checkDataInTable(3, "e.saady@ndceg.com");
    }

    public void checkSearchWithValidName()  {
        driver.element().click(reportsPage)
                .click(quotationReport)
                .select(quoteStatusSelect, "All")
                .click(dateRangeDuration)
                .type(quotNameInput, "nagy abdelhamid")
                .click(searchBtn);
        identicalData = true;
        checkDataInTable(1, "nagy abdelhamid");
    }

    public void checkSearchWithValidCompany(){
        driver.element().click(reportsPage)
                .click(quotationReport)
                .select(quoteStatusSelect, String.valueOf(0))
                .click(dateRangeDuration)
                .type(companyInput, "")
                .click(searchBtn);
    }
    // -ve //
    public void searchWithoutData(){
        driver.element().click(reportsPage)
                .click(quotationReport)
                .click(searchBtn);
    }
    public void searchWithInvalidCompany(){
        driver.element().click(reportsPage)
                .click(quotationReport)
                .select(quoteStatusSelect, String.valueOf(0))
                .click(dateRangeDuration)
                .type(companyInput, "invalid data")
                .click(searchBtn);
        identicalData = true;
        checkDataInTable(2, "invalid");
    }

    public void searchWithInvalidName(){
        driver.element().click(reportsPage)
                .click(quotationReport)
                .select(quoteStatusSelect, String.valueOf(0))
                .click(dateRangeDuration)
                .type(quotNameInput, "new client")
                .click(searchBtn);
    }

    public void searchWithInvalidQuotNo(){
        driver.element().click(reportsPage)
                .click(quotationReport)
                .select(quoteStatusSelect, String.valueOf(0))
                .click(dateRangeDuration)
                .type(quotNumberInput, "EGAGN2BRN21951")
                .click(searchBtn);
    }

    public void searchWithInvalidEmail(){
        driver.element().click(reportsPage)
                .click(quotationReport)
                .select(quoteStatusSelect, String.valueOf(0))
                .click(dateRangeDuration)
                .type(emailInput, "e.saady@ndceg.co")
                .click(searchBtn);
    }
}