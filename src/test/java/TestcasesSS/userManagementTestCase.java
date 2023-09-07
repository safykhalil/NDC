package TestcasesSS;

import Pages.DashboardPage;
import TestPackage.BasePage.TCBase;
import com.shaft.validation.Validations;
import logintest.testLogin;
import logintest.userManagement;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class userManagementTestCase extends TCBase {

    testLogin loginObj1;
    DashboardPage dashObj1;
    userManagement manageObj1;


    @BeforeTest
    public void beforeTest() throws InterruptedException {
        loginObj1 = new testLogin(driver);
        loginObj1.loginWithValidData();
        dashObj1 = new DashboardPage(driver);
        dashObj1.openUserManagment();
        manageObj1 = new userManagement(driver);

    }

    @Test(priority = 1)
    public void searchWithValidData() throws InterruptedException {
        dashObj1.openUserManagment();
        manageObj1.selectAgency("Arab Travel");
        manageObj1.searchButton();
        Thread.sleep(1000);
        Validations.verifyThat().element(manageObj1.agentName).exists().perform();
    }

    @Test
    public void searchWithFullName() {
        dashObj1.openUserManagment();
        manageObj1.selectAgency("wangrunzeng");
        manageObj1.selectFullName("YIXING TICKETS");
        manageObj1.searchButton();
        driver.element().assertThat(manageObj1.agentNameYin).text().isEqualTo("YIXING TICKETS").perform();


    }

    @Test
    public void searchWithoutData() throws InterruptedException {

        dashObj1.openUserManagment();
        manageObj1.searchButton();
        Validations.verifyThat().element(manageObj1.selectAgencyText).exists().perform();
    }

}
