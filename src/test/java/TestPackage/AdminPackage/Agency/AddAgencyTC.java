package TestPackage.AdminPackage.Agency;

import Pages.Admin.Agency.AddAgency;
import Pages.Admin.Agency.SearchAgency;
import Pages.Login.LoginPage;
import TestPackage.Login.LoginPageTC;
import TestPackage.BasePage.TCBase;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddAgencyTC extends TCBase {

    AddAgency addagencyobject;
    LoginPageTC loginObj;
    SearchAgency searchAGNObj;

    @BeforeTest
    public void beforeTest()throws InterruptedException{
        loginObj = new LoginPageTC();
        loginObj.loginWithValidCredentials();

    }

    @Test
    public void AddWithValidData() throws InterruptedException {
//        loginObj3 = new LoginPageTC();
//        loginObj3.loginWithValidCredentials();
        addagencyobject = new AddAgency(driver);
        addagencyobject.addAgencyWithValidData();
        driver.assertThat().element(By.xpath("//*[@id=\"statusMsg\"]/font/font")).isVisible();

    }

    @Test
    public void SearchAndApprove() throws InterruptedException{
        searchAGNObj = new SearchAgency(driver);
        searchAGNObj.searchForAgencyWithValidData();
        searchAGNObj.approveLatestAgn();

    }

}

