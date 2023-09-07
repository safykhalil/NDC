package TestPackage.AdminPackage.Agency;


import Pages.Admin.Agency.SearchAgency;
import TestPackage.Login.LoginPageTC;
import TestPackage.BasePage.TCBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SearchAgencyTC extends TCBase {
    SearchAgency searchagencyobject;
    LoginPageTC loginObj2;


    @Test
    public void SearchWithValidData() throws InterruptedException {
        loginObj2 = new LoginPageTC();
        loginObj2.loginWithValidCredentials();
        searchagencyobject = new SearchAgency(driver);
        searchagencyobject.searchForAgencyWithValidData();
        driver.assertThat().element(By.id("air_tb")).isVisible();
    }
}

