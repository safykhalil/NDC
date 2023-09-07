package TestcasesSS;

import Pages.DashboardPage;
import TestPackage.BasePage.TCBase;
import com.shaft.validation.Validations;
import logintest.KnowledgeCenterPage;
import logintest.SupplierPage;
import logintest.testLogin;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SupplierTestCase extends TCBase {
    testLogin loginObj7;
    DashboardPage dashObj7;
    SupplierPage SupplierObj;
    String disableSupplier = "Supplier disabled successfully";


    @BeforeTest
    public void beforeTest() throws InterruptedException {
        loginObj7 = new testLogin(driver);
        loginObj7.loginWithValidData();
        dashObj7 = new DashboardPage(driver);
        dashObj7.openMaster();
    }

    @Test
    public void SearchWithAllSupplierAndSelectStatusBoth() {
        SupplierObj = new SupplierPage(driver);
        dashObj7.openMaster();
        SupplierObj.openSupplierPage();
        SupplierObj.searchWithAllSupplier();
        SupplierObj.searchButton();
        Validations.verifyThat().element(SupplierObj.table).exists().perform();
    }

    @Test
    public void SearchWithSpecificActiveSupplier() {
        SupplierObj = new SupplierPage(driver);
        dashObj7.openMaster();
        SupplierObj.openSupplierPage();
        SupplierObj.SearchWithSpecificActiveSupplier();
        SupplierObj.searchButton();
        driver.element().assertThat(SupplierObj.supplierNameTable).text().contains("FlyEgypt").perform();
    }


    @Test
    public void searchWithSupplierNameAfterChangedStatusToInactive() throws InterruptedException {
        SupplierObj = new SupplierPage(driver);
        dashObj7.openMaster();
        SupplierObj.openSupplierPage();
        SupplierObj.searchWithSupplierNameAfterChangeStatusToInactive();
        driver.element().assertThat(SupplierObj.inactiveSupplierMasg).text().contains(disableSupplier).perform();
        SupplierObj.searchButton();
        driver.element().assertThat(SupplierObj.supplierNameTable).text().contains("FlyEgypt").perform();
        SupplierObj.ClickInactiveOption();
    }

    @Test
    public void searchWithInactiveProduct() {
        SupplierObj = new SupplierPage(driver);
        dashObj7.openMaster();
        SupplierObj.openSupplierPage();
        SupplierObj.searchWithSelectHotelFromProduct();
        SupplierObj.searchButton();
        Validations.verifyThat().element(SupplierObj.notFound).exists().perform();
    }


}