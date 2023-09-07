package TestPackage.AdminPackage.Staff;


import Pages.Admin.Staff.SearchStaff;
import TestPackage.Login.LoginPageTC;
import TestPackage.BasePage.TCBase;
import org.testng.annotations.Test;
//import org.apache.xpath.operations.String;

    public class SearchStaffTC extends TCBase {
        SearchStaff searchStaffObject;
        LoginPageTC loginObj1;


        @Test
        public void searchWithValidCriteria() throws InterruptedException {
            loginObj1  = new LoginPageTC();
            loginObj1.loginWithValidCredentials();
            searchStaffObject = new SearchStaff(driver);
            searchStaffObject.searchAboutStaffWithValidData();
            driver.assertThat().element(searchStaffObject.ResultsTable).isVisible();
        }

    }

