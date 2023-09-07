package TestPackage.AdminPackage.Staff;

import Pages.Admin.Staff.AddStaff;
import TestPackage.Login.LoginPageTC;
import TestPackage.BasePage.TCBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

    public class AddStaffTC extends TCBase {
        AddStaff addStaffObject;
        LoginPageTC loginObj4;


        @Test
        public void addNewCountryWithValidData() throws InterruptedException {
            loginObj4  = new LoginPageTC();
            loginObj4.loginWithValidCredentials();
            addStaffObject  = new AddStaff (driver);
            addStaffObject.addStaffWithValidData();
            driver.assertThat().element(By.xpath("//*[@id=\"statusMsg\"]/font")).isVisible();
        }
    }
