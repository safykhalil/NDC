package Pages.Reports;
import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SalesReportsPage extends BasePage {
    public SalesReportsPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }
    By salesReports = By.xpath("(//a[@href='../Reports/saleReports?menu=reports'])[1]");
    By branchNameInput = By.id("branchListValue");
    By productType = By.id("productType");
    By fromDateInput = By.id("datepickerA");
    By toDateInput = By.id("datepickerB");
    By prevDateBtn = By.xpath("//a[@title='Prev']");
    By fromDate = By.xpath("//a[normalize-space()='14']");
    By toDate = By.xpath("//a[normalize-space()='12']");
    By searchBtn = By.xpath("//input[@name='search']");
    By allBranchesCheckBox = By.id("branchIDChk");
    By branchListValue = By.id("branchListValue");
    public By errMsg = By.xpath("//div[contains(@class,'alert-danger')]");
    public String errTxt;
    String txt;
    Alert alert;
    public String alertText;
    public void openReleasedPnrReport() {
        driver.element().click(salesReports);
    }
    public void searchWithValidData() {
        txt = driver.element().getText(branchListValue);
        WebDriverWait wait = new WebDriverWait(driver.getDriver(),Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(branchListValue,"Selected(51)"));
        driver.element().select(productType,"Flights")
                .click(fromDateInput)
                .click(prevDateBtn)
                .click(prevDateBtn)
                .click(fromDate)
                .click(toDateInput)
                .click(prevDateBtn)
                .click(toDate)
                .click(searchBtn);
        wait.until(ExpectedConditions.presenceOfElementLocated(errMsg));
        errTxt = driver.element().getText(errMsg);
    }
    public void searchWithEmptyBranch(){
        txt = driver.element().getText(branchListValue);
        WebDriverWait wait = new WebDriverWait(driver.getDriver(),Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(branchListValue,"Selected(50)"));
        driver.element().click(branchNameInput)
                .click(allBranchesCheckBox)
                .click(searchBtn);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
    }
    public void searchWithEmptyProductType(){
        txt = driver.element().getText(branchListValue);
        WebDriverWait wait = new WebDriverWait(driver.getDriver(),Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(branchListValue,"Selected(50)"));
        driver.element().click(searchBtn);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
    }
    public void searchWithEmptyFromDate() {
        txt = driver.element().getText(branchListValue);
        WebDriverWait wait = new WebDriverWait(driver.getDriver(),Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(branchListValue,"Selected(50)"));
        driver.element().select(productType,"Flights")
                .click(searchBtn);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
    }
    public void searchWithEmptyToDate() {
        txt = driver.element().getText(branchListValue);
        WebDriverWait wait = new WebDriverWait(driver.getDriver(),Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(branchListValue,"Selected(50)"));
        driver.element().select(productType,"Flights")
                .click(fromDateInput)
                .click(prevDateBtn)
                .click(fromDate)
                .click(searchBtn);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
    }
    public void searchWithDatePeriodMoreThen60() {
        driver.element().click(fromDateInput)
                .click(prevDateBtn)
                .click(prevDateBtn)
                .click(prevDateBtn)
                .click(prevDateBtn)
                .click(fromDate)
                .click(toDateInput)
                .click(prevDateBtn)
                .click(toDate);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
    }
}
