package TestcasesSS;

import Pages.DashboardPage;
import TestPackage.BasePage.TCBase;
import com.shaft.validation.Validations;
import logintest.KnowledgeCenterPage;
import logintest.masterRegionCountryPage;
import logintest.masterRegionState;
import logintest.testLogin;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KnowledgeCenterTestCase extends TCBase {
    testLogin loginObj6;
    DashboardPage dashObj6;
    KnowledgeCenterPage knowledgeObj;
    String des = "test1";

    @BeforeTest
    public void beforeTest() throws InterruptedException {
        loginObj6 = new testLogin(driver);
        loginObj6.loginWithValidData();
        dashObj6 = new DashboardPage(driver);
        dashObj6.openMaster();
    }

    @Test
    public void searchWithSpecificInactiveData() throws InterruptedException {
        knowledgeObj = new KnowledgeCenterPage(driver);
        dashObj6.openMaster();
        knowledgeObj.searchWithInactiveData();
        knowledgeObj.searchButton();
        Thread.sleep(1000);
        driver.element().scrollToElement(knowledgeObj.rejected).assertThat(knowledgeObj.rejected).text().contains("Rejected").perform();
    }

    @Test
    public void searchWithCountryAndBranchAndSelectActive() throws InterruptedException {
        knowledgeObj = new KnowledgeCenterPage(driver);
        dashObj6.openMaster();
        knowledgeObj.searchWithActiveData();
        knowledgeObj.searchButton();
        driver.element().assertThat(knowledgeObj.description).text().isEqualTo(des).perform();
    }

    @Test
    public void searchWithSpecificDateOnly() throws InterruptedException {
        knowledgeObj = new KnowledgeCenterPage(driver);
        dashObj6.openMaster();
        knowledgeObj.searchWithSpecificDate();
        knowledgeObj.searchButton();
        Validations.verifyThat().element(knowledgeObj.table).exists().perform();
    }

    @Test
    public void searchWithoutEnterDateToCheckAllDataAndSelectOptionBoth() throws InterruptedException {
        knowledgeObj = new KnowledgeCenterPage(driver);
        dashObj6.openMaster();
        knowledgeObj.searchWithoutEnterDate();
        knowledgeObj.searchButton();
        Validations.verifyThat().element(knowledgeObj.table).exists().perform();
    }

    //Assert country selected
    @Test
    public void searchWithSpecificBranchOnlyWithOptionBoth() throws InterruptedException {
        knowledgeObj = new KnowledgeCenterPage(driver);
        dashObj6.openMaster();
        knowledgeObj.searchWithBranch();
        knowledgeObj.searchButton();
        driver.element().assertThat(knowledgeObj.countryName).text().contains("Egypt").perform();
        Validations.verifyThat().element(knowledgeObj.table).exists().perform();
    }

    @Test
    public void searchWithSpecificAgencyOnlyWithOptionBoth() throws InterruptedException {
        knowledgeObj = new KnowledgeCenterPage(driver);
        dashObj6.openMaster();
        knowledgeObj.searchWithAgency();
        knowledgeObj.searchButton();
        driver.element().assertThat(knowledgeObj.countryName).text().contains("Iraq").perform();
    }

    @Test
    public void searchWithInactiveDateAndSelectActiveOption() throws InterruptedException {
        knowledgeObj = new KnowledgeCenterPage(driver);
        dashObj6.openMaster();
        knowledgeObj.searchWithWrongStatus();
        knowledgeObj.searchButton();
        Validations.verifyThat().element(knowledgeObj.notFound).exists().perform();
    }
}