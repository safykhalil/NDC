package Portal.ReportsPages;
import Portal.PortalBasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class PerformanceReportsPage extends PortalBasePage {
    public PerformanceReportsPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }
    By reportsPage = By.id("reports");
    By performanceReport = By.xpath("//*[@id=\"new-passenger-details-wrap\"]/div[2]/div/div[2]/a[4]/div");
    By year = By.id("year");
    By agentNameInput = By.id("agentName");
    public By table = By.xpath("//*[@id=\"new-passenger-details-wrap\"]/div[2]/div/div[2]/div[2]/div[1]");
    By searchBtn = By.cssSelector("input[name='search']");
    public By firstNameInTable = By.xpath("//*[@id=\"new-passenger-details-wrap\"]/div[2]/div/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[2]/strong");
    public By AgentnameInTable = By.xpath("//*[@id=\"new-passenger-details-wrap\"]/div[2]/div/div[2]/div[2]/div/table/tbody/tr[1]/td[2]/strong");
    public By noResultMsg = By.className("result_not_found");

    public void openReportPage() {
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        driver.element().click(reportsPage);
        wait.until(ExpectedConditions.elementToBeClickable(performanceReport));
        driver.element().click(performanceReport);
    }

    public void searchWithValidData() throws InterruptedException {
        driver.element().select(year, "2023")
                .click(searchBtn);
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(table));
    }
    public void searchWithValidAgentName() {
        driver.element().select(year, "2023")
                .click(searchBtn)
                .type(agentNameInput,driver.element().getText(firstNameInTable))
                .click(searchBtn);
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(table));
    }
    public void searchWithInValidAgentName(){
        driver.element().select(year, "2023")
                .type(agentNameInput,"l")
                .click(searchBtn);
    }
}
