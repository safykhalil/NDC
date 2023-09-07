package PortalPackage.ReportsNegativeTC;
import Portal.PortalLoginPage;
import Portal.ReportsPages.PerformanceReportsPage;
import PortalPackage.Base.PortalTCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PerformanceReportsNegativeTC extends PortalTCBase {
    PortalLoginPage loginObj;
    PerformanceReportsPage performanceReportsObj;
    @BeforeTest
    public void beforeTest(){
        loginObj = new PortalLoginPage(driver);
        loginObj.PortalLoginWithValidData();
        performanceReportsObj = new PerformanceReportsPage(driver);
    }
    @Test
    public void searchWithInValidAgentName() {
        performanceReportsObj.openReportPage();
        performanceReportsObj.searchWithInValidAgentName();
        Assert.assertEquals(driver.element().getText(performanceReportsObj.noResultMsg),"Data Not Found");
    }
}
