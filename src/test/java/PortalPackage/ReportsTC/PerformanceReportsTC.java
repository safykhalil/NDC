package PortalPackage.ReportsTC;
import Portal.PortalLoginPage;
import Portal.ReportsPages.PerformanceReportsPage;
import PortalPackage.Base.PortalTCBase;
import com.shaft.validation.Validations;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PerformanceReportsTC extends PortalTCBase {
    PortalLoginPage loginObj;
    PerformanceReportsPage performanceReportsObj;
    @BeforeTest
    public void beforeTest(){
        loginObj = new PortalLoginPage(driver);
        loginObj.PortalLoginWithValidData();
        performanceReportsObj = new PerformanceReportsPage(driver);
    }
    @Test
    public void searchWithValidData() throws InterruptedException {
        performanceReportsObj.openReportPage();
        performanceReportsObj.searchWithValidData();
        Validations.verifyThat().element(performanceReportsObj.table).exists().perform();
    }
    @Test
    public void searchWithValidAgentName() {
        performanceReportsObj.openReportPage();
        performanceReportsObj.searchWithValidAgentName();
        Validations.verifyThat().element(performanceReportsObj.table).exists().perform();
        Assert.assertEquals(driver.element().getText(performanceReportsObj.firstNameInTable),driver.element().getText(performanceReportsObj.AgentnameInTable));
    }
}
